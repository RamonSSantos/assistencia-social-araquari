package br.com.asa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonitoringFamilyDto {
    private int userId;
    private int responsibleFamilyMemberIdentification;
    private String dateOfValuation;
    private int numberOfMonthsOfFamilyMonitoring;
    private String socialAssistanceOffers;
    private String effectiveService;
    private String serviceMonitoringContributes;
    private String resultsObtained;
    private String resultsObtainedDescription;

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", responsibleFamilyMemberIdentification=" + responsibleFamilyMemberIdentification +
                ", dateOfValuation=" + dateOfValuation +
                ", numberOfMonthsOfFamilyMonitoring=" + numberOfMonthsOfFamilyMonitoring +
                ", socialAssistanceOffers='" + socialAssistanceOffers + '\'' +
                ", effectiveService='" + effectiveService + '\'' +
                ", serviceMonitoringContributes='" + serviceMonitoringContributes + '\'' +
                ", resultsObtained='" + resultsObtained + '\'' +
                ", resultsObtainedDescription='" + resultsObtainedDescription + '\'' +
                '}';
    }
}
