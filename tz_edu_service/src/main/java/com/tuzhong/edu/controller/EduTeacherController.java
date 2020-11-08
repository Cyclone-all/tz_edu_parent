package com.tuzhong.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tuzhong.edu.entity.EduTeacher;
import com.tuzhong.edu.service.EduTeacherService;
import com.tuzhong.request.EduTeacherConditionVO;
import com.tuzhong.response.RetVal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author WangYongShuai
 * @since 2020-11-08
 */
@CrossOrigin
@RestController
@RequestMapping("/edu/teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    /**
     * 查询所有讲师
     * @Author WangYongShuai
     * @Date 21:36 2020/11/8
     * @param
     * @throws
     * @return com.tuzhong.response.RetVal
     */
    @GetMapping
    public RetVal queryAllTeacher() {
        List<EduTeacher> allTeacher = eduTeacherService.list(null);
        return RetVal.success().data("allTeacher", allTeacher);
    }

    /**
     * 带条件的分页查询
     * @Author WangYongShuai
     * @Date 21:35 2020/11/8
     * @param pageNum
     * @param pageSize
     * @param eduTeacherConditionVO
     * @throws
     * @return com.tuzhong.response.RetVal
     */
    @GetMapping("queryPageTeacherByCondition/{pageNum}/{pageSize}")
    public RetVal queryPageTeacherByCondition(@PathVariable("pageNum") long pageNum,
                                              @PathVariable("pageSize") long pageSize,
                                              EduTeacherConditionVO eduTeacherConditionVO) {
        Page<EduTeacher> page = new Page<>(pageNum, pageSize);
        eduTeacherService.queryPageTeacherByCondition(page, eduTeacherConditionVO);
        long total = page.getTotal();
        List<EduTeacher> teacherList = page.getRecords();
        return RetVal.success().data("total", total).data("teacherList", teacherList);
    }

    /**
     * 通过Id查询讲师
     * @Author WangYongShuai
     * @Date 21:32 2020/11/8
     * @param id
     * @throws
     * @return com.tuzhong.response.RetVal
     */
    @GetMapping("{id}")
    public RetVal queryTeacherById(@PathVariable String id){
        EduTeacher teacher = eduTeacherService.getById(id);
        return RetVal.success().data("teacher",teacher);
    }

    /**
     * 通过id删除讲师
     * @Author WangYongShuai
     * @Date 21:34 2020/11/8
     * @param id
     * @throws
     * @return com.tuzhong.response.RetVal
     */
    @DeleteMapping("{id}")
    public RetVal deleteTeacherById(@PathVariable String id) {
        boolean flag = eduTeacherService.removeById(id);
        if (flag) {
            return RetVal.success();
        } else {
            return RetVal.error();
        }
    }

    /**
     * 添加讲师
     * @Author WangYongShuai
     * @Date 21:36 2020/11/8
     * @param teacher
     * @throws
     * @return com.tuzhong.response.RetVal
     */
    @PostMapping
    public RetVal saveTeacher(EduTeacher teacher) {
        boolean flag = eduTeacherService.save(teacher);
        if (flag) {
            return RetVal.success();
        } else {
            return RetVal.error();
        }
    }

    /**
     * 修改讲师信息
     * @Author WangYongShuai
     * @Date 21:36 2020/11/8
     * @param teacher
     * @throws
     * @return com.tuzhong.response.RetVal
     */
    @PutMapping
    public RetVal updateTeacher(EduTeacher teacher) {
        boolean flag = eduTeacherService.updateById(teacher);
        if (flag) {
            return RetVal.success();
        } else {
            return RetVal.error();
        }
    }

}

