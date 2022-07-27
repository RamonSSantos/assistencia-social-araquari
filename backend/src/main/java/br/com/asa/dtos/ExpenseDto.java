package br.com.asa.dtos;

import br.com.asa.models.FamilyHasExpenseEntity;
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
public class ExpenseDto {
    private int id;
    private Integer status;
    private List<FamilyHasExpenseEntity> familyHasExpense = new ArrayList<>();
}
