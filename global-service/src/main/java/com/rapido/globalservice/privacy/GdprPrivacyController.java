package com.rapido.globalservice.privacy;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class GdprPrivacyController {

    private final GdprPrivacyService service;

    public GdprPrivacyController(
            GdprPrivacyService service
    ) {
        this.service = service;
    }

    @GetMapping("/data-export")
    public ResponseEntity<InputStreamResource>
    exportData(
            @RequestParam Long userId
    ) {

        InputStreamResource resource =
                new InputStreamResource(
                        service.exportUserData(
                                userId
                        )
                );

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=user-data.json"
                )
                .contentType(
                        MediaType.APPLICATION_OCTET_STREAM
                )
                .body(resource);
    }

    @DeleteMapping("/data-request")
    public String deleteRequest(
            @RequestParam Long userId
    ) {

        service.requestDeletion(
                userId
        );

        return "Deletion request accepted";
    }
}