package com.masai.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "userGenerator")
    @SequenceGenerator(name = "userGenerator",sequenceName = "usergen",allocationSize = 1,initialValue = 1)
	private Integer customerID;
	
	@NotNull(message = "First name is required")
	private String firstName;
	
	private String lastName;
	
	@Max(value = 100,message = "Age Should be less then 100")
	private Integer age;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private FoodCart foodCart = new FoodCart();
	
	private String gender;
	
	@NotNull(message = "Mobile Number is required")
	@NotBlank(message = "Enter vaild Mobile Number")
	@Size(min = 10,max = 10,message = "Mobile Number Should Be 10 digits")
	@Column(unique = true)
	private String mobileNumber;
	
	@NotNull(message = "Email is required")
	@Email(message = "Please enter vaild email")
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull(message = "Password is required")
	@Size(min = 4,max = 8)
	@NotBlank(message = "Password should not be black")
	private String password;
	
	@Valid
	@Embedded
	private Address address;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<OrderDetails> orders = new ArrayList<>();

}
