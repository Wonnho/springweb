package org.springweb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    @Min(value=1)
    @Positive
    private int page=1;


    @Builder.Default
    @Min(value=1)
    @Max(value=100)
    @Positive
    private int size=10;

    public int getSkip() {
        return (page -1)*10;
    }

    private String link;

    public  String getLink() {
        if(link==null) {

            StringBuilder stringBuilder =new StringBuilder();
            stringBuilder.append("page=" +this.page);
            stringBuilder.append("&size=" + this.size);
            link=stringBuilder.toString();
        }
        return link;
    }


    private String[] types;
    private String keyword;
    private boolean done;
    private LocalDate from;
    private LocalDate to;



}
