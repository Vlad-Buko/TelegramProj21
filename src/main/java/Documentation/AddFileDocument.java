package Documentation;
import java.io.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class AddFileDocument  {
    private static String name;
    private static String procedure;
    private static String date;
    private static String location;

    public void setName(String name) {
        this.name = name;
    }
    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public PDDocument printText (PDDocument file) throws IOException {
        PDPage page = file.getPage(0);
        PDFont font = PDType0Font.load(file, new File("C:\\JAVA\\Proj\\src\\main\\resources\\times-new-roman.ttf"));
        float fontSize = 18;

        try (PDPageContentStream contentStream = new PDPageContentStream(file, page, PDPageContentStream.AppendMode.APPEND, true)) {
            contentStream.beginText();
            contentStream.newLineAtOffset(130, 445);
            contentStream.setFont(font, fontSize);
            contentStream.showText(name);
            contentStream.endText();
        }
        try (PDPageContentStream contentStream = new PDPageContentStream(file, page, PDPageContentStream.AppendMode.APPEND, true)) {
            contentStream.beginText();
            contentStream.newLineAtOffset(130, 428);
            contentStream.setFont(font, fontSize);
            contentStream.showText(procedure);
            contentStream.endText();
        }
        try (PDPageContentStream contentStream = new PDPageContentStream(file, page, PDPageContentStream.AppendMode.APPEND, true)) {
            contentStream.beginText();
            contentStream.newLineAtOffset(750, 345);
            contentStream.setFont(font, 14);
            contentStream.showText(date);
            contentStream.endText();
        }
        try (PDPageContentStream contentStream = new PDPageContentStream(file, page, PDPageContentStream.AppendMode.APPEND, true)) {
            contentStream.beginText();
            contentStream.newLineAtOffset(60, 192);
            contentStream.setFont(font, fontSize);
            contentStream.showText(location);
            contentStream.endText();
        }
        file.save("Minsk.pdf");
        file.close();
        return file;
    }
}