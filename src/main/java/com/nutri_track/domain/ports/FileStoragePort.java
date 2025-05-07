package com.nutri_track.domain.ports;

import com.nutri_track.domain.value_objects.FileLocation;

import java.io.IOException;

public interface FileStoragePort {
    FileLocation store(byte[] content) throws IOException;
}
