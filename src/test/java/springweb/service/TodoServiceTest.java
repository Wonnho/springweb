package springweb.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springweb.domain.TodoVO;
import org.springweb.dto.PageRequestDTO;
import org.springweb.dto.PageResponseDTO;
import org.springweb.dto.TodoDTO;
import org.springweb.mapper.TodoMapper;
import org.springweb.service.TodoService;

import java.time.LocalDate;


@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTest {
    @Autowired
    private TodoService todoService;

    @Test
    public void testRegister() {
        TodoDTO todoDTO=TodoDTO.builder()
                .title("'transfer of VO to DTO' Test:")
                .dueDate(LocalDate.of(2026,5,8))
                .writer("coder")
                .build();
        todoService.register(todoDTO);
    }

    @Autowired
    private TodoMapper todoMapper;
    @Test
    public void testSelectOne() {
        TodoVO todoVO= todoMapper.selectOne(3L);

        log.info(todoVO);

    }

    @Test
    public void testPaging() {
        PageRequestDTO pageRequestDTO=PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

      PageResponseDTO<TodoDTO> responseDTO= todoService.getList(pageRequestDTO);

      log.info(responseDTO);

      responseDTO.getDtoList().stream().forEach(todoDTO -> log.info(todoDTO));
    }
}
