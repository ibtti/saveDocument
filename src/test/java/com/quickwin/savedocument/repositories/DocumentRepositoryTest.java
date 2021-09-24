package com.quickwin.savedocument.repositories;

import com.quickwin.savedocument.entities.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DocumentRepositoryTest {
    @Autowired
    private DocumentRepository underTest;


    @Test
    void itShouldCheckIfDocumentExistsTitle() {
        //given
        String title = "time";
        Document document = new Document( LocalDate.of(2021, Month.SEPTEMBER, 20), "content",
                "mimeType", "description"
                , "time",
                LocalDate.of(2021, Month.SEPTEMBER, 20),
                LocalDate.of(2021, Month.SEPTEMBER, 20),
                "metaentities"
        );
        underTest.save(document);

        //when

        boolean expected = underTest.getDocumentByTitle(title).equals(document);

        //then

        assertThat(expected).isTrue();
    }
}