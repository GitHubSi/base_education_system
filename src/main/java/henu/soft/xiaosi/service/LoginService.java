package henu.soft.xiaosi.service;

import henu.soft.xiaosi.pojo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    MongoTemplate mongoTemplate;



    /**
     * 1. 根据学工号查询用户
     */
    public User findUserByUserNumber(String currentUserNumber) {
        Query query=new Query(Criteria.where("usernumber").is(currentUserNumber));
        User currentUser = mongoTemplate.findOne(query, User.class);
        return currentUser;

    }

    /**
     * 2. 根据用户名查询用户
     */
    public User findUserByUsername(String currentUsername){
        Query query=new Query(Criteria.where("username").is(currentUsername));
        User currentUser = mongoTemplate.findOne(query, User.class);
        return currentUser;


    }




}
