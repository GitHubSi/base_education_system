package henu.soft.xiaosi.service;


import com.mongodb.client.result.UpdateResult;
import henu.soft.xiaosi.pojo.major.MajorAndCodeItem;
import henu.soft.xiaosi.pojo.major.MajorAndCodeList;
import henu.soft.xiaosi.pojo.organization.OrganizationNameList;
import henu.soft.xiaosi.vo.VoDataMaintenanceMajorItem;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataMaintenanceService {

    @Autowired
    MongoTemplate mongoTemplate;


    /**
     * 1. 增：
     * 插入一个学院
     *
     * @param college
     * @return
     */

    public Boolean saveCollege(String college) {
        // 这里需要根据表id手动调整
        try {
            Query query = new Query(Criteria.where("_id").is(new ObjectId("6062b6079bbc4b0d8c4ae49e")));
            Update update = new Update();
            update.addToSet("items", college);
            UpdateResult result = mongoTemplate.upsert(query, update, "college");
            if (result.getMatchedCount() == 1) return true;
            else return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 2. 增
     * 插入基层教学组织
     *
     * @param organization
     * @return
     */

    public Boolean saveOrganization(String organization) {

        // 这里需要根据表id手动调整
        try {
            Query query = new Query(Criteria.where("_id").is(new ObjectId("605b36c185088413906875d8")));
            Update update = new Update();
            update.addToSet("names", organization);
            UpdateResult result = mongoTemplate.upsert(query, update, "organization_name");
            if (result.getMatchedCount() == 1) return true;
            else return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    /**
     * 3. 批量增
     * 插入基层教学组织
     * @param organizations
     * @return
     */

    public Boolean saveImportOrganizations(List<String> organizations) {



        // 这里需要根据表id手动调整
        try {
            Query query = new Query(Criteria.where("_id").is(new ObjectId("605b36c185088413906875d8")));
            Update update = new Update();
            for (String organization :
                    organizations) {
                update.addToSet("names", organization);
                mongoTemplate.upsert(query, update, "organization_name");


            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 3. 查
     * @return
     */

    public List<String> getOrganizations() {

        Query query = new Query(Criteria.where("_id").is(new ObjectId("605b36c185088413906875d8")));


        OrganizationNameList list = mongoTemplate.findOne(query, OrganizationNameList.class, "organization_name");
        if(list != null){
            return list.getNames();
        }
        return null;



    }


    /**
     * 4. 增
     * 批量添加专业及其代码
     * @param majors
     * @return
     */
    public Boolean saveImportMajors(List<VoDataMaintenanceMajorItem> majors) {

        // 这里需要根据表id手动调整
        try {
            Query query = new Query(Criteria.where("_id").is(new ObjectId("60659156518180092416132e")));
            Update update = new Update();
            for (VoDataMaintenanceMajorItem majorAndCode :
                    majors) {
                update.addToSet("majors", majorAndCode);
                mongoTemplate.upsert(query, update, "major_and_code");


            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 4.1 查
     * @return
     */


    public List<MajorAndCodeItem> getMajors() {

        Query query = new Query(Criteria.where("_id").is(new ObjectId("60659156518180092416132e")));


        MajorAndCodeList list = mongoTemplate.findOne(query, MajorAndCodeList.class, "major_and_code");

        if(list != null){
            return list.getMajors();
        }
        return null;
    }


}
