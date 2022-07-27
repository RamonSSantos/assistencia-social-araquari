package br.com.asa.dtos;

import br.com.asa.models.ExpenseEntity;
import br.com.asa.models.FamilyEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyHasExpenseDto {
    private int id;
    private Integer expenseType;
    private Float amountSpent;
    private FamilyEntity family;
    private ExpenseEntity expense;
}
