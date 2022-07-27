package br.com.asa.controllers;

import br.com.asa.dtos.SocialProgramDto;
import br.com.asa.models.SocialProgramEntity;
import br.com.asa.services.SocialProgramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(value = "/social-program", method = RequestMethod.GET)
@RestController
public class SocialProgramController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final SocialProgramService socialProgramService;

    @Autowired
    public SocialProgramController(SocialProgramService socialProgramService) {
        this.socialProgramService = socialProgramService;
    }

    @GetMapping
    public List<SocialProgramEntity> getAllSocialPrograms() {
        return socialProgramService.findAll();
    }

    @PostMapping(value = "/new")
    public ResponseEntity<String> addSocialProgram(@RequestBody SocialProgramDto socialProgramDto) {
        try {
            socialProgramService.save(socialProgramDto);
            return ResponseEntity.status(HttpStatus.OK).body("Registro cadastrado com sucesso!");
        } catch (Exception exp) {
            logger.error(exp.toString(), exp);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
        }
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<String> editSocialProgram(@RequestBody SocialProgramDto socialProgramDto) {
        try {
            socialProgramService.save(socialProgramDto);
            return ResponseEntity.status(HttpStatus.OK).body("Registro editado com sucesso!");
        } catch (Exception exp) {
            logger.error(exp.toString(), exp);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
        }
    }
}