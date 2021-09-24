package com.quickwin.savedocument.configurations;

import com.quickwin.savedocument.entities.Document;
import com.quickwin.savedocument.repositories.DocumentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class DocumentConfiguration {


    @Bean
    CommandLineRunner commandLineRunner(DocumentRepository documentRepository){
        return args -> {

            Document document = new Document( LocalDate.of(2021, Month.SEPTEMBER, 20), "content",
                    "mimeType", "description"
                    , "time sheet",
                    LocalDate.of(2021, Month.SEPTEMBER, 20),
                    LocalDate.of(2021, Month.SEPTEMBER, 20), "metaentities");
            Document documentSecond = new Document( LocalDate.of(2021, Month.SEPTEMBER, 20), "content",
                    "mimeType", "description"
                    , "time sheet",
                    LocalDate.of(2021, Month.SEPTEMBER, 20),
                    LocalDate.of(2021, Month.SEPTEMBER, 20), "metaentities");

            documentRepository.saveAll(List.of(document,documentSecond));
        };
    }
}
