package henu.soft.xiaosi.dao;

import henu.soft.xiaosi.pojo.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User,String> {
}
