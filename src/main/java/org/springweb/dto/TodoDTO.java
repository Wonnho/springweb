package org.springweb.dto;
import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TodoDTO {
    private Long tno;

    @NotEmpty
    private String title;

    @Future
    private LocalDate dueDate;


    private Boolean done;

    @NotEmpty
    private String writer;


}

