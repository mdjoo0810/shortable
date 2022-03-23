package me.mdjoo0810.shortable.config;

import com.google.gson.Gson;
import me.mdjoo0810.shortable.common.filter.RequestFilter;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RequestFilterTest {

    // TODO : Test Coverage 높이기
    @Test
    void do_filter() throws ServletException, IOException {
        Map<String, String> object = getObject();
        Gson gson = new Gson();

        MockHttpServletRequest mockReq = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        FilterChain chain = mock(FilterChain.class);

        System.out.println("test " + gson.toJson(object));
        mockReq.setContent(gson.toJson(object).getBytes(StandardCharsets.UTF_8));
        mockReq.setContentType("application/json");
        mockReq.addHeader("Content-Type", "application/json");

        response.setStatus(200);

        RequestFilter filter = new RequestFilter();
        filter.doFilter(mockReq, response, chain);

        assertEquals(200, response.getStatus());
    }

    private Map<String, String> getObject() {
        Map<String, String> object = new HashMap<>();
        object.put("test", "1234");
        return object;
    }

}