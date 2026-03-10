package com.muhle.claimsapi.dto;
import com.muhle.claimsapi.entity.ClaimStatus;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ClaimResponse {
    private Long id;
    private String claimNumber;
    private String policyholderName;
    private String description;
    private BigDecimal claimAmount;
    private ClaimStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
