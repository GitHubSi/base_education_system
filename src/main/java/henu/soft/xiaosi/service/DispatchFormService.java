package henu.soft.xiaosi.service;


import com.mongodb.client.result.UpdateResult;
import henu.soft.xiaosi.pojo.approval_page.ApprovalPage;

import henu.soft.xiaosi.pojo.declarationform.DeclarationForm;
import henu.soft.xiaosi.pojo.user.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DispatchFormService {

    @Autowired
    MongoTemplate mongoTemplate;


    /**
     * 1. 查：查询已经审核成功的申报表
     * @return
     */

    public List<DeclarationForm> findDeclarationForms() {

        Query query = new Query(Criteria.where("info.$.status").is("校级审核通过"));
        List<DeclarationForm> declaration_formList = mongoTemplate.find(query, DeclarationForm.class, "declaration_form");
        return declaration_formList;

    }


    /**
     * 1.1 查：查询审核成功未分配专家的表单
     * @return
     */
    public List<DeclarationForm> findDeclarationFormsOfUndispatch() {
        Query query = new Query(Criteria.where("info.$.status").is("校级审核通过").andOperator(Criteria.where("info.$.userNumberOfMarker").in("",null)));
        List<DeclarationForm> declaration_formList = mongoTemplate.find(query, DeclarationForm.class, "declaration_form");
        return declaration_formList;

    }

    /**
     * 2. 查：查评审专家列表
     * @return
     */

    public List<User> findUsers() {

        Query query = new Query(Criteria.where("role").is("评审专家"));
        List<User> userList = mongoTemplate.find(query, User.class, "user");
        return userList;

    }

    /**
     * 3. 更新：遍历选中的申报表，然后分配给评审专家
     *      同步更新declaration_form和approval_page表
     * @param userNumber
     * @param declarationFormList
     * @return
     */

    public Boolean updateDispatchInfo(String userNumber, List<DeclarationForm> declarationFormList) {

        try{
            for (DeclarationForm declarationForm : declarationFormList) {

                System.out.println("debug===>" + declarationForm);
                // 1. 更新approval_page表
                Query query = new Query(Criteria.where("_id").is(new ObjectId("606ed7537c4ba32cb8846ecf")).and("data.formID").is(declarationForm.getFormID()));
                Update update = new Update();
                update.set("data.$.userNumberOfMarker",userNumber);
                UpdateResult approval_page = mongoTemplate.updateFirst(query, update, ApprovalPage.class, "approval_page");


                // 2. 更新declaration_form表
                Query query1 = new Query(Criteria.where("_id").is(new ObjectId(declarationForm.getFormID())));
                Update update1 = new Update();
                update1.set("info.$.userNumberOfMarker",userNumber);
                UpdateResult declaration_form = mongoTemplate.updateFirst(query1, update1, DeclarationForm.class, "declaration_form");
                System.out.println("debug=>更新的declaration_form.getMatchedCount() 和 approval_page.getMatchedCount() 结果：" + declaration_form.getMatchedCount()+" ---" + approval_page.getMatchedCount() );
               if(declaration_form.getMatchedCount() == 1 && approval_page.getMatchedCount() == 1) continue;
               else return false;
            }
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }


    }
}
