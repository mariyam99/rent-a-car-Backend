package banger.demo.Entity;


import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userID;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(nullable = false)
    private String Password;
    @Column(nullable = false)
    private String age;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String liscenceNo;
    @Column(nullable = false)
    private String nic;
    @Column(nullable = false)
    private Boolean isBlacklisted;
    @Column(nullable = false)
    private String role;




    public User(String username, String password) {
        this.username = username;
        Password = password;
    }

    public User(String username, String email, String password, String age, String firstName, String lastName, String phone, String liscenceNo, String nic, Boolean isBlacklisted, String role) {
        this.username = username;
        this.email = email;
        Password = password;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.liscenceNo = liscenceNo;
        this.nic = nic;
        this.isBlacklisted = isBlacklisted;
        this.role = role;
    }

    public boolean validatePassword(String rawPassword, String encryptedPassword){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        return encoder.matches(rawPassword,encryptedPassword);
    }


}
