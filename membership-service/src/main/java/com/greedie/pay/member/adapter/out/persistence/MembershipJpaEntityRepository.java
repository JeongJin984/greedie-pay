package com.greedie.pay.member.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipJpaEntityRepository extends JpaRepository<MembershipJpaEntity, String> {
}
