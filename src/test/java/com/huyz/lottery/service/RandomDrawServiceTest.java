package com.huyz.lottery.service;

import com.huyz.lottery.domain.RateMapDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author HYZ
 * @Created 2022/10/5
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RandomDrawServiceTest {

    @Resource
    RandomDrawService randomDrawService;


    @Test
    public void randomIndexTest() {

        String rateStr = "1:0.1;2:0.2;3:0.3;4:0.4";

        List<RateMapDTO<Integer>> rateMapDTOList = Arrays.stream(rateStr.split(";"))
                .map(str -> new RateMapDTO<>(Integer.valueOf(str.split(":")[0]),
                        Double.parseDouble(str.split(":")[1]))).collect(Collectors.toList());

        Map<Integer, Long> result = new HashMap<>();

        for (int i = 0; i < 1000; i++) {
            Integer key = randomDrawService.randomIndex(rateMapDTOList);
            result.put(key, result.getOrDefault(key, 0L) + 1);
        }

    }
}
