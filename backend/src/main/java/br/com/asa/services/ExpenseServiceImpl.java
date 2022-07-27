package br.com.asa.services;

import br.com.asa.dtos.ExpenseDto;
import br.com.asa.models.ExpenseEntity;
import br.com.asa.repositories.ExpenseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public void save(ExpenseDto expenseDto) {
        ExpenseEntity expenseEntity = new ExpenseEntity();
        BeanUtils.copyProperties(expenseDto, expenseEntity);

        this.expenseRepository.save(expenseEntity);
    }

    @Override
    public List<ExpenseEntity> findAll() {
        return this.expenseRepository.findAll();
    }
}