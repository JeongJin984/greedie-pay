package com.greedie.pay.banking.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmbankingRequestRepository extends JpaRepository<FirmbankingRequestEntity, Long> {
}
