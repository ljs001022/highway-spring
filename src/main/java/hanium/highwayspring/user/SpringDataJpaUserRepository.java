package hanium.highwayspring.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaUserRepository extends JpaRepository<User, Long>, UserRepository {
}
