package com.unit_test.springboot_35.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public static <T> BaseResponse<T> ok(T data){
        return new BaseResponse<>(true, "ok", data);
    }

    public static <T> BaseResponse<T> created(T data){
        return new BaseResponse<>(true, "created", data);
    }

    public static <T> BaseResponse<T> error(String message){
        return new BaseResponse<>(false, message, null);
    }

}
