package com.binary.carDealerApp.classCarDealerApp.exception;

import java.time.LocalDateTime;

public record ApiError(
        String message,
        int statusCode,
        String path,
        LocalDateTime timestamp
) {
}
