package com.st.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;
@Data
@Entity
public class Product {
		@Id
		@GeneratedValue
		private Integer id;
		@Column(name="pname")
		private String name;
		@Column(name="pcode")
		private String code;
		@Column (name="pcost")
		private Double cost;
		@Column(name="pgst")
		private Integer gst;
		@Column(name="pnote")
		private String note; 
		@Transient
		private String pEmail;
		
}
