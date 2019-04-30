package aspose;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @Description TODO
 * @Author dujx
 * @Date 2019/4/28 15:09
 **/
public class AsposeDoc2pdf {

    /**
     * 获取license
     *
     * @return
     */
    public static boolean getLicense() {
        boolean result = false;
        InputStream license;
        try {
            license = AsposeDoc2pdf.class.getClassLoader().getResourceAsStream("\\license\\aspose-words-license.xml");// license路径
            License aposeLic = new License();
            aposeLic.setLicense(license);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String doc = "E:\\workspace\\djxhero\\some_funny_thing\\pdf-example\\src\\main\\resources\\华南理工2016.doc";
        doc2pdf(doc,"e:\\temp\\pdf1.pdf");
    }

    public static void doc2pdf(String docPath,String destPath) {
        if (!getLicense()) {
            // 验证License 若不验证则转化出的pdf文档会有水印产生
            return;
        }
        try {
            long old = System.currentTimeMillis();
            File file = new File(destPath);  //新建一个空白pdf文档
            FileOutputStream os = new FileOutputStream(file);
            Document doc = new Document(docPath);                    //Address是将要被转化的word文档
            doc.save(os, SaveFormat.PDF);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");  //转化用时
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
