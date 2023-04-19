package hanium.highwayspring.user;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Long join(User user){
        userRepository.save(user);
        return user.getUser_no();
    }
    public List<User> findUsers() {
        return userRepository.findAll();
    }
    public Optional<User> findOne(Long userNo){
        return userRepository.findById(userNo);
    }
}
