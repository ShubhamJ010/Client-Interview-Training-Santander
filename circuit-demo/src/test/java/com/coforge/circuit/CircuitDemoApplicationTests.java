package com.coforge.circuit;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CircuitDemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;


    private static WireMockServer wireMockServer;

    @BeforeAll
    static void beforeAll() {
        wireMockServer = new WireMockServer(9090);
        wireMockServer.start();
        WireMock.configureFor(9090);
    }

    @AfterAll
    static void afterAll() {
        wireMockServer.stop();

    }

    @SneakyThrows
    @Test
    void getEmployee_when_valid_request_success() {
        WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/core-employee"))
                .willReturn(WireMock.aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBodyFile("employee.json")
                        .withStatus(200)));

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/employee")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @SneakyThrows
    @Test
    void getEmployee_when_500_failure() {
        WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/core-employee"))
                .willReturn(WireMock.aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody("{\n" +
                                "  \"code\": \"500\",\n" +
                                "  \"error\": \"Internal one\"\n" +
                                "}").withStatus(500)));

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/employee")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(500));
    }

    @SneakyThrows
    @Test
    void getEmployee_when_500_withFallback_success() {
        WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/core-employee"))
                .willReturn(WireMock.aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody("{\n" +
                                "  \"code\": \"500\",\n" +
                                "  \"error\": \"Internal\"\n" +
                                "}").withStatus(500)));

        // total 8 calls will be performed to end point
        for (int i = 0; i < 2; i++) {
            mockMvc.perform(MockMvcRequestBuilders.get("/v1/employee")
                    .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        }
        // 6th time circuit is open and rest call are going to default
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/employee")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));
    }


}
