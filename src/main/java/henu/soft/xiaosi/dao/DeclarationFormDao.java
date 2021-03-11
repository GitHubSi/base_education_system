package henu.soft.xiaosi.dao;

import henu.soft.xiaosi.pojo.declarationform.DeclarationForm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarationFormDao extends MongoRepository<DeclarationForm,String> {





}
