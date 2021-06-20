package banger.demo.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "upload")
public class Upload {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fileId;
    @Column(length = 1000)
    private byte[] licenceImage;
    @Column(length = 1000)
    private byte[] utilityBillImage;
    @OneToOne
    @JoinColumn(name="User")
    private User user;

}
