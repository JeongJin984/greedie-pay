package com.greedie.pay.member.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "greedie_membership")
@Data
@NoArgsConstructor
public class MembershipJpaEntity {
    @Id
    private String membershipId;
    private String name;
    private String password;
    private String address;
    private String email;
    private boolean isValid;
    private boolean isCorp;

    public MembershipJpaEntity(String membershipId, String name, String address, String email, boolean isValid, boolean isCorp) {
        this.membershipId = membershipId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.isValid = isValid;
        this.isCorp = isCorp;
    }
}
