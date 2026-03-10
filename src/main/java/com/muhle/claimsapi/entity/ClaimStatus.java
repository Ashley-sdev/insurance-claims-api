package com.muhle.claimsapi.entity;

public enum ClaimStatus {
    SUBMITTED,        // First Notice of Loss (FNOL) received
    UNDER_REVIEW,     // Assigned to adjuster, investigation in progress
    APPROVED,         // Claim validated and approved for settlement
    REJECTED,         // Claim denied after adjudication
    CLOSED            // Settlement complete, claim closed
}
