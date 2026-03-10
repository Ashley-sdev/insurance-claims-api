package com.muhle.claimsapi.service;
import com.muhle.claimsapi.dto.ClaimRequest;
import com.muhle.claimsapi.dto.ClaimResponse;
import com.muhle.claimsapi.entity.Claim;
import com.muhle.claimsapi.entity.ClaimStatus;
import com.muhle.claimsapi.exception.ClaimNotFoundException;
import com.muhle.claimsapi.repository.ClaimRepository;
import com.muhle.claimsapi.dto.ClaimXmlReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //this is a service component. Spring will manage lifecycle to make it available for injection elsewhere
public class ClaimService {

    @Autowired //A dependency injection. Spring creates repo & hands it to service
    private ClaimRepository claimRepository;

    public ClaimResponse submitClaim(ClaimRequest request) {
        Claim claim = new Claim();
        claim.setPolicyholderName(request.getPolicyholderName());
        claim.setDescription(request.getDescription());
        claim.setClaimAmount(request.getClaimAmount());

        Claim savedClaim = claimRepository.save(claim);
        return mapToResponse(savedClaim);
    }

    public List<ClaimResponse> getAllClaims() {
        List<Claim> claims = claimRepository.findAll();
        List<ClaimResponse> responses = new ArrayList<>();
        for (Claim claim : claims) {
            responses.add(mapToResponse(claim));
        }
        return responses; //Java Streams - powerful way to process collections. Takes all claims,
                                              // transforms each to a response DTO & collects them to a list
    }

    public ClaimResponse getClaimById(Long id) {
        Optional<Claim> result = claimRepository.findById(id);
        if (result.isPresent()) {
            return mapToResponse(result.get());
        } else {
            throw new ClaimNotFoundException(id); // Lambda Expression - get claim if exists, if not, throw custom exception
       }
    }

    public ClaimResponse updateClaimStatus(Long id, ClaimStatus newStatus) {
        Optional<Claim> result = claimRepository.findById(id);
        if (result.isPresent()) {
            Claim claim = result.get();
            claim.setStatus(newStatus);
            Claim updatedClaim = claimRepository.save(claim);
            return mapToResponse(updatedClaim);
        } else {
            throw new ClaimNotFoundException(id);
        }
    }

    public void deleteClaim(Long id) {
        Optional<Claim> result = claimRepository.findById(id);
        if (result.isPresent()) {
            claimRepository.delete(result.get());
        } else {
            throw new ClaimNotFoundException(id);
        }
    }

    private ClaimResponse mapToResponse(Claim claim) {
        ClaimResponse response = new ClaimResponse();
        response.setId(claim.getId());
        response.setClaimNumber(claim.getClaimNumber());
        response.setPolicyholderName(claim.getPolicyholderName());
        response.setDescription(claim.getDescription());
        response.setClaimAmount(claim.getClaimAmount());
        response.setStatus(claim.getStatus());
        response.setCreatedAt(claim.getCreatedAt());
        response.setUpdatedAt(claim.getUpdatedAt());
        return response;
    }
    public ClaimXmlReport getClaimAsXmlReport(Long id) {
        Optional<Claim> result = claimRepository.findById(id);
        if (result.isPresent()) {
            Claim claim = result.get();
            return new ClaimXmlReport(
                    claim.getId(),
                    claim.getClaimNumber(),
                    claim.getPolicyholderName(),
                    claim.getDescription(),
                    claim.getClaimAmount(),
                    claim.getStatus(),
                    claim.getCreatedAt(),
                    claim.getUpdatedAt()
            );
        } else {
            throw new ClaimNotFoundException(id);
        }
    }
}
