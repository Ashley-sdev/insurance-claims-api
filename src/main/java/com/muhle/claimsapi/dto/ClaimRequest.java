package com.muhle.claimsapi.dto;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ClaimRequest {
    @NotBlank(message = "Policyholder name is required")
    private String policyholderName;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Claim amount is required")
    @DecimalMin(value = "0.01", message = "Claim amount must be greater than zero")
    private BigDecimal claimAmount;
}
