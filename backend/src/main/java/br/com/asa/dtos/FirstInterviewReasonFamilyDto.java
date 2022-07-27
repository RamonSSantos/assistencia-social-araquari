package br.com.asa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FirstInterviewReasonFamilyDto {
    private String wayToGetFirstInterview;
    private String governmentAgencyDescription;
    private String firstInterviewReason;
    private int beneficiarySocialProgramme;
    private String beneficiarySocialProgrammeDescription;

    @Override
    public String toString() {
        return "{" +
                "wayToGetFirstInterview=" + wayToGetFirstInterview +
                ", governmentAgencyDescription=" + governmentAgencyDescription +
                ", firstInterviewReason=" + firstInterviewReason +
                ", beneficiarySocialProgramme=" + beneficiarySocialProgramme +
                ", beneficiarySocialProgrammeDescription=" + beneficiarySocialProgrammeDescription +
                '}';
    }
}
