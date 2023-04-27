package hanium.highwayspring.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@Transactional
class UserServiceIntegrationTest {

    @Autowired UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    void 회원가입(){
        //given
        User user = new User();
        user.setUserId("admin");
        user.setUser_pw("admin1234");
        user.setUser_name("name");
        user.setUser_email("email");
        user.setUser_sex("man");
        user.setUser_age(19L);
        //when
        Long saveId = userService.join(user);

        User findUser = userService.findOne(saveId).get();
        assertThat(user.getUser_name()).isEqualTo(findUser.getUser_name());
    }

    @Test
    void 로그인(){
        String id = "admin";
        String pw = "admin1234";
        Boolean login = userService.login(id, pw);
        System.out.println(login);
    }
}
