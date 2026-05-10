package org.springweb.dto;

import lombok.Builder;

import java.util.List;


public class PageResponseDTO<E> {


private int page;
private int size;
private int total;

private int start;
private int end;

private boolean prev;
private boolean next;

private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO,List<E> dtoList,int total) {
        this.page=PageRequestDTO.getPage();
        this.page=PageRequestDTO.getSize();

        this.total=total;
        this.dtoList=dtoList;
    }

}
