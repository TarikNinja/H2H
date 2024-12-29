package com.example.H2HBackend.controller;


import com.example.H2HBackend.dtos.AttachmentResponseDto;
import com.example.H2HBackend.services.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/attachment")
@RequiredArgsConstructor
public class AttachmentController {
    private final AttachmentService attachmentService;

    @GetMapping("/download/{fileCode}")
    public ResponseEntity<?> getAttachmentById(@PathVariable("fileCode") String fileCode) {
        AttachmentResponseDto attachmentResponseDto = attachmentService.getAttachmentByFileCode(fileCode);
        String contentType = attachmentResponseDto.type();
        String headerValue = "attachment:filename=\"" + attachmentResponseDto.file() + "\"";
        return ResponseEntity.ok()
                .contentLength(attachmentResponseDto.size())
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(attachmentResponseDto.fileResource());
    }
}
