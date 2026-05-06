package org.springweb.dto;
import lombok.*;

import java.time.LocalDate;

@ToString
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TodoDTO {
    private Long tno;
    private String title;

    private LocalDate dueDate;

    private Boolean done;
    private String writer;


}

