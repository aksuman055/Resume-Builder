import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;

public class ResumeBuilder {
    private Frame mainFrame;
    int mainFrameH = 800;
    int mainFrameW = 1000;

    TextField nameF=new TextField();
    TextField dobF = new TextField();
    TextField fatherNameF= new TextField();
//    TextField emailF= new TextField();
//    TextField contactNoF= new TextField();
    TextArea addressF= new TextArea();
    CheckboxGroup genderR = new CheckboxGroup();
    TextField schoolNameF = new TextField();
    TextField schoolMarksF = new TextField();
    TextField schoolYearF= new TextField();
    TextField collegeNameF = new TextField();
    TextField collegeMarksF = new TextField();
    TextField collegeYearF= new TextField();
    TextArea skillF = new TextArea();
    TextArea experienceF = new TextArea();
    TextArea projectAndAchievementF = new TextArea();
    TextArea objectiveF = new TextArea();
    Button submitF = new Button("Submit");
    String gender;


    ResumeBuilder() {
        prepareGUI();
    }

    public static void main(String[] args) {
        ResumeBuilder resumeBuilder = new ResumeBuilder();
        resumeBuilder.showForm();
    }


    private void prepareGUI() {
        mainFrame = new Frame("Resume Builder");
        mainFrame.setSize(mainFrameW, mainFrameH);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        Label head = new Label("RESUME BUILDER");
        head.setBounds(0, 35, mainFrameW, 70);
        head.setFont(new Font("Times New Roman", Font.BOLD, 30));
        head.setAlignment(Label.CENTER);
        mainFrame.add(head);
        mainFrame.setLayout(null);
        System.out.println(mainFrame.getSize());
        mainFrame.setVisible(true);
    }
    private void showForm() {
        Label h1;
        h1 = getL2("PERSONAL INFORMATION");
        h1.setBounds(20, 105, 300, 20);
        mainFrame.add(h1);



        setTextPanel("Name:", nameF, 20, 120);
        setTextPanel("DOB(dd/mm/yyyy):", dobF,20, 160);
        setTextPanel("Father's Name:", fatherNameF,20, 200);

        Label genderLabel = getL1("Gender");


        genderLabel.setBounds(30, 245, 180, 25);
        mainFrame.add(genderLabel);
        Checkbox maleC = new Checkbox("Male", genderR, false);
        maleC.setBounds(210,240, 70,50);
        maleC.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                gender = "Male";
            }
        });
        Checkbox femaleC = new Checkbox("Female", genderR, false);
        femaleC.setBounds(280,240, 80,50);
        femaleC.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                gender = "Female";
            }
        });
        Checkbox otherC = new Checkbox("Other", genderR, false);
        otherC.setBounds(370,240, 70,50);
        otherC.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                gender = "Other";
            }
        });
        mainFrame.add(maleC);
        mainFrame.add(femaleC);
        mainFrame.add(otherC);

        Label addressL = getL1("Address:");
        addressL.setBounds(30, 280, 180, 25);
        mainFrame.add(addressL);
        addressF.setBounds(215, 290, 200, 70);
        mainFrame.add(addressF);

        Label h2 = getL2("Qualifications");
        h2.setBounds(20, 380, 180, 25);
        mainFrame.add(h2);
        setTextPanel("School Name(XII):", schoolNameF, 20, 410);
        setTextPanel("Marks(Percentage):", schoolMarksF, 20, 450);
        setTextPanel("Year: ", schoolYearF, 20, 490);


        setTextPanel("College Name: ", collegeNameF, 20, 560);
        setTextPanel("Marks(CGPA):", collegeMarksF, 20, 600);
        setTextPanel("Year: ", collegeYearF, 20, 640);

        Label h3 = getL2("Skills");
        h3.setBounds(mainFrameW/2+100, 105, 300, 20);
        mainFrame.add(h3);
        skillF.setBounds(mainFrameW/2+100, 130, 250, 120);
        mainFrame.add(skillF);

        Label h4 = getL2("Experiences");
        h4.setBounds(mainFrameW/2+100, 265, 300, 20);
        mainFrame.add(h4);
        experienceF.setBounds(mainFrameW/2+100, 290, 250, 120);
        mainFrame.add(experienceF);

        Label h5 = getL2("Projects and Achievements");
        h5.setBounds(mainFrameW/2+100, 425, 300, 20);
        mainFrame.add(h5);
        projectAndAchievementF.setBounds(mainFrameW/2+100, 450, 250, 120);
        mainFrame.add(projectAndAchievementF);

        Label h6 = getL2("Carrier Objective");
        h6.setBounds(mainFrameW/2+100, 580, 300, 20);
        mainFrame.add(h6);
        objectiveF.setBounds(mainFrameW/2+100, 605, 250, 120);
        mainFrame.add(objectiveF);

        submitF.setBounds(0, mainFrameH -50, mainFrameW, 40);
        submitF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    FileWriter fw=new FileWriter("ResumeFile.txt");

                    fw.write("-----------------------RESUME("+nameF.getText()+ ")-------------------------------\n\n\n");
                    fw.write("\n----Personal Details-----");
                    fw.write("\n\nName : "+ nameF.getText());
                    fw.write("\nSex :  "+ gender);
                    fw.write("\nDate of Birth :  "+ dobF.getText());
                    fw.write("\nFather's Name :  "+ fatherNameF.getText());
                    fw.write("\nAddress :  "+ addressF.getText());
                    fw.write("\n\n -----Qualifications-----");
                    fw.write("\nSchool Name : "+ schoolNameF.getText());
                    fw.write("\nMarks : "+ schoolMarksF.getText());
                    fw.write("\nYear of Passing : "+ schoolYearF.getText());
                    fw.write("\n\nCollege Name : " + collegeNameF.getText());
                    fw.write("\nMarks : "+ collegeMarksF.getText());
                    fw.write("\nYear of Passing : "+ collegeYearF.getText());
                    fw.write("\n\n----Skills---");
                    fw.write("\n"+skillF.getText());
                    fw.write("\n\n----Experiences----");
                    fw.write("\n"+experienceF.getText());
                    fw.write("\n\n----Projects and Achievements----");
                    fw.write("\n"+projectAndAchievementF.getText());
                    fw.write("\n\n----Carrier Objective----");
                    fw.write("\n"+objectiveF.getText());
                    fw.close();
                }catch(Exception error){System.out.println(error);}
            }
        });
        mainFrame.add(submitF);


        mainFrame.setLayout(null);
    }



    void setTextPanel(String lName, TextField tf, int x, int y){
        Panel p = new Panel();
//        p.setBackground(Color.CYAN);
        p.setBounds(x, y, 400, 40);
        p.setLayout(null);
        Label l = getL1(lName);
        l.setBounds(10, 10, 190, 30);
        tf.setBounds(200, 10, 200, 25);
        p.add(l);
        p.add(tf);

        mainFrame.add(p);
        mainFrame.setLayout(null);
    }

    Label getL1(String title){

        Label label = new Label(title);
        label.setFont(new Font("Arial Black", Font.PLAIN, 15));
        return label;
    }
    Label getL2(String title){
        Label label = new Label(title);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        return label;
    }


}
