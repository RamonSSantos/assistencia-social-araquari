package br.com.asa.services;

import java.util.*;

import br.com.asa.dtos.*;
import br.com.asa.utils.DateFormatter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.asa.models.FamilyAnswerEntity;
import br.com.asa.repositories.FamilyAnswerRepository;

@Service
public class FamilyAnswerServiceImpl implements FamilyAnswerService {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final FamilyAnswerRepository familyAnswerRepository;

	@Autowired
	public FamilyAnswerServiceImpl(FamilyAnswerRepository familyAnswerRepository) {
		this.familyAnswerRepository = familyAnswerRepository;
	}

	@Override
	public Optional<FamilyAnswerEntity> findById(Integer id) {
		return this.familyAnswerRepository.findById(id);
	}

	@Override
	public void save(FamilyAnswerDto familyAnswerDto) {
		FamilyAnswerEntity familyAnswerEntity = new FamilyAnswerEntity();
		BeanUtils.copyProperties(familyAnswerDto, familyAnswerEntity);

		this.familyAnswerRepository.save(familyAnswerEntity);
	}

	@Override
	public MonitoringFamilyDto getMonitoringFamilyById(int id) {
		Optional<FamilyAnswerEntity> familyAnswerEntity = familyAnswerRepository.findById(id);

		try {
			return new ObjectMapper().readValue(familyAnswerEntity.map(FamilyAnswerEntity::getJson).orElse(null), MonitoringFamilyDto.class);
		} catch (JsonProcessingException exp) {
			logger.error(exp.toString(), exp);
		}
		return null;
	}

	@Override
	public void newMonitoringFamily(int familyId, MonitoringFamilyDto monitoringFamilyDto) {
		FamilyAnswerEntity familyAnswer = new FamilyAnswerEntity();

		try {
			familyAnswer.setRegisterDate(DateFormatter.convertDateObjectToDateSql());
			familyAnswer.setFormName("monitoringFamily");
			familyAnswer.setJson(new ObjectMapper().writeValueAsString(monitoringFamilyDto));
			familyAnswer.setFamilyId(familyId);

			familyAnswerRepository.save(familyAnswer);
		} catch (JsonProcessingException exp) {
			logger.error(exp.toString(), exp);
		}
	}

	@Override
	public DispatchFamilyDto getDispatchFamilyById(int id) {
		Optional<FamilyAnswerEntity> familyAnswerEntity = familyAnswerRepository.findById(id);

		try {
			return new ObjectMapper().readValue(familyAnswerEntity.map(FamilyAnswerEntity::getJson).orElse(null), DispatchFamilyDto.class);
		} catch (JsonProcessingException exp) {
			logger.error(exp.toString(), exp);
		}
		return null;
	}

	@Override
	public void newDispatchFamily(int familyId, DispatchFamilyDto dispatchFamilyDto) {
		FamilyAnswerEntity familyAnswer = new FamilyAnswerEntity();

		try {
			familyAnswer.setRegisterDate(DateFormatter.convertDateObjectToDateSql());
			familyAnswer.setFormName("dispatchFamily");
			familyAnswer.setJson(new ObjectMapper().writeValueAsString(dispatchFamilyDto));
			familyAnswer.setFamilyId(familyId);

			familyAnswerRepository.save(familyAnswer);
		} catch (JsonProcessingException exp) {
			logger.error(exp.toString(), exp);
		}
	}

	@Override
	public AgeProfileOfFamilyDto getAgeProfileOfFamilyById(int id) {
		Optional<FamilyAnswerEntity> familyAnswerEntity = familyAnswerRepository.findById(id);

		try {
			return new ObjectMapper().readValue(familyAnswerEntity.map(FamilyAnswerEntity::getJson).orElse(null), AgeProfileOfFamilyDto.class);
		} catch (JsonProcessingException exp) {
			logger.error(exp.toString(), exp);
		}
		return null;
	}

	@Override
	public void newAgeProfileOfFamily(int familyId, AgeProfileOfFamilyDto ageProfileOfFamilyDto) {
		FamilyAnswerEntity familyAnswer = new FamilyAnswerEntity();

		try {
			familyAnswer.setRegisterDate(DateFormatter.convertDateObjectToDateSql());
			familyAnswer.setFormName("ageProfileOfFamily");
			familyAnswer.setJson(new ObjectMapper().writeValueAsString(ageProfileOfFamilyDto));
			familyAnswer.setFamilyId(familyId);

			familyAnswerRepository.save(familyAnswer);
		} catch (JsonProcessingException exp) {
			logger.error(exp.toString(), exp);
		}
	}

	@Override
	public FirstInterviewReasonFamilyDto getFirstInterviewReasonFamilyById(int id) {
		Optional<FamilyAnswerEntity> familyAnswerEntity = familyAnswerRepository.findById(id);

		try {
			return new ObjectMapper().readValue(familyAnswerEntity.map(FamilyAnswerEntity::getJson).orElse(null), FirstInterviewReasonFamilyDto.class);
		} catch (JsonProcessingException exp) {
			logger.error(exp.toString(), exp);
		}
		return null;
	}

	@Override
	public void newFirstInterviewReasonFamily(int familyId, FirstInterviewReasonFamilyDto firstInterviewReasonFamilyDto) {
		FamilyAnswerEntity familyAnswer = new FamilyAnswerEntity();

		try {
			familyAnswer.setRegisterDate(DateFormatter.convertDateObjectToDateSql());
			familyAnswer.setFormName("firstInterviewReasonFamily");
			familyAnswer.setJson(new ObjectMapper().writeValueAsString(firstInterviewReasonFamilyDto));
			familyAnswer.setFamilyId(familyId);

			familyAnswerRepository.save(familyAnswer);
		} catch (JsonProcessingException exp) {
			logger.error(exp.toString(), exp);
		}
	}

	@Override
	public SingleSystemOfSocialAssistanceFamilyDto getSingleSystemOfSocialAssistanceFamilyById(int id) {
		Optional<FamilyAnswerEntity> familyAnswerEntity = familyAnswerRepository.findById(id);

		try {
			return new ObjectMapper().readValue(familyAnswerEntity.map(FamilyAnswerEntity::getJson).orElse(null), SingleSystemOfSocialAssistanceFamilyDto.class);
		} catch (JsonProcessingException exp) {
			logger.error(exp.toString(), exp);
		}
		return null;
	}

	@Override
	public void newSingleSystemOfSocialAssistanceFamily(int familyId, SingleSystemOfSocialAssistanceFamilyDto singleSystemOfSocialAssistanceFamilyDto) {
		FamilyAnswerEntity familyAnswer = new FamilyAnswerEntity();

		try {
			familyAnswer.setRegisterDate(DateFormatter.convertDateObjectToDateSql());
			familyAnswer.setFormName("singleSystemOfSocialAssistanceFamily");
			familyAnswer.setJson(new ObjectMapper().writeValueAsString(singleSystemOfSocialAssistanceFamilyDto));
			familyAnswer.setFamilyId(familyId);

			familyAnswerRepository.save(familyAnswer);
		} catch (JsonProcessingException exp) {
			logger.error(exp.toString(), exp);
		}
	}
}