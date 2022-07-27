package br.com.asa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingleSystemOfSocialAssistanceFamilyDto {
    private int responsibleFamilyMemberId;
    private String localAttendanceDescription;
    private String localAttendanceAddress;
    private int needsIdentifiedBySocialAssistance;
    private String referralFormDate;
    private String referralPlaceOfOriginDescription;
    private String referralPlaceOfOriginContact;
    private int referralPlaceOfOriginSocialWorkerId;
    private String referralFormDetails;
    @Override
    public String toString() {
        return "{" +
                "responsibleFamilyMemberId=" + responsibleFamilyMemberId +
                ", localAttendanceDescription=" + localAttendanceDescription +
                ", localAttendanceAddress=" + localAttendanceAddress +
                ", needsIdentifiedBySocialAssistance=" + needsIdentifiedBySocialAssistance +
                ", referralFormDate=" + referralFormDate +
                ", referralPlaceOfOriginDescription=" + referralPlaceOfOriginDescription +
                ", referralPlaceOfOriginContact=" + referralPlaceOfOriginContact +
                ", referralPlaceOfOriginSocialWorkerId=" + referralPlaceOfOriginSocialWorkerId +
                ", referralFormDetails=" + referralFormDetails +
                '}';
    }
}
