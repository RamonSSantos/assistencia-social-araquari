package br.com.asa.dtos;

import br.com.asa.models.FamilyHasSocialProgramEntity;
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
public class SocialProgramDto {
    private int id;
    private int receiveBenefit;
    private Float familyGrossSalary;
    private Float perCapitaIncome;
    private List<FamilyHasSocialProgramEntity> familyHasSocialProgram = new ArrayList<>();
}