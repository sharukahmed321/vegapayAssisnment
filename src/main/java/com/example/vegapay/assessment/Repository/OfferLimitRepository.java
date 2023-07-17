package com.example.vegapay.assessment.Repository;

import com.example.vegapay.assessment.Entity.OfferLimitEntity;
import com.example.vegapay.assessment.Enum.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OfferLimitRepository extends JpaRepository<OfferLimitEntity, String> {

    Optional<OfferLimitEntity> findByAccountId(String AccountId);

    List<OfferLimitEntity> findByAccountIdAndStatus(String accountId, Status status);
}
