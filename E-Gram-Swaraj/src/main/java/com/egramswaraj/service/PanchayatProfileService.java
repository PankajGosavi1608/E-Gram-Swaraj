package com.egramswaraj.service;

import java.util.List;

import com.egramswaraj.dto.PanchayatProfileDto;

public interface PanchayatProfileService {


	    PanchayatProfileDto createProfile(PanchayatProfileDto panchayatProfileDto);

	    PanchayatProfileDto updateProfile(PanchayatProfileDto panchayatProfileDto,Long id);

	    void deleteProfile(Long id);
	    
	    List<PanchayatProfileDto> getAllProfiles();
	    
	    PanchayatProfileDto getProfileById(Long id);
	    
	    PanchayatProfileDto getProfileByEmail(String email);
	    
	    PanchayatProfileDto getProfileByVillage(String village);
	    
	    PanchayatProfileDto getProfileByTahsil(String tahsil);
	    
	    PanchayatProfileDto getProfileByDistrict(String district);
	    
	    PanchayatProfileDto getProfileByState(String state);

	    PanchayatProfileDto getProfileByElectedYear(Long electedYear);
	    	    
}