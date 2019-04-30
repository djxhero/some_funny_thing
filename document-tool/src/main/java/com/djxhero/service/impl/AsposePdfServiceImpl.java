package com.djxhero.service.impl;

import com.aspose.pdf.Document;
import com.aspose.pdf.License;
import com.aspose.pdf.SaveFormat;
import com.djxhero.service.AsposePdfService;
import com.djxhero.service.AsposeService;
import com.djxhero.service.ExportCommonService;
import com.djxhero.service.QiNiuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Description TODO
 * @Author dujx
 * @Date 2019/4/30 14:08
 **/
@Service
public class AsposePdfServiceImpl implements AsposePdfService {

    @Autowired
    AsposeService asposeService;

    @Autowired
    ExportCommonService exportCommonService;

    @Autowired
    QiNiuService qiNiuService;

    @Override
    public String pdf2doc(String newFileName, InputStream inputFile, OutputStream out) {
        boolean license = asposeService.getLicense("\\license\\aspose-pdf-license.xml");

        // 验证License
        if (!license) {
            return null;
        }
        File tempFile = null;
        FileOutputStream tempOut = null;
        try {
            long old = System.currentTimeMillis();
            Document pdfDocument = new Document(inputFile);
//            File file = new File(docPath);// 输出路径
//            FileOutputStream fileOS = new FileOutputStream(file);
//            out = response.getOutputStream();

            //创建临时文件
            tempFile = File.createTempFile("armyControl", null);

            tempOut = new FileOutputStream(tempFile);


            System.out.println("准备转换");
            pdfDocument.save(tempOut, SaveFormat.Doc);

            String url = qiNiuService.uploadFile(tempFile, newFileName);
            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒\n\n");

            return url;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (tempFile != null && tempFile.exists()) {
                tempFile.delete();
            }
        }
        return null;
    }

}
