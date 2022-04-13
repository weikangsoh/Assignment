package com.example.workshop01.service;
import org.junit.jupiter.api.Assertions;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Arrays;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {
                IndexService.class,
        }, loader = AnnotationConfigContextLoader.class)
public class IndexServiceTest {

    @Autowired
    private IndexService indexService;

    @Test
    public void testService() {
        String[] dataSet = indexService.returnDataSet();
        for (int i = 0; i < dataSet.length; i++) {
            int indexResult = Arrays.asList(dataSet).indexOf(dataSet[i]);
            System.out.println(indexResult);
            Assertions.assertNotEquals(-1, indexResult, "Result not Found");
        }
    }
}
