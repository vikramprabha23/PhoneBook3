package com.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Customer2")
public class CustomerDtls {
	
	@Id
	@GeneratedValue()
	private Integer cid;
	private String cname;
	private String email;
	private Long cnumber;
}
