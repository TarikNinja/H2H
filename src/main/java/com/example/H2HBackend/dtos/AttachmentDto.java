package com.example.H2HBackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentDto {
    private Long id;
    private String name;
    private Long size;
    private String type;
    private String extension;
    private String file;
}
