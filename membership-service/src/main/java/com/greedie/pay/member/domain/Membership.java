package com.greedie.pay.member.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Membership {
    private final String membershipId;
    private final String name;
    private final String password;
    private final String email;
    private final String address;
    private final boolean isValid;
    private final boolean isCorp;
}
