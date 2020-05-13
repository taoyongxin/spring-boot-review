package com.soft1851.springbootjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tao
 * @version 1.0
 * @ClassName UserDetailParam
 * @Description TODO
 * @date 2020-05-13 19:58
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailParam {
    private String introduction;
    private String realName;
    private Integer minAge;
    private Integer maxAge;
    private Integer age;
}
