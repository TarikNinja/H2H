package com.example.H2HBackend.services.Impl;

import com.example.H2HBackend.dtos.AttachmentResponseDto;
import com.example.H2HBackend.entities.Attachment;
import com.example.H2HBackend.repositories.AttachmentRepository;
import com.example.H2HBackend.services.AttachmentService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    private AttachmentRepository attachmentRepository;
    @Override
    public Attachment createAttachment(MultipartFile file) {
        if (file == null) {
            return null;
        }
        Attachment attachment = null;
        try {
            String fileName = file.getOriginalFilename();
            Long fileSize = file.getSize();
            String extension = fileName.substring(fileName.lastIndexOf("."));
            String filePath = saveFile(fileName, file);
            String type = file.getContentType();
            attachment = Attachment.builder()
                    .name(fileName)
                    .size(fileSize)
                    .extension(extension)
                    .type(type)
                    .file(filePath).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return attachment;
    }

    @Override
    public List<Attachment> createAttachments(MultipartFile[] files) {
        if (files.length == 0) {
            throw new RuntimeException("Files are empty !!");
        }
        List<Attachment> attachments = new ArrayList<>();
        for (MultipartFile file : files) {
            attachments.add(createAttachment(file));
        }
        return attachments;
    }

    @Override
    public AttachmentResponseDto getAttachmentByFileCode(String fileCode) {
        Attachment attachment = attachmentRepository.findAttachmentByFile(fileCode);
        if (attachment == null) {
            throw new RuntimeException("Attachmenet not found");
        }
        return AttachmentResponseDto.builder()
                .size(attachment.getSize())
                .extension(attachment.getExtension())
                .type(attachment.getType())
                .name(attachment.getName())
                .file(attachment.getFile())
                .fileResource(getFileAsResource(fileCode))
                .build();
    }

    @Override
    public void deleteAttachment(Long id) {
        attachmentRepository.deleteById(id);
    }
    private String saveFile(String fileName, MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get("src", "main", "resources", "static", "file-upload");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        String fileCode = UUID.randomUUID().toString();
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileCode + "-" + fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save file: " + fileName, ioe);
        }
        return fileCode + "-" + fileName;
    }

    private Resource getFileAsResource(String fileCode) {
        Path dirPath = Paths.get("src", "main", "resources", "static", "file-upload");
        try (Stream<Path> filesStream = Files.list(dirPath)) {
            Path foundFile = filesStream
                    .filter(file -> file.getFileName().toString().startsWith(fileCode))
                    .findFirst()
                    .orElse(null);
            if (foundFile != null) {
                return (Resource) new UrlResource(foundFile.toUri());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
