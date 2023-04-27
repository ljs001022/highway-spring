package hanium.highwayspring.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class UserService {
    private final UserRepository userRepository;
    ;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder1) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder1;
    }

    public Long join(User user) {
        String enPw = passwordEncoder.encode(user.getUser_pw());
        user.setUser_pw(enPw);
        userRepository.save(user);
        return user.getUser_no();
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(Long userNo) {
        return userRepository.findById(userNo);
    }

    public Boolean login(String id, String pw) {
        User user = userRepository.findByUserId(id);
        if(user != null && passwordEncoder.matches(pw, user.getUser_pw())){
            return true;
        }else{
            return false;
        }
    }
}
