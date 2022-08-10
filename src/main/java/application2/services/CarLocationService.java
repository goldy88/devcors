package application2.services;

import application2.data.CarLocation;
import application2.repo.GpsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarLocationService {

    private final GpsRepository gpsRepository;

    public CarLocationService(GpsRepository gpsRepository) {
        this.gpsRepository = gpsRepository;
    }

    public List<CarLocation> findCarsByCarId(Long carId) {
        return gpsRepository.findCarsByCarId(carId);
    }
}
