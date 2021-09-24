package com.quickwin.savedocument.reposototiesImpl;

import com.quickwin.savedocument.entities.Document;
import com.quickwin.savedocument.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository){
        this.documentRepository= documentRepository;
    }

    public List<Document> getDocuments(){
        return documentRepository.findAll();
    }

    public void saveDocument(Document document) {
        documentRepository.save(document);
    }

    public void deleteDocument(Long id) {
        boolean exists = documentRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Document with id "+ id +" does not exist");
        }
        documentRepository.deleteById(id);
    }

    @Transactional
    public void updateDocument(Long documentId, String title) {
        Document document = documentRepository.findById(documentId).orElseThrow( () -> new IllegalStateException("Document with id "+ documentId +" does not exist"));
        if (title != null && title.length()>0 && !Objects.equals(document.getTitle(),title)){
            document.setTitle(title);
        }
    }
}
