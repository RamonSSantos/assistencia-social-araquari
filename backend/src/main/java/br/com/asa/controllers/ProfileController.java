package br.com.asa.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.asa.models.ProfileEntity;
import br.com.asa.services.ProfileService;

@RequestMapping(value = "/profile", method = RequestMethod.GET)
@RestController
public class ProfileController {
	private final ProfileService profileService;
	
	@Autowired
	public ProfileController(ProfileService profileService) {
		this.profileService = profileService;
	}
	
	@GetMapping
	public List<ProfileEntity> getAllProfiles(){
		return profileService.findAll();
	}
}