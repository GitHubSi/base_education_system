package henu.soft.xiaosi;


import henu.soft.xiaosi.controller.UserController;
import henu.soft.xiaosi.pojo.user.User;
import henu.soft.xiaosi.service.UserService;
import henu.soft.xiaosi.vo.VoUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BaseEducationDemo1ApplicationTests {
    @Autowired
    UserService userService;

    @Autowired
    UserController userController;

    @Test
    void contextLoads() {

    }
    @Test
    void testFindUerByUserNumber(){
        User currentUser = userService.findUserByUserNumber("1925050351");
        System.out.println(currentUser);
    }


}
