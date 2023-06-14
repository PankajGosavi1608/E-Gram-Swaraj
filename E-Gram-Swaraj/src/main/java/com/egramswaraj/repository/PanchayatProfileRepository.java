package com.egramswaraj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egramswaraj.entity.PanchayatProfile;

public interface PanchayatProfileRepository extends JpaRepository<PanchayatProfile, Long>{

	Optional<PanchayatProfile> findByElectedYear(Long electedYear);
	
	Optional<PanchayatProfile> findByEmail(String email);
	
	Optional<PanchayatProfile> findByVillage(String village);
	
	Optional<PanchayatProfile> findByTahsil(String tahsil);
	
	Optional<PanchayatProfile> findByDistrict(String district);
	
	Optional<PanchayatProfile> findByState(String state);

}
