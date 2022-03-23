package me.mdjoo0810.shortable.common.model;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class ApiResTest {

    @Test
    void api_res_test_success() {
        String resData = HttpStatus.CREATED.name();
        ApiRes<String> success = ApiRes.success(resData);

        assertTrue(success.isSuccess());
        assertEquals("success", success.getMessage());
        assertEquals(resData, success.getData());
    }

    @Test
    void api_res_test_fail() {
        String errorMessage = "Username must String type";
        ApiRes<Object> fail = ApiRes.fail(errorMessage);

        assertFalse(fail.isSuccess());
        assertEquals(errorMessage, fail.getMessage());
        assertNull(fail.getData());
    }

}