package org.example.officemanagement.service;

import org.example.officemanagement.model.Client;
import org.example.officemanagement.model.Document;
import org.example.officemanagement.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class DocumentService {

    private final String UPLOAD_DIR = "uploads/";

    @Autowired
    private DocumentRepository documentRepository;

    public DocumentService() {
        try {
            Files.createDirectories(Paths.get(UPLOAD_DIR));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Document uploadDocument(Client client, MultipartFile file) throws IOException {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIR + fileName);
        Files.copy(file.getInputStream(), filePath);

        Document document = new Document();
        document.setFileName(file.getOriginalFilename());
        document.setFilePath(filePath.toString());
        document.setFileType(file.getContentType());
        document.setClient(client);

        return documentRepository.save(document);
    }

    public List<Document> getDocumentsByClientId(String clientId) {
        return documentRepository.findByClientId(clientId);
    }
}
