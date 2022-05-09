package com.hanksrang.easyexcel.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileReadAndWriteServiceTest {

    @Autowired
    private FileReadAndWriteService fileReadAndWriteService;

    @Test
    public void testReadAndWrite() {
        fileReadAndWriteService.readAndSave();
    }

}
