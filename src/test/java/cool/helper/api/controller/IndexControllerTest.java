package cool.helper.api.controller;

import cool.helper.api.HelperApiApplicationTest;
import cool.helper.api.config.AppConfig;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

class IndexControllerTest extends HelperApiApplicationTest {

    @Resource
    private AppConfig appConfig;

    @Resource
    private MockMvc mockMvc;

    @Test
    void index() {

        String api = "/";

        String responseBody;

        try {
            responseBody = mockMvc.perform(MockMvcRequestBuilders.get(api))
                    .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn()
                    .getResponse()
                    .getContentAsString(Charset.defaultCharset());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(appConfig.getApplication(), responseBody);

    }

}