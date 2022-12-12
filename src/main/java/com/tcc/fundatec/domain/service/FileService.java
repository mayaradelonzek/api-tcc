package com.tcc.fundatec.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@Service
public class FileService {

//    private static final String LOCAL_PATH = "src/main/resouces/resumes/";
    private static final String LOCAL_PATH = "/home/mayara_delonzek/Documents/Pessoal/TCC/arquivos/";

    public void uploadFile(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(LOCAL_PATH + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException ex) {
            System.out.println("deu pau");
        }
    }

    public String getStoragePath() {
        return LOCAL_PATH;
    }

}
