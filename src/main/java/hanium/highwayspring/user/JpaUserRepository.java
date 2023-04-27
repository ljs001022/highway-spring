package hanium.highwayspring.user;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaUserRepository implements UserRepository{
    private final EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long user_no) {
        User user =em.find(User.class, user_no);
        return Optional.ofNullable(user);
    }

    @Override
    public User findByUserId(String user_id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select u from TB_USER u", User.class).getResultList();
    }
}
