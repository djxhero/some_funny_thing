package aspose;

import com.aspose.pdf.Document;
import com.aspose.pdf.License;
import com.aspose.pdf.SaveFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @Description TODO
 * @Author dujx
 * @Date 2019/4/28 14:10
 **/
public class AposePdf2doc {

    /**
     * 获取license
     *
     * @return
     */
    public static boolean getLicense() {
        boolean result = false;
        InputStream license;
        try {
            license = AposePdf2doc.class.getClassLoader().getResourceAsStream(
                    "\\license\\aspose-pdf-license.xml");// license路径
            License aposeLic = new License();
            aposeLic.setLicense(license);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String pdf = "E:\\workspace\\djxhero\\some_funny_thing\\pdf-example\\src\\main\\resources\\20162.pdf";
//        pdf2doc(pdf, "e:\\temp\\test.docx", SaveFormat.DocX);
        pdf2doc(pdf, "e:\\temp\\test.doc", SaveFormat.Doc);
    }

    public static void pdf2doc(String pdf, String docPath, int saveFormat) {
        // 验证License
        if (!getLicense()) {
            return;
        }

        try {
            long old = System.currentTimeMillis();
            Document pdfDocument = new Document(pdf);
            File file = new File(docPath);// 输出路径
            FileOutputStream fileOS = new FileOutputStream(file);

            pdfDocument.save(fileOS, saveFormat);

            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒\n\n" + "文件保存在:" + file.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

