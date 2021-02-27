package henu.soft.xiaosi.controller;


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
import henu.soft.xiaosi.service.DeclarationFormService;
import henu.soft.xiaosi.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/declaration-form")
public class DeclarationFormController{

    @Autowired
    DeclarationFormService declarationFormService;


    /**
     * 1. 获取当前申报表的 整体信息 及 分表ID
     */
    @GetMapping("/total/{formID}")
    public ResultResponse getDeclarationFormByFormId(@PathVariable String formID){
        System.out.println("debug=>formID: " + formID);
        DeclarationForm declarationForm = declarationFormService.findDeclarationFormInfoByFormId(formID);
        if(declarationForm != null){
            System.out.println("debug=>declarationForm: " + declarationForm);
            return ResultResponse.success(200,"获取申报表整体信息成功！",declarationForm);
        }
        return ResultResponse.fail(404,"获取申报表整体信息失败！",null);

    }

    /**
     *  1.1 增：保存当前申报表 整体信息
     */
    @PostMapping("/total")
    public ResultResponse saveDeclarationForm(@RequestBody DeclarationForm declarationForm){
        DeclarationForm declarationFormResult = declarationFormService.saveDeclarationForm(declarationForm);
        if (declarationFormResult == null){
            return ResultResponse.fail(404,"申报表信息保存失败！",null);
        }
        return ResultResponse.success(200,"申报表信息保存成功！",declarationFormResult);


    }


    /**
     * 2. 获取分表principal信息
     */
    @GetMapping("/principal/{principalID}")
    public ResultResponse getPrincipalInfoById(@PathVariable String principalID){
        System.out.println("debug=>principalID: " + principalID);
        Principal principal = declarationFormService.findPrincipalInfoById(principalID);
        if(principal != null){
            System.out.println("debug=>principal: " + principal);
            return ResultResponse.success(200,"获取申报表负责人情况信息成功！",principal);
        }
        return ResultResponse.fail(404,"获取申报表负责人情况信息失败！",null);

    }

    /**
     * 2.1 增
     */

    @PostMapping("/principal")
    public ResultResponse savePrincipal(@RequestBody Principal principal ){

        Principal principalResult = declarationFormService.savePrincipal(principal);
        if (principalResult == null){
            return ResultResponse.fail(404,"负责人信息保存失败！",null);
        }
        return ResultResponse.success(200,"负责人信息保存成功！",principalResult);
    }


    /**
     * 3. 获取分表teachers信息
     */
    @GetMapping("/teachers/{membersID}")
    public ResultResponse getMembersInfoById(@PathVariable String membersID){
        System.out.println("debug=>membersID: " + membersID);
        Teachers teachers = declarationFormService.findTeachersInfoById(membersID);
        if(teachers != null){
            System.out.println("debug=>members: " + teachers );
            return ResultResponse.success(200,"获取申报表成员信息成功！",teachers);
        }
        return ResultResponse.fail(404,"获取申报表成员信息失败！",null);

    }

    /**
     * 3.1 增
     */

    @PostMapping("/teachers")
    public ResultResponse saveMembers(@RequestBody Teachers teachers){
        Teachers teachersResult = declarationFormService.saveMembers(teachers);

        if (teachersResult == null){
            return ResultResponse.fail(404,"成员信息保存失败！",null);
        }
        return ResultResponse.success(200,"成员信息保存成功！",teachersResult);


    }

    /**
     * 4. 获取分表rulesAndRegulations 信息
     */
    @GetMapping("/rules-and-regulations/{ruleAndRegulationID}")
    public ResultResponse getRuleAndRegulationInfoById(@PathVariable String ruleAndRegulationID){
        System.out.println("debug=>ruleAndRegulationID: " + ruleAndRegulationID);
        RulesAndRegulations rulesAndRegulations= declarationFormService.findRuleAndRegulationInfoById(ruleAndRegulationID);
        if(rulesAndRegulations != null){
            System.out.println("debug=>rulesAndRegulations: " + rulesAndRegulations );
            return ResultResponse.success(200,"获取申报表规章制度建设信息成功！",rulesAndRegulations);
        }
        return ResultResponse.fail(404,"获取申报表规章制度建设信息失败！",null);

    }

    /**
     * 4.1 增
     */

    @PostMapping("/rules-and-regulations")
    public ResultResponse saveRuleAndRegulation(@RequestBody RulesAndRegulations rulesAndRegulations){
        RulesAndRegulations rulesAndRegulationsResult = declarationFormService.saveRuleAndRegulation(rulesAndRegulations);
        if (rulesAndRegulationsResult == null){
            return ResultResponse.fail(404,"规章制度信息保存失败！",null);
        }
        return ResultResponse.success(200,"规章制度信息保存成功！",rulesAndRegulationsResult);
    }

    /**
     * 5. 获取分表teamBuilding 信息
     */
    @GetMapping("/team-building/{teamBuildingID}")
    public ResultResponse getTeamBuildingInfoById(@PathVariable String teamBuildingID){
        System.out.println("debug=>teamBuildingID: " + teamBuildingID);
        TeamBuilding teamBuilding = declarationFormService.findTeamBuildingInfoById(teamBuildingID);
        if(teamBuilding != null){
            System.out.println("debug=>teamBuilding: " + teamBuilding );
            return ResultResponse.success(200,"获取申报表队伍建设信息成功！",teamBuilding);
        }
        return ResultResponse.fail(404,"获取申报表队伍建设建设信息失败！",null);

    }


    /**
     * 5.1 增
     */

    @PostMapping("/team-building")
    public ResultResponse saveTeamBuilding(@RequestBody TeamBuilding teamBuilding){
        TeamBuilding teamBuildingResult = declarationFormService.saveTeamBuilding(teamBuilding);
        if (teamBuildingResult == null){
            return ResultResponse.fail(404,"队伍建设信息保存失败！",null);
        }
        return ResultResponse.success(200,"队伍建设信息保存成功！",teamBuildingResult);
    }

    /**
     * 6. 获取分表teachingOrganization 信息
     */
    @GetMapping("/teaching-organization/{teachingOrganizationID}")
    public ResultResponse getTeachingOrganizationInfoById(@PathVariable String teachingOrganizationID){
        System.out.println("debug=>teachingOrganizationID: " + teachingOrganizationID);
        TeachingOrganization teachingOrganization = declarationFormService.findTeachingOrganizationInfoById(teachingOrganizationID);

        if(teachingOrganization != null){

            System.out.println("debug=>teachingOrganization: " + teachingOrganization );
            return ResultResponse.success(200,"获取申报表队教学组织信息成功！",teachingOrganization);
        }
        return ResultResponse.fail(404,"获取申报表队伍教学组织信息失败！",null);

    }


    /**
     *  6.1 增
     */

    @PostMapping("/teaching-organization")
    public ResultResponse saveTeachingOrganization(@RequestBody TeachingOrganization teachingOrganization){
        TeachingOrganization teachingOrganizationResult = declarationFormService.saveTeachingOrganization(teachingOrganization);
        if (teachingOrganizationResult == null){
            return ResultResponse.fail(404,"教学组织信息保存失败！",null);
        }
        return ResultResponse.success(200,"教学组织信息保存成功！",teachingOrganizationResult);
    }



    /**
     * 7. 获取分表 教材概述courseMaterial 信息
     *
     */
    @GetMapping("/course-material/{courseMaterialID}")
    public ResultResponse getCourseMaterialInfoById(@PathVariable String courseMaterialID){
        System.out.println("debug=>courseMaterialID: " + courseMaterialID);
        CourseMaterial courseMaterial = declarationFormService.findCourseMaterialIDInfoById(courseMaterialID);

        if(courseMaterial != null){

            System.out.println("debug=>courseMaterial: " + courseMaterial );
            return ResultResponse.success(200,"获取申报表队课程教材信息成功！",courseMaterial);
        }
        return ResultResponse.fail(404,"获取申报表课程教材信息失败！",null);

    }


    /**
     * 7.1 增
     */

    @PostMapping("/course-material")
    public ResultResponse saveCourseMaterial(@RequestBody CourseMaterial courseMaterial){
        CourseMaterial courseMaterialResult = declarationFormService.saveCourseMaterial(courseMaterial);
        if (courseMaterialResult == null){
            return ResultResponse.fail(404,"课程教材概述信息保存失败！",null);
        }
        return ResultResponse.success(200,"教学组织信息保存成功！",courseMaterialResult);
    }

    /**
     * 8. 获取分表 教学研究 teachingResearch 信息
     *
     */

    @GetMapping("/teaching-research/{teachingResearchID}")
    public ResultResponse getTeachingResearchInfoById(@PathVariable String teachingResearchID){
        System.out.println("debug=>teachingResearchID: " + teachingResearchID);
        TeachingResearch teachingResearch = declarationFormService.findTeachingResearchInfoById(teachingResearchID);

        if(teachingResearch != null){

            System.out.println("debug=>teachingResearch: " + teachingResearch );
            return ResultResponse.success(200,"获取申报表队教学研究信息成功！",teachingResearch);
        }
        return ResultResponse.fail(404,"获取申报表教学研究信息失败！",null);

    }

    /**
     * 8.1 增
     */
    @PostMapping("/teaching-research")
    public ResultResponse saveTeachingResearch(@RequestBody TeachingResearch teachingResearch){
        TeachingResearch teachingResearchResult = declarationFormService.saveTeachingResearch(teachingResearch);
        if (teachingResearchResult == null){
            return ResultResponse.fail(404,"教学研究信息保存失败！",null);
        }
        return ResultResponse.success(200,"教学研究保存成功！",teachingResearchResult);
    }


    /**
     * 9. 获取分表 专业建设 specialtyConstruction 信息
     *
     */
    @GetMapping("/specialty-construction/{specialtyConstructionID}")
    public ResultResponse getSpecialtyConstructionInfoById(@PathVariable String specialtyConstructionID){
        System.out.println("debug=>specialtyConstructionID: " + specialtyConstructionID);
        SpecialtyConstruction specialtyConstruction = declarationFormService.findSpecialtyConstructionInfoById(specialtyConstructionID);

        if(specialtyConstruction != null){

            System.out.println("debug=>specialtyConstruction: " + specialtyConstruction );
            return ResultResponse.success(200,"获取申报表队教学研究信息成功！",specialtyConstruction);
        }
        return ResultResponse.fail(404,"获取申报表教学研究信息失败！",null);

    }


    /**
     * 9.1 增
     */

    @PostMapping("/specialty-construction")
    public ResultResponse saveSpecialtyConstruction(@RequestBody SpecialtyConstruction specialtyConstruction){
        SpecialtyConstruction specialtyConstructionResult = declarationFormService.saveSpecialtyConstruction(specialtyConstruction);
        if (specialtyConstructionResult == null){
            return ResultResponse.fail(404,"教学研究信息保存失败！",null);
        }
        return ResultResponse.success(200,"教学研究保存成功！",specialtyConstructionResult);
    }
    /**
     * 10. 获取分表 实践教学practicalTeaching 信息
     *
     */
    @GetMapping("/practical-teaching/{practicalTeachingID}")
    public ResultResponse getPracticalTeachingInfoById(@PathVariable String practicalTeachingID){
        System.out.println("debug=>practicalTeachingID: " + practicalTeachingID);
        PracticalTeaching practicalTeaching = declarationFormService.findPracticalTeachingInfoById(practicalTeachingID);

        if(practicalTeaching != null){

            System.out.println("debug=>practicalTeaching: " + practicalTeaching);
            return ResultResponse.success(200,"获取申报表队实践教学信息成功！", practicalTeaching);
        }
        return ResultResponse.fail(404,"获取申报表实践教学信息失败！",null);

    }


    /**
     * 10.1 增
     */
    @PostMapping("/practical-teaching")
    public ResultResponse savePracticalTeaching(@RequestBody PracticalTeaching practicalTeaching){
        PracticalTeaching practicalTeachingResult = declarationFormService.savePracticalTeaching(practicalTeaching);
        if (practicalTeachingResult == null){
            return ResultResponse.fail(404,"实践教学信息保存失败！",null);
        }
        return ResultResponse.success(200,"实践教学信息保存成功！",practicalTeachingResult);
    }

    /**
     * 11. 获取分表 条件保证conditionGuarantee 信息
     *
     */
    @GetMapping("/condition-guarantee/{conditionGuaranteeID}")
    public ResultResponse getConditionGuaranteeInfoById(@PathVariable String conditionGuaranteeID){
        System.out.println("debug=>conditionGuaranteeID: " + conditionGuaranteeID);
        ConditionGuarantee conditionGuarantee = declarationFormService.findConditionGuaranteeInfoById(conditionGuaranteeID);

        if(conditionGuarantee != null){

            System.out.println("debug=>conditionGuarantee: " + conditionGuarantee );
            return ResultResponse.success(200,"获取申报表队条件保障信息成功！",conditionGuarantee);
        }
        return ResultResponse.fail(404,"获取申报表条件保障信息失败！",null);

    }

    /**
     * 11.1 增
     */

    @PostMapping("/condition-guarantee")
    public ResultResponse saveConditionGuarantee(@RequestBody ConditionGuarantee conditionGuarantee){
        ConditionGuarantee conditionGuaranteeResult = declarationFormService.saveConditionGuarantee(conditionGuarantee);
        if (conditionGuaranteeResult == null){
            return ResultResponse.fail(404,"条件保障信息保存失败！",null);
        }
        return ResultResponse.success(200,"条件保障信息保存成功！",conditionGuaranteeResult);
    }
    /**
     * 12. 获取分表 人才培养能力talentCultivationAbility 信息
     *
     */
    @GetMapping("/talent-cultivation-ability/{talentCultivationAbilityID}")
    public ResultResponse getTalentCultivationAbilityInfoById(@PathVariable String talentCultivationAbilityID){
        System.out.println("debug=>talentCultivationAbilityID: " + talentCultivationAbilityID);
        TalentCultivationAbility talentCultivationAbility = declarationFormService.findTalentCultivationAbilityInfoById(talentCultivationAbilityID);


        if(talentCultivationAbility != null){

            System.out.println("debug=>: talentCultivationAbility" + talentCultivationAbility );
            return ResultResponse.success(200,"获取申报表队人才培养能力信息成功！",talentCultivationAbility);
        }
        return ResultResponse.fail(404,"获取申报表人才培养能力信息失败！",null);

    }

    /**
     * 12.1 增
     */

    @PostMapping("/talent-cultivation-ability")
    public ResultResponse saveTalentCultivationAbility(@RequestBody TalentCultivationAbility talentCultivationAbility){
        TalentCultivationAbility talentCultivationAbilityResult = declarationFormService.saveTalentCultivationAbility(talentCultivationAbility);
        if (talentCultivationAbilityResult == null){
            return ResultResponse.fail(404,"人才培养能力信息保存失败！",null);
        }
        return ResultResponse.success(200,"人才培养能力信息保存成功！",talentCultivationAbilityResult);
    }


    /**
     * 13. 获取分表 将来建设计划 futureConstructionPlanID信息表
     *
     */
    @GetMapping("/future-construction-plan/{futureConstructionPlanID}")
    public ResultResponse getFutureConstructionPlanInfoById(@PathVariable String futureConstructionPlanID){
        System.out.println("debug=>futureConstructionPlanID: " + futureConstructionPlanID);
        FutureConstructionPlan futureConstructionPlan = declarationFormService.findFutureConstructionPlanInfoById(futureConstructionPlanID);



        if(futureConstructionPlan != null){

            System.out.println("debug=>: futureConstructionPlan" + futureConstructionPlan );
            return ResultResponse.success(200,"获取申报表队将来建设计划能力信息成功！",futureConstructionPlan);
        }
        return ResultResponse.fail(404,"获取申报表将来建设计划信息失败！",null);

    }

    /**
     * 13.1 增
     */

    @PostMapping("/future-construction-plan")
    public ResultResponse saveFutureConstructionPlan(@RequestBody FutureConstructionPlan futureConstructionPlan){
        FutureConstructionPlan futureConstructionPlanResult = declarationFormService.saveFutureConstructionPlan(futureConstructionPlan);
        if (futureConstructionPlanResult == null){
            return ResultResponse.fail(404,"将来建设计划信息保存失败！",null);
        }
        return ResultResponse.success(200,"将来建设计划信息保存成功！",futureConstructionPlanResult);
    }

    /**
     * 14. 获取分表 教务处审核反馈表 opinionFeedback
     *
     */
    @GetMapping("/opinion-feedback/{opinionFeedbackID}")
    public ResultResponse getOpinionFeedbackInfoById(@PathVariable String opinionFeedbackID){
        System.out.println("debug=>opinionFeedbackID: " + opinionFeedbackID);
        OpinionFeedback opinionFeedback = declarationFormService.findOpinionFeedbackInfoById(opinionFeedbackID);


        if(opinionFeedback != null){

            System.out.println("debug=>: opinionFeedback" + opinionFeedback );
            return ResultResponse.success(200,"获取申报表教务处反馈表信息成功！",opinionFeedback);
        }
        return ResultResponse.fail(404,"获取申报表教务处反馈表信息失败！",null);

    }


    /**
     * 14.1 增
     */
    @PostMapping("/opinion-feedback")
    public ResultResponse saveOpinionFeedback(@RequestBody OpinionFeedback opinionFeedback){
        OpinionFeedback opinionFeedbackResult = declarationFormService.saveOpinionFeedback(opinionFeedback);
        if (opinionFeedbackResult == null){
            return ResultResponse.fail(404,"教务处反馈信息保存失败！",null);
        }
        return ResultResponse.success(200,"教务处反馈信息保存成功！",opinionFeedbackResult);
    }
}