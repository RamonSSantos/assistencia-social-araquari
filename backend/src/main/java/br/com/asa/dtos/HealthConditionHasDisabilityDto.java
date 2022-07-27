package br.com.asa.dtos;

import br.com.asa.models.DisabilityEntity;
import br.com.asa.models.HealthConditionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthConditionHasDisabilityDto {
    private int id;
    private Integer constantCare;
    private HealthConditionEntity healthCondition;
    private DisabilityEntity disability;
}