package com.huyz.lottery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author HYZ
 * @Created 2022/10/5
 */
@Data
@AllArgsConstructor
public class RateMapDTO<T> {

    private T key;

    private double value;


}
