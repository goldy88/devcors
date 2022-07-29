package lesson6.data.entity;

import lesson6.data.enums.CarColor;
import lesson6.data.enums.CarType;
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
public class Car {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "year_")
    private Short year;
    private String brand;
    private String licencePlate;
    @Enumerated(EnumType.STRING)
    private CarType type;
    @Enumerated(EnumType.STRING)
    private CarColor color;


}
