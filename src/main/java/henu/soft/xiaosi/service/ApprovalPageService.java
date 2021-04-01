package henu.soft.xiaosi.service;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import henu.soft.xiaosi.pojo.approval_page.ApprovalPage;
import henu.soft.xiaosi.pojo.approval_page.Data;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ApprovalPageService {

    @Autowired
    MongoTemplate mongoTemplate;




    /**
     * 1. 查：获取申报表列表
     *
     *
     */
    public ApprovalPage findFormList() {

        ApprovalPage formList = mongoTemplate.findOne(new Query(), ApprovalPage.class);
        return formList;

    }



    /**
     * 2. 增：向存在文档插入数据
     * @param data
     * @return
     */

    public Boolean updateFormList(Data data) {
        try{

                                                                 // 需要根据动态生成的ObjectId修改
            Query query = new Query(Criteria.where("_id").is(new ObjectId("6063ff4cd876c32de8c60c0f")));
            Update update = new Update();
            update.addToSet("data",data);
            System.out.println("debug=> 插入approval_page的 data" + data);
            UpdateResult updateResult = mongoTemplate.upsert(query, update, "approval_page");

            return updateResult != null;

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;


    }

    /**
     * 3. 删除：删除内嵌文档declaration_form的信息、declaration_form整体信息
     * @param data
     * @return
     */

    public Boolean deleteDeclarationFormByInfo(Data data) {
        try{

            // 1. 删除declaration_form整体表信息
            Query query = Query.query(Criteria.where("_id").is(new ObjectId(data.getFormID())));
            System.out.println("debug=>要删除的declaration_form 的 formID " + data.getFormID());
            DeleteResult declarationFormDeleteResult = mongoTemplate.remove(query, "declaration_form");


            // 2. 删除approval_page的申报表
            Query query1 = Query.query(Criteria.where("_id").is(new ObjectId("6063ff4cd876c32de8c60c0f")));

            // 完全删除需要 pull,需要重新查询当前declaration_form的FormInfo


            Update update1 = new Update();
            update1.pull("data",data);

            UpdateResult approvalPageDeleteResult = mongoTemplate.updateFirst(query1, update1, "approval_page");
            return declarationFormDeleteResult.getDeletedCount() == 1 && approvalPageDeleteResult.getMatchedCount() == 1;


        }
        catch(Exception e){
            e.printStackTrace();

        }
        return false;



    }


}
