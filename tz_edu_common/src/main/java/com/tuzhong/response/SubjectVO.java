package com.tuzhong.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author：BaiYun
 * @create：2020-11-08-22:13
 * @Description：
 */
@Data
public class SubjectVO {

    @ApiModelProperty(value = "课程类别ID")
    private String id;

    @ApiModelProperty(value = "类别名称")
    private String title;

    @ApiModelProperty(value = "二级分类列表")
    private List<SubjectVO> childrenList;

}
