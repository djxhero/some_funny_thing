package com.djxhero;

import com.djxhero.service.QiNiuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @Description TODO
 * @Author dujx
 * @Date 2019/4/30 18:19
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class QiniuTest {
    @Autowired
    QiNiuService qiNiuService;

    @Test
    public void test(){
        String pdf = "E:\\temp\\pdf1.pdf";
        File file = new File(pdf);// 输出路径
        System.out.println("上传test");
        qiNiuService.uploadFile(file,"pdf1.pdf");
        System.out.println("上传test end");
    }
}
