package com.tuzhong.edu.service;

import com.tuzhong.edu.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tuzhong.response.SubjectVO;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author BaiYun
 * @since 2020-11-08
 */
public interface EduSubjectService extends IService<EduSubject> {

    /**
     * 获取所有分类信息
     * @return  以list方式返回
     */
    List<SubjectVO> getAllSubject();

}
