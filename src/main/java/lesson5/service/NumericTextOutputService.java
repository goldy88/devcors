package lesson5.service;

import  lesson5.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumericTextOutputService implements OutputService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public String output() {
        return documentRepository.retrieveNumber().toString();
    }
}
