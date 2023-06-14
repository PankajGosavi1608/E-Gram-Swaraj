package com.egramswaraj.service.Impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egramswaraj.dto.PanchayatProfileDto;
import com.egramswaraj.entity.PanchayatProfile;
import com.egramswaraj.exception.ResourceNotFoundException;
import com.egramswaraj.repository.PanchayatProfileRepository;
import com.egramswaraj.service.PanchayatProfileService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class PanchayatProfileServiceImpl implements PanchayatProfileService{
	
	@Autowired
	private PanchayatProfileRepository panchayatProfileRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<PanchayatProfileDto> getAllProfiles() {

		List<PanchayatProfile> panchayatProfiles= panchayatProfileRepository.findAll();
		List<PanchayatProfileDto> panchayatProfileDtos =panchayatProfiles.stream().map(PanchayatProfile-> this.profileToDto(PanchayatProfile)).collect(Collectors.toList());
		
		return panchayatProfileDtos;
	}

	@Override
	public PanchayatProfileDto getProfileById(Long id) {
		
		PanchayatProfile panchayatProfile=this.panchayatProfileRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("panchayatProfile not Found with id: " +id));
		return this.profileToDto(panchayatProfile);
	}

	@Override
	public PanchayatProfileDto getProfileByElectedYear(Long electedYear) {
		
		PanchayatProfile panchayatProfile=this.panchayatProfileRepository.findById(electedYear)
				.orElseThrow(() -> new ResourceNotFoundException("PanchayatProfile not found with electedYear: "+electedYear));
		return this.profileToDto(panchayatProfile);
	}

	@Override
	public PanchayatProfileDto createProfile(PanchayatProfileDto panchayatProfileDto) {

		PanchayatProfile panchayatProfile=this.dtoToProfile(panchayatProfileDto);
		
		PanchayatProfile savedPanchayatProfile = this.panchayatProfileRepository.save(panchayatProfile);
		return this.profileToDto(savedPanchayatProfile);
	}

	@Override
	public PanchayatProfileDto updateProfile(PanchayatProfileDto panchayatProfileDto,Long id) {
		
		//Long id = panchayatProfileDto.getId();
		
		PanchayatProfile panchayatProfile=panchayatProfileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Profile not found with this id: "+id));
		
		// Map the updated data from the UserDto to the User entity
		
		modelMapper.map(panchayatProfileDto, panchayatProfile);
		
		PanchayatProfile updatedPanchayatProfile = panchayatProfileRepository.save(panchayatProfile);
		
		PanchayatProfileDto updatedPanchayatProfileDto = modelMapper.map(updatedPanchayatProfile, PanchayatProfileDto.class);
		
		return updatedPanchayatProfileDto;
	}

	@Override
	public void deleteProfile(Long id) {
		PanchayatProfile panchayatProfile=this.panchayatProfileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PanchayatProfile"+ id));

		this.profileToDto(panchayatProfile);
	}

	@Override
	public PanchayatProfileDto getProfileByEmail(String email) {
		PanchayatProfile panchayatProfile=this.panchayatProfileRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("PanchayatProfile not found with email: "+email));
		return this.profileToDto(panchayatProfile);
	}

	@Override
	public PanchayatProfileDto getProfileByVillage(String village) {
		PanchayatProfile panchayatProfile=this.panchayatProfileRepository.findByVillage(village).orElseThrow(() -> new ResourceNotFoundException("PanchayatProfile not fonud with village name:" +village));
		return this.profileToDto(panchayatProfile);
	}

	@Override
	public PanchayatProfileDto getProfileByTahsil(String tahsil) {
		PanchayatProfile panchayatProfile=this.panchayatProfileRepository.findByTahsil(tahsil).orElseThrow(() -> new ResourceNotFoundException("PanchayatProfile not fonud with tahsil:"+tahsil));
		return this.profileToDto(panchayatProfile);
	}

	@Override
	public PanchayatProfileDto getProfileByDistrict(String district) {
		PanchayatProfile panchayatProfile=this.panchayatProfileRepository.findByDistrict(district).orElseThrow(() -> new ResourceNotFoundException("PanchayatProfile"+district));
		return this.profileToDto(panchayatProfile);
	}
	@Override
	public PanchayatProfileDto getProfileByState(String state) {
		PanchayatProfile panchayatProfile=this.panchayatProfileRepository.findByState(state).orElseThrow(() -> new ResourceNotFoundException("PanchayatProfile"+state));
		return this.profileToDto(panchayatProfile);
	}
	
	private PanchayatProfile dtoToProfile( PanchayatProfileDto panchayatProfileDto) {
		//log.info("Starting request from dto to Profile with ProfileDto:{}",panchayatProfileDto);
		PanchayatProfile panchayatProfile =this.modelMapper.map(panchayatProfileDto,PanchayatProfile.class);
		
		//log.info("Completed request from dto to Profile with ProfileDto:{}",panchayatProfileDto);
		return panchayatProfile;
		
		/*model mappper saved coding below just above line is enough
		User user = new User();
	    user.setId(userDto.getId());        //for using model mapper we cmnt this
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());*/
		
		}

	public PanchayatProfileDto profileToDto(PanchayatProfile panchayatProfile) {

		//log.info("Starting request from Profile to Profiledto with panchayatProfile:{}", panchayatProfile);
		PanchayatProfileDto panchayatProfileDto = this.modelMapper.map(panchayatProfile, PanchayatProfileDto.class);

		//log.info("Completed request from Profile to Profiledto with panchayatProfile:{}", panchayatProfile);
		return panchayatProfileDto;

	}

}
