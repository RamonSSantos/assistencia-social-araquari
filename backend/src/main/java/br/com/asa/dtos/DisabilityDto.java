package br.com.asa.dtos;

import br.com.asa.models.HealthConditionHasDisabilityEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisabilityDto {
    private int id;
    private String description;
    private List<HealthConditionHasDisabilityEntity> healthConditionHasDisability = new ArrayList<>();
}
