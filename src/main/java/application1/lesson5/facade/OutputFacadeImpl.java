package application1.lesson5.facade;

import application1.lesson5.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OutputFacadeImpl implements OutputFacade {

    @Autowired
    private OutputService numericTextOutputService;
    @Autowired
    private OutputService stringOutputService;

    @Override
    public String outputText() {
        return stringOutputService.output();
    }

    @Override
    public String outputNumber() {
        return numericTextOutputService.output();
    }
}
