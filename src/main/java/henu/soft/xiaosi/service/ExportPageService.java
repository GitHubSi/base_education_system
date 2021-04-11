package henu.soft.xiaosi.service;


import henu.soft.xiaosi.pojo.approval_page.ApprovalPage;
import henu.soft.xiaosi.pojo.approval_page.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportPageService {

    @Autowired
    MongoTemplate mongoTemplate;


    /**
     * 1. 获取 所有的 的备案表 信息
     * @return
     */
    public List<Data> exportSchool() {

        ApprovalPage approvalPage = mongoTemplate.findOne(new Query(), ApprovalPage.class);
        if(approvalPage != null){
            return approvalPage.getData();
        }
        return null;
    }


}
