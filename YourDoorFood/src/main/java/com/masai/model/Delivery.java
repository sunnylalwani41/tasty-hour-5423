package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Delivery {

	@Id
	private Integer deliveryId;
	
	@ElementCollection
	private List<Item> items = new ArrayList<>();
	
}
