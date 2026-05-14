package org.springweb.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;
import java.io.UnsupportedEncodingException;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageRequestDTO {

    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1;


    @Builder.Default
    @Min(value = 1)
    @Max(value = 100)
    @Positive
    private int size = 10;

    public int getSkip() {
        return (page - 1) * 10;
    }

    private String link;


    private String[] types;
    private String keyword;
    private boolean done;
    private LocalDate from;
    private LocalDate to;



    public  boolean checkType(String type) {
        if(types==null || types.length==0) {
            return  false;
        }
        return Arrays.stream(types).anyMatch(type::equals);
    }


    public String getLink() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("page=" + this.page);
        stringBuilder.append("&size=" + this.size);

        if (done) {
            stringBuilder.append("&done=on");
        }

        if(types !=null && types.length>0) {
            for (int k=0;k<types.length;k++) {
                stringBuilder.append("&types=" + types[k]);
            }
        }

        if (keyword != null) {
            try {
                stringBuilder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace(); // Handle the error (UTF-8 is almost always supported)
            }
        }

        if(from !=null) {
            stringBuilder.append("&from=" +from.toString());
        }
        if(to !=null) {
            stringBuilder.append("&to=" +to.toString());
        }

        return  stringBuilder.toString();
    }

}
