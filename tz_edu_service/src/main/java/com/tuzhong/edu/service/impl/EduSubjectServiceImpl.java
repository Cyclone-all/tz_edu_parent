package com.tuzhong.edu.service.impl;

import com.tuzhong.edu.entity.EduSubject;
import com.tuzhong.edu.mapper.EduSubjectMapper;
import com.tuzhong.edu.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tuzhong.response.SubjectVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author BaiYun
 * @since 2020-11-08
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public List<SubjectVO> getAllSubject() {
        // 首先获取所有的分类信息
        List<EduSubject> eduSubjects = baseMapper.selectList(null);
        // 从eduSubjects找出一级分类，存储到list中
        List<SubjectVO> parentList = new ArrayList<>();
        for (EduSubject eduSubject : eduSubjects) {
            if ("0".equals(eduSubject.getParentId())) {
                SubjectVO parentSubjectVO = new SubjectVO();
                BeanUtils.copyProperties(eduSubject, parentSubjectVO);
                parentSubjectVO.setChildrenList(new ArrayList<>());
                parentList.add(parentSubjectVO);
            }
        }
        HashMap<String, SubjectVO> subjectVOHashMap = new HashMap<>(16);
        for (SubjectVO subjectVO : parentList) {
            subjectVOHashMap.put(subjectVO.getId(), subjectVO);
        }
        for (EduSubject eduSubject : eduSubjects) {
            if (!"0".equals(eduSubject.getParentId())) {
                SubjectVO childrenVO = new SubjectVO();
                BeanUtils.copyProperties(eduSubject, childrenVO);
                SubjectVO parentSubjectVO = subjectVOHashMap.get(eduSubject.getParentId());
                List<SubjectVO> childrenList = parentSubjectVO.getChildrenList();
                childrenList.add(childrenVO);
            }
        }
        return parentList;
    }
}

















