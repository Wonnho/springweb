package org.springweb.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;


public class PageResponseDTO<E> {


private int page;
private int size;
private int total;

private int start;
private int end;

private boolean prev;
private boolean next;

@Getter
@ToString
private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO,List<E> dtoList,int total) {
        this.page=PageRequestDTO.getPage();
        this.page=PageRequestDTO.getSize();

        this.total=total;
        this.dtoList=dtoList;

        //end page
        this.end=(int)(Math.ceil(this.page/10.0))*10;
        //start page
        this.start=this.end-9;

        // last page
        int last=(int)(Math.ceil((total/(double)size)));

        //이론상의 끝과 실제 데이터상의 끝을 비교하여, 더 작은 값을 최종 페이지 끝 번호로 선택한다
        this.end=end>last?last:end;

        this.prev=this.start >1;
        this.next=total>this.end*this.size;

    }



}
