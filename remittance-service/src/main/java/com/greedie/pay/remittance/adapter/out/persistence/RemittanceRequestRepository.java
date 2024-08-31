package com.greedie.pay.remittance.adapter.out.persistence;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemittanceRequestRepository extends JpaRepository<RemittanceRequestJpaEntity, String> {
}
