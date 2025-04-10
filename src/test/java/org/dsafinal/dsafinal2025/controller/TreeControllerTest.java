package org.dsafinal.dsafinal2025.controller;

import org.dsafinal.dsafinal2025.repository.BinarySearchTreeRepository;
import org.dsafinal.dsafinal2025.service.BinarySearchTreeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TreeController.class)
class TreeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BinarySearchTreeService bstService;

    @MockBean
    private BinarySearchTreeRepository treeRepo;

    @Test
    void testEnterNumbersPage() throws Exception {
        mockMvc.perform(get("/enter-numbers"))
                .andExpect(status().isOk())
                .andExpect(view().name("enterNumbers"));
    }
}

