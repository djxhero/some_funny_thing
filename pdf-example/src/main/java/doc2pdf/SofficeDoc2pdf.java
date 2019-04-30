package doc2pdf;

import common.CommandExecute;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @Description TODO
 * @Author dujx
 * @Date 2019/4/28 10:45
 **/
public class SofficeDoc2pdf {

    private static Logger LOGGER = Logger.getGlobal();

    public static void main(String[] args) throws IOException {
        pdfConverterToWord("E:\\workspace\\djxhero\\some_funny_thing\\pdf-example\\src\\main\\resources\\华南理工20162.pdf");
    }
    public static boolean wordConverterToPdf(String docxPath) throws IOException {
        File file = new File(docxPath);
        String path = file.getParent();
        try {
            String osName = System.getProperty("os.name");
            String command = "";
            if (osName.contains("Windows")) {
                command = "soffice  --convert-to pdf  -outdir " + path + " " + docxPath;
            }
//            else {
//                command = "doc2pdf --output=" + path + File.separator + file.getName().replaceAll(".(?i)docx", ".pdf") + " " + docxPath;
//            }
            String result = CommandExecute.executeCommand(command);
            LOGGER.info("result==" + result);
            if (result.equals("") || result.contains("writer_pdf_Export")) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return false;
    }

    public static boolean pdfConverterToWord(String pdfPath) throws IOException {
        File file = new File(pdfPath);
        String path = file.getParent();
        try {
            String osName = System.getProperty("os.name");
            String command = "";

            if (osName.contains("Windows")) {
                command = "soffice  --convert-to doc -outdir " + path + " " + pdfPath;
            }
//            else {
//                command = "doc2pdf --output=" + path + File.separator + file.getName().replaceAll(".(?i)docx", ".pdf") + " " + docxPath;
//            }
            String result = CommandExecute.executeCommand(command);
            LOGGER.info("result==" + result);
            if (result.equals("") || result.contains("writer_doc_Export")) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return false;
    }
}
