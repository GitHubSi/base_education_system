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

        // id部署的时候，需要根据mongodb修改
        CollegeList collegeList = mongoTemplate.findById(new ObjectId("606ed72b7c4ba32cb8846ecd"), CollegeList.class, "college");
        return collegeList;
    }
}
