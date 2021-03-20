package henu.soft.xiaosi.dao;

import henu.soft.xiaosi.pojo.approval_page.ApprovalPage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalPageDao extends MongoRepository<ApprovalPage,String> {

    /**
     * 1. 根据页码信息查询申报表列表
     *
     */

}
