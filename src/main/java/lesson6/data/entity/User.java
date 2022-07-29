package lesson6.data.entity;

import lesson6.data.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private String address;
    @Enumerated(EnumType.STRING)
    private UserRole role;

}
