package br.com.asa.services;

import br.com.asa.dtos.SocialProgramDto;
import br.com.asa.models.SocialProgramEntity;
import java.util.List;

public interface SocialProgramService {
    List<SocialProgramEntity> findAll();
    void save(SocialProgramDto socialProgramDto);
}