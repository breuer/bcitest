package com.gl.usermicroservice.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Generated
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {

	private String id;
	private LocalDateTime created;
	private LocalDateTime lastLogin;
	private boolean isActive;
    private String name;
    private String email;
    private String password;
	private List<PhoneDTO> phones;
	private String token;
}
