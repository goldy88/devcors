package application1.lesson5.service;

import application1.lesson5.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StringOutputService implements OutputService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public String output() {
        return documentRepository.retrieveConcatenatedText();
    }
}
