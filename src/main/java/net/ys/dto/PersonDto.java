package net.ys.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("person")
public class PersonDto {

    @ApiModelProperty(value = "主键", required = true)
    private Long id;

    @ApiModelProperty(value = "用户名", required = true)
    private String user_name;

    @ApiModelProperty(value = "年龄", required = true)
    private int age;
}