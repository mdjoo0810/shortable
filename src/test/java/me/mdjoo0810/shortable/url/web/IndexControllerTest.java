package me.mdjoo0810.shortable.url.web;

import me.mdjoo0810.shortable.IndexController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    @Test
    void index() {
        IndexController controller = new IndexController();
        String index = controller.index();
        assertEquals("index", index);
    }

}