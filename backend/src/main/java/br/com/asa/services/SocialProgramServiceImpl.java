package br.com.asa.services;

import br.com.asa.dtos.SocialProgramDto;
import br.com.asa.models.SocialProgramEntity;
import br.com.asa.repositories.SocialProgramRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SocialProgramServiceImpl implements SocialProgramService {
    private final SocialProgramRepository socialProgramRepository;

    @Autowired
    public SocialProgramServiceImpl(SocialProgramRepository socialProgramRepository) {
        this.socialProgramRepository = socialProgramRepository;
    }

    @Override
    public List<SocialProgramEntity> findAll() {
        return this.socialProgramRepository.findAll();
    }

    @Override
    public void save(SocialProgramDto socialProgramDto) {
        SocialProgramEntity socialProgramEntity = new SocialProgramEntity();
        BeanUtils.copyProperties(socialProgramDto, socialProgramEntity);

        this.socialProgramRepository.save(socialProgramEntity);
    }
}