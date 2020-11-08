package com.tuzhong.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tuzhong.edu.entity.EduTeacher;
import com.tuzhong.edu.mapper.EduTeacherMapper;
import com.tuzhong.edu.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tuzhong.request.EduTeacherConditionVO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author WangYongShuai
 * @since 2020-11-08
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public void queryPageTeacherByCondition(Page<EduTeacher> page, EduTeacherConditionVO eduTeacherConditionVO) {
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        String name = eduTeacherConditionVO.getName();
        Integer level = eduTeacherConditionVO.getLevel();
        String beginTime = eduTeacherConditionVO.getBeginTime();
        String endTime = eduTeacherConditionVO.getEndTime();
        if (name != null) {
            wrapper.like("name",name);
        }
        if (level != null) {
            wrapper.eq("level",level);
        }
        if (StringUtils.isNotEmpty(beginTime) && StringUtils.isNotEmpty(endTime)) {
            wrapper.ge("gmt_create",beginTime);
            wrapper.le("gmt_create",endTime);
        }
        wrapper.orderByDesc("gmt_create",beginTime);
        baseMapper.selectPage(page,wrapper);
    }
}
