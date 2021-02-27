package henu.soft.xiaosi;


import com.mongodb.client.result.UpdateResult;
import henu.soft.xiaosi.controller.DeclarationFormController;
import henu.soft.xiaosi.controller.UserController;
import henu.soft.xiaosi.pojo.approvalPage.Data;
import henu.soft.xiaosi.pojo.declarationform.DeclarationForm;
import henu.soft.xiaosi.pojo.declarationform.form1_principal.Principal;
import henu.soft.xiaosi.pojo.declarationform.form2_teachers.Teachers;
import henu.soft.xiaosi.pojo.declarationform.form3_rules_and_regulations.RulesAndRegulations;
import henu.soft.xiaosi.pojo.declarationform.form4_teaching_organization.TeachingOrganization;
import henu.soft.xiaosi.pojo.declarationform.form6_team_building.TeamBuilding;
import henu.soft.xiaosi.pojo.user.User;
import henu.soft.xiaosi.service.ApprovalPageService;
import henu.soft.xiaosi.service.DeclarationFormService;
import henu.soft.xiaosi.service.UserService;
import henu.soft.xiaosi.vo.ResultResponse;
import henu.soft.xiaosi.vo.VoUser;
import net.sf.saxon.query.Declaration;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
class BaseEducationDemo1ApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    UserService userService;



    @Autowired
    UserController userController;


    @Autowired
    DeclarationFormService declarationFormService;

    @Autowired
    DeclarationFormController declarationFormController;


    @Autowired
    ApprovalPageService approvalPageService;


    @Test
    void contextLoads() {

    }
    @Test
    void testFindUerByUserNumber(){
        User currentUser = userService.findUserByUserNumber("1925050351");
        System.out.println(currentUser);
    }
    @Test
    void testFindFormByFormId(){
        DeclarationForm form = declarationFormService.findDeclarationFormInfoByFormId("603605b39b7064bfcc0bbc36");
        System.out.println(form);
    }

    @Test
    void testFindPrincipalInfoById(){
        Principal principal = declarationFormService.findPrincipalInfoById("1");
        System.out.println(principal);

    }
    @Test
    void testFindTeachersInfoById(){
        Teachers form = declarationFormService.findTeachersInfoById("1");
        System.out.println(form);
    }
    @Test
    void testFindRuleAndRegulationIDInfoById(){
        RulesAndRegulations form = declarationFormService.findRuleAndRegulationInfoById("1");
        System.out.println(form);
    }
    @Test
    void test6(){
        TeamBuilding form = declarationFormService.findTeamBuildingInfoById("1");
        System.out.println(form);
    }
    @Test
    void test7(){
        TeachingOrganization form = declarationFormService.findTeachingOrganizationInfoById("1");
        System.out.println(form);
    }
    @Test
    void test8(){

        System.out.println( declarationFormService.findCourseMaterialIDInfoById("1"));
    }
    @Test
    void test9(){

        System.out.println( declarationFormService.findTeachingResearchInfoById("1"));
    }
    @Test
    void test10(){

        System.out.println( declarationFormService.findSpecialtyConstructionInfoById("1"));
    }

    @Test
    void test11(){

        System.out.println( declarationFormService.findPracticalTeachingInfoById("1"));
    }

    @Test
    void test12(){

        System.out.println( declarationFormService.findConditionGuaranteeInfoById("1"));
    }

    @Test
    void test13(){

        System.out.println( declarationFormService.findTalentCultivationAbilityInfoById("1"));
    }

    @Test
    void test14(){

        System.out.println( declarationFormService.findFutureConstructionPlanInfoById("1"));
    }
    @Test
    void test15(){

        System.out.println( declarationFormService.findOpinionFeedbackInfoById("1"));
    }
    @Test
    void testObjectIdFind(){

        System.out.println(mongoTemplate.findById(new ObjectId("603605b39b7064bfcc0bbc36"),DeclarationForm.class));
    }
    @Test
    void testSave1(){
        DeclarationForm declarationForm = new DeclarationForm();
        declarationForm.setMembersID("1");

        ResultResponse resultResponse = declarationFormController.saveDeclarationForm(declarationForm);
        System.out.println(resultResponse);
    }
    @Test
    void testInsert1(){
        Data data = new Data();
        data.setFormID("1");
        data.setCollege("软件学院");
        approvalPageService.updateFormList(data);

    }


}
