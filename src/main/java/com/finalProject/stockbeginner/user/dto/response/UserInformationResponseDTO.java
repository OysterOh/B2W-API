package com.finalProject.stockbeginner.user.dto.response;

import lombok.*;

import javax.management.relation.Role;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInformationResponseDTO {
    private String name;
    private Role role;
}
