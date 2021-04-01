package henu.soft.xiaosi.service;

import com.mongodb.client.result.DeleteResult;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


/**
 * 删除分表 抽取类
 * 2- 14 分表删除抽取
 *
 * 目前未使用该模块
 */
@Service
public class DeleteService {

    @Autowired
    MongoTemplate mongoTemplate;

    public Boolean deleteCollectionById(String collection,String idName,String id) {

        try{
            Query query = new Query(Criteria.where("_id").is(new ObjectId(id)));
            DeleteResult remove = mongoTemplate.remove(query, collection);
            System.out.println("debug ==> 删除文档的结果数目 " + remove.getDeletedCount());

            return remove.getDeletedCount() == 1;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
