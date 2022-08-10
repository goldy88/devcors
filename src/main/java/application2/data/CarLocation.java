package application2.data;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarLocation {

    @Id
    @GeneratedValue
    public Long id;
    public Long carId;
    public Long latitude;
    public Long longitude;


}
