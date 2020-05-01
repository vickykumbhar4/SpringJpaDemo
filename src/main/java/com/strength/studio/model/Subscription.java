package com.strength.studio.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table( name = "subscription")
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "id")
	@ApiModelProperty(position = 0, required = false)
	private Long id;
	
	@Column( name = "name")
	@ApiModelProperty(position = 1, required = true)
	private String name;
	
	@Column(name = "description")
	@ApiModelProperty(position = 2, required = false)
	private String description;
	
	@Column(name = "days")
	@ApiModelProperty(position = 3, required = true)
	private Integer days;
	
	@Column(name = "price")
	@ApiModelProperty(position = 4, required = true)
	private Double price;

	@OneToMany(mappedBy = "subscription")
	private List<MemberSubscription> memberSubscription;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
