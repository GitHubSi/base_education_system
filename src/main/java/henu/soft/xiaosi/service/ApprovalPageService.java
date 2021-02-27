package henu.soft.xiaosi.service;

import com.mongodb.client.result.UpdateResult;
import henu.soft.xiaosi.pojo.approvalPage.ApprovalPage;
import henu.soft.xiaosi.pojo.approvalPage.Data;
import henu.soft.xiaosi.vo.ResultResponse;
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
     * 1. 获取申报表列表
     *
     *
     */
    public ApprovalPage findFormList() {

        ApprovalPage formList = mongoTemplate.findOne(new Query(), ApprovalPage.class);
        return formList;

    }

    /**
     * 2. 向存在文档插入数据
     * @param data
     * @return
     */

    public Boolean updateFormList(Data data) {
        try{
            Query query = new Query(Criteria.where("_id").is(new ObjectId("6035ed339b7064bfcc0bbc35")));
            Update update = new Update();
            update.addToSet("data",data);
            System.out.println("debug=> 插入approval_page的 data" + data);
            mongoTemplate.upsert(query, update, "approval_page");
            return true;

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;


    }
}
