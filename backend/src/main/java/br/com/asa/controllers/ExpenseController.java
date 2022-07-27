package br.com.asa.controllers;

import br.com.asa.dtos.ExpenseDto;
import br.com.asa.models.ExpenseEntity;
import br.com.asa.services.ExpenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(value = "/expense", method = RequestMethod.GET)
@RestController
public class ExpenseController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<ExpenseEntity> getAllExpenses() { return expenseService.findAll(); }

    @PostMapping(value = "/new")
    public ResponseEntity<String> newExpense(@RequestBody ExpenseDto expenseDto) {
        try {
            expenseService.save(expenseDto);
            return ResponseEntity.status(HttpStatus.OK).body("Despesa registrada com sucesso!");
        } catch (Exception exp) {
            logger.error(exp.toString(), exp);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
        }
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<String> editExpense(@RequestBody ExpenseDto expenseDto) {
        try {
            expenseService.save(expenseDto);
            return ResponseEntity.status(HttpStatus.OK).body("Despesa editada com sucesso!");
        } catch (Exception exp) {
            logger.error(exp.toString(), exp);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
        }
    }
}
