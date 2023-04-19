package hanium.highwayspring.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "TB_USER")
@Data
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_no;
    private String user_id;
    private String user_pw;
    private String user_name;
    private String user_email;
    private String user_sex;
    private Long user_age;
}
