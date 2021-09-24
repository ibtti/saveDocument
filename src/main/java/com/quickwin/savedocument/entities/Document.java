package com.quickwin.savedocument.entities;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Document {
    @Id
    @SequenceGenerator(
            name = "title_sequence",
            sequenceName = "title_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator ="title_sequence"
    )
    private Long id;
    private LocalDate creationDate;
    private String content;
    private String mimeType;
    private String description;

    private String title;
    private LocalDate createdAt;
    private LocalDate modifiedAt;
    private String metadataEntities;


    public Document(LocalDate creationDate,String title) {
        this.creationDate = creationDate;
        this.title = title;

    }
    public Document(Long id,LocalDate creationDate, String content, String mimeType, String description, String title, LocalDate createdAt, LocalDate modifiedAt, String metadataEntities) {

        this.id=id;
        this.creationDate = creationDate;
        this.content = content;
        this.mimeType = mimeType;
        this.description = description;
        this.title = title;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.metadataEntities = metadataEntities;
    }
    public Document(LocalDate creationDate, String content, String mimeType, String description, String title, LocalDate createdAt, LocalDate modifiedAt, String metadataEntities) {


        this.creationDate = creationDate;
        this.content = content;
        this.mimeType = mimeType;
        this.description = description;
        this.title = title;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.metadataEntities = metadataEntities;
    }
    public Document() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDate modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getMetadataEntities() {
        return metadataEntities;
    }

    public void setMetadataEntities(String metadataEntities) {
        this.metadataEntities = metadataEntities;
    }

    @Override
    public String toString() {
        return "Document{" +
                "creationDate=" + creationDate +
                ", content='" + content + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", metadataEntities='" + metadataEntities + '\'' +
                '}';
    }
}
