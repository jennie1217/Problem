package com.company.palindromic;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PalindromicApplicationTests {

    @Autowired
    private MockMvc mvc;

    // test longest palindromic substring result for case "babad"
    @Test
    public void givenInput1_returnPalindromic_thenStatus200() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/palindromic/babad")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.origin").value("babad"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.longest_palindromic").value("bab"));
    }

    // test longest palindromic substring result for case "cbbd"
    @Test
    public void givenInput2_returnPalindromic_thenStatus200() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/palindromic/cbbd")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.origin").value("cbbd"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.longest_palindromic").value("bb"));
    }

    // test /getAll can return correct result
    @Test
    public void getAll_returnAllPalindromic_thenStatus200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/palindromic/babad"));
        mvc.perform(MockMvcRequestBuilders.get("/palindromic/cbbd"));
        mvc.perform(MockMvcRequestBuilders
                .get("/palindromic/getAll"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].origin").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].origin").exists());
    }
}
