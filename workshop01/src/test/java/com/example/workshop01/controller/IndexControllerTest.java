package com.example.workshop01.controller;
import com.example.workshop01.model.IndexModel;
import com.example.workshop01.service.IndexService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(IndexController.class)
public class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IndexController indexController;

    @MockBean
    private IndexService indexService;

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testIndex1() {
        when(indexService.returnData()).thenReturn("abc");
        String result = indexController.index1();
        System.out.println(result);
        Assertions.assertNotNull(result, "Result is null.");
    }

    @Test
    public void testIndex6() {
        ResponseEntity<String> result = indexController.index6();
        Assertions.assertEquals("success", result.getBody(), "Correct Body.");
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode(), "Status Code is 200.");
    }

    @Test
    public void testIndex6Mock() throws Exception{
            this.mockMvc.perform(get("/index6")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testIndex2() throws Exception {
        this.mockMvc.perform(post("/index2?name={name}&mail={mail}", "hi", "hello"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testIndex3() throws Exception {
        IndexModel indexModel = new IndexModel("Hi", "Hello");
        this.mockMvc.perform(post("/index3")
                .content(asJsonString(indexModel))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
 }
