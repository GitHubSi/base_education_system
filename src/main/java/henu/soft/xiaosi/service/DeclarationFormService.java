package henu.soft.xiaosi.service;

import com.mongodb.BasicDBObject;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import henu.soft.xiaosi.pojo.declarationform.DeclarationForm;
import henu.soft.xiaosi.pojo.declarationform.form10_condition_guarantee.ConditionGuarantee;
import henu.soft.xiaosi.pojo.declarationform.form11_talent_cultivation_ability.TalentCultivationAbility;
import henu.soft.xiaosi.pojo.declarationform.form12_future_construction_plan.FutureConstructionPlan;
import henu.soft.xiaosi.pojo.declarationform.form13_opinion_feedback.OpinionFeedback;
import henu.soft.xiaosi.pojo.declarationform.form1_principal.Principal;
import henu.soft.xiaosi.pojo.declarationform.form2_teachers.Teachers;
import henu.soft.xiaosi.pojo.declarationform.form3_rules_and_regulations.RulesAndRegulations;
import henu.soft.xiaosi.pojo.declarationform.form4_teaching_organization.TeachingOrganization;
import henu.soft.xiaosi.pojo.declarationform.form5_course_material.CourseMaterial;
import henu.soft.xiaosi.pojo.declarationform.form6_team_building.TeamBuilding;
import henu.soft.xiaosi.pojo.declarationform.form7_teaching_research.TeachingResearch;
import henu.soft.xiaosi.pojo.declarationform.form8_specialty_construction.SpecialtyConstruction;
import henu.soft.xiaosi.pojo.declarationform.form9_practical_teaching.PracticalTeaching;
import henu.soft.xiaosi.vo.ResultResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class DeclarationFormService {

    @Autowired
    MongoTemplate mongoTemplate;


    /**
     * 1 . 查：根据formID查询 整个申报表的信息 及 分表id 信息
     * @param formID
     * @return
     */

    public DeclarationForm findDeclarationFormInfoByFormId(String formID) {


        Query query = new Query(Criteria.where("formID").is(new ObjectId(formID)));



        DeclarationForm declaration_form = mongoTemplate.findOne(query, DeclarationForm.class,"declaration_form");


        return declaration_form;
    }

    /**
     *  1.1 增：增加一个新的申报表整体信息
     * @param declarationForm
     * @return
     */

    public DeclarationForm saveDeclarationForm(DeclarationForm declarationForm) {

        DeclarationForm declaration_form = mongoTemplate.save(declarationForm, "declaration_form");


        return declaration_form;
    }



    /**
     * 1.2 更新 ：更新的declaration_form的 status、reviewer和 更新approval_page的审核状态status、reviewer、userNumberOfReviewer
     * @param declarationForm
     * @return
     */

    public Boolean updateDeclarationFormOfStatusAndReviewer(String formID,DeclarationForm declarationForm) {
        try{

            // 1. 更新declaration_form
            Query query = new Query(Criteria.where("_id").is(new ObjectId(formID)));
            Update update = new Update();
            update.set("info.formID",declarationForm.getFormID()).
                    set("info.status",declarationForm.getInfo().getStatus()).
                    set("info.reviewer",declarationForm.getInfo().getReviewer()).
                    set("info.userNumberOfReviewer",declarationForm.getInfo().getUserNumberOfReviewer());


            UpdateResult updateDeclarationFormResult = mongoTemplate.updateFirst(query, update, "declaration_form");


            // 2. 更新approval_page
            Query query1 = new Query(Criteria.where("_id").is(new ObjectId("6035ed339b7064bfcc0bbc35")).and("data.formID").is(formID));
            Update update1 = new Update();
            update1.set("data.$.status",declarationForm.getInfo().getStatus()).
                    set("data.$.reviewer",declarationForm.getInfo().getReviewer()).
                    set("data.$.userNumberOfReviewer",declarationForm.getInfo().getUserNumberOfReviewer());


            System.out.println("debug=> 更新approval_page的status:" + declarationForm.getInfo().getStatus());
            System.out.println("debug=> 更新approval_page的reviewer:" + declarationForm.getInfo().getReviewer());

            UpdateResult updateApprovalPageResult = mongoTemplate.updateFirst(query1, update1, "approval_page");
            return updateDeclarationFormResult.getMatchedCount() == 1 && updateApprovalPageResult.getMatchedCount() == 1;

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;

    }
    /**
     * 1.3 更新 ：更新的declaration_form的 info和 更新approval_page的审核状态info
     * @param declarationForm
     * @return
     */

    public Boolean updateDeclarationFormOfInfo(String formID,DeclarationForm declarationForm) {
        try{

            // 1. 更新declaration_form
           declarationForm.getInfo().setFormID(declarationForm.getFormID());
            Query query = new Query(Criteria.where("_id").is(new ObjectId(formID)));
            Update update = Update.update("info",declarationForm.getInfo());

            System.out.println("debug=> 更新的declaration_form的info" + declarationForm.getInfo());
            UpdateResult updateDeclarationFormResult = mongoTemplate.updateFirst(query, update, "declaration_form");


            // 2. 更新approval_page
            Query query1 = new Query(Criteria.where("_id").is(new ObjectId("6035ed339b7064bfcc0bbc35")).and("data.formID").is(formID));
            Update update1 = new Update();
            update1.set("data.$.status",declarationForm.getInfo().getStatus()).
                    set("data.$.reviewer",declarationForm.getInfo().getReviewer()).
                    set("data.$.college",declarationForm.getInfo().getCollege()).
                    set("data.$.principal",declarationForm.getInfo().getPrincipal()).
                    set("data.$.organization",declarationForm.getInfo().getOrganization()).
                    set("data.$.professionalTitle",declarationForm.getInfo().getProfessionalTitle()).
                    set("data.$.userNumberOfMarker",declarationForm.getInfo().getUserNumberOfMarker()).
                    set("data.$.userNumberOfReviewer",declarationForm.getInfo().getUserNumberOfReviewer()).
                    set("data.$.totalScore",declarationForm.getInfo().getTotalScore());


            System.out.println("debug=> 更新approval_page的status:" + declarationForm.getInfo().getStatus());
            System.out.println("debug=> 更新approval_page的reviewer:" + declarationForm.getInfo().getReviewer());

            UpdateResult updateApprovalPageResult = mongoTemplate.updateFirst(query1, update1, "approval_page");
            return updateDeclarationFormResult.getMatchedCount() == 1 && updateApprovalPageResult.getMatchedCount() == 1;

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;

    }









    /**
     * 2. 根据principalID查询 负责人信息
     * @param principalID
     * @return
     */

    public Principal findPrincipalInfoById(String principalID) {
        Query query = new Query(Criteria.where("principalID").is(principalID));

        Principal form1_principal = mongoTemplate.findOne(query, Principal.class, "form1_principal");

        return form1_principal;



    }

    /**
     * 2.1 增
     * @param principal
     * @return
     */
    public Principal savePrincipal(Principal principal) {
        Principal form1_principal = mongoTemplate.save(principal, "form1_principal");
        return form1_principal;
    }



    /**
     * 3. 根据membersID查询 成员教师信息
     * @param membersID
     * @return
     */

    public Teachers findTeachersInfoById(String membersID) {
        Query query = new Query(Criteria.where("membersID").is(membersID));
        Teachers form2_teachers = mongoTemplate.findOne(query, Teachers.class, "form2_teachers");
        return form2_teachers;
    }

    /**
     * 3.1 增
     * @param teachers
     * @return
     */

    public Teachers saveMembers(Teachers teachers) {
        Teachers form2_teachers = mongoTemplate.save(teachers, "form2_teachers");
        return form2_teachers;
    }


    /**
     * 4. 根据ruleAndRegulationsID查询 规章制度建设信息
     * @param ruleAndRegulationID
     * @return
     */

    public RulesAndRegulations findRuleAndRegulationInfoById(String ruleAndRegulationID) {
        Query query = new Query(Criteria.where("ruleAndRegulationID").is(ruleAndRegulationID));
        RulesAndRegulations form3_rules_and_regulations = mongoTemplate.findOne(query, RulesAndRegulations.class, "form3_rules_and_regulations");
        return form3_rules_and_regulations;
    }

    /**
     * 4.1 增
     * @param rulesAndRegulations
     * @return
     */

    public RulesAndRegulations saveRuleAndRegulation(RulesAndRegulations rulesAndRegulations) {
        RulesAndRegulations form3_rules_and_regulations = mongoTemplate.save(rulesAndRegulations, "form3_rules_and_regulations");


        return form3_rules_and_regulations;
    }

    /**
     * 5. 根据 teamBuildingID 查询 队伍建设信息
     * @param teamBuildingID
     * @return
     */

    public TeamBuilding findTeamBuildingInfoById(String teamBuildingID) {
        Query query = new Query(Criteria.where("teamBuildingID").is(teamBuildingID));
        TeamBuilding form6_team_building = mongoTemplate.findOne(query, TeamBuilding.class, "form6_team_building");
        return  form6_team_building;
    }

    /**
     * 5.1 增
     * @param teamBuilding
     * @return
     */

    public TeamBuilding saveTeamBuilding(TeamBuilding teamBuilding) {

        TeamBuilding form6_team_building = mongoTemplate.save(teamBuilding, "form6_team_building");

        return form6_team_building;
    }

    /**
     * 6. 根据 teachingOrganizationID 查询 教学组织信息
     * @param teachingOrganizationID
     * @return
     */

    public TeachingOrganization findTeachingOrganizationInfoById(String teachingOrganizationID) {
        Query query = new Query(Criteria.where("teachingOrganizationID").is(teachingOrganizationID));
        TeachingOrganization form4_teaching_organizations = mongoTemplate.findOne(query, TeachingOrganization.class, "form4_teaching_organizations");


        return form4_teaching_organizations;
    }

    /**
     * 6.1 增
     * @param teachingOrganization
     * @return
     */

    public TeachingOrganization saveTeachingOrganization(TeachingOrganization teachingOrganization) {
        TeachingOrganization form4_teaching_organizations = mongoTemplate.save(teachingOrganization, "form4_teaching_organizations");

        return form4_teaching_organizations;
    }


    /**
     * 7. 查询课程建设信息
     * @param courseMaterialID
     * @return
     */

    public CourseMaterial findCourseMaterialIDInfoById(String courseMaterialID) {
        Query query = new Query(Criteria.where("courseMaterialID").is(courseMaterialID));
        CourseMaterial form5_course_material = mongoTemplate.findOne(query, CourseMaterial.class, "form5_course_material");

        return form5_course_material;
    }

    /**
     * 7.1 增
     * @param courseMaterial
     * @return
     */

    public CourseMaterial saveCourseMaterial(CourseMaterial courseMaterial) {
        CourseMaterial form5_course_material = mongoTemplate.save(courseMaterial, "form5_course_material");

        return form5_course_material;
    }



    /**
     * 8. 查询教学研究信息
     * @param teachingResearchID
     * @return
     */

    public TeachingResearch findTeachingResearchInfoById(String teachingResearchID) {
        Query query = new Query(Criteria.where("teachingResearchID").is(teachingResearchID));
        TeachingResearch form7_teaching_research = mongoTemplate.findOne(query, TeachingResearch.class, "form7_teaching_research");


        return form7_teaching_research;
    }

    /**
     * 8.1 增
     * @param teachingResearch
     * @return
     */

    public TeachingResearch saveTeachingResearch(TeachingResearch teachingResearch) {

        TeachingResearch form7_teaching_research = mongoTemplate.save(teachingResearch, "form7_teaching_research");
        return form7_teaching_research;


    }

    /**
     * 9. 查询专业建设信息
     * @param specialtyConstructionID
     * @return
     */

    public SpecialtyConstruction findSpecialtyConstructionInfoById(String specialtyConstructionID) {
        Query query = new Query(Criteria.where("specialtyConstructionID").is(specialtyConstructionID));
        SpecialtyConstruction form8_speciality_construction = mongoTemplate.findOne(query, SpecialtyConstruction.class, "form8_speciality_construction");


        return form8_speciality_construction;
    }

    /**
     * 9.1 增
     * @param specialtyConstruction
     * @return
     */

    public SpecialtyConstruction saveSpecialtyConstruction(SpecialtyConstruction specialtyConstruction) {

        SpecialtyConstruction form8_speciality_construction = mongoTemplate.save(specialtyConstruction, "form8_speciality_construction");
        return form8_speciality_construction;
    }


    /**
     * 10. 查询实践教学信息
     * @param practicalTeachingID
     * @return
     */

    public PracticalTeaching findPracticalTeachingInfoById(String practicalTeachingID) {
        Query query = new Query(Criteria.where("practicalTeachingID").is(practicalTeachingID));
        PracticalTeaching form9_practical_teaching = mongoTemplate.findOne(query, PracticalTeaching.class, "form9_practical_teaching");

        return form9_practical_teaching;
    }

    /**
     * 10.1 增
     * @param practicalTeaching
     * @return
     */
    public PracticalTeaching savePracticalTeaching(PracticalTeaching practicalTeaching) {

        PracticalTeaching form9_practical_teaching = mongoTemplate.save(practicalTeaching, "form9_practical_teaching");
        return form9_practical_teaching;
    }



    /**
     * 11. 查询 条件保障信息
     * @param conditionGuaranteeID
     * @return
     */
    public ConditionGuarantee findConditionGuaranteeInfoById(String conditionGuaranteeID) {
        Query query = new Query(Criteria.where("conditionGuaranteeID").is(conditionGuaranteeID));
        ConditionGuarantee form10_condition_guarantee = mongoTemplate.findOne(query, ConditionGuarantee.class, "form10_condition_guarantee");


        return form10_condition_guarantee;
    }

    /**
     * 11.1 增
     * @param conditionGuarantee
     * @return
     */

    public ConditionGuarantee saveConditionGuarantee(ConditionGuarantee conditionGuarantee) {

        ConditionGuarantee form10_condition_guarantee = mongoTemplate.save(conditionGuarantee, "form10_condition_guarantee");
        return form10_condition_guarantee;
    }


    /**
     * 12. 查询人才培养能力
     * @param talentCultivationAbilityID
     * @return
     */
    public TalentCultivationAbility findTalentCultivationAbilityInfoById(String talentCultivationAbilityID) {

        Query query = new Query(Criteria.where("talentCultivationAbilityID").is(talentCultivationAbilityID));
        TalentCultivationAbility form11_talent_cultivation_ability = mongoTemplate.findOne(query, TalentCultivationAbility.class, "form11_talent_cultivation_ability");

        return form11_talent_cultivation_ability;
    }

    /**
     * 12.1 增
     * @param talentCultivationAbility
     * @return
     */

    public TalentCultivationAbility saveTalentCultivationAbility(TalentCultivationAbility talentCultivationAbility) {

        TalentCultivationAbility form11_talent_cultivation_ability = mongoTemplate.save(talentCultivationAbility, "form11_talent_cultivation_ability");
        return form11_talent_cultivation_ability;
    }


    /**
     * 13. 查询今后建设计划
     * @param futureConstructionPlanID
     * @return
     */

    public FutureConstructionPlan findFutureConstructionPlanInfoById(String futureConstructionPlanID) {

        Query query = new Query(Criteria.where("futureConstructionPlanID").is(futureConstructionPlanID));
        FutureConstructionPlan form12_future_construction_plan = mongoTemplate.findOne(query, FutureConstructionPlan.class, "form12_future_construction_plan");

        return form12_future_construction_plan;
    }

    /**
     * 13.1 增
     * @param futureConstructionPlan
     * @return
     */

    public FutureConstructionPlan saveFutureConstructionPlan(FutureConstructionPlan futureConstructionPlan) {

        FutureConstructionPlan form12_future_construction_plan = mongoTemplate.save(futureConstructionPlan, "form12_future_construction_plan");
        return form12_future_construction_plan;
    }

    /**
     *  14. 查询教务处审核反馈表
     * @param opinionFeedbackID
     * @return
     */

    public OpinionFeedback findOpinionFeedbackInfoById(String opinionFeedbackID) {
        Query query = new Query(Criteria.where("opinionFeedbackID").is(opinionFeedbackID));
        OpinionFeedback form13_opinion_feedback = mongoTemplate.findOne(query, OpinionFeedback.class, "form13_opinion_feedback");

        return form13_opinion_feedback;
    }

    /**
     * 14.1 增：增加教务处审核反馈表
     * @param opinionFeedback
     * @return
     */

    public OpinionFeedback saveOpinionFeedback(OpinionFeedback opinionFeedback) {

        OpinionFeedback form13_opinion_feedback = mongoTemplate.save(opinionFeedback, "form13_opinion_feedback");
        return form13_opinion_feedback;
    }








}
