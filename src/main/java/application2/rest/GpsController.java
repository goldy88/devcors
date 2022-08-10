package application2.rest;


import application2.data.CarLocation;
import application2.repo.GpsRepository;
import application2.services.CarLocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GpsController {

private final GpsRepository gpsRepository;

private final CarLocationService carLocationService;

    public GpsController(GpsRepository gpsRepository, CarLocationService carLocationService) {
        this.gpsRepository = gpsRepository;
        this.carLocationService = carLocationService;
    }

    @GetMapping(value = "/gps/{carId}")
    public ResponseEntity<List<CarLocation>> findAllCarsByCarId(@PathVariable (value = "carId")Long carId) {
     List<CarLocation> carLocation = carLocationService.findCarsByCarId(carId);
         return  ResponseEntity.ok(carLocation);
    }




}
