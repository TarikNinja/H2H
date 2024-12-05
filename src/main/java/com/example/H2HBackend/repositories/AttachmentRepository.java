package com.example.H2HBackend.repositories;

import com.example.H2HBackend.entities.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment,Long> {
    Attachment findAttachmentByFile(String fileCode);
}
