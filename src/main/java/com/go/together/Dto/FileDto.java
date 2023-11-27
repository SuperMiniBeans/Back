package com.go.together.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Data
@Slf4j
@NoArgsConstructor
public class FileDto {
    private Long FileNumber;
    private String fileName;
    private String fileUploadPath;
    private String fileUuid;
    private Long productNumber;
    ;
}
