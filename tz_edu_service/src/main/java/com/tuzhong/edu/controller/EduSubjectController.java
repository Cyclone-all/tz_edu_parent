package com.tuzhong.edu.controller;


import com.tuzhong.edu.service.EduSubjectService;
import com.tuzhong.response.RetVal;
import com.tuzhong.response.SubjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author BaiYun
 * @since 2020-11-08
 */
@RestController
@RequestMapping("/edu/subject")
public class EduSubjectController {
    @Autowired
    private EduSubjectService subjectService;

    @GetMapping("getAllSubject")
    public RetVal getAllSubject() {
        List<SubjectVO> subjectVOList =  subjectService.getAllSubject();
        return RetVal.success().data("subjectVOList",subjectVOList);
    }

}

