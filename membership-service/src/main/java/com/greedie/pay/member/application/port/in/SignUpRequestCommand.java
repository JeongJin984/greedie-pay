package com.greedie.pay.member.application.port.in;

import com.greedie.pay.common.SelfValidating;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class SignUpRequestCommand extends SelfValidating<SignUpRequestCommand> {
    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    private String email;

    private String address;

    @NotNull
    private boolean isCorp;

    public SignUpRequestCommand(String username, String password, String email, String address, boolean isCorp) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.isCorp = isCorp;
        validateSelf();
    }
}
