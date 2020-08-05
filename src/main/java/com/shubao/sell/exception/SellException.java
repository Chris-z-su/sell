package com.shubao.sell.exception;

import com.shubao.sell.enums.ResultEnum;

/**
 * @author Mr.Chris
 * @title: SellException
 * @projectName sell
 * @description: TODO
 * @date 2019/07/11 0011 16:02
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
