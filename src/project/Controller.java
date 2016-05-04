package project;
//@author Name: Adesh Pandey , Rishabh Gupta Roll no: 2014004,2014086
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller implements Initializable
{
	Candidate c=new Candidate();
	@FXML private ToggleGroup phd,gender,category,phydis,defense;
	@FXML private ToggleGroup corm;
	@FXML private Label status;
	@FXML private Label emaillabel,gradyearlabel;
	@FXML private Label mlabel;
	@FXML private Label cgpalabel;
	@FXML private Label fatherlabel;
	@FXML private Label markslabel;
	@FXML private Label pinlabel;
	@FXML private Label namelabel;
	@FXML private Label xmarkslabel;
	@FXML private Label xiimarkslabel;
	@FXML private Label xyearlabel;
	@FXML private Label xiiyearlabel;

	@FXML private ChoiceBox<String> phd1,phd2,phd3,nationality,xyear,xiiyear,grad_year,total_cgpa,state;
	@FXML private TextField email, name,enrollno,corr_address,mobile,father,perm_address,pin,xboard,xiiboard,xmarks,xiimarks,cgpa,marks;
	@FXML private TextField degree,dept,college,university,city,achievements;
	@FXML private DatePicker dob;
	  @FXML
	    private Pane pane1;
	  @FXML
	    private Pane pane2;
	  @FXML
	    private Pane pane3;
	  @FXML
	    private Pane pane4;
	   @FXML
	    private TextField pg_department;
	    @FXML
	    private TextField pg_gatearea;
	    @FXML
	    private TextField pg_gatemarks;
	    @FXML
	    private TextField pg_college;
	    @FXML
	    private TextField pg_marks;
	    @FXML
	    private ChoiceBox pg_pref2;
	    @FXML
	    private ChoiceBox pg_pref1;
	    @FXML
	    private ChoiceBox pg_pref4;
	    @FXML
	    private ChoiceBox pg_pref3;
	    @FXML
	    private TextField pg_exam;
	    @FXML
	    private ChoiceBox pg_state;
	    @FXML
	    private TextField pg_cgpa;
	    @FXML
	    private ChoiceBox pg_year;
	    @FXML
	    private ChoiceBox pg_gateyear;
	    @FXML
	    private ChoiceBox pg_totcgpa;
	    @FXML
	    private TextField pg_city,pg_thesis;
	    @FXML
	    private TextField pg_gatescore;
	    @FXML
	    private TextField pg_degree;
	    @FXML
	    private TextField pg_gaterank;
	    @FXML
	    private TextField pg_otherscore;
	    @FXML
	    private ToggleGroup pg_corm;
	    @FXML
	    private TextField pg_sub;
	    @FXML
	    private ChoiceBox pg_otheryear;
	    @FXML private TextField pg_otherrank;
	@FXML private CheckBox check1,check2,check3,check4;
	@FXML private Label cvfile,sopfile;
	private FileChooser fc;
	String CVPath,SOPPath,CVExt,SOPExt;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
    	enrollno.setText(c.Enrollno.toString());
    	
    	nationality.setItems(FXCollections.observableArrayList("Afghanistan ","Albania ","Algeria ","Andorra ","Angola ","Antigua & Deps ","Argentina ","Armenia ","Australia ","Austria ","Azerbaijan ","Bahamas ","Bahrain ","Bangladesh ","Barbados ","Belarus ","Belgium ","Belize ","Benin ","Bhutan ","Bolivia ","Bosnia Herzegovina ","Botswana ","Brazil ","Brunei ","Bulgaria ","Burkina ","Burundi ","Cambodia ","Cameroon ","Canada ","Cape Verde ","Central African Rep ","Chad ","Chile ","China ","Colombia ","Comoros ","Congo ","Congo {Democratic Rep} ","Costa Rica ","Croatia ","Cuba ","Cyprus ","Czech Republic ","Denmark ","Djibouti ","Dominica ","Dominican Republic ","East Timor ","Ecuador ","Egypt ","El Salvador ","Equatorial Guinea ","Eritrea ","Estonia ","Ethiopia ","Fiji ","Finland ","France ","Gabon ","Gambia ","Georgia ","Germany ","Ghana ","Greece ","Grenada ","Guatemala ","Guinea ","Guinea-Bissau ","Guyana ","Haiti ","Honduras ","Hungary ","Iceland ","India ","Indonesia ","Iran ","Iraq ","Ireland {Republic} ","Israel ","Italy ","Ivory Coast ","Jamaica ","Japan ","Jordan ","Kazakhstan ","Kenya ","Kiribati ","Korea North ","Korea South ","Kosovo ","Kuwait ","Kyrgyzstan ","Laos ","Latvia ","Lebanon ","Lesotho ","Liberia ","Libya ","Liechtenstein ","Lithuania ","Luxembourg ","Macedonia ","Madagascar ","Malawi ","Malaysia ","Maldives ","Mali ","Malta ","Marshall Islands ","Mauritania ","Mauritius ","Mexico ","Micronesia ","Moldova ","Monaco ","Mongolia ","Montenegro ","Morocco ","Mozambique ","Myanmar, {Burma} ","Namibia ","Nauru ","Nepal ","Netherlands ","New Zealand ","Nicaragua ","Niger ","Nigeria ","Norway ","Oman ","Pakistan ","Palau ","Panama ","Papua New Guinea ","Paraguay ","Peru ","Philippines ","Poland ","Portugal ","Qatar ","Romania ","Russian Federation ","Rwanda ","St Kitts & Nevis ","St Lucia ","Saint Vincent & the Grenadines ","Samoa ","San Marino ","Sao Tome & Principe ","Saudi Arabia ","Senegal ","Serbia ","Seychelles ","Sierra Leone ","Singapore ","Slovakia ","Slovenia ","Solomon Islands ","Somalia ","South Africa ","South Sudan ","Spain ","Sri Lanka ","Sudan ","Suriname ","Swaziland ","Sweden ","Switzerland ","Syria ","Taiwan ","Tajikistan ","Tanzania ","Thailand ","Togo ","Tonga ","Trinidad & Tobago ","Tunisia ","Turkey ","Turkmenistan ","Tuvalu ","Uganda ","Ukraine ","United Arab Emirates ","United Kingdom ","United States ","Uruguay ","Uzbekistan ","Vanuatu ","Vatican City ","Venezuela ","Vietnam ","Yemen ","Zambia ","Zimbabwe"));
    	xyear.setItems(FXCollections.observableArrayList("2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"));
    	xiiyear.setItems(FXCollections.observableArrayList("2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"));
    	grad_year.setItems(FXCollections.observableArrayList("2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"));
    	total_cgpa.setItems(FXCollections.observableArrayList("4","10"));
    	pg_totcgpa.setItems(FXCollections.observableArrayList("4","10"));
    	state.setItems(FXCollections.observableArrayList("Andhra Pradesh ","Arunachal Pradesh ","Assam ","Bihar ","Chhattisgarh ","Delhi","Goa ","Gujarat ","Haryana ","Himachal Pradesh ","Jammu and Kashmir ","Jharkhand ","Karnataka ","Kerala ","Madhya Pradesh ","Maharashtra ","Manipur ","Meghalaya ","Mizoram ","Nagaland ","Odisha ","Punjab ","Rajasthan ","Sikkim ","Tamil Nadu ","Tripura ","Uttar Pradesh ","Uttarakhand ","West Bengal"));
    	pg_state.setItems(FXCollections.observableArrayList("Andhra Pradesh ","Arunachal Pradesh ","Assam ","Bihar ","Chhattisgarh ","Delhi","Goa ","Gujarat ","Haryana ","Himachal Pradesh ","Jammu and Kashmir ","Jharkhand ","Karnataka ","Kerala ","Madhya Pradesh ","Maharashtra ","Manipur ","Meghalaya ","Mizoram ","Nagaland ","Odisha ","Punjab ","Rajasthan ","Sikkim ","Tamil Nadu ","Tripura ","Uttar Pradesh ","Uttarakhand ","West Bengal"));
    	pg_year.setItems(FXCollections.observableArrayList("2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"));
    	pg_otheryear.setItems(FXCollections.observableArrayList("2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"));
    	pg_otheryear.setItems(FXCollections.observableArrayList("2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"));
    	pg_gateyear.setItems(FXCollections.observableArrayList("2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"));
    	pg_pref1.setItems(FXCollections.observableArrayList("Advanced Signal Processing","Linear System","Communication Networks","Embedded Systems"));
    	pg_pref2.setItems(FXCollections.observableArrayList("Advanced Signal Processing","Linear System","Communication Networks","Embedded Systems"));
    	pg_pref3.setItems(FXCollections.observableArrayList("Advanced Signal Processing","Linear System","Communication Networks","Embedded Systems"));
    	pg_pref4.setItems(FXCollections.observableArrayList("Advanced Signal Processing","Linear System","Communication Networks","Embedded Systems"));
    	
    }
    public void csact(ActionEvent e){
    	phd1.setItems(FXCollections.observableArrayList("Artificial Intelligence and Robotics - CSE","Compilers - CSE","Computer Architecture and Systems Design - CSE","Computer Graphics - CSE","Computer Vision - CSE","Image Analysis and Biometrics - CSE","Information Management and Data Engineering - CSE","Machine Learning - CSE","Massively Parallel Systems - CSE","Mobile Computing and Networking Applications - CSE","Program Analysis - CSE","Security and Privacy - CSE","Signal and Image Processing - CSE","Software Engineering - CSE","Theoretical Computer Science - CSE","Wireless Networks - CSE"));
    	phd2.setItems(FXCollections.observableArrayList("Artificial Intelligence and Robotics - CSE","Compilers - CSE","Computer Architecture and Systems Design - CSE","Computer Graphics - CSE","Computer Vision - CSE","Image Analysis and Biometrics - CSE","Information Management and Data Engineering - CSE","Machine Learning - CSE","Massively Parallel Systems - CSE","Mobile Computing and Networking Applications - CSE","Program Analysis - CSE","Security and Privacy - CSE","Signal and Image Processing - CSE","Software Engineering - CSE","Theoretical Computer Science - CSE","Wireless Networks - CSE"));
    	phd3.setItems(FXCollections.observableArrayList("Artificial Intelligence and Robotics - CSE","Compilers - CSE","Computer Architecture and Systems Design - CSE","Computer Graphics - CSE","Computer Vision - CSE","Image Analysis and Biometrics - CSE","Information Management and Data Engineering - CSE","Machine Learning - CSE","Massively Parallel Systems - CSE","Mobile Computing and Networking Applications - CSE","Program Analysis - CSE","Security and Privacy - CSE","Signal and Image Processing - CSE","Software Engineering - CSE","Theoretical Computer Science - CSE","Wireless Networks - CSE"));
    }
    public void eceact(ActionEvent e){
    	phd1.setItems(FXCollections.observableArrayList("Computer Architecture and Systems Design - ECE","Controls and Robotics - ECE","Digital and Analog VLSI Systems Design - ECE","Electromagnetics - ECE","Embedded and VLSI systems design - ECE","Embedded Systems - ECE","Fiber-Wireless Architectures - ECE","Machine Learning - ECE","OFDM based Optical Access Networks - ECE","Optical Wireless Communication Systems - ECE","RF and mixed signal electronics - ECE","Signal and Image Processing - ECE","Wireless Communication - ECE","Wireless Networks - ECE"));
    	phd2.setItems(FXCollections.observableArrayList("Computer Architecture and Systems Design - ECE","Controls and Robotics - ECE","Digital and Analog VLSI Systems Design - ECE","Electromagnetics - ECE","Embedded and VLSI systems design - ECE","Embedded Systems - ECE","Fiber-Wireless Architectures - ECE","Machine Learning - ECE","OFDM based Optical Access Networks - ECE","Optical Wireless Communication Systems - ECE","RF and mixed signal electronics - ECE","Signal and Image Processing - ECE","Wireless Communication - ECE","Wireless Networks - ECE"));
    	phd3.setItems(FXCollections.observableArrayList("Computer Architecture and Systems Design - ECE","Controls and Robotics - ECE","Digital and Analog VLSI Systems Design - ECE","Electromagnetics - ECE","Embedded and VLSI systems design - ECE","Embedded Systems - ECE","Fiber-Wireless Architectures - ECE","Machine Learning - ECE","OFDM based Optical Access Networks - ECE","Optical Wireless Communication Systems - ECE","RF and mixed signal electronics - ECE","Signal and Image Processing - ECE","Wireless Communication - ECE","Wireless Networks - ECE"));
    }
    public void cbact(ActionEvent e){
    	phd1.setItems(FXCollections.observableArrayList("Biophysics - CB","Structural Biology - CB","Systems Biology - CB"));
    	phd2.setItems(FXCollections.observableArrayList("Biophysics - CB","Structural Biology - CB","Systems Biology - CB"));
    	phd3.setItems(FXCollections.observableArrayList("Biophysics - CB","Structural Biology - CB","Systems Biology - CB"));
    }
    public void save1(ActionEvent e){
    	
    	
    	c.Email=email.getText();
    	c.Name=name.getText();
    	c.Enrollno=Integer.parseInt(enrollno.getText());
    	c.Corr_Address=corr_address.getText();
    	c.Mobile=Long.parseLong(mobile.getText());
    	c.Stream=((RadioButton)phd.getSelectedToggle()).getText();
    	c.Area1=phd1.getValue().toString();c.Area2=phd2.getValue().toString();c.Area3=phd3.getValue().toString();
    	c.Gender=((RadioButton)gender.getSelectedToggle()).getText();
    	c.Category=((RadioButton)category.getSelectedToggle()).getText();
    	if(((RadioButton)phydis.getSelectedToggle()).getText().equals("YES"))
    		c.Handicap=true;
    	else
    		c.Handicap=false;
    	c.DOB=dob.getValue();
    	if(((RadioButton)defense.getSelectedToggle()).getText().equals("YES"))
    		c.Defense=true;
    	else
    		c.Defense=false;
    	c.FName=father.getText();
    	c.Nationality=nationality.getValue().toString();
    	c.Perm_Address=perm_address.getText();
    	c.PIN=Integer.parseInt(pin.getText());
    }
    public void save2(ActionEvent e) throws IOException{
  	c.XBoard=xboard.getText();
    	c.XMarks=Float.parseFloat(xmarks.getText());
    	c.XYear=Integer.parseInt(xyear.getValue().toString());
    	c.XIIBoard=xiiboard.getText();
    	c.XIIMarks=Float.parseFloat(xiimarks.getText());
    	c.XIIYear=Integer.parseInt(xiiyear.getValue().toString());
    	c.Degree=degree.getText();
    	c.Department=dept.getText();
    	c.College=college.getText();
    	c.University=university.getText();
    	c.City=city.getText();
    	c.State=state.getValue().toString();
    	c.GradYear=Integer.parseInt(grad_year.getValue());
    	if(((RadioButton)corm.getSelectedToggle()).getText().equals("CGPA"))
    		{
    			c.cgpaormarks=true;c.CGPA=Float.parseFloat(cgpa.getText());c.TotalCGPA=Integer.parseInt(total_cgpa.getValue().toString());
    		}
    	else
    		{
    			c.cgpaormarks=false;c.Marks=Float.parseFloat(marks.getText().toString());
    		}
    	c.ApplyECE=check1.isSelected();
    	if(c.ApplyECE){
    		if(pg_pref1.getValue()!=null)
    	c.Pref1=pg_pref1.getValue().toString();
    		if(pg_pref2.getValue()!=null)
    	c.Pref2=pg_pref2.getValue().toString();
    		if(pg_pref3.getValue()!=null)
    	c.Pref3=pg_pref3.getValue().toString();
    		if(pg_pref4.getValue()!=null)
    	c.Pref4=pg_pref4.getValue().toString();}
    	c.PGDone=check2.isSelected();
    	if(c.PGDone){
    	c.PGCollege=pg_college.getText();
    	c.PGCity=pg_city.getText();
    	if(pg_state.getValue()!=null)
    	c.PGState=pg_state.getValue().toString();
    	c.PGDepartment=pg_department.getText();
    	c.PGDegree=pg_degree.getText();
    	c.PGThesis=pg_thesis.getText();
    	if(pg_year.getValue()!=null)
    	c.PGYear=Integer.parseInt(pg_year.getValue().toString());
    	try{
    	if(((RadioButton)pg_corm.getSelectedToggle()).getText().equals("CGPA"))
		{
			c.pgcgpaormarks=true;c.PGCGPA=Float.parseFloat(pg_cgpa.getText());c.PGTotalCGPA=Integer.parseInt(pg_totcgpa.getValue().toString());
		}
	else
		{
			c.pgcgpaormarks=false;c.PGMarks=Float.parseFloat(pg_marks.getText().toString());
		}}
    	catch(Exception ex){}
    	}
    	c.OtherDegree=check3.isSelected();
    	if(c.OtherDegree){
    	c.OtherExam=pg_exam.getText();
    	c.OtherSubject=pg_sub.getText();
    	if(pg_otheryear.getValue()!=null)
    	c.OtherYear=pg_otheryear.getValue().toString();
    	if(!pg_otherscore.getText().isEmpty())
    	c.OtherScore=Float.parseFloat(pg_otherscore.getText());
    	if(!pg_otherrank.getText().isEmpty())
    	c.OtherRank=Integer.parseInt(pg_otherrank.getText());}
    	c.TakenGATE=check4.isSelected();
    	if(c.TakenGATE){
    	c.GateArea=pg_gatearea.getText();
    	if(pg_gateyear.getValue()!=null)
    	c.GateYear=Integer.parseInt(pg_gateyear.getValue().toString());
    	if(!pg_gatemarks.getText().isEmpty())
    	c.GateMarks=Float.parseFloat(pg_gatemarks.getText());
    	if(!pg_gatescore.getText().isEmpty())
    	c.GateScore=Float.parseFloat(pg_gatescore.getText());
    	if(!pg_gaterank.getText().isEmpty())
    	c.GateRank=Integer.parseInt(pg_gaterank.getText());}
    	c.Achievements=achievements.getText();
    	File in=new File(CVPath);
    	File out=new File("./src/CV/"+c.Enrollno+"_CV."+CVExt);
    	if(Files.exists(out.toPath()))
    		Files.delete(out.toPath());
    	Files.copy(in.toPath(),out.toPath());
    	in=new File(SOPPath);
    	out=new File("./src/SOP/"+c.Enrollno+"_SOP."+SOPExt);
    	if(Files.exists(out.toPath()))
    		Files.delete(out.toPath());
    	Files.copy(in.toPath(),out.toPath());
    }
    public void opencv(ActionEvent e) throws IOException{
    	Stage stage=new Stage();
    	fc=new FileChooser();
    	fc.setTitle("Open CV");
    	CVPath=fc.showOpenDialog(stage).toString();
    	String temp[]=CVPath.split("\\.");
    	CVExt=temp[1];
    	cvfile.setText("File selected");
    	cvfile.setTextFill(Color.web("#00FF00"));
    }
    @FXML
    void actionece(ActionEvent event) {

    	if(pane1.isDisabled()==true)
    		pane1.setDisable(false);
    	else
    		pane1.setDisable(true);
    	
    }
    @FXML
    void actionpg(ActionEvent event) {
    	if(pane2.isDisabled()==true)
    		pane2.setDisable(false);
    	else
    		pane2.setDisable(true);
    	
    }   
    @FXML
    void actionother(ActionEvent event) {
    	if(pane3.isDisabled()==true)
    		pane3.setDisable(false);
    	else
    		pane3.setDisable(true);
    	
    }   
    
    @FXML
    void actiongate(ActionEvent event) {
    	if(pane4.isDisabled()==true)
    		pane4.setDisable(false);
    	else
    		pane4.setDisable(true);
    	
    }   
    public void opensop(ActionEvent e){
    	Stage stage=new Stage();
    	fc=new FileChooser();
    	fc.setTitle("Open Statement Of Purpose");
    	SOPPath=fc.showOpenDialog(stage).toString();
    	String temp[]=SOPPath.split("\\.");
    	SOPExt=temp[1];
    	sopfile.setText("File selected");
    	sopfile.setTextFill(Color.web("#00FF00"));
    }
    
    public static boolean containsOnlyNumbers(String str) {
        for (int i = 0; i < str.length(); i++) {
        	if(str.charAt(i)=='.')
        		continue;
        	if(str.charAt(i)=='-')
        		return false;
          if (!Character.isDigit(str.charAt(i)))
            return false;
        }
        return true;
      }
    
    public int checkfields()
    {
    
        	int empty=0;
        	int wrong=0;
        	
        	if(name.getText().isEmpty()==false)
        	{
        		String regx ="^[\\p{L} .'-]+$" ;
        		String inp_name=name.getText().toString();
        		Boolean b = (inp_name).matches(regx);
        		if(b==false)
        		{
        			wrong=1;
        			namelabel.setText("name cannot have numbers !");
        			 namelabel.setTextFill(Color.web("#ff0000"));
        		}
        		else
        		{
        			namelabel.setText("");
        		}
        	}
        	
        	
        	
        	if(father.getText().isEmpty()==false)
        	{
        		String regx = "^[\\p{L} .'-]+$";
        		String inp_father=father.getText().toString();
        		Boolean b = (inp_father).matches(regx);
        		if(b==false)
        		{
        			wrong=1;
        			fatherlabel.setText("name cannot have numbers !");
        			 fatherlabel.setTextFill(Color.web("#ff0000"));
        		}
        		else
        		{
        			fatherlabel.setText("");
        		}
        	}
        	
        	
        	
        	
        	
        	if(mobile.getText().isEmpty()==false)
        	{
        		if(containsOnlyNumbers(mobile.getText()))
        		{
        			if(mobile.getText().length()!=10)
        	    	{
        	    		mlabel.setText("Mobile No. should be 10 digits long !");
        	    		 mlabel.setTextFill(Color.web("#ff0000"));
        	    		wrong=1;
        	    		
        	    	}
        	    	else
        	    	{
        	    		mlabel.setText("");
        	    	}
        		}
        		else
        		{
        			mlabel.setText("Only 0-9 digits allowed !");
        			 mlabel.setTextFill(Color.web("#ff0000"));
        		}
    	    	
        	}
        	if(xmarks.getText().isEmpty()==false)
        	{
        		if(containsOnlyNumbers(xmarks.getText()))
        				{
		        			if(Float.parseFloat(xmarks.getText())>100)
		        	    	{
		        	    		xmarkslabel.setText("Marks should be <= 100 !");
		        	    		 xmarkslabel.setTextFill(Color.web("#ff0000"));
		        	    		wrong=1;
		        	    	}
		        	    	else
		        	    	{
		        	    		xmarkslabel.setText("");
		        	    	}
        				}
        		else
        		{
        			xmarkslabel.setText("Only numbers allowed !");
        			 xmarkslabel.setTextFill(Color.web("#ff0000"));
    	    		wrong=1;
        		}
    	    	
        	}
        	
        	
        	if(xiimarks.getText().isEmpty()==false)
        	{
        		if(containsOnlyNumbers(xiimarks.getText()))
        				{
		        			if(Float.parseFloat(xiimarks.getText())>100)
		        	    	{
		        	    		xiimarkslabel.setText("Marks should be <= 100 !");
		        	    		 xiimarkslabel.setTextFill(Color.web("#ff0000"));
		        	    		wrong=1;
		        	    	}
		        	    	else
		        	    	{
		        	    		xiimarkslabel.setText("");
		        	    	}
		        			
        				}
        		else
        		{
        			xiimarkslabel.setText("Only numbers allowed !");
        			 xiimarkslabel.setTextFill(Color.web("#ff0000"));
    	    		wrong=1;
        			
        		}
        	
    	    	
        	}
        	
        	if(xyear.getValue()!=null && xiiyear.getValue()!=null)
        	{
    	    	if(Integer.parseInt(xiiyear.getValue())-Integer.parseInt(xyear.getValue())<2)
    	    	{
    	    		xyearlabel.setText("Wrong");
    	    		xiiyearlabel.setText("Wrong");
    	    		 xyearlabel.setTextFill(Color.web("#ff0000"));
    	    		 xiiyearlabel.setTextFill(Color.web("#ff0000"));
    	    		wrong=1;
    	    		
    	    	}
    	    	else
    	    	{
    	    		xyearlabel.setText("");
    	    		xiiyearlabel.setText("");
    	    	}
        	}
        	
        	if((RadioButton)corm.getSelectedToggle()!=null)
        	{
    	    	if(((RadioButton)corm.getSelectedToggle()).getText().equals("CGPA"))
    	    	{
    	    		markslabel.setText("");
    	    		if(cgpa.getText()!=null)
    	    		{
    	    			if(containsOnlyNumbers(cgpa.getText()))
    	        		{
    		    		
	    		    		if(Float.parseFloat(cgpa.getText())>Integer.parseInt(total_cgpa.getValue()))
	    		    		{
	    		    			wrong=1;
	    		    			cgpalabel.setText("Not Valid Input");
	    		    			 cgpalabel.setTextFill(Color.web("#ff0000"));
	    		    		}
	    		    		else
	    		    			cgpalabel.setText("");
    	        		}
    	    			else
    	    			{
    	    				wrong=1;
    		    			cgpalabel.setText("Only numbers allowed !");
    		    			 cgpalabel.setTextFill(Color.web("#ff0000"));
    	    			}
    	    		}
    	    	}
    	    		
    	    	else if(((RadioButton)corm.getSelectedToggle()).getText().equals("MARKS(%)"))
    	    	{
    	    		cgpalabel.setText("");
    	    		if(cgpa.getText()!=null)
    	    		{
    	    			if(containsOnlyNumbers(marks.getText()))
    	    					{
		    	    				if(Float.parseFloat(marks.getText())>100)
		        		    		{
		        		    			wrong=1;
		        		    			markslabel.setText("Marks should be less than 100 !");
		        		    			 markslabel.setTextFill(Color.web("#ff0000"));
		        		    		}
		        		    		else
		        		    			markslabel.setText("");
    	    					}
    	    			else
    	    			{
    	    				wrong=1;
    		    			markslabel.setText("Only numbers allowed !");
    		    			 markslabel.setTextFill(Color.web("#ff0000"));
    	    			}
    		    		
    		    			
    	    		}
    	    	}
        	}
        	
        	
        	if(email.getText().isEmpty()==false)
        	{
        		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        		String inp_email=email.getText().toString();
        		Boolean b = (inp_email).matches(EMAIL_REGEX);
        		if(b==false)
        		{
        			wrong=1;
        			emaillabel.setText("Wrong email");
        			 emaillabel.setTextFill(Color.web("#ff0000"));
        		}
        		else
        		{
        			emaillabel.setText("");

        		}
        	}
        	
        	if(xiiyear.getValue()!=null && grad_year.getValue()!=null)
        	{
    	    	if(Integer.parseInt(grad_year.getValue())-(Integer.parseInt(xiiyear.getValue()))<2)
    	    	{
    	    		gradyearlabel.setText("Wrong");
    	    		//xiiyearlabel.setText("Wrong");
    	    		 gradyearlabel.setTextFill(Color.web("#ff0000"));
    	    		// xiiyearlabel.setTextFill(Color.web("#ff0000"));
    	    		wrong=1;
    	    		
    	    	}
    	    	else
    	    	{
    	    		gradyearlabel.setText("");
    	    		//xiiyearlabel.setText("");
    	    	}
        	}
        	
        	if(pin.getText().isEmpty()==false)
        	{
        		if(containsOnlyNumbers(pin.getText()))
        		{
        			if(pin.getText().length()!=6)
                			{
            					wrong=1;
                				pinlabel.setText("Wrong Pin (6 Digit pin allowed) !");
                				 pinlabel.setTextFill(Color.web("#ff0000"));
                			}
        			else
        			{
        				pinlabel.setText("");
        			}
        		}
        		else
    			{
        			wrong=1;
    				pinlabel.setText("Only 0-9 digits allowed !");
    				 pinlabel.setTextFill(Color.web("#ff0000"));
    			}
        		
        		
        	}
        	boolean f;
        	if(CVPath==null)
        	{
        		cvfile.setText("No File Chosen");
        		 cvfile.setTextFill(Color.web("#ff0000"));
        	}

        	
        	
        	
        	if(SOPPath==null)
        	{
        		sopfile.setText("No File Chosen");
        		 sopfile.setTextFill(Color.web("#ff0000"));
        	}
        	
        	
        	
        	
        	if(xmarks.getText().isEmpty() || email.getText().isEmpty() || name.getText().isEmpty() )
        		empty=1;
        			if(  corr_address.getText().isEmpty() || mobile.getText().isEmpty() )
        				empty=1;
        			if(phd.getSelectedToggle()==null || phd1.getValue()==null || phd2.getValue()==null || phd3.getValue()==null)
        				empty=1;
        			if(gender.getSelectedToggle()==null || category.getSelectedToggle()==null ||  phydis.getSelectedToggle()==null )
        				empty=1;
        			if(defense.getSelectedToggle()==null || father.getText().isEmpty() || nationality.getValue()==null)
        				empty=1;
        			if( perm_address.getText().isEmpty() || pin.getText().isEmpty() || xmarks.getText().isEmpty() || xiimarks.getText().isEmpty())
        				empty=1;
        			if( xyear.getValue()==null || xiiyear.getValue()==null || xboard.getText().isEmpty() || xiiboard.getText().isEmpty())
        				empty=1;
        			if( degree.getText().isEmpty() || dept.getText().isEmpty() || college.getText().isEmpty() || university.getText().isEmpty())
        				empty=1;
        			if(city.getText().isEmpty() || state.getValue()==null || grad_year.getValue()==null || corm.getSelectedToggle()==null || dob.getValue()==null )
        		empty=1;
        		
        	if(empty==1 || wrong==1)
        	
        		return 0;
        		
        	   else
        	    		return 1;
        	
        		
        
        }


    public void submitb(ActionEvent e) throws IOException{
    	int flag=0;
    	flag=checkfields();
    	if(flag==0)
    	{
    		status.setText("Please fill all Fields !");
    		 status.setTextFill(Color.web("#ff0000"));
    		return;
    	}
    	status.setText("Submission Successful !");
    	save1(e);
    	save2(e);
    	c.Display(1);
    	System.out.println("\n\n");
    	c.Display(2);
    	
    	ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("./src/Records/"+c.Enrollno+".dat"));
    	out.writeObject(c);
    	out.close();
    	BufferedWriter o=new BufferedWriter(new FileWriter("./src/Records/LastID.txt"));
		o.write(c.Enrollno.toString());
		o.close();
		o=new BufferedWriter(new FileWriter("./src/options/xboard.txt",true));
		o.write(c.XBoard+"\n");o.close();
		o=new BufferedWriter(new FileWriter("./src/options/xiiboard.txt",true));
		o.write(c.XIIBoard+"\n");o.close();
		o=new BufferedWriter(new FileWriter("./src/options/grad_degree.txt",true));
		o.write(c.Degree+"\n");o.close();
		o=new BufferedWriter(new FileWriter("./src/options/grad_dep.txt",true));
		o.write(c.Department+"\n");o.close();
		o=new BufferedWriter(new FileWriter("./src/options/pg_degree.txt",true));
		o.write(c.Degree+"\n");o.close();
		o=new BufferedWriter(new FileWriter("./src/options/pg_dep.txt",true));
		o.write(c.Department+"\n");o.close();
    }
}







