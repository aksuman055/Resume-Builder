import com.itextpdf.text.*;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.pdf.draw.LineSeparator;


import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import com.itextpdf.tool.xml.html.table.Table;
import org.w3c.dom.Text;

import java.io.FileOutputStream;


public class resumeGenerator {
    private final Map<String, String> details; // stores form values from ResumeBuilder.java

    resumeGenerator(Map<String, String> detailsFromRB) {
        details = detailsFromRB;
    }

    void createResume() throws IOException {
        Document resume = new Document();
        try {


            PdfWriter.getInstance(resume, new FileOutputStream("resume.pdf"));
            resume.open();
            LineSeparator line;
            line = new LineSeparator();
            Font f = new Font();
            resume.add(Chunk.NEWLINE);
            Font font2 = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD );
            Paragraph name = new Paragraph((String) details.get("Name"), font2);
            name.setAlignment(Paragraph.ALIGN_RIGHT);
            resume.add(name);

            Font font = new Font(Font.FontFamily.HELVETICA, 8);

            Paragraph address = new Paragraph((String) details.get("Address"), font);
            address.setAlignment(Paragraph.ALIGN_RIGHT);
            resume.add(address);
            Paragraph contact = new Paragraph((String) details.get("ContactNumber"), font);
            contact.setAlignment(Paragraph.ALIGN_RIGHT);
            resume.add(contact);
            Paragraph email = new Paragraph((String) details.get("Email"), font);
            email.setAlignment(Paragraph.ALIGN_RIGHT);
            resume.add(email);
            Font font1 = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD );
            resume.add(Chunk.NEWLINE);
            resume.add(line);
            Paragraph obj = new Paragraph("OBJECTIVE",font1);
            obj.setAlignment(Element.ALIGN_MIDDLE);
            resume.add(obj);
            resume.add(Chunk.NEWLINE);
            resume.add(line);
            Paragraph objective = new Paragraph((String) details.get("Objective"), font);
            objective.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            resume.add(objective);

            resume.add(Chunk.NEWLINE);
            resume.add(line);
            Paragraph edu = new Paragraph("EDUCATION",font1);
            resume.add(edu);
            resume.add(Chunk.NEWLINE);
            resume.add(line);
            Chunk col = new Chunk(new VerticalPositionMark());
            Paragraph colp = new Paragraph(20,(String) details.get("College"),font1);
            colp.add(new Chunk(col));
            colp.add(details.get("DateCollege"));
            colp.setIndentationLeft(25);
            colp.setIndentationRight(30);
            resume.add(colp);
            Chunk br = new Chunk(details.get("BranchName"), font);
            Chunk cgpa = new Chunk("  CGPA "+details.get("CollegePercentage"),font1);
            Paragraph branch = new Paragraph();
            branch.add(br);
            branch.add(cgpa);
            branch.setIndentationLeft(30);
            branch.setLeading(15);
            resume.add(branch);


            Chunk c12 = new Chunk(new VerticalPositionMark());
            Paragraph sc1 = new Paragraph(20,(String) details.get("SchoolXII"),font1);
            sc1.add(new Chunk(c12));
            sc1.add(details.get("DateXII"));
            sc1.setIndentationLeft(25);
            sc1.setIndentationRight(30);
            resume.add(sc1);
            Chunk br2 = new Chunk("Class 12th ", font);
            Chunk per12 = new Chunk("   Percentage "+details.get("PercentageXII"),font1);
            Paragraph sc12 = new Paragraph();
            sc12.add(br2);
            sc12.add(per12);
            sc12.setIndentationLeft(30);
            sc12.setLeading(15);
            resume.add(sc12);


            Chunk c10= new Chunk(new VerticalPositionMark());
            Paragraph sc2 = new Paragraph(20,(String) details.get("SchoolX"),font1);
            sc2.add(new Chunk(c10));
            sc2.add(details.get("DateX"));
            sc2.setIndentationLeft(25);
            sc2.setIndentationRight(30);
            resume.add(sc2);
            Chunk br10 = new Chunk("Class 10th ", font);
            Chunk per10 = new Chunk("   Percentage "+details.get("PercentageX"),font1);
            Paragraph sc10 = new Paragraph();
            sc10.add(br10);
            sc10.add(per10);
            sc10.setIndentationLeft(30);
            sc10.setLeading(15);
            resume.add(sc10);


            resume.add(Chunk.NEWLINE);
            resume.add(line);
            Paragraph skill = new Paragraph("SKILLS",font1);
            resume.add(skill);
            resume.add(Chunk.NEWLINE);
            resume.add(line);
            List list = new List();
            list.setSymbolIndent(15);
            list.setListSymbol("\u2022");
            list.add(new ListItem(20,details.get("Skill1"), font));
            list.add(new ListItem(20,details.get("Skill2"), font));
            list.add(new ListItem(20,details.get("Skill3"), font));
            list.add(new ListItem(20,details.get("Skill4"), font));
            list.setIndentationLeft(30);
            resume.add(list);
            resume.add(Chunk.NEWLINE);
            resume.add(line);

            Paragraph exp = new Paragraph("EXPERIENCE AND PROJECTS ",font1);
            resume.add(exp);
            resume.add(Chunk.NEWLINE);
            resume.add(line);

            Chunk glue = new Chunk(new VerticalPositionMark());
            Paragraph p = new Paragraph(20,(String) "1. "+details.get("ProjectName1"),font1);
            p.add(new Chunk(glue));
            p.add(details.get("ProjectDate1"));
            p.setIndentationRight(30);
            p.setIndentationLeft(25);
            resume.add(p);
            Chunk ch5 = new Chunk( " Abstract: ", font1);
            Chunk ch6 = new Chunk(details.get("ProjectDescription1"),font);
            Paragraph pd1 = new Paragraph();
            pd1.add(ch5);
            pd1.add(ch6);
            pd1.setIndentationLeft(30);
            pd1.setLeading(10);
            resume.add(pd1);


            Chunk glue2 = new Chunk(new VerticalPositionMark());
            Paragraph p2 = new Paragraph(20,(String) "2. "+details.get("ProjectName2"),font1);
            p2.add(new Chunk(glue2));
            p2.add(details.get("ProjectDate2"));
            p2.setIndentationRight(30);
            p2.setIndentationLeft(25);
            resume.add(p2);
            Chunk ch3 = new Chunk( " Abstract: ", font1);
            Chunk ch4 = new Chunk(details.get("ProjectDescription2"),font);
            Paragraph pd2 = new Paragraph();
            pd2.add(ch3);
            pd2.add(ch4);
            pd2.setIndentationLeft(30);
            pd2.setLeading(10);
            resume.add(pd2);


            Chunk glue3= new Chunk(new VerticalPositionMark());
            Paragraph p3 = new Paragraph(20,(String) "3. "+details.get("ProjectName3"),font1);
            p3.add(new Chunk(glue3));
            p3.add(details.get("ProjectDate3"));
            p3.setIndentationRight(30);
            p3.setIndentationLeft(25);
            resume.add(p3);
            Chunk ch1 = new Chunk( " Abstract: ", font1);
            Chunk ch2 = new Chunk(details.get("ProjectDescription3"),font);
            Paragraph pd3 = new Paragraph();
            pd3.add(ch1);
            pd3.add(ch2);
            pd3.setIndentationLeft(30);
            pd3.setLeading(10);
            resume.add(pd3);

            resume.add(Chunk.NEWLINE);
            resume.add(line);
            Paragraph ach = new Paragraph("ACHIEVEMENTS ",font1);
            resume.add(ach);
            resume.add(Chunk.NEWLINE);
            resume.add(line);

            Paragraph ac1 = new Paragraph(20,(String) "1. "+details.get("Achievement1"),font1);
            ac1.setIndentationLeft(30);
            resume.add(ac1);

            Paragraph ac2 = new Paragraph(20,(String) "1. "+details.get("Achievement2"),font1);
            ac2.setIndentationLeft(30);
            resume.add(ac2);

            resume.close();

        } catch (DocumentException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        File file = new File("resume.pdf");
        Desktop.getDesktop().open(file);

    }
}
