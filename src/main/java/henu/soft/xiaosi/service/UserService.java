package henu.soft.xiaosi.service;

import com.mongodb.client.result.DeleteResult;
import henu.soft.xiaosi.pojo.user.User;
import henu.soft.xiaosi.vo.VoListQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 1. 查：根据角色权限 分级获取用户列表
     * @return
     */
    public List<User> findUserList(VoListQuery voListQuery) {


        // 1. 当前用户的角色学院，控制学院列表 和 角色列表
        String role = voListQuery.getRole();
        String college = voListQuery.getCollege();

        // 2. 查询条件
        String queryUsername = voListQuery.getQueryUsername();
        String queryRole = voListQuery.getQueryRole();
        String queryCollege = voListQuery.getQueryCollege();

        System.out.println("queryUsername=>" + queryUsername);
        System.out.println("queryRole=>" + queryRole);
        System.out.println("queryCollege=>" + queryCollege);



        // 3. 判断当前角色
        if("系统管理员".equals(role)){
            // 3.1 没有条件的查询
            if(queryUsername == null && queryCollege == null && queryRole == null){
                List<User> userList = mongoTemplate.findAll(User.class, "user");
                return userList;
            }

            // 3.2 三个条件都有的查询
            if(queryUsername!= null && queryCollege != null && queryRole != null){

                Criteria criteria = new Criteria();
                criteria.andOperator(Criteria.where("username").is(queryUsername),Criteria.where("college").is(queryCollege),Criteria.where("role").is(queryRole));
                Query query = new Query();
                query.addCriteria(criteria);
                List<User> userList = mongoTemplate.find(query, User.class, "user");
                return userList;
            }
            // 3.3 一个条件
            if(queryUsername!= null && queryCollege == null && queryRole == null){

                Query query = new Query(Criteria.where("username").is(queryUsername));

                List<User> userList = mongoTemplate.find(query, User.class, "user");
                return userList;
            }
            if(queryUsername == null && queryCollege != null &&queryRole == null){

                Query query = new Query(Criteria.where("college").is(queryCollege));

                List<User> userList = mongoTemplate.find(query, User.class, "user");
                return userList;
            }
            if(queryUsername == null && queryCollege == null && queryRole!= null){

                Query query = new Query(Criteria.where("role").is(queryRole));
                List<User> userList = mongoTemplate.find(query, User.class, "user");
                return userList;
            }

            // 3.4 两个条件
            if(queryUsername!= null && queryCollege != null && queryRole == null){
                Criteria criteria = new Criteria();
                criteria.andOperator(Criteria.where("username").is(queryUsername),Criteria.where("college").is(queryCollege));
                Query query = new Query();
                query.addCriteria(criteria);
                List<User> userList = mongoTemplate.find(query, User.class, "user");
                return userList;
            }
            if(queryUsername != null && queryCollege == null &&queryRole != null){
                Criteria criteria = new Criteria();
                criteria.andOperator(Criteria.where("username").is(queryUsername),Criteria.where("role").is(queryRole));
                Query query = new Query();
                query.addCriteria(criteria);
                List<User> userList = mongoTemplate.find(query, User.class, "user");
                return userList;
            }
            if(queryUsername == null && queryCollege != null && queryRole!= null){
                Criteria criteria = new Criteria();
                criteria.andOperator(Criteria.where("college").is(queryCollege),Criteria.where("role").is(queryRole));
                Query query = new Query();
                query.addCriteria(criteria);
                List<User> userList = mongoTemplate.find(query, User.class, "user");
                return userList;
            }



        }
         if("校级管理员".equals(role)){
             //1. 无条件查询
            if(queryUsername == null && queryCollege == null && queryRole == null){
                Criteria criteria = Criteria.where("role").in("院级管理员","评审专家","校级管理员");
                Query query = new Query();
                query.addCriteria(criteria);
                List<User> userList = mongoTemplate.find(query, User.class, "user");
                return userList;
            }

             // 3.2 三个条件都有的查询
             if(queryUsername!= null && queryCollege != null && queryRole != null){

                 Criteria criteria = new Criteria();
                 criteria.andOperator(Criteria.where("username").is(queryUsername),Criteria.where("college").is(queryCollege),Criteria.where("role").is(queryRole));
                 Query query = new Query();
                 query.addCriteria(criteria);
                 List<User> userList = mongoTemplate.find(query, User.class, "user");
                 return userList;
             }
             // 3.3 一个条件
             if(queryUsername!= null && queryCollege == null && queryRole == null){

                 Query query = new Query(Criteria.where("username").is(queryUsername));

                 List<User> userList = mongoTemplate.find(query, User.class, "user");
                 return userList;
             }
             if(queryUsername == null && queryCollege != null &&queryRole == null){

                 Query query = new Query(Criteria.where("college").is(queryCollege));

                 List<User> userList = mongoTemplate.find(query, User.class, "user");
                 return userList;
             }
             if(queryUsername == null && queryCollege == null && queryRole!= null){

                 Query query = new Query(Criteria.where("role").is(queryRole));
                 List<User> userList = mongoTemplate.find(query, User.class, "user");
                 return userList;
             }

             // 3.4 两个条件
             if(queryUsername!= null && queryCollege != null && queryRole == null){
                 Criteria criteria = new Criteria();
                 criteria.andOperator(Criteria.where("username").is(queryUsername),Criteria.where("college").is(queryCollege));
                 Query query = new Query();
                 query.addCriteria(criteria);
                 List<User> userList = mongoTemplate.find(query, User.class, "user");
                 return userList;
             }
             if(queryUsername != null && queryCollege == null && queryRole != null){
                 Criteria criteria = new Criteria();
                 criteria.andOperator(Criteria.where("username").is(queryUsername),Criteria.where("role").is(queryRole));
                 Query query = new Query();
                 query.addCriteria(criteria);
                 List<User> userList = mongoTemplate.find(query, User.class, "user");
                 return userList;
             }
             if(queryUsername == null && queryCollege != null && queryRole!= null){
                 Criteria criteria = new Criteria();
                 criteria.andOperator(Criteria.where("college").is(queryCollege),Criteria.where("role").is(queryRole));
                 Query query = new Query();
                 query.addCriteria(criteria);
                 List<User> userList = mongoTemplate.find(query, User.class, "user");
                 return userList;
             }



        }
        if("院级管理员".equals(role)) {

            // 1. 无条件查询
            if (queryUsername == null && queryCollege == null && queryRole == null) {
                Criteria criteria = Criteria.where("college").is(college);
                Query query = new Query();
                query.addCriteria(criteria);
                List<User> userList = mongoTemplate.find(query, User.class, "user");
                return userList;
            }

            // 3.2 三个条件都有的查询
            if(queryUsername!= null && queryCollege != null && queryRole != null){

                Criteria criteria = new Criteria();
                criteria.andOperator(Criteria.where("username").is(queryUsername),Criteria.where("college").is(queryCollege),Criteria.where("role").is(queryRole));
                Query query = new Query();
                query.addCriteria(criteria);
                List<User> userList = mongoTemplate.find(query, User.class, "user");
                return userList;
            }
            // 3.3 一个条件
            if(queryUsername!= null && queryCollege == null && queryRole == null){

                Query query = new Query(Criteria.where("username").is(queryUsername));

                List<User> userList = mongoTemplate.find(query, User.class, "user");
                return userList;
            }
            if(queryUsername == null && queryCollege != null &&queryRole == null){

                Query query = new Query(Criteria.where("college").is(queryCollege));

                List<User> userList = mongoTemplate.find(query, User.class, "user");
                return userList;
            }
            if(queryUsername == null && queryCollege == null && queryRole!= null){

                Query query = new Query(Criteria.where("role").is(queryRole));
                List<User> userList = mongoTemplate.find(query, User.class, "user");
                return userList;
            }

            // 3.4 两个条件
            if(queryUsername!= null && queryCollege != null && queryRole == null){
                Criteria criteria = new Criteria();
                criteria.andOperator(Criteria.where("username").is(queryUsername),Criteria.where("college").is(queryCollege));
                Query query = new Query();
                query.addCriteria(criteria);
                List<User> userList = mongoTemplate.find(query, User.class, "user");
                return userList;
            }
            if(queryUsername != null && queryCollege == null &&queryRole != null){
                Criteria criteria = new Criteria();
                criteria.andOperator(Criteria.where("username").is(queryUsername),Criteria.where("role").is(queryRole));
                Query query = new Query();
                query.addCriteria(criteria);
                List<User> userList = mongoTemplate.find(query, User.class, "user");
                return userList;
            }
            if(queryUsername == null && queryCollege != null && queryRole!= null){
                Criteria criteria = new Criteria();
                criteria.andOperator(Criteria.where("college").is(queryCollege),Criteria.where("role").is(queryRole));
                Query query = new Query();
                query.addCriteria(criteria);
                List<User> userList = mongoTemplate.find(query, User.class, "user");
                return userList;
            }


        }
        return null;








    }

    /**
     * 2. 新增用户
     * @param user
     * @return
     */
    public Boolean saveUser(User user) {


        try {
            User newUser = mongoTemplate.save(user, "user");
            if (newUser == null){
                return false;
            }
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }


    }

    /**
     * 3. 删除用户
     * @param userNumber
     * @return
     */
    public Boolean deleteUserByUserNumber(String userNumber) {

        try {
            Query query = new Query(Criteria.where("userNumber").is(userNumber));
            DeleteResult result = mongoTemplate.remove(query, User.class, "user");

            if (result.getDeletedCount() == 1){
                return true;
            }
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 4. 更新用户
     * @param userNumber
     * @param user
     * @return
     */
    public Boolean updateUserBuyUserNumber(String userNumber, User user) {

        try {
            Query query = new Query(Criteria.where("userNumber").is(userNumber));
            User updatedUser = mongoTemplate.findAndReplace(query, user, "user");


            if (updatedUser != null){
                return true;
            }
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
