package com.example.workshop01.unittest;

import com.example.workshop01.controller.IndexController;
import com.example.workshop01.model.IndexModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

public class IndexControllerTest {

    @Test
    public void testIndex1() {
        IndexController indexController = new IndexController();
        String result = indexController.index1();
        Assert.notNull(result, "Result is null.");
    }
}
