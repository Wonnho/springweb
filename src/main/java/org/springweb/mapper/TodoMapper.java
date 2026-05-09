package org.springweb.mapper;

import org.springweb.domain.TodoVO;

import java.util.List;

public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();

    // retrieve a specific item

    TodoVO selectOne(Long tno);

    void delete(Long tno);

}
