package org.springweb.mapper;

import org.springweb.domain.TodoVO;
import org.springweb.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();

    // retrieve a specific item

    TodoVO selectOne(Long tno);

    void delete(Long tno);

    void update(TodoVO todoVO);

 List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

 int getCount(PageRequestDTO pageRequestDTO);
}
