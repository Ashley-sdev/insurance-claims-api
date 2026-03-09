package com.muhle.claimsapi.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity //enables ORM - "the following class is a database table"
@Table(name = "claims") // names the database table 'claims' otherwise table name is class name by default
public class Claim {

    @Id //marks as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increments value
    private Long id; //Long = larger larger integer type

    @Column(unique = true, nullable = false)
    private String claimNumber; // String is a class (string variables are references to objects in memory) (not Primitive), stores & manipulates text data

    @NotBlank(message = "Policyholder name is required")
    @Column(nullable = false)
    private String policyholderName;

    @NotBlank(message = "Description is required")
    @Column(nullable = false, length = 1000)
    private String description;

    @NotNull(message = "Claim amount is required")
    @DecimalMin(value = "0.01", message = "Claim amount must be greater than zero")
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal claimAmount; // precise decimal type for money, critical in financial systems

    @Enumerated(EnumType.STRING) // stores enum values as a String not number in database for readability
    @Column(nullable = false)
    private ClaimStatus status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() { // method that runs automatically before saving new record to database. Sets & creates timestamp & auto-generates claim number
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        status = ClaimStatus.SUBMITTED;
        claimNumber = "CLM-" + System.currentTimeMillis(); //generates unique claim number using current time in milliseconds
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
