package org.springweb.mapper;

import org.springweb.domain.TodoVO;
public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);

}
