package com.egramswaraj.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egramswaraj.dto.ApiResponse;
import com.egramswaraj.dto.PanchayatProfileDto;
import com.egramswaraj.service.PanchayatProfileService;

@RestController
@RequestMapping("/eGram/profiles")
public class PanchayatProfileController {

	@Autowired
	private PanchayatProfileService panchayatProfileService;

	// create
	@PostMapping("/")
	public ResponseEntity<PanchayatProfileDto> createProfile(
			@Valid @RequestBody PanchayatProfileDto panchayatProfileDto) {

		PanchayatProfileDto createProfileDto = this.panchayatProfileService.createProfile(panchayatProfileDto);

		return new ResponseEntity<>(createProfileDto, HttpStatus.CREATED);

	}

	// Update
	@PutMapping("/{id}")
	public ResponseEntity<PanchayatProfileDto> updateProfile(@RequestBody PanchayatProfileDto panchayatProfileDto,
			@PathVariable Long id) {

		PanchayatProfileDto updatedProfile = this.panchayatProfileService.updateProfile(panchayatProfileDto,id);

		return ResponseEntity.ok(updatedProfile);

	}

	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteProfile(@PathVariable("id") Long id) {

		this.panchayatProfileService.deleteProfile(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse(), HttpStatus.OK); // error on msg here new Api rsponse

	}

	// Get All Profile
	@GetMapping("/")
	public ResponseEntity<List<PanchayatProfileDto>> getAllProfiles() {

		return ResponseEntity.ok(this.panchayatProfileService.getAllProfiles());

	}

	// get single profile

	@GetMapping("/{id}")
	public ResponseEntity<PanchayatProfileDto> getProfileById(@PathVariable Long id) {

		return ResponseEntity.ok(this.panchayatProfileService.getProfileById(id));

	}

	// get by email
	@GetMapping("/email/{email}")
	public ResponseEntity<PanchayatProfileDto> getProfileByEmail(@PathVariable String email) {

		return ResponseEntity.ok(this.panchayatProfileService.getProfileByEmail(email));

	}

	// get by village name
	@GetMapping("/village/{village}")
	public ResponseEntity<PanchayatProfileDto> getProfileByVillage(@PathVariable String village) {

		return ResponseEntity.ok(this.panchayatProfileService.getProfileByVillage(village));
	}

	// get by tahsil name

	@GetMapping("/tahsil/{tahsil}")
	public ResponseEntity<PanchayatProfileDto> getProfileByTahsil(@PathVariable String tahsil) {

		return ResponseEntity.ok(this.panchayatProfileService.getProfileByTahsil(tahsil));

	}

	// get by district name
	@GetMapping("/district/{district}")
	public ResponseEntity<PanchayatProfileDto> getProfileByDistrict(@PathVariable String district) {

		return ResponseEntity.ok(this.panchayatProfileService.getProfileByDistrict(district));

	}

	// get by state

	@GetMapping("/state/{State}")
	public ResponseEntity<PanchayatProfileDto> getProfileByState(@PathVariable String state) {

		return ResponseEntity.ok(this.panchayatProfileService.getProfileByState(state));

	}

	// get by electedyear

	@GetMapping("/electedYear/{electedYear}")
	public ResponseEntity<PanchayatProfileDto> getProfileByElectedYear(@PathVariable Long electedYear) {

		return ResponseEntity.ok(this.panchayatProfileService.getProfileByElectedYear(electedYear));

	}

}