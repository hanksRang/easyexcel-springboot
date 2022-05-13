package com.hanksrang.easyexcel.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.hanksrang.easyexcel.dao.EasyexcelSpringbootCourseDao;
import com.hanksrang.easyexcel.entity.EasyexcelSpringbootCourseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FileReadAndWriteService {

    private String rootPath = "D:\\a\\b\\easyexcel-springboot\\file\\";

    @Autowired
    private EasyexcelSpringbootCourseDao easyexcelSpringbootCourseDao;

    public void readAndSave() {
        String fileName = rootPath + "course.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取3000条数据 然后返回过来 直接调用使用数据就行
        EasyExcel.read(fileName, EasyexcelSpringbootCourseEntity.class, new PageReadListener<EasyexcelSpringbootCourseEntity>(dataList -> {
            for (EasyexcelSpringbootCourseEntity demoData : dataList) {
                log.info("读取到一条数据{}", JSON.toJSONString(demoData));
                demoData.setId(null);
                easyexcelSpringbootCourseDao.insert(demoData);
            }
        })).sheet().doRead();
    }

}
