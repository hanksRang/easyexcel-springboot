package com.hanksrang.easyexcel.service;

import com.alibaba.excel.EasyExcel;
import com.hanksrang.easyexcel.dao.EasyexcelSpringbootCourseDao;
import com.hanksrang.easyexcel.entity.EasyexcelSpringbootCourseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DbLoadAndExportService {

    @Autowired
    private EasyexcelSpringbootCourseDao easyexcelSpringbootCourseDao;

    private String rootPath = "D:\\2_work_for_own\\projects-open\\easyexcel-springboot\\file\\";

    public void loadAndExport() {
        String fileName = rootPath + "export.xlsx";
        EasyExcel.write(fileName, EasyexcelSpringbootCourseEntity.class).sheet("模板").doWrite(data());
    }

    private List<EasyexcelSpringbootCourseEntity> data() {
        List<Long> ids = new ArrayList<>();
        ids.add(1l);
        ids.add(2l);
        List<EasyexcelSpringbootCourseEntity> easyexcelSpringbootCourseEntityList = easyexcelSpringbootCourseDao.selectBatchIds(ids);
        return easyexcelSpringbootCourseEntityList;
    }

}
