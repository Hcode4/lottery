package com.huyz.lottery.service;

import com.huyz.lottery.domain.RateMapDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author HYZ
 * @Created 2022/10/5
 */
@Service
public class RandomDrawService {

    /**
     * @param rateList
     * @param <T>
     * @return
     */
    public <T> T randomIndex(List<RateMapDTO<T>> rateList) {
        if (CollectionUtils.isEmpty(rateList)) {
            throw new RuntimeException("空数组");
        }

        double randomNum = Math.random();
        double rateSum = 0.0;

        for (RateMapDTO<T> tRateMapDTO : rateList) {
            if (randomNum >= rateSum && randomNum < rateSum + tRateMapDTO.getValue()) {
                return tRateMapDTO.getKey();
            } else {
                rateSum += tRateMapDTO.getValue();
            }
        }
        return rateList.get(0).getKey();
    }


}
