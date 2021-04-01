package henu.soft.xiaosi.service;

import com.mongodb.client.result.UpdateResult;
import henu.soft.xiaosi.pojo.approval_page.ApprovalPage;
import henu.soft.xiaosi.pojo.declarationform.DeclarationForm;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class EvaluateService {

    @Autowired
    MongoTemplate mongoTemplate;
    /**
     * 1. 评审专家打分
     */
    public Boolean giveTotalScore(String formID, String totalScore) {
        try{


            System.out.println("debug=>formID :" + formID);
            System.out.println("debug=>totalScore :" + totalScore);
            // 1. 更新approval_page表
            Query query = new Query(Criteria.where("_id").is(new ObjectId("6063ff4cd876c32de8c60c0f")).and("data.formID").is(formID));
            Update update = new Update();
            update.set("data.$.totalScore",totalScore).set("data.$.status","评定结束");


            UpdateResult approval_page = mongoTemplate.updateFirst(query, update, ApprovalPage.class, "approval_page");


            // 2. 更新declaration_form表
            Query query1 = new Query(Criteria.where("_id").is(new ObjectId(formID)));
            Update update1 = new Update();

            update1.set("info.$.totalScore",totalScore).set("info.$.status","评定结束");
            UpdateResult declaration_form = mongoTemplate.upsert(query1, update1, DeclarationForm.class, "declaration_form");
            System.out.println("debug=>更新的declaration_form.getMatchedCount() 和 approval_page.getMatchedCount() 结果：" + declaration_form.getMatchedCount()+" ---" + approval_page.getMatchedCount() );
            if(declaration_form.getMatchedCount() == 1 && approval_page.getMatchedCount() == 1) return true;
            else return false;


        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }


    }


}
