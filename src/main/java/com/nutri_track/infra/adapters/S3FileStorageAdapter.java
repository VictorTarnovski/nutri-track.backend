package com.nutri_track.infra.adapters;

import com.nutri_track.domain.ports.FileStoragePort;
import com.nutri_track.domain.value_objects.FileLocation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@Component
public class S3FileStorageAdapter implements FileStoragePort {
    private final String bucketName;
    private final String region;
    private final S3Client s3Client;

    public S3FileStorageAdapter(
            @Value("${aws.endpoint}") String endpoint,
            @Value("${aws.s3.region}") String region,
            @Value("${aws.s3.bucket-name}") String bucketName) throws URISyntaxException {
        this.bucketName = bucketName;
        this.region = region;
        this.s3Client = S3Client.builder()
                .endpointOverride(new URI(endpoint))
                .forcePathStyle(true)
                .region(Region.of(this.region))
                .build();
    }

    @Override
    public FileLocation store(byte[] content) throws IOException {
        var key = UUID.randomUUID();
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key.toString())
                .contentType("application/octet-stream")
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(content));

        var path = String.format("s3://%s/%s", bucketName, key);
        return FileLocation.forS3(path);
    }

    @Override
    public byte[] retrieve(String path) throws IOException {
        var strs = path.split("/");
        var bucketName = strs[2];
        var key = strs[3];

        var getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .responseContentType("application/octet-stream")
                .build();

        byte[] content = s3Client.getObject(getObjectRequest).readAllBytes();
        return content;
    }
}
