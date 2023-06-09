package hanium.highwayspring.user;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "TB_USER")
@Data
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_no;
    @Column(name = "user_id")
    private String userId;
    private String user_pw;
    private String user_name;
    private String user_email;
    private String user_sex;
    private Long user_age;
}
