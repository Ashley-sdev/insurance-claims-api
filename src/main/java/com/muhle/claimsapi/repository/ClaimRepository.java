package com.muhle.claimsapi.repository;
import com.muhle.claimsapi.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
    Optional<Claim> findByClaimNumber(String claimNumber);

    List<Claim> findByPolicyholderNameContainingIgnoreCase(String name);

    List<Claim> findByStatus(com.muhle.claimsapi.entity.ClaimStatus status);
}
