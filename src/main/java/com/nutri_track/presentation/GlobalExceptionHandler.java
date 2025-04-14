package com.nutri_track.presentation;

import com.nutri_track.domain.exceptions.AppointmentOverlapException;
import com.nutri_track.domain.exceptions.NutriTrackRuntimeException;
import com.nutri_track.domain.dtos.MessageDto;
import jakarta.persistence.OptimisticLockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NutriTrackRuntimeException.class})
    public ResponseEntity<MessageDto> handleNutriTrackRuntimeException(NutriTrackRuntimeException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new MessageDto(exception.getMessage()));
    }

    @ExceptionHandler({OptimisticLockException.class})
    public ResponseEntity<MessageDto> handleOptmisticLockException(OptimisticLockException exception) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new MessageDto("The resource has been modified by another process. Please try again."));
    }

    @ExceptionHandler({AppointmentOverlapException.class})
    public ResponseEntity<MessageDto> handleAppointmentOverlapException(AppointmentOverlapException exception) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new MessageDto(exception.getMessage()));
    }
}