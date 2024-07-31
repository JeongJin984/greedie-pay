package com.greedie.pay.banking.adapter.out.persistence;

import com.greedie.pay.banking.application.port.out.RegisterBankAccountPersistencePort;
import com.greedie.pay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@PersistenceAdapter
@Service
@RequiredArgsConstructor
public class MemberBankAccountPersistenceAdaptor implements RegisterBankAccountPersistencePort {
    private final MemberBankAccountJPARepository memberBankAccountJPARepository;

    @Override
    public void registerBankAccount(String membershipId, String bankName, String bankAccountNumber, Boolean isValid) {
        memberBankAccountJPARepository.save(new MemberBankAccountJPAEntity(membershipId, bankName, bankAccountNumber, isValid));
    }
}
