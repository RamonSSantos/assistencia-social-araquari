package br.com.asa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgeProfileOfFamilyDto {
    private int zeroToSix;
    private int sevenToFourteen;
    private int fifteenToSeventeen;
    private int eighteenToTwentyNine;
    private int thirtyToFiftyNine;
    private int sixtyToSixtyFour;
    private int sixtyFiveToSixtyNine;
    private int seventyToPlus;

    @Override
    public String toString() {
        return "{" +
                "zeroToSix=" + zeroToSix +
                ", sevenToFourteen=" + sevenToFourteen +
                ", fifteenToSeventeen=" + fifteenToSeventeen +
                ", eighteenToTwentyNine=" + eighteenToTwentyNine +
                ", thirtyToFiftyNine=" + thirtyToFiftyNine +
                ", sixtyToSixtyFour=" + sixtyToSixtyFour +
                ", sixtyFiveToSixtyNine=" + sixtyFiveToSixtyNine +
                ", seventyToPlus=" + seventyToPlus +
                '}';
    }
}
