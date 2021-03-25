package henu.soft.xiaosi.service;

import com.mongodb.client.result.UpdateResult;
import henu.soft.xiaosi.pojo.approval_page.ApprovalPage;
import henu.soft.xiaosi.pojo.approval_page.Data;
import henu.soft.xiaosi.pojo.declarationform.DeclarationForm;
import henu.soft.xiaosi.pojo.todo_list.ToDoItem;
import henu.soft.xiaosi.pojo.todo_list.ToDoList;
import henu.soft.xiaosi.pojo.user.User;
import henu.soft.xiaosi.vo.VoToDoNumbersInfo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoItemsService {

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 1. 查
     * @param userNumber
     * @return
     */
    public ToDoList getToDoListByUserNumber(String userNumber) {
        Query query = new Query(Criteria.where("userNumber").is(userNumber));
        ToDoList todo_list = mongoTemplate.findOne(query, ToDoList.class, "todo_list");
        return todo_list;


    }

    /**
     * 2. 增
     * @param userNumber
     * @param toDoItem
     * @return
     */

    public Boolean saveToDoItem(String userNumber, ToDoItem toDoItem) {

        try {
            Query query = new Query(Criteria.where("userNumber").is(userNumber));
            Update update = new Update();
            update.addToSet("toDoItems",toDoItem);
            UpdateResult result = mongoTemplate.upsert(query, update, ToDoList.class, "todo_list");
            if(result.getMatchedCount() == 1) return true;
            else return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 3. 删
     * @param userNumber
     * @param toDoItem
     * @return
     */

    public Boolean deleteToDoItem(String userNumber, ToDoItem toDoItem) {

        try {
            Query query = new Query(Criteria.where("userNumber").is(userNumber));
            Update update = new Update();
            update.pull("toDoItems",toDoItem);
            UpdateResult result = mongoTemplate.updateFirst(query, update, ToDoList.class, "todo_list");
            if(result.getMatchedCount() == 1) return true;
            else return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }




    }

    public VoToDoNumbersInfo getToDoNumbers(String userNumber) {

        try {
            Query query = new Query(Criteria.where("userNumber").is(userNumber));
            User user = mongoTemplate.findOne(query, User.class, "user");

            String role = user.getRole();

            long numbersOfPriview = 0;
            long numbersOfDispatch = 0;
            long numbersOfMarker = 0;
            long numbersOfNeedEdit = 0;


            if("基层教学组织管理员".equals(role)){
                Query query1 = new Query(Criteria.where("info.status").is("返回修改").and("info.userNumber").is(userNumber));
                numbersOfNeedEdit = mongoTemplate.count(query1, DeclarationForm.class, "declaration_form");
            }


            if("校级管理员".equals(role)){
                Query query1 = new Query(Criteria.where("info.status").is("院级审核通过"));
                numbersOfPriview = mongoTemplate.count(query1, DeclarationForm.class, "declaration_form");

                Query query2 = new Query(Criteria.where("info.status").is("校级审核通过").and("info.userNumberOfMarker").in("",null));
                numbersOfDispatch = mongoTemplate.count(query2, DeclarationForm.class, "declaration_form");

            }

            else if("院级管理员".equals(role)){
                String college = user.getCollege();
                Query query3 = new Query();
                query3.addCriteria(Criteria.where("info.college").is(college));

                query3.addCriteria(Criteria.where("info.status").is("等待审核"));

                List<DeclarationForm> declarationFormList = mongoTemplate.find(query3, DeclarationForm.class, "declaration_form");


                numbersOfPriview = declarationFormList.size();


            }

            else if("评审专家".equals(role)){
                Query query3 = new Query(Criteria.where("info.userNumberOfMarker").is(userNumber).and("info.status").is("校级审核通过"));
                numbersOfMarker = mongoTemplate.count(query3, DeclarationForm.class, "declaration_form");

            }

            VoToDoNumbersInfo voToDoNumbersInfo = new VoToDoNumbersInfo();
            voToDoNumbersInfo.setNumbersOfDispatch((int) numbersOfDispatch);
            voToDoNumbersInfo.setNumbersOfMarker((int) numbersOfMarker);
            voToDoNumbersInfo.setNumbersOfPriview((int) numbersOfPriview);
            voToDoNumbersInfo.setNumbersOfNeedEdit((int) numbersOfNeedEdit);
            return voToDoNumbersInfo;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
}
