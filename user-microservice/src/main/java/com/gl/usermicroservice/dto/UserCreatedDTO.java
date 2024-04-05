package com.gl.usermicroservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Generated
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatedDTO {

	private String id;
    //private String name;
    //private String email;
    //private String password;
    //private List<PhoneDTO> phones;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime created;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime lastLogin;
	private String token;
	private boolean isActive;
}
