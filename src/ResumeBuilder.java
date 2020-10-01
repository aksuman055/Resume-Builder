import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
//import javax.swing.event.AncestorEvent;
//import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResumeBuilder implements ActionListener {
    ResumeBuilder() {
        //defining all the fields
        TextField nt;
        TextField at;
        TextField ct;
        TextField et;
        TextField st;
        TextField dt1;
        TextField pt;
        TextField hst;
        TextField pt2;
        TextField dt2;
        TextField colt;
        TextField pt3;
        TextField dt3;
        TextField bran;
        TextArea objt;
        TextField s1;
        TextField s2;
        TextField s3;
        TextField s4;
        TextField p1;
        TextField pdt1;
        TextArea pdst1;
        TextField p2;
        TextField pdt2;
        TextArea pdst2;
        TextField p3;
        TextField pdt3;
        TextArea pdst3;
        TextField at1;
        TextField at2;
        initComponent();
    }

    private void initComponent() {
        Frame mainFrame = new Frame("Resume Builder");
        mainFrame.setSize(1150, 820);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        //*************Adding of Menu Bar.**********************
        MenuBar mb = new MenuBar();
        Menu filemenu = new Menu("File");
        Menu aboutmenu = new Menu("About");

        MenuItem i1 = new MenuItem("New", new MenuShortcut(KeyEvent.VK_N));
        i1.setActionCommand("New");
        i1.addActionListener(this);

        MenuItem i2 = new MenuItem("Exit");
        i2.setActionCommand("Exit");
        i2.addActionListener(this);

        MenuItem i3 = new MenuItem("Save", new MenuShortcut(KeyEvent.VK_S));
        i3.setActionCommand("Save");

        filemenu.add(i1);
        filemenu.add(i3);
        filemenu.add(i2);
        mb.add(filemenu);
        mb.add(aboutmenu);
        mainFrame.setMenuBar(mb);
        //**************Menu bar end***************************************************************

        Label head = new Label("RESUME BUILDER");
        head.setBounds(0, 35, 1150, 70);
        head.setFont(new Font("Tahoma", Font.BOLD, 30));
        head.setAlignment(Label.CENTER);
        // head.setBackground(Color.cyan);
        mainFrame.add(head);
        Label l1;
        l1 = new Label("PERSONAL INFORMATION");
        l1.setBounds(20, 105, 260, 20);
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        // l1.setBackground(Color.pink);
        l1.setForeground(Color.black);

        Label name = new Label("Name:");
        name.setBounds(20, 135, 50, 20);
        name.setFont(new Font("Arial Black", Font.PLAIN, 13));
        nt = new TextField();
        nt.setBackground(Color.cyan);
        nt.setBounds(150, 135, 200, 20);
        nt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ntActionPerformed(e);
            }
        });


        Label address = new Label("Address:");
        address.setBounds(20, 165, 60, 20);
        address.setFont(new Font("Arial Black", Font.PLAIN, 13));
        at = new TextField();
        at.setBounds(150, 165, 200, 20);
        at.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ntActionPerformed(e);
            }

        });

        Label conNo = new Label("Contact No.:");
        conNo.setBounds(20, 195, 70, 20);
        conNo.setFont(new Font("Arial Black", Font.PLAIN, 13));
        ct = new TextField();
        ct.setBounds(150, 195, 200, 20);
        ct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctActionPerformed(e);
            }
        });


        Label email = new Label("Email:");
        email.setBounds(20, 225, 50, 20);
        email.setFont(new Font("Arial Black", Font.PLAIN, 13));
        et = new TextField();
        et.setBounds(150, 225, 200, 20);


        //*********Adding of Education Qualifications*****************
        Label edu;
        edu = new Label("EDUCATIONAL QUALIFICATIONS");
        edu.setBounds(20, 265, 340, 20);
        edu.setFont(new Font("Tahoma", Font.BOLD, 20));

        Label sc = new Label("School Name(X):");
        sc.setBounds(20, 295, 120, 20);
        sc.setFont(new Font("Arial Black", Font.PLAIN, 13));
        st = new TextField();
        st.setBounds(150, 295, 200, 20);

        Label per = new Label("Percentage/CGPA:");
        per.setBounds(20, 325, 120, 20);
        per.setFont(new Font("Arial Black", Font.PLAIN, 13));
        pt = new TextField();
        pt.setBounds(150, 325, 200, 20);

        Label date1 = new Label("Date:");
        date1.setBounds(20, 355, 120, 20);
        email.setFont(new Font("Arial Black", Font.PLAIN, 13));
        dt1 = new TextField("From-to-To");
        dt1.setBounds(150, 355, 200, 20);

        Label hsc = new Label("School Name(XII):");
        hsc.setBounds(20, 385, 120, 20);
        hsc.setFont(new Font("Arial Black", Font.PLAIN, 13));
        hst = new TextField();
        hst.setBounds(150, 385, 200, 20);

        Label per2 = new Label("Percentage");
        per2.setBounds(20, 415, 120, 20);
        per2.setFont(new Font("Arial Black", Font.PLAIN, 13));
        pt2 = new TextField();
        pt2.setBounds(150, 415, 200, 20);

        Label date2 = new Label("Date:");
        date2.setBounds(20, 445, 120, 20);
        date2.setFont(new Font("Arial Black", Font.PLAIN, 13));
        dt2 = new TextField("From-to-To");
        dt2.setBounds(150, 445, 200, 20);

        Label col = new Label("College/University ");
        col.setBounds(20, 475, 120, 20);
        col.setFont(new Font("Arial Black", Font.PLAIN, 13));
        colt = new TextField("College/University Name");
        colt.setBounds(150, 475, 200, 20);

        Label per3 = new Label("Percentage/CGPA");
        per3.setBounds(20, 505, 120, 20);
        per3.setFont(new Font("Arial Black", Font.PLAIN, 13));
        pt3 = new TextField();
        pt3.setBounds(150, 505, 200, 20);

        Label date3 = new Label("Date:");
        date3.setBounds(20, 535, 120, 20);
        date3.setFont(new Font("Arial Black", Font.PLAIN, 13));
        dt3 = new TextField("From-to-To");
        dt3.setBounds(150, 535, 200, 20);


        Label br = new Label("Branch Name:");
        br.setBounds(20,565,120,20);
        bran = new TextField();
        bran.setBounds(150,565,200,20);
        //**********End of educational qualifications*********************


        Label obj = new Label("OBJECTIVE");
        obj.setBounds(20, 605, 260, 20);
        obj.setFont(new Font("Tahoma", Font.BOLD, 20));
        objt = new TextArea();
        objt.setBounds(20, 635, 330, 80);


        //********Skills*****************
        Label skill = new Label("SKILLS");
        skill.setBounds(450, 105, 260, 20);
        skill.setFont(new Font("Tahoma", Font.BOLD, 20));
        s1 = new TextField();
        s1.setBounds(450, 135, 200, 20);
        s2 = new TextField();
        s2.setBounds(670, 135, 200, 20);
        s3 = new TextField();
        s3.setBounds(450, 165, 200, 20);
        s4 = new TextField();
        s4.setBounds(670, 165, 200, 20);
        //*******************************

        //Adding of Projects and work***************
        Label work = new Label("PROJECTS AND WORK EXPERIENCE");
        work.setBounds(450, 205, 370, 20);
        work.setFont(new Font("Tahoma", Font.BOLD, 20));

        Label pr1 = new Label("Name:");
        pr1.setBounds(450, 235, 120, 20);
        pr1.setFont(new Font("Arial Black", Font.PLAIN, 13));
        p1 = new TextField("Enter Project Title");
        p1.setBounds(580, 235, 290, 20);

        Label pd1 = new Label("Date:");
        pd1.setBounds(450, 265, 120, 20);
        pd1.setFont(new Font("Arial Black", Font.PLAIN, 13));
        pdt1 = new TextField("From-to-To");
        pdt1.setBounds(580, 265, 290, 20);

        Label pds1 = new Label("Description:");
        pds1.setBounds(450, 295, 120, 20);
        pds1.setFont(new Font("Arial Black", Font.PLAIN, 13));
        pdst1 = new TextArea();
        pdst1.setBounds(580, 295, 290, 80);

        Label pr2 = new Label("Name:");
        pr2.setBounds(450, 385, 120, 20);
        pr2.setFont(new Font("Arial Black", Font.PLAIN, 13));
        p2 = new TextField("Enter Project Title");
        p2.setBounds(580, 385, 290, 20);

        Label pd2 = new Label("Date:");
        pd2.setBounds(450, 415, 120, 20);
        pd2.setFont(new Font("Arial Black", Font.PLAIN, 13));
        pdt2 = new TextField("From-to-To");
        pdt2.setBounds(580, 415, 290, 20);

        Label pds2 = new Label("Description:");
        pds2.setBounds(450, 445, 120, 20);
        pds2.setFont(new Font("Arial Black", Font.PLAIN, 13));
        pdst2 = new TextArea();
        pdst2.setBounds(580, 445, 290, 80);

        Label pr3 = new Label("Name:");
        pr3.setBounds(450, 535, 120, 20);
        pr3.setFont(new Font("Arial Black", Font.PLAIN, 13));
        p3 = new TextField("Enter Project Title");
        p3.setBounds(580, 535, 290, 20);

        Label pd3 = new Label("Date:");
        pd3.setBounds(450, 565, 120, 20);
        pd3.setFont(new Font("Arial Black", Font.PLAIN, 13));
        pdt3 = new TextField("From-to-To");
        pdt3.setBounds(580, 565, 290, 20);

        Label pds3 = new Label("Description:");
        pds3.setBounds(450, 595, 120, 20);
        pds3.setFont(new Font("Arial Black", Font.PLAIN, 13));
        pdst3 = new TextArea();
        pdst3.setBounds(580, 595, 290, 60);
        //****************************************************************************************

        //***************Achievements****************************************
        Label ach = new Label("ACHIEVMENTS");
        ach.setBounds(450, 665, 260, 30);
        ach.setFont(new Font("Tahoma", Font.BOLD, 20));
        at1 = new TextField();
        at1.setBounds(450, 695, 200, 20);
        at2 = new TextField();
        at2.setBounds(670, 695, 200, 20);
        //*******************************************************************

        Label fot1 = new Label("\" YOUR RESUME SAYS A LOT ABOUT YOU,");
        fot1.setBounds(0, 735, 1150, 20);
        fot1.setFont(new Font("Arial Black", Font.ITALIC, 15));
        fot1.setAlignment(Label.CENTER);
        Label fot2 = new Label("IT DETERMINES WHETHER YOU WILL");
        fot2.setBounds(0, 755, 1150, 20);
        fot2.setFont(new Font("Arial Black", Font.ITALIC, 15));
        fot2.setAlignment(Label.CENTER);
        Label fot3 = new Label("BE CALLED IN FOR INTERVIEW OR NOT.\"");
        fot3.setBounds(0, 775, 1150, 20);
        fot3.setFont(new Font("Arial Black", Font.ITALIC, 15));
        fot3.setAlignment(Label.CENTER);


        Label img = new Label("IMAGE");
        img.setBounds(950, 105, 370, 20);
        img.setFont(new Font("Tahoma", Font.BOLD, 20));


        //**************Adding of buttons******************************
        Button bt1 = new Button("Reset");
        bt1.setBounds(950, 550, 100, 30);
        Button bt2 = new Button("Generate PDF");
        bt2.setBounds(950, 600, 100, 30);
        Button bt3 = new Button("Exit");
        bt3.setBounds(950, 650, 100, 30);

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm(e);
            }
        });


        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubmitActionPerformed(e);
            }

        });

        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


//****************Adding Image****************

        Button btup = new Button("Add Image");
        btup.setBounds(950, 390, 100, 30);
        mainFrame.add(btup);

        JLabel label = new JLabel();
        label.setBounds(900, 125, 250, 250);
        label.setBackground(Color.RED);

        btup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                //filter the files
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);
                //if the user click on save in Jfilechooser
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    label.setIcon(ResizeImage(path));
                }
                //if the user click on save in Jf
                // ilechooser


                else if (result == JFileChooser.CANCEL_OPTION) {
                    System.out.println("No File Select");
                }

            }
        });
        mainFrame.add(label);
//****************************************************************************************


        mainFrame.add(l1);
        mainFrame.add(name);
        mainFrame.add(nt);
        mainFrame.add(address);
        mainFrame.add(at);
        mainFrame.add(conNo);
        mainFrame.add(ct);
        mainFrame.add(email);
        mainFrame.add(et);
        mainFrame.add(edu);
        mainFrame.add(sc);
        mainFrame.add(st);
        mainFrame.add(per);
        mainFrame.add(pt);
        mainFrame.add(date1);
        mainFrame.add(dt1);
        mainFrame.add(hsc);
        mainFrame.add(hst);
        mainFrame.add(per2);
        mainFrame.add(pt2);
        mainFrame.add(date2);
        mainFrame.add(dt2);
        mainFrame.add(col);
        mainFrame.add(colt);
        mainFrame.add(per3);
        mainFrame.add(pt3);
        mainFrame.add(date3);
        mainFrame.add(dt3);
        mainFrame.add(br);
        mainFrame.add(bran);
        mainFrame.add(obj);
        mainFrame.add(objt);
        mainFrame.add(skill);
        mainFrame.add(s1);
        mainFrame.add(s2);
        mainFrame.add(s3);
        mainFrame.add(s4);
        mainFrame.add(work);
        mainFrame.add(pr1);
        mainFrame.add(p1);
        mainFrame.add(pd1);
        mainFrame.add(pdt1);
        mainFrame.add(pds1);
        mainFrame.add(pdst1);
        mainFrame.add(pr2);
        mainFrame.add(p2);
        mainFrame.add(pd2);
        mainFrame.add(pdt2);
        mainFrame.add(pds2);
        mainFrame.add(pdst2);
        mainFrame.add(pdst3);
        mainFrame.add(pr3);
        mainFrame.add(p3);
        mainFrame.add(pd3);
        mainFrame.add(pdt3);
        mainFrame.add(pds3);
        mainFrame.add(ach);
        mainFrame.add(at1);
        mainFrame.add(at2);
        mainFrame.add(fot1);
        mainFrame.add(fot2);
        mainFrame.add(fot3);
        mainFrame.add(img);
        mainFrame.add(bt1);
        mainFrame.add(bt2);
        mainFrame.add(bt3);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }


    //*************Getting text from setText***********************
    public Map<String, String> getDetails() {
        Map<String, String> details;
        details = new HashMap<String, String>();

        String candidateName = nt.getText();
        details.put("Name", candidateName);

        String address = at.getText();
        details.put("Address", address);

        String contactNo = ct.getText();
        details.put("ContactNumber", contactNo);

        String email = et.getText();
        details.put("Email", email);

        String schoolX = st.getText();
        details.put("SchoolX", schoolX);

        String perX = pt.getText();
        details.put("PercentageX", perX);

        String dateX = dt1.getText();
        details.put("DateX", dateX);

        String schoolXII = hst.getText();
        details.put("SchoolXII", schoolXII);

        String perXII = pt2.getText();
        details.put("PercentageXII", perXII);

        String dateXII = dt2.getText();
        details.put("DateXII", dateXII);

        String college = colt.getText();
        details.put("College", college);

        String colPer = pt3.getText();
        details.put("CollegePercentage", colPer);

        String dateCol = dt3.getText();
        details.put("DateCollege", dateCol);

        String branch = bran.getText();
        details.put("BranchName", branch);

        String objective = objt.getText();
        details.put("Objective", objective);

        String skill1 = s1.getText();
        details.put("Skill1", skill1);

        String skill2 = s2.getText();
        details.put("Skill2", skill2);

        String skill3 = s3.getText();
        details.put("Skill3", skill3);

        String skill4 = s4.getText();
        details.put("Skill4", skill4);

        String projectName1 = p1.getText();
        details.put("ProjectName1", projectName1);

        String prDate1 = pdt1.getText();
        details.put("ProjectDate1", prDate1);

        String prDes1 = pdst1.getText();
        details.put("ProjectDescription1", prDes1);

        String projectName2 = p2.getText();
        details.put("ProjectName2", projectName2);

        String prDate2 = pdt2.getText();
        details.put("ProjectDate2", prDate2);

        String prDes2 = pdst2.getText();
        details.put("ProjectDescription2", prDes2);

        String projectName3 = p3.getText();
        details.put("ProjectName3", projectName3);

        String prDate3 = pdt3.getText();
        details.put("ProjectDate3", prDate3);

        String prDes3 = pdst3.getText();
        details.put("ProjectDescription3", prDes3);

        String act1 = at1.getText();
        details.put("Achievement1", act1);

        String act2 = at2.getText();
        details.put("Achievement2", act2);

        return details;
    }

    //*********************************************************
    public void clearForm(ActionEvent e) {
        nt.setText("");
        at.setText("");
        ct.setText("");
        et.setText("");
        st.setText("");
        pt.setText("");
        hst.setText("");
        pt2.setText("");
        pt3.setText("");
        bran.setText("");
        objt.setText("");
        s1.setText("");
        s2.setText("");
        s3.setText("");
        s4.setText("");
        pdst1.setText("");
        pdst2.setText("");
        pdst3.setText("");
        at1.setText("");
        at2.setText("");
    }

    private void SubmitActionPerformed(ActionEvent e) {
//                 PDFTest pdftest = new PDFTest();
//        try {
//            pdftest.createPdf("blank.pdf");
//        } catch (IOException ex) {
//            Logger.getLogger(ResumeBuilder.class.getName()).log(Level.SEVERE, null, ex);
//        }
        Map<String, String> details = getDetails();

        resumeGenerator resume;
        resume = new resumeGenerator(details);
        try {
            resume.createResume();
        } catch (IOException ex) {
            Logger.getLogger(ResumeBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void etkeyTyped(KeyEvent e) {
    }

    private void ctActionPerformed(ActionEvent e) {
    }

    private void ntActionPerformed(ActionEvent e) {
    }


    // Method to resize imageIcon with the same size of a label
    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img1 = MyImage.getImage();
        Image newImg = img1.getScaledInstance(220, 220, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }


    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Exit")) {
            System.exit(0);
        }
        String str1 = e.getActionCommand();
        if(str1.equals("New")){
           clearForm(e);

        }
    }

    public static void main(String args[]) {
        new ResumeBuilder();
    }

    private TextField nt;
    private TextField at;
    private TextField ct;
    private TextField et;
    private TextField st;
    private TextField dt1;
    private TextField pt;
    private TextField hst;
    private TextField pt2;
    private TextField dt2;
    private TextField colt;
    private TextField pt3;
    private TextField dt3;
    private TextArea objt;
    private TextField bran;
    private TextField s1;
    private TextField s2;
    private TextField s3;
    private TextField s4;
    private TextField p1;
    private TextField pdt1;
    private TextArea pdst1;
    private TextField p2;
    private TextField pdt2;
    private TextArea pdst2;
    private TextField p3;
    private TextField pdt3;
    private TextArea pdst3;
    private TextField at1;
    private TextField at2;

}
