//package com.rapido.backupservice.storage;
//
//import java.nio.file.Paths;
//
//import org.springframework.stereotype.Service;
//
//import software.amazon.awssdk.services.s3.S3Client;
//import software.amazon.awssdk.services.s3.model.PutObjectRequest;
//
//@Service
//public class BackupUploadService {
//
//    private final S3Client s3Client;
//
//    public BackupUploadService(
//            S3Client s3Client) {
//
//        this.s3Client = s3Client;
//    }
//
//    public void uploadBackup(
//            String filePath,
//            String bucketName,
//            String objectName) {
//
//        PutObjectRequest request =
//                PutObjectRequest.builder()
//                        .bucket(bucketName)
//                        .key(objectName)
//                        .build();
//
//        s3Client.putObject(
//                request,
//                Paths.get(filePath));
//
//        System.out.println(
//                "Backup uploaded successfully");
//    }
//}