package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "docs")
public class Doc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String docName;
    private String docType;

    @Lob
    private byte[] data;

    public Doc(String docName, String docType, byte[] data) {
        this.docName = docName;
        this.docType = docType;
        this.data = data;
    }

    public Doc() {
    }

    public String getDocName() {
        return docName;
    }

    public String getDocType() {
        return docType;
    }

    public byte[] getData() {
        return data;
    }

    public Integer getId() {
        return id;
    }
}
