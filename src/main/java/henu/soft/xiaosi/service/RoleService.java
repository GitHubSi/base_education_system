package henu.soft.xiaosi.service;

import henu.soft.xiaosi.pojo.role.RoleList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 1. 根据当前用户查询能 分配的角色列表
     * @param currentRole
     * @return
     */

    public RoleList findRoleListByCurrentRole(String currentRole) {



        Query query = new Query(Criteria.where("currentUserRole").is(currentRole));
        RoleList roleList = mongoTemplate.findOne(query, RoleList.class, "role");
        return roleList;


    }
}
