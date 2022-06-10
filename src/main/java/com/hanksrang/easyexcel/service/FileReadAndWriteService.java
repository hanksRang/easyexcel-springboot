package com.hanksrang.easyexcel.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.fastjson.JSON;
import com.hanksrang.easyexcel.dao.EasyexcelSpringbootCourseDao;
import com.hanksrang.easyexcel.entity.EasyexcelSpringbootCourseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FileReadAndWriteService {

    private String rootPath = "D:\\a\\projects\\easyexcel-springboot\\file\\";

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

    // 循环读取sheet页，将文件内容读到object对象
    public void read() {
        String fileName = rootPath + "course.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取3000条数据 然后返回过来 直接调用使用数据就行
        ExcelReader build = EasyExcel.read(fileName)
                .build();
        List<ReadSheet> readSheets = build.excelExecutor()
                .sheetList();
        for (ReadSheet readSheet : readSheets) {
            EasyExcel.read(fileName, new PageReadListener<>(dataList -> {
                for (Object demoData : dataList) {
                    log.info("读取到一条数据{}", JSON.toJSONString(demoData));

                }
            })).sheet(readSheet.getSheetNo()).doRead();
        }

    }

    public static void main(String[] args) {
        FileReadAndWriteService fileReadAndWriteService = new FileReadAndWriteService();
        fileReadAndWriteService.read();
    }

}
