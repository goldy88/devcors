package application2.listener;

import application2.data.CarLocation;
import application2.repo.GpsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    private final GpsRepository gpsRepository;
    public MyListener(GpsRepository gpsRepository) {
        this.gpsRepository = gpsRepository;
    }

    @SneakyThrows
    @RabbitListener(queues = "coordinateQueue")
    public void process(Message message) {
        ObjectMapper objectMapper = new ObjectMapper();
        CarLocation carLocation = objectMapper.readValue(message.getBody(), CarLocation.class);
        System.out.println(carLocation);
        gpsRepository.save(carLocation);


    }


}
