package com.strength.studio.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table( name = "member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@ApiModelProperty(position = 0, required = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	@ApiModelProperty(position = 1, required = true)
	private String name;
	
	@Column(name = "address", nullable = false)
	@ApiModelProperty(position = 2, required = true)
	private String address;
	
	@Column(name = "mobile", nullable = false)
	@ApiModelProperty(position = 3, required = true)
	private String mobile;
	
	@Column(name = "email", nullable = true)
	@ApiModelProperty(position = 4, required = false)
	private String email;
	
	@Column(name = "height", nullable = false)
	@ApiModelProperty(position = 5, required = true)
	private Double height;
	
	@Column(name = "status", nullable = true)
	private Boolean status;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private Set<MemberSubscription> memberSubscription;
	
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Set<MemberSubscription> getMemberSubscription() {
		return memberSubscription;
	}

	public void setMemberSubscription(Set<MemberSubscription> memberSubscription) {
		this.memberSubscription = memberSubscription;
	}

		
}
