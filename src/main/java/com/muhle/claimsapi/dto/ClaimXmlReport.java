package com.muhle.claimsapi.dto;

import com.muhle.claimsapi.entity.ClaimStatus;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlRootElement(name = "claimReport")
public class ClaimXmlReport {

    private Long id;
    private String claimNumber;
    private String policyholderName;
    private String description;
    private BigDecimal claimAmount;
    private ClaimStatus status;
    private String createdAt;
    private String updatedAt;

    // Required by JAXB
    public ClaimXmlReport() {}

    public ClaimXmlReport(Long id, String claimNumber,
                          String policyholderName, String description,
                          BigDecimal claimAmount, ClaimStatus status,
                          LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.claimNumber = claimNumber;
        this.policyholderName = policyholderName;
        this.description = description;
        this.claimAmount = claimAmount;
        this.status = status;
        this.createdAt = createdAt.toString();
        this.updatedAt = updatedAt.toString();
    }

    @XmlElement public Long getId() { return id; }
    @XmlElement public String getClaimNumber() { return claimNumber; }
    @XmlElement public String getPolicyholderName() { return policyholderName; }
    @XmlElement public String getDescription() { return description; }
    @XmlElement public BigDecimal getClaimAmount() { return claimAmount; }
    @XmlElement public ClaimStatus getStatus() { return status; }
    @XmlElement public String getCreatedAt() { return createdAt; }
    @XmlElement public String getUpdatedAt() { return updatedAt; }
}
