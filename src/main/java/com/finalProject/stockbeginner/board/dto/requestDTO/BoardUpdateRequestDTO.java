package com.finalProject.stockbeginner.board.dto.requestDTO;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardUpdateRequestDTO {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private String email;

}
