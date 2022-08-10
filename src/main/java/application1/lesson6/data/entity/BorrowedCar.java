package application1.lesson6.data.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BorrowedCar {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private Integer carId;


}
