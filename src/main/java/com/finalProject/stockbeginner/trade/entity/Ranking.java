package com.finalProject.stockbeginner.trade.entity;

import com.finalProject.stockbeginner.user.entity.User;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Getter
@ToString
@EqualsAndHashCode(of = "email")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name = "ranking")
public class Ranking {
//    @Id
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
//    private String id;

    @Column(nullable = false)
    private Long profit;

    @Column(nullable = false)
    private String userName;

    @Id
<<<<<<< HEAD
    @Column(nullable = false)
=======
    @Column(name = "email", nullable = false)
>>>>>>> feat/jh
    private String email;

    //@OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "user_email")
    //@ToString.Exclude
    //private User user;
}
