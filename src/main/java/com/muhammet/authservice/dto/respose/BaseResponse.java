package com.muhammet.authservice.dto.respose;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponse<T> {
    String message;
    Integer code;
    T data;
}
