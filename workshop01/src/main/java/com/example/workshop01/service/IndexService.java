package com.example.workshop01.service;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class IndexService {
    String[] dataSet = {
            "Logic will get you from A to B. Imagination will take you everywhere.",
            "There are 10 kinds of people. Those who know binary and those who don't.",
            "There are two ways of constructing a software design. \n" +
                    "One way is to make it, so simple that there are obviously no deficiencies and the other is to make it \n" +
                    "so complicated that there are no obvious deficiencies.",
            "It's not that I'm so smart, it's just that I stay with problems longer.",
            "It is pitch dark. You are likely to be eaten by a grue."
    };

    public String[] returnDataSet() {
        return this.dataSet;
    }

    public String returnData() {

        int rnd = new Random().nextInt(dataSet.length);
        return dataSet[rnd];
    }

}
