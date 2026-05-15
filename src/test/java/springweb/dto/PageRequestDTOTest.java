package springweb.dto;

import org.junit.jupiter.api.Test;
import org.springweb.dto.PageRequestDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PageRequestDTOTest {

    @Test
    public void getSkipUsesRequestedPageSize() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(3)
                .size(20)
                .build();

        assertEquals(40, pageRequestDTO.getSkip());
    }

    @Test
    public void paginationScriptDoesNotRemoveSearchFormFields() throws IOException {
        String listJsp = Files.readString(Path.of("src/main/webapp/WEB-INF/views/todo/list.jsp"));

        assertFalse(listJsp.contains("formObj.innerHTML"));
    }
}
