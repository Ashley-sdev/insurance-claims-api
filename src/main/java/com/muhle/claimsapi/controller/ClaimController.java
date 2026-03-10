package com.muhle.claimsapi.controller;
import com.muhle.claimsapi.dto.ClaimRequest;
import com.muhle.claimsapi.dto.ClaimResponse;
import com.muhle.claimsapi.entity.ClaimStatus;
import com.muhle.claimsapi.service.ClaimService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {
    @Autowired
    private ClaimService claimService;

//POST /api/claims - Submit a new claim
    @PostMapping
    public ResponseEntity<ClaimResponse> submitClaim(
            @Valid @RequestBody ClaimRequest request) {
        ClaimResponse response = claimService.submitClaim(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET /api/claims - Get all claims
    @GetMapping
    public ResponseEntity<List<ClaimResponse>> getAllClaims() {
        List<ClaimResponse> claims = claimService.getAllClaims();
        return ResponseEntity.ok(claims);
    }

    // GET /api/claims/{id} - Get a specific claim by ID
    @GetMapping("/{id}")
    public ResponseEntity<ClaimResponse> getClaimById(
            @PathVariable Long id) {
        ClaimResponse response = claimService.getClaimById(id);
        return ResponseEntity.ok(response);
    }

    // PUT /api/claims/{id}/status - Update claim status
    @PutMapping("/{id}/status")
    public ResponseEntity<ClaimResponse> updateClaimStatus(
            @PathVariable Long id,
            @RequestParam ClaimStatus status) {
        ClaimResponse response = claimService.updateClaimStatus(id, status);
        return ResponseEntity.ok(response);
    }

    // DELETE /api/claims/{id} - Delete a claim
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClaim(
            @PathVariable Long id) {
        claimService.deleteClaim(id);
        return ResponseEntity.noContent().build();
    }
}
