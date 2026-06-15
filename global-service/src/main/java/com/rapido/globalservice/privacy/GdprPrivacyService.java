package com.rapido.globalservice.privacy;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

@Service
public class GdprPrivacyService {

    private final ConsentLogRepository consentLogRepository;

    private final UserDeletionRequestRepository
            deletionRequestRepository;

    public GdprPrivacyService(
            ConsentLogRepository consentLogRepository,
            UserDeletionRequestRepository deletionRequestRepository
    ) {
        this.consentLogRepository =
                consentLogRepository;

        this.deletionRequestRepository =
                deletionRequestRepository;
    }

    public ByteArrayInputStream exportUserData(
            Long userId
    ) {

        ConsentLog log =
                new ConsentLog();

        log.setUserId(userId);
        log.setAction("DATA_EXPORT");

        consentLogRepository.save(log);

        String payload =
                """
                {
                  "userId": %d,
                  "exportStatus":"READY"
                }
                """.formatted(userId);

        return new ByteArrayInputStream(
                payload.getBytes(
                        StandardCharsets.UTF_8
                )
        );
    }

    public void requestDeletion(
            Long userId
    ) {

        ConsentLog consent =
                new ConsentLog();

        consent.setUserId(userId);
        consent.setAction(
                "ACCOUNT_DELETION_REQUEST"
        );

        consentLogRepository.save(consent);

        UserDeletionRequest request =
                new UserDeletionRequest();

        request.setUserId(userId);
        request.setStatus("PENDING");

        deletionRequestRepository.save(
                request
        );

        processDeletionAsync(
                request.getId()
        );
    }

    @Async
    public void processDeletionAsync(
            Long requestId
    ) {

        try {

            Thread.sleep(5000);

            UserDeletionRequest request =
                    deletionRequestRepository
                            .findById(requestId)
                            .orElseThrow();

            request.setStatus(
                    "COMPLETED"
            );

            deletionRequestRepository
                    .save(request);

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}