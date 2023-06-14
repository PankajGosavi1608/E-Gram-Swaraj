package com.egramswaraj.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class PanchayatProfileDto {

	    private Long id;

	    @NotBlank(message = "Name is required")
	    @Size(max = 100, message = "Name must not exceed 100 characters")
	    private String name;

	    @NotBlank(message = "Village is required")
	    @Size(max = 100, message = "Village must not exceed 100 characters")
	    private String village;

	    @NotBlank(message = "Tahsil is required")
	    @Size(max = 100, message = "Tahsil must not exceed 100 characters")
	    private String tahsil;

	    @NotBlank(message = "District is required")
	    @Size(max = 100, message = "District must not exceed 100 characters")
	    private String district;

	    @NotBlank(message = "State is required")
	    @Size(max = 100, message = "State must not exceed 100 characters")
	    private String state;

	    @NotNull(message = "Elected year is required")
	    @Min(value = 2010, message = "Elected year must be greater than or equal to 1900")
	    @Max(value = 2100, message = "Elected year must be less than or equal to 2100")
	    private Long electedYear;

	    @NotBlank(message = "Email is required")
	    @Email(message = "Email is not valid")
	    @Size(max = 100, message = "Email must not exceed 100 characters")
	    private String email;

	    @NotBlank(message = "Gender is required")
	    @Pattern(regexp = "^(Male|Female)$", message = "Gender must be either 'Male' or 'Female'")
	    private String gender;

	    @NotBlank(message = "About is required")
	    @Size(max = 500, message = "About must not exceed 500 characters")
	    private String about;

	    @Size(max = 100, message = "Image name must not exceed 100 characters")
	    private String imageName;

}
