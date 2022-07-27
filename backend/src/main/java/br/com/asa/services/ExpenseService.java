package br.com.asa.services;

import br.com.asa.dtos.ExpenseDto;
import br.com.asa.models.ExpenseEntity;
import java.util.List;

public interface ExpenseService {
    void save(ExpenseDto expenseDto);
    List<ExpenseEntity> findAll();
}