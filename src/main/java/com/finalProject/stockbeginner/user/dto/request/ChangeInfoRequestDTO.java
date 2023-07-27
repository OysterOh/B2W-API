package com.finalProject.stockbeginner.user.dto.request;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class ChangeInfoRequestDTO {
    private String password;

    private String nick;

    private String mbti;

    private String email;
}
