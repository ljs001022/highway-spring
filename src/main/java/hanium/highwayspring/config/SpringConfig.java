package hanium.highwayspring.config;

import hanium.highwayspring.user.UserRepository;
import hanium.highwayspring.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringConfig {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SpringConfig(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository, passwordEncoder);
    }
}
