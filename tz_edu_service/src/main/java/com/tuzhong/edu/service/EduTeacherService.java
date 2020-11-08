package com.tuzhong.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tuzhong.edu.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tuzhong.request.EduTeacherConditionVO;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author WangYongShuai
 * @since 2020-11-08
 */
public interface EduTeacherService extends IService<EduTeacher> {

    /**
     * 带条件的分页查询
     * @Author WangYongShuai
     * @Date 21:19 2020/11/8
     * @param page
     * @param eduTeacherConditionVO
     * @throws
     * @return void
     */
    void queryPageTeacherByCondition(Page<EduTeacher> page, EduTeacherConditionVO eduTeacherConditionVO);
}
