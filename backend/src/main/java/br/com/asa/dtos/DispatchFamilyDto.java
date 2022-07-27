package br.com.asa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DispatchFamilyDto {
    private int locationCodeFromReferralId;
    private int referralRegisterReason;
    private String referralRegisterDate;
    private int referralRegisterSocialWorkerId;
    private String referralRegisterDetails;

    @Override
    public String toString() {
        return "{" +
                "locationCodeFromReferralId=" + locationCodeFromReferralId +
                ", referralRegisterReason=" + referralRegisterReason +
                ", referralRegisterDate=" + referralRegisterDate +
                ", referralRegisterSocialWorkerId=" + referralRegisterSocialWorkerId +
                ", referralRegisterDetails=" + referralRegisterDetails +
                '}';
    }
}
