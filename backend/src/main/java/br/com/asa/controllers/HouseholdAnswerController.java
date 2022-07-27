package br.com.asa.controllers;

import br.com.asa.dtos.HouseholdAnswerDto;
import br.com.asa.models.HouseholdAnswerEntity;
import br.com.asa.repositories.HouseholdAnswerRepository;
import br.com.asa.services.HouseholdAnswerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(value = "/household-answer", method = RequestMethod.GET)
@RestController
public class HouseholdAnswerController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final HouseholdAnswerService householdAnswerService;

    @Autowired
    public HouseholdAnswerController(HouseholdAnswerService householdAnswerService) {
        this.householdAnswerService = householdAnswerService;
    }

    @GetMapping
    public List<HouseholdAnswerEntity> getAllHouseholdAnswers() { return householdAnswerService.findAll(); }

    @PostMapping(value = "/new")
    public ResponseEntity<String> newHouseholdAnswer(@RequestBody HouseholdAnswerDto householdAnswerDto) {
        try {
            householdAnswerService.save(householdAnswerDto);
            return ResponseEntity.status(HttpStatus.OK).body("Resposta registrada com sucesso!");
        } catch (Exception exp) {
            logger.error(exp.toString(), exp);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
        }
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<String> editHouseholdAnswer(@RequestBody HouseholdAnswerDto householdAnswerDto) {
        try {
            householdAnswerService.save(householdAnswerDto);
            return ResponseEntity.status(HttpStatus.OK).body("Resposta editada com sucesso!");
        } catch (Exception exp) {
            logger.error(exp.toString(), exp);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
        }
    }
}
