package com.gl.usermicroservice.dto;

import lombok.*;

import java.util.List;

@Generated
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

	private String name;
	private String email;
	private String password;
	private List<PhoneDTO> phones;
}
