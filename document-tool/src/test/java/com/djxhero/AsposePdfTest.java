package com.djxhero;

import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;
import com.djxhero.service.AsposePdfService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @Description TODO
 * @Author dujx
 * @Date 2019/4/30 15:37
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AsposePdfTest {

    @Autowired
    AsposePdfService asposePdfService;

    @Test
    public void pdf2doc() throws FileNotFoundException {
        String pdf = "E:\\dujx\\其他\\17.行测的思维（言语理解与表达）.pdf";
        String docPath = "e:\\temp\\test2.doc";
        File file = new File(docPath);// 输出路径
        FileOutputStream fileOS = new FileOutputStream(file);
        System.out.println("转换test");
        asposePdfService.pdf2doc(pdf,new FileInputStream(new File(pdf)),fileOS);
        System.out.println("转换test end");
    }
}
