package com.quickwin.savedocument.controllers;

import com.quickwin.savedocument.entities.Document;
import com.quickwin.savedocument.reposototiesImpl.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/documents")
public class DocumentController {
    private final DocumentService documentService;
    @Autowired
    public DocumentController(DocumentService documentService){
        this.documentService = documentService;
    }

    @GetMapping("/")
    public List<Document> getDocuments() {
        return documentService.getDocuments();
    }

    @PostMapping("/saveDocument")
    public void saveDocuments(@RequestBody Document document){
        documentService.saveDocument(document);
    }

    @PutMapping(path = "{documentId}")
    public void updateDocument(
            @PathVariable("documentId") Long documentId,
            @RequestParam(required = false) String title
    ){
        documentService.updateDocument(documentId,title);
    }
    @DeleteMapping(path = "{documentId}")
    public void deleteDocument(@PathVariable("documentId") Long id){
        documentService.deleteDocument(id);
    }
}
