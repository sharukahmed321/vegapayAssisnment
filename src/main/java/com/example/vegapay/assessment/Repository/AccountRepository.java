package com.example.vegapay.assessment.Repository;

import com.example.vegapay.assessment.Entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,String> {
}
