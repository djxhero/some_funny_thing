package pdfbox;

import org.apache.pdfbox.io.RandomAccessBufferedFileInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;

/**
 * @Description TODO
 * @Author dujx
 * @Date 2019/4/26 15:30
 **/
public class PdfBoxExample {
    public static String ROOT = "E:\\workspace\\djxhero\\some_funny_thing\\pdf-example\\src\\main\\resources\\";

    static {
        System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
    }

    public static void main(String[] args) throws IOException {
        pdfToDoc(ROOT + "chinese-sample.pdf");

    }

    public static void pdfToDoc(String name1)
            throws IOException {
        RandomAccessRead randomAccessRead = new RandomAccessBufferedFileInputStream(name1);

        PDFParser pdfParser = new PDFParser(randomAccessRead);
        pdfParser.parse();
        PDDocument doc = new PDDocument(pdfParser.getDocument());

        int pagenumber = doc.getNumberOfPages();

        name1 = name1.substring(0, name1.lastIndexOf("."));

        String dirName = name1;

        String fileName = dirName + ".doc";
        createFile(fileName);
        FileOutputStream fos = new FileOutputStream(fileName);
        Writer writer = new OutputStreamWriter(fos, "UTF-8");
        PDFTextStripper stripper = new PDFTextStripper();

        stripper.setSortByPosition(true);

        stripper.setStartPage(1);
        stripper.setEndPage(pagenumber);
        stripper.writeText(doc, writer);
        writer.close();
        doc.close();
        System.out.println("pdf转换word成功！");
    }

    private static void createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            System.out.println("创建目录失败，目标目录已存在！");
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        if (dir.mkdirs()) {
            System.out.println("创建目录成功！" + destDirName);
        } else {
            System.out.println("创建目录失败！");
        }
    }

    public static void createFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("目标文件已存在" + filePath);
        }
        if (filePath.endsWith(File.separator)) {
            System.out.println("目标文件不能为目录！");
        }
        if (!file.getParentFile().exists()) {
            System.out.println("目标文件所在目录不存在，准备创建它！");
            if (!file.getParentFile().mkdirs()) {
                System.out.println("创建目标文件所在的目录失败！");
            }
        }
        try {
            if (file.createNewFile()) {
                System.out.println("创建文件成功:" + filePath);
            } else {
                System.out.println("创建文件失败！");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("创建文件失败！" + e.getMessage());
        }
    }


    public static void readPdf() {
        String a = null;
        try {
            RandomAccessRead randomAccessRead = new RandomAccessBufferedFileInputStream(ROOT + "chinese-sample.pdf");

            PDFParser pdfParser = new PDFParser(randomAccessRead);
            pdfParser.parse();
            PDDocument pdDocument = new PDDocument(pdfParser.getDocument());
            PDFTextStripper pdfTextStripper = new PDFLayoutTextStripper();
            a = pdfTextStripper.getText(pdDocument);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
        System.out.println(a);
    }


    public static void wirtePdf() {

        // Create a Document object.
        PDDocument pdDocument = new PDDocument();

        // Create a Page object
        PDPage pdPage = new PDPage();
        // Add the page to the document and save the document to a desired file.
        pdDocument.addPage(pdPage);
        try {
            // Create a Content Stream
            PDPageContentStream pdPageContentStream = new PDPageContentStream(pdDocument, pdPage);

            // Start the stream
            pdPageContentStream.beginText();

            // Set the X and Y corodinates for the text to be positioned
            pdPageContentStream.newLineAtOffset(25, 700);

            // Set a Font and its Size
            // We cannot use the standard fonts provided.
            // pdPageContentStream.setFont(PDType1Font.HELVETICA, 12);
            String fileUtl = (ROOT + "ARIALUNI.TTF");
            PDFont unicodeFont = PDType0Font.load(pdDocument, new File(fileUtl));
            pdPageContentStream.setFont(unicodeFont, 14);

            pdPageContentStream.showText("这是我的第一个字");

            // End the Stream
            pdPageContentStream.endText();

            // Once all the content is written, close the stream
            pdPageContentStream.close();

            pdDocument.save(ROOT + "chinese-sample.pdf");
            pdDocument.close();
            System.out.println("PDF saved to the location !!!");

        } catch (IOException ioe) {
            System.out.println("Error while saving pdf " + ioe.getMessage());
        }

    }
}
