package br.com.asa.services;

import java.util.Optional;

import br.com.asa.dtos.*;
import br.com.asa.models.FamilyAnswerEntity;

public interface FamilyAnswerService {
	Optional<FamilyAnswerEntity> findById(Integer id);
	void save(FamilyAnswerDto familyAnswerDto);
	MonitoringFamilyDto getMonitoringFamilyById(int id);
	void newMonitoringFamily(int familyId, MonitoringFamilyDto monitoringFamilyDto);
	DispatchFamilyDto getDispatchFamilyById(int id);
	void newDispatchFamily(int familyId, DispatchFamilyDto dispatchFamilyDto);
	AgeProfileOfFamilyDto getAgeProfileOfFamilyById(int id);
	void newAgeProfileOfFamily(int familyId, AgeProfileOfFamilyDto ageProfileOfFamilyDto);
	FirstInterviewReasonFamilyDto getFirstInterviewReasonFamilyById(int id);
	void newFirstInterviewReasonFamily(int familyId, FirstInterviewReasonFamilyDto firstInterviewReasonFamilyDto);
	SingleSystemOfSocialAssistanceFamilyDto getSingleSystemOfSocialAssistanceFamilyById(int id);
	void newSingleSystemOfSocialAssistanceFamily(int familyId, SingleSystemOfSocialAssistanceFamilyDto singleSystemOfSocialAssistanceFamilyDto);
}