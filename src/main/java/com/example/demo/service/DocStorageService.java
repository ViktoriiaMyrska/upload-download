package com.example.demo.service;

import com.example.demo.model.Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.repository.DocRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DocStorageService {
    @Autowired
    private DocRepository docRepository;

    public Doc saveFile(MultipartFile file){
        String docName = file.getOriginalFilename();
        try {
            Doc doc = new Doc(docName,file.getContentType(), file.getBytes());
            return docRepository.save(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Optional<Doc> getFile(Integer fileId){
        return docRepository.findById(fileId);
    }

    public List<Doc> getFiles(){
        return docRepository.findAll();
    }

}
