package lesson5;

import application1.lesson5.facade.OutputFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class Lesson5Test {

    @Autowired
    private OutputFacade outputFacade;

    @Test
    void outputText() {
        assertEquals("Spring boot is awesome and Quarkus sucks", outputFacade.outputText());
    }

    @Test
    void outputNumber() {
        assertEquals("5", outputFacade.outputNumber());
    }
}
