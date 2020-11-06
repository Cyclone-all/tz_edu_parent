package com.tuzhong.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ProjectName: tz_edu_parent
 * @Package: com.tuzhong.request
 * @Author: WangYongShuai
 * @Description:
 * @Date: 2020/11/2 10:27
 * @Version: 1.0
 */
@Data
public class EduTeacherConditionVO {
    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "开始时间")
    private String beginTime;

    @ApiModelProperty(value = "结束时间")
    private String endTime;
}
