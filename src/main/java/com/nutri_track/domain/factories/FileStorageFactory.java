package com.nutri_track.domain.factories;

import com.nutri_track.domain.ports.FileStoragePort;
import com.nutri_track.infra.adapters.S3FileStorageAdapter;
import org.springframework.stereotype.Component;

@Component
public class FileStorageFactory {

    private final S3FileStorageAdapter s3FileStorageAdapter;

    public FileStorageFactory(S3FileStorageAdapter s3FileStorageAdapter) {
        this.s3FileStorageAdapter = s3FileStorageAdapter;
    }

    public FileStoragePort create() {
        return s3FileStorageAdapter;
    }
}
