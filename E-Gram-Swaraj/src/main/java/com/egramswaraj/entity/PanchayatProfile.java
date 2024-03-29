package com.egramswaraj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name="panchayat_profile_details")
public class PanchayatProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="sarpanch_name")
	private String name;
	
	@Column(name="village_name")
	private String village;
	
	@Column(name="tahsil_name")
	private String tahsil;
	
	@Column(name="district_name")
	private String district;
	
	@Column(name="state_name")
	private String state;
	
	@Column(name="elected_year")
	private Long electedYear;
	
	@Column(name="panchayat_email")
	private String email;
	
	@Column (name="user_gender")
    private String gender;

    @Column(name="about_village")
    private String about;

    @Column(name = "sarpanch_image")
    private String imageName;
	
}
