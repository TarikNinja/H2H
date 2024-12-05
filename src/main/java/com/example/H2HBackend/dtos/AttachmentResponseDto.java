package com.example.H2HBackend.dtos;

import jakarta.annotation.Resource;
import lombok.Builder;

@Builder
public record AttachmentResponseDto(
        String name,
        Long size,
        String extension,
        String type,
        String file,
        Resource fileResource
) {
}
