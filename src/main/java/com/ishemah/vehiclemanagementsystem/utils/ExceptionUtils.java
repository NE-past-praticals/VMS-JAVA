package com.ishemah.vehiclemanagementsystem.utils;

import com.ishemah.vehiclemanagementsystem.exceptions.BadRequestException;
import com.ishemah.vehiclemanagementsystem.exceptions.ConflictException;
import com.ishemah.vehiclemanagementsystem.exceptions.InternalServerErrorException;
import com.ishemah.vehiclemanagementsystem.exceptions.NotFoundException;
import com.ishemah.vehiclemanagementsystem.exceptions.*;
import com.ishemah.vehiclemanagementsystem.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;

import java.nio.file.AccessDeniedException;

public class ExceptionUtils {
    public static ResponseEntity<ApiResponse<Object>> handleResponseException(Exception e) {
        if (e instanceof NotFoundException) {
            return ApiResponse.fail(
                    e.getMessage(),
                    HttpStatus.NOT_FOUND,
                    null
            );
        }

        if (e instanceof ConflictException) {
            return ApiResponse.fail(
                    e.getMessage(),
                    HttpStatus.CONFLICT,
                    null
            );
        } else if (e instanceof InternalServerErrorException) {
            return ApiResponse.fail(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        } else if (e instanceof BadRequestException || e instanceof InternalAuthenticationServiceException || e instanceof BadCredentialsException || e instanceof AccessDeniedException) {
            return ApiResponse.fail(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST,
                    null
            );
        } else {
            return ApiResponse.fail(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }
}