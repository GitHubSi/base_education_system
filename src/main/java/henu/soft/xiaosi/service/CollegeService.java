package henu.soft.xiaosi.service;

import henu.soft.xiaosi.pojo.college.CollegeList;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {

    @Autowired
    MongoTemplate mongoTemplate;


    /**
     * 1. 查：获取学院列表
     * @return
     */

    public CollegeList findCollegeList() {

        CollegeList collegeList = mongoTemplate.findById(new ObjectId("60409b6b2237533084cf7302"), CollegeList.class, "college");
        return collegeList;
    }
}
