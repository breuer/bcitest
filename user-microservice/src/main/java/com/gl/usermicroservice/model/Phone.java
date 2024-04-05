package com.gl.usermicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private Long number;
	private Integer citycode;
	private String contrycode;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

}
