package henu.soft.xiaosi.dao;

import henu.soft.xiaosi.pojo.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao extends MongoRepository<User,String> {

}
