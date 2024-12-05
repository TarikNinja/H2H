package com.example.H2HBackend.services;

import com.example.H2HBackend.dtos.AttachmentDto;
import com.example.H2HBackend.dtos.AttachmentResponseDto;
import com.example.H2HBackend.entities.Attachment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface AttachmentService {
    Attachment createAttachment(MultipartFile file);

    List<Attachment> createAttachments(MultipartFile[] file);

    AttachmentResponseDto getAttachmentByFileCode(String fileCode);

    void deleteAttachment(Long id);
}
