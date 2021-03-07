package henu.soft.xiaosi.service;

import henu.soft.xiaosi.pojo.declarationform.form1_principal.Principal;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
/**
 * 更新分表 抽取类
 * 2 - 14 分表更新抽取
 *
 */

@Service
public class UpdateService {

    @Autowired
    MongoTemplate mongoTemplate;


    public Boolean updateCollectionById(String collection,String idName,String id, Object object) {
        try{
            Query query = new Query(Criteria.where(idName).is(new ObjectId(id)));
            Object result = mongoTemplate.findAndReplace(query, object, collection);
            System.out.println("debug=> 更新分表的结果 " + result);

            return result != null;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;

        }


    }
}
