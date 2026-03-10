package com.muhle.claimsapi.exception;

public class ClaimNotFoundException extends RuntimeException {

    public ClaimNotFoundException(Long id) {
        super("Claim not found with id: " + id);
    }

    public ClaimNotFoundException(String claimNumber) {
        super("Claim not found with claim number: " + claimNumber);
    }
}