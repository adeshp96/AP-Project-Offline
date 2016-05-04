package filter;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import project.Candidate;
//@author Name: Adesh Pandey , Rishabh Gupta Roll no: 2014004,2014086
	public class Controller implements Initializable{
		@FXML    private CheckBox fx_lt;
	    @FXML    private TextField fpg_percent;
	    @FXML    private CheckBox fpg_lt;
	    @FXML    private RadioButton fdob_after;
	    @FXML    private RadioButton fpd_yes;
	    @FXML    private CheckBox fgate_gt;
	    @FXML    private ChoiceBox fgrad_state;
	    @FXML    private CheckBox fgate_eq;
	    @FXML    private TextField fenroll_no;
	    @FXML    private CheckBox fxii_lt;
	    @FXML	 private ChoiceBox fxboard;
	    @FXML    private TextField fpg_univ;
	    @FXML    private ChoiceBox fpg_degree;
	    @FXML    private ChoiceBox fgrad_degree;
	    @FXML    private DatePicker fdate_upto;
	    @FXML    private Button submit_filter;
	    @FXML    private DatePicker fdate_from;
	    @FXML    private ChoiceBox fgrad_dep;
	    @FXML    private TextField fgate_score;
	    @FXML    private CheckBox fgrad_lt;
	    @FXML    private TextField fgrad_univ;
	    @FXML    private TextField fgrad_percent;
	    @FXML    private DatePicker fdate;
	    @FXML    private ToggleGroup fpd;
	    @FXML    private ChoiceBox fpg_dep;
	    @FXML    private CheckBox fxii_eq;
	    @FXML    private TextField fname;
	    @FXML    private RadioButton fpd_no;
	    @FXML    private ChoiceBox fcategory;
	    @FXML    private RadioButton fmale;
	    @FXML    private CheckBox fxii_gt;  
	    @FXML    private CheckBox fgrad_gt;
	    @FXML    private TextField femail;
	    @FXML    private ToggleGroup fgender;
	    @FXML    private CheckBox fpg_eq;
	    @FXML    private RadioButton fdob_on;
	    @FXML    private CheckBox fpg_gt;
	    @FXML    private CheckBox fgate_lt;
	    @FXML    private CheckBox fx_eq;
	    @FXML    private CheckBox fx_gt;
	    @FXML    private CheckBox fgrad_eq;
	    @FXML    private ChoiceBox fxiiboard;
	    @FXML    private RadioButton fdob_before;
	    @FXML    private ChoiceBox fstream;
	    @FXML    private TextField fx_percent;
	    @FXML	 private TextField fxii_percent;
	    @FXML    private RadioButton ffemale;
	    @FXML    private ToggleGroup fdob;
	    @FXML    private ChoiceBox fpg_state;
	    @FXML	 private Label fgatelabel,fstatus;
	    @FXML    private Button back;
	    @FXML    private TableView table;
		@FXML    private TableColumn col1,col2,col3;
	    @FXML	 private Label fxlabel;
	    @FXML	 private Label fenrolllabel;
	    @FXML    private Label fxiilabel;
	    @FXML    private Label fgradlabel;
	    @FXML    private Label fpglabel;
	    @FXML    private Label fdoblabel;
	    @FXML	 private Label fromdatelabel;
	    @FXML	 private Label uptodatelabel;
	    @FXML	 private Label femaillabel;
	    @FXML	 private Label fenrollnolabel;
	    @FXML	 private Label fnamelabel;
	static ArrayList<Candidate> cands=new ArrayList<Candidate> ();
	static ArrayList<Candidate> main=new ArrayList<Candidate>();
	static ArrayList<Candidate> filtered=new ArrayList<Candidate>();
	static String email,name,category,gender,f_dob;
	static String phdStream,XBoard,XIIBoard,gradDegree,pgDegree,gradDepartment,pgDepartment,ug_university,pg_university,ug_state,pg_state;
	static boolean pd;
	static int enrollno;
	static Float xpercent,xiipercent,gradpercent,pgpercent,gate_score;
	static LocalDate dob,date_from,date_upto;;
	static boolean isname=false,isenrollno=false,isemail=false,iscategory=false,isgender=false,ispd=false,isdob=false,isphdStream=false,isgradDegree=false,ispgDegree=false,isXBoard=false,isXIIBoard=false,isgradDepartment=false,ispgDepartment=false,isug_university=false,ispg_university=false,isug_state=false,ispg_state=false,isxpercent=false,isxiipercent=false,isgradpercent=false,ispgpercent=false,isgate_score=false,isdate_from=false,isdate_upto=false;
	public void clicked(MouseEvent e)
	{
		String temp=e.getTarget().toString();
		System.out.println(temp);
		for(int i=0;i<main.size();i++)
		{
			if(temp.contains(main.get(i).Name) && temp.contains(main.get(i).Enrollno.toString()) && temp.contains("LINK"))
			{
				Candidate s=main.get(i);
				try{
				BufferedWriter bw=new BufferedWriter(new FileWriter("./src/temp"+main.get(i).Enrollno+".txt"));
				bw.write("Name: "+s.Name+"\nEnroll no: "+s.Enrollno+"\nEmail: "+s.Email+"\nCorrespondence Address: "+s.Corr_Address+"\nMobile: "+s.Mobile+"\nStream: "+s.Stream+"\nPHD Area1: "+s.Area1+"\nPHD Area2: "+s.Area2+"\nPHD Area 3: "+s.Area3+"\nGender: "+s.Gender+"\nCategory: "+s.Category+"\nPhysically Disabled: "+s.Handicap+"\nDOB: "+s.DOB+"\nWard of Defense Employee? "+s.Defense+"\nFather's Name: "+s.FName+"\nNationality: "+s.Nationality+"\nPermanent Address: "+s.Perm_Address+"\nPIN: "+s.PIN+"\n");
				bw.write("X Board: "+s.XBoard+"\nX Marks: "+s.XMarks+"\nX Year: "+s.XYear+"\nXII Board: "+s.XIIBoard+"\nXII Marks: "+s.XIIMarks+"\nXII Year: "+s.XIIYear+"\nDegree: "+s.Degree+"\nDepartment: "+s.Department+"\nCollege: "+s.College+"\nUniversity: "+s.University+"\nCity: "+s.City+"\nState: "+s.State+"\nGraduation Year: "+s.GradYear+"\nCGPA or Marks specified?"+s.cgpaormarks+"\nCGPA: "+s.CGPA+"\nMarks: "+s.Marks+"\nApplying for ECE? "+s.ApplyECE+"\nPG Done? "+s.PGDone+"\nAny Other Degree? "+s.OtherDegree+"\nTaken GATE? "+s.TakenGATE+"\nAchievements: "+s.Achievements);
				bw.write("\nTimeStamp: "+s.TimeStamp);
				bw.close();
				File tempfile=new File("./src/temp"+main.get(i).Enrollno+".txt");
				Desktop.getDesktop().open(tempfile);
				}
				catch(Exception E){E.printStackTrace();}
			}
		}
	}
	public void is()
			{

			if(fname.getText().isEmpty()==false)
			{
				System.out.println("Name will be checked now");
				isname=true;
			}

			if(femail.getText().isEmpty()==false)
			{
			isemail=true;
			}

			if(fenroll_no.getText().isEmpty()==false)
			{
			isenrollno=true;
			}

			if(fcategory.getValue().equals("All")==false && fcategory.getValue().equals("")==false)
			{
				System.out.println("I WILL CHECK CATEGORY NOW");
			iscategory=true;
			}


			if((RadioButton)fgender.getSelectedToggle()!=null)
			{
			isgender=true;
			}

			if((RadioButton)fpd.getSelectedToggle()!=null)
			{
			ispd=true;
			}

			if((RadioButton)fdob.getSelectedToggle()!=null)
			{
			isdob=true;
			}

			if(fstream.getValue().equals("All")==false && fstream.getValue().equals("")==false)
			{
			isphdStream=true;
			}

			if(fxboard.getValue().equals("All")==false && fxboard.getValue().equals("")==false)
			{
			isXBoard=true;
			}

			if(fxiiboard.getValue().equals("All")==false && fxiiboard.getValue().equals("")==false)
			{
			isXIIBoard=true;
			}

			if(fgrad_degree.getValue().equals("All")==false && fgrad_degree.getValue().equals("")==false)
			{
			isgradDegree=true;
			}

			if(fpg_degree.getValue().equals("All")==false && fpg_degree.getValue().equals("")==false)
			{
			ispgDegree=true;
			}

			if(fgrad_dep.getValue().equals("All")==false && fgrad_dep.getValue().equals("")==false)
			{
			isgradDepartment=true;
			}

			if(fpg_dep.getValue().equals("All")==false && fpg_dep.getValue().equals("")==false)
			{
			ispgDepartment=true;
			}

			if(fpg_univ.getText().isEmpty()==false)
			{
			isug_university=true;
			}

			if(fpg_univ.getText().isEmpty()==false)
			{
			ispg_university=true;
			}

			if(fgrad_state.getValue().equals("All")==false && fgrad_state.getValue().equals("")==false)
			{
			isug_state=true;
			}

			if(fpg_state.getValue().equals("All")==false && fpg_state.getValue().equals("")==false)
			{
			ispg_state=true;
			}

			if(fx_percent.getText().isEmpty()==false)
			{
			isxpercent=true;
			}

			if(fxii_percent.getText().isEmpty()==false)
			{
			isxiipercent=true;
			}

			if(fgrad_percent.getText().isEmpty()==false)
			{
			isgradpercent=true;
			}
			if(fpg_percent.getText().isEmpty()==false)
			{
			ispgpercent=true;
			}

			if(fgate_score.getText().isEmpty()==false)
			{
			isgate_score=true;
			}
			//System.out.println(fdate_from.getValue());
			if((fdate_from).getValue()!=null)
			{
			isdate_from=true;
			}

			if(fdate_upto.getValue()!=null)
			{
			isdate_upto=true;
			}



}

	static int i=0;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		if(i>=1)
		{
				//System.out.println("Tryiing "+ col1+" "+col2);
				
			   	col1.setCellValueFactory(new PropertyValueFactory<>("Enrollno"));
		    	col2.setCellValueFactory(new PropertyValueFactory<>("Name"));
		    	col3.setCellValueFactory(new PropertyValueFactory<>("Link"));
		    	
		    	ObservableList<Entry> data=FXCollections.observableArrayList();
		    	
		    	//cands.get(2).Enrollno=SimpleStringProperty(cands.get(2).Enrollno.toString());
		    	for(int i=0;i<main.size();i++)
		    		{
			    		System.out.println("Adding "+main.get(i).Name);
			    		data.add(new Entry(main.get(i)));
		    		}
		    	table.setItems(data);
		    	return;
		}
		i++;
		fcategory.setValue("All");fstream.setValue("All");fgrad_degree.setValue("All");fpg_degree.setValue("All");fxboard.setValue("All");fxiiboard.setValue("All");fgrad_dep.setValue("All");fpg_dep.setValue("All");fgrad_state.setValue("All");fpg_state.setValue("All");
		fcategory.setItems(FXCollections.observableArrayList("All","General","SC","ST","OBC"));
		Candidate c;
		try{
			BufferedReader bin=new BufferedReader(new FileReader("./src/Records/LastID.txt"));
			int last=Integer.parseInt(bin.readLine());
			bin.close();
			System.out.println(last);
			ObjectInputStream in;
			for(Integer i=1001;i<=last;i++)
			{
				in=new ObjectInputStream(new FileInputStream("./src/Records/"+i.toString()+".dat"));
				c=(Candidate)in.readObject();
				cands.add(c);
				main.add(c);
				System.out.println("Name is "+c.Name);
			}
		}
		catch(Exception e){}
		fstream.setItems(FXCollections.observableArrayList("All","Computer Science","Electronics and Communication","Commutational Biology"));
		ObservableList<String> arr=FXCollections.observableArrayList();
		try{
			BufferedReader br=new BufferedReader(new FileReader("./src/options/grad_degree.txt"));
			while(true)
			{
				String line=br.readLine();
				//System.out.println(line);
				if(line==null)
					break;
				arr.add(line);
			}
		}
		catch(Exception ep){}
		Set <String> s=new HashSet();
		s.addAll(arr);
		arr.clear();
		arr.addAll(s);
		fgrad_degree.setItems((ObservableList)arr);
		arr =FXCollections.observableArrayList();
		try{
			BufferedReader br=new BufferedReader(new FileReader("./src/options/pg_degree.txt"));
			while(true)
			{
				String line=br.readLine();
				//System.out.println(line);
				if(line==null)
					break;
				arr.add(line);
			}
		}
		catch(Exception ep){}
		s=new HashSet();
		s.addAll(arr);
		arr.clear();
		arr.addAll(s);
		fpg_degree.setItems((ObservableList)arr);
		arr =FXCollections.observableArrayList();
		try{
			BufferedReader br=new BufferedReader(new FileReader("./src/options/xboard.txt"));
			while(true)
			{
				String line=br.readLine();
				//System.out.println(line);
				if(line==null)
					break;
				arr.add(line);
			}
		}
		catch(Exception ep){}
		s=new HashSet();
		s.addAll(arr);
		arr.clear();
		arr.addAll(s);
		fxboard.setItems((ObservableList)arr);
		arr =FXCollections.observableArrayList();
		try{
			BufferedReader br=new BufferedReader(new FileReader("./src/options/xiiboard.txt"));
			while(true)
			{
				String line=br.readLine();
				//System.out.println(line);
				if(line==null)
					break;
				arr.add(line);
			}
		}
		catch(Exception ep){}
		s=new HashSet();
		s.addAll(arr);
		arr.clear();
		arr.addAll(s);
		fxiiboard.setItems((ObservableList)arr);
		arr =FXCollections.observableArrayList();
		try{
			BufferedReader br=new BufferedReader(new FileReader("./src/options/grad_dep.txt"));
			while(true)
			{
				String line=br.readLine();
				//System.out.println(line);
				if(line==null)
					break;
				arr.add(line);
			}
		}
		
		catch(Exception ep){}
		s=new HashSet();
		s.addAll(arr);
		arr.clear();
		arr.addAll(s);
		fgrad_dep.setItems((ObservableList)arr);
		arr =FXCollections.observableArrayList();
		try{
			BufferedReader br=new BufferedReader(new FileReader("./src/options/pg_dep.txt"));
			while(true)
			{
				String line=br.readLine();
				//System.out.println(line);
				if(line==null)
					break;
				arr.add(line);
			}
		}
		catch(Exception ep){}
		s=new HashSet();
		s.addAll(arr);
		arr.clear();
		arr.addAll(s);
		fpg_dep.setItems((ObservableList)arr);
		fgrad_state.setItems(FXCollections.observableArrayList("All","Andhra Pradesh ","Arunachal Pradesh ","Assam ","Bihar ","Chhattisgarh ","Delhi","Goa ","Gujarat ","Haryana ","Himachal Pradesh ","Jammu and Kashmir ","Jharkhand ","Karnataka ","Kerala ","Madhya Pradesh ","Maharashtra ","Manipur ","Meghalaya ","Mizoram ","Nagaland ","Odisha ","Punjab ","Rajasthan ","Sikkim ","Tamil Nadu ","Tripura ","Uttar Pradesh ","Uttarakhand ","West Bengal"));
		fpg_state.setItems(FXCollections.observableArrayList("All","Andhra Pradesh ","Arunachal Pradesh ","Assam ","Bihar ","Chhattisgarh ","Delhi","Goa ","Gujarat ","Haryana ","Himachal Pradesh ","Jammu and Kashmir ","Jharkhand ","Karnataka ","Kerala ","Madhya Pradesh ","Maharashtra ","Manipur ","Meghalaya ","Mizoram ","Nagaland ","Odisha ","Punjab ","Rajasthan ","Sikkim ","Tamil Nadu ","Tripura ","Uttar Pradesh ","Uttarakhand ","West Bengal"));		
	}
	
	boolean x_gt,x_eq,x_lt,xii_gt,xii_eq,xii_lt,grad_gt,grad_eq,grad_lt,pg_gt,pg_eq,pg_lt,gate_gt,gate_eq,gate_lt;
	void Display()
	{
		System.out.println(name+"\n"+enrollno+"\n"+email+"\n"+gender+"\n"+category+"\n"+"Phy Disabled: "+pd+"\n"+f_dob+"\n"+dob);
    	System.out.println(phdStream+"\n"+XBoard+"\n"+XIIBoard+"\n"+gradDegree+"\n"+pgDegree+"\n"+gradDepartment+"\n"+pgDepartment+"\n"+ug_university+"\n"+pg_university+"\n"+ug_state+"\n"+pg_state);
		System.out.println("\n"+"date from--"+date_from+"\n"+"date upto---"+date_upto);
	}

	 public static boolean containsOnlyNumbers(String str) {
	        for (int i = 0; i < str.length(); i++) {
	          if (!Character.isDigit(str.charAt(i)))
	            return false;
	        }
	        return true;
	      }
	
	public int fcheckfields()
	{
	int fwrong=0;
	fdoblabel.setText("");
	if((RadioButton)fdob.getSelectedToggle()!=null)
	        	{
	        		if(fdate.getValue()==null)
	        		{
	        			fwrong=1;
	        			fdoblabel.setText("Please enter Date of birth");
	        			 fdoblabel.setTextFill(Color.web("#ff0000"));
	        		}
	        		else
	        		{
	        		fdoblabel.setText("");
	        		}
	        	}
	fdoblabel.setText("");
	if(fdate.getValue()!=null)
				{
					if((RadioButton)fdob.getSelectedToggle()==null)
					{
						fwrong=1;
						fdoblabel.setText("Choose one of the options");
						 fdoblabel.setTextFill(Color.web("#ff0000"));
					}
					else
					{
					fdoblabel.setText("");
					}
				}
	fromdatelabel.setText("");
	if(fdate_from.getValue()!=null && fdate_from.getValue()!=null)
	{
	if(fdate_from.getValue().isAfter(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()))
	{
	fwrong=1;
	fromdatelabel.setText("Invalid Date");
	fromdatelabel.setTextFill(Color.web("#ff0000"));
	}
	else
	{
	fromdatelabel.setText("");
	}


	uptodatelabel.setText("");
	if(fdate_upto.getValue().isAfter(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()))
	{
	fwrong=1;
	uptodatelabel.setText("Invalid Date");
	uptodatelabel.setTextFill(Color.web("#ff0000"));
	}
	else
	{
	uptodatelabel.setText("");
	}
	
	if(fdate_upto.getValue().isBefore(fdate_from.getValue()))
	{
	fwrong=1;
	uptodatelabel.setText("Invalid Date");
	uptodatelabel.setTextFill(Color.web("#ff0000"));
	}
	
	
	
	}
	fxlabel.setText("");
	if(fx_gt.isSelected()==true || fx_eq.isSelected()==true || fx_lt.isSelected()==true)
	{
		if(fx_percent.getText().isEmpty()==true)
		{
			fwrong=1;
			fxlabel.setText("Enter percent");
			 fxlabel.setTextFill(Color.web("#ff0000"));
		}
		else
		{
			fxlabel.setText("");
		}
		
	}
	femaillabel.setText("");
	if(femail.getText().isEmpty()==false)
	{
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		String inp_email=femail.getText().toString();
		Boolean b = (inp_email).matches(EMAIL_REGEX);
		if(b==false)
		{
			fwrong=1;
			femaillabel.setText("Wrong email");
			 femaillabel.setTextFill(Color.web("#ff0000"));
		}
		else
		{
			femaillabel.setText("");

		}
	}
	fnamelabel.setText("");
	if(fname.getText().isEmpty()==false)
	{
		String regx = "^[\\p{L} .'-]+$";
		String inp_father=fname.getText().toString();
		Boolean b = (inp_father).matches(regx);
		if(b==false)
		{
			fwrong=1;
			fnamelabel.setText("name cannot have numbers !");
			 fnamelabel.setTextFill(Color.web("#ff0000"));
		}
	}
	fenrollnolabel.setText("");
	if(fenroll_no.getText().isEmpty()==false)
	{
		if(containsOnlyNumbers(fenroll_no.getText()))
		{
			
			fenrollnolabel.setText("");
			
		}
		else
		{
			fwrong=1;
			fenrollnolabel.setText("Only numbers are allowed !");
			fenrollnolabel.setTextFill(Color.web("#ff0000"));
		}
		
		
	}
	fxiilabel.setText("");
	if(fxii_gt.isSelected()==true || fxii_eq.isSelected()==true || fxii_lt.isSelected()==true)
	{
		if(fxii_percent.getText().isEmpty()==true)
		{
			fwrong=1;
			fxiilabel.setText("Enter percent");
			 fxiilabel.setTextFill(Color.web("#ff0000"));
		}
		else
		{
			fxiilabel.setText("");
		}
		
	}
	fgradlabel.setText("");
	if(fgrad_gt.isSelected()==true || fgrad_eq.isSelected()==true || fgrad_lt.isSelected()==true)
	{
		if(fgrad_percent.getText().isEmpty()==true)
		{
			fwrong=1;
			fgradlabel.setText("Enter percent");
			 fgradlabel.setTextFill(Color.web("#ff0000"));
		}
		else
		{
			fgradlabel.setText("");
		}
		
	}
	fpglabel.setText("");
	if(fpg_gt.isSelected()==true || fpg_eq.isSelected()==true || fpg_lt.isSelected()==true)
	{
		if(fpg_percent.getText().isEmpty()==true)
		{
			fwrong=1;
			fpglabel.setText("Enter percent");
			 fpglabel.setTextFill(Color.web("#ff0000"));
		}
		else
		{
			fpglabel.setText("");
		}
		
	}
	fgatelabel.setText("");
	if(fgate_gt.isSelected()==true || fgate_eq.isSelected()==true || fgate_lt.isSelected()==true)
	{
		if(fgate_score.getText().isEmpty()==true)
		{
			fwrong=1;
			fgatelabel.setText("Enter percent");
			 fgatelabel.setTextFill(Color.web("#ff0000"));
		}
		else
		{
			fgatelabel.setText("");
		}
		
	}
	fenrollnolabel.setText("");
	if(fenroll_no.getText().isEmpty()==false)
	{
		if(containsOnlyNumbers(fenroll_no.getText()))
				{
			fenrollnolabel.setText("");
				}
		else
		{
			fwrong=1;
			fenrollnolabel.setText("Only 0-9 digits allowed");
			 fenrollnolabel.setTextFill(Color.web("#ff0000"));
		}
	}
	
	//fxlabel.setText("");
	if(fx_percent.getText().isEmpty()==false)
	{
		if(fx_gt.isSelected()==false && fx_eq.isSelected()==false && fx_lt.isSelected()==false)
		{
			fwrong=1;
			fxlabel.setText("Choose option(s)");
			 fxlabel.setTextFill(Color.web("#ff0000"));
		}
		else
		{
			fxlabel.setText("");
		}
		
	}
	//fxiilabel.setText("");
	if(fxii_percent.getText().isEmpty()==false)
	{
		if(fxii_gt.isSelected()==false && fxii_eq.isSelected()==false && fxii_lt.isSelected()==false)
		{
			fwrong=1;
			fxiilabel.setText("Choose option(s)");
			 fxiilabel.setTextFill(Color.web("#ff0000"));
		}
		else
		{
			fxiilabel.setText("");
		}
		
	}
	//fgradlabel.setText("");
	if(fgrad_percent.getText().isEmpty()==false)
	{
		if(fgrad_gt.isSelected()==false && fgrad_eq.isSelected()==false && fgrad_lt.isSelected()==false)
		{
			fwrong=1;
			fgradlabel.setText("Choose option(s)");
			 fgradlabel.setTextFill(Color.web("#ff0000"));
		}
		else
		{
			fgradlabel.setText("");
		}
		
	}
	//fpglabel.setText("");
	if(fpg_percent.getText().isEmpty()==false)
	{
		if(fpg_gt.isSelected()==false && fpg_eq.isSelected()==false && fpg_lt.isSelected()==false)
		{
			fwrong=1;
			fpglabel.setText("Choose option(s)");
			 fpglabel.setTextFill(Color.web("#ff0000"));
		}
		else
		{
			fpglabel.setText("");
		}
		
	}
	//fgatelabel.setText("");
	if(fgate_score.getText().isEmpty()==false)
	{
		if(fgate_gt.isSelected()==false && fgate_eq.isSelected()==false && fgate_lt.isSelected()==false)
		{
			fwrong=1;
			fgatelabel.setText("Choose option(s)");
			 fgatelabel.setTextFill(Color.web("#ff0000"));
		}
		else
		{
			fgatelabel.setText("");
		}
		
	}
	
	

	return fwrong;


	}
	
	
	
	void validate()
	{
		if(isname){
			for(int i=0;i<main.size();i++)
				{
					System.out.println("Checking "+main.get(i).Name+" vs "+name);
					if(main.get(i).Name.equals(name))
						filtered.add(main.get(i));
				}
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(isemail){
			for(int i=0;i<main.size();i++)
				if(main.get(i).Email.equals(email))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(isenrollno){
			System.out.println("Enroll no checking "+enrollno);
			for(int i=0;i<main.size();i++)
				{	
				System.out.println("CHecking with "+main.get(i).Enrollno);
				if(main.get(i).Enrollno.equals(enrollno))
				{
					System.out.println("Succeeded");
					filtered.add(main.get(i));
				}
				}
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(iscategory){
			for(int i=0;i<main.size();i++)
				if(main.get(i).Category.equals(category))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(isgender){
			for(int i=0;i<main.size();i++)
				if(main.get(i).Gender.equals(gender))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(ispd){
			for(int i=0;i<main.size();i++)
				if(main.get(i).Handicap==pd)
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(isdob && f_dob.equals("Before")){
			for(int i=0;i<main.size();i++)
				if(main.get(i).DOB.isBefore(dob))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(isdob && f_dob.equals("After")){
			for(int i=0;i<main.size();i++)
				if(main.get(i).DOB.isAfter(dob))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(isdob && f_dob.equals("On")){
			for(int i=0;i<main.size();i++)
				if(main.get(i).DOB.isEqual(dob))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(isphdStream){
			for(int i=0;i<main.size();i++)
				if(main.get(i).Stream.equals(phdStream))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(isXBoard){
			for(int i=0;i<main.size();i++)
				if(main.get(i).XBoard.equals(XBoard))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(isXIIBoard){
			for(int i=0;i<main.size();i++)
				if(main.get(i).XIIBoard.equals(XIIBoard))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(isgradDegree){
			for(int i=0;i<main.size();i++)
				if(main.get(i).Degree.equals(gradDegree))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(ispgDegree){
			for(int i=0;i<main.size();i++)
				if(main.get(i).PGDone && main.get(i).PGDegree.equals(pgDegree))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(isgender){
			for(int i=0;i<main.size();i++)
				if(main.get(i).Gender.equals(gender))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(isgradDepartment){
			for(int i=0;i<main.size();i++)
				if(main.get(i).Department.equals(gradDepartment))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(ispgDepartment){
			for(int i=0;i<main.size();i++)
				if(main.get(i).PGDepartment!=null&&main.get(i).PGDepartment.equals(pgDepartment))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(isug_university){
			for(int i=0;i<main.size();i++)
				if(main.get(i).University.equals(ug_university))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(ispg_university){
			for(int i=0;i<main.size();i++)
				if(main.get(i).University.equals(pg_university))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(isug_state){
			for(int i=0;i<main.size();i++)
				if(main.get(i).State.equals(ug_state))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(ispg_state){
			for(int i=0;i<main.size();i++)
				if(!main.get(i).PGState.isEmpty()&&main.get(i).PGState.equals(pg_state))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(isxpercent)
		{
			System.out.println("Xpercentage checking");
			if(x_gt){
				System.out.println("Is Greater than"+xpercent);
				for(int i=0;i<main.size();i++)
					{
						System.out.println("Checking with "+main.get(i).XMarks);
						if(main.get(i).XMarks>xpercent)
							filtered.add(main.get(i));
					}
				//System.out.println(filtered);
			}
			if(x_lt){
				for(int i=0;i<main.size();i++)
					if(main.get(i).XMarks<xpercent)
						filtered.add(main.get(i));
			}
			if(x_eq){
				for(int i=0;i<main.size();i++)
					if(main.get(i).XMarks==xpercent)
						filtered.add(main.get(i));
				}
			if(x_gt ||x_lt || x_eq)
			{
				main.clear();
				main.addAll(filtered);
				filtered.clear();
			}
		}
		if(isxiipercent)
		{
			if(xii_gt){
				for(int i=0;i<main.size();i++)
					if(main.get(i).XIIMarks>xiipercent)
						filtered.add(main.get(i));
			}
			if(xii_lt){
				for(int i=0;i<main.size();i++)
					if(main.get(i).XIIMarks<xiipercent)
						filtered.add(main.get(i));
			}
			if(xii_eq){
				for(int i=0;i<main.size();i++)
					if(main.get(i).XIIMarks==xiipercent)
						filtered.add(main.get(i));
			}
			if(xii_gt ||xii_lt || xii_eq)
			{
				main.clear();
				main.addAll(filtered);
				filtered.clear();
			}
		}
		if(isgradpercent)
		{
			if(grad_gt){
				for(int i=0;i<main.size();i++)
					if(main.get(i).Marks>gradpercent)
						filtered.add(main.get(i));
			}
			if(grad_lt){
				for(int i=0;i<main.size();i++)
					if(main.get(i).Marks<gradpercent)
						filtered.add(main.get(i));
			}
			if(grad_eq){
				for(int i=0;i<main.size();i++)
					if(main.get(i).Marks==gradpercent)
						filtered.add(main.get(i));
			}
			if(grad_gt || grad_lt || grad_eq)
			{
				main.clear();
				main.addAll(filtered);
				filtered.clear();
			}
		}
		if(ispgpercent)
		{
			if(pg_gt){
				for(int i=0;i<main.size();i++)
					if(main.get(i).PGDone &&main.get(i).PGMarks>pgpercent)
						filtered.add(main.get(i));
			}
			if(pg_lt){
				for(int i=0;i<main.size();i++)
					if(main.get(i).PGDone &&main.get(i).PGMarks<pgpercent)
						filtered.add(main.get(i));
			}
			if(pg_eq){
				for(int i=0;i<main.size();i++)
					if(main.get(i).PGDone &&main.get(i).PGMarks==pgpercent)
						filtered.add(main.get(i));
			}
			if(pg_gt || pg_lt || pg_eq)
			{
				main.clear();
				main.addAll(filtered);
				filtered.clear();
			}
		}
		if(isgate_score)
		{
			if(gate_gt){
				for(int i=0;i<main.size();i++)
					if(main.get(i).TakenGATE && main.get(i).GateScore>gate_score)
						filtered.add(main.get(i));
			}
			if(gate_lt){
				for(int i=0;i<main.size();i++)
					if(main.get(i).TakenGATE &&  main.get(i).GateScore<gate_score)
						filtered.add(main.get(i));
			}
			if(gate_eq){
				for(int i=0;i<main.size();i++)
					if(main.get(i).TakenGATE &&  main.get(i).GateScore==gate_score)
						filtered.add(main.get(i));
			}
			if( (gate_gt || gate_lt || gate_eq))
			{
				System.out.println("Inside");
				main.clear();
				main.addAll(filtered);
				filtered.clear();
			}
		}
		if(isdate_from){
			for(int i=0;i<main.size();i++)
				if(date_from.isBefore(main.get(i).TimeStamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
		if(isdate_upto){
			for(int i=0;i<main.size();i++)
				if(date_upto.isAfter(main.get(i).TimeStamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()))
					filtered.add(main.get(i));
		main.clear();
		main.addAll(filtered);
		filtered.clear();}
	}
	public void takevalues(ActionEvent event)
	{
		
		if(fcheckfields()!=0)
		{
			fstatus.setText("Please Enter entries Correctly !");
			fpglabel.setTextFill(Color.web("#ff0000"));
			return;
		}
      	fpglabel.setTextFill(Color.web("#00ff00"));
		

		email=femail.getText();
		name=fname.getText();
		if(fenroll_no.getText().toString().isEmpty()==false)
			enrollno=Integer.parseInt(fenroll_no.getText());
		category=fcategory.getValue().toString();
		if(((RadioButton)fgender.getSelectedToggle())!=null)
			gender=((RadioButton)fgender.getSelectedToggle()).getText();
		if(((RadioButton)fpd.getSelectedToggle())!=null)
    		if(((RadioButton)fpd.getSelectedToggle()).getText().equals("YES"))
    			pd=true;
    		else
    			pd=false;
		if(((RadioButton)fdob.getSelectedToggle())!=null)
			{f_dob=((RadioButton)fdob.getSelectedToggle()).getText();
			dob=fdate.getValue();}
		phdStream=fstream.getValue().toString();
		XBoard=fxboard.getValue().toString();
		XIIBoard=fxiiboard.getValue().toString();
		gradDegree=fgrad_degree.getValue().toString();
		pgDegree=fpg_degree.getValue().toString();
		gradDepartment=fgrad_dep.getValue().toString();
		pgDepartment=fpg_dep.getValue().toString();
		if(fgrad_univ.getText().isEmpty()==false)
			ug_university=fgrad_univ.getText();
		if(fpg_univ.getText().isEmpty()==false)
			pg_university=fpg_univ.getText();
		ug_state=fgrad_state.getValue().toString();
		pg_state=fpg_state.getValue().toString();
		
		if(fx_percent.getText().isEmpty()==false)
			xpercent=Float.parseFloat(fx_percent.getText());
		if(fxii_percent.getText().isEmpty()==false)
			xiipercent=Float.parseFloat(fxii_percent.getText());
		if(fgrad_percent.getText().isEmpty()==false)
			gradpercent=Float.parseFloat(fgrad_percent.getText());
		if(fpg_percent.getText().isEmpty()==false)
			pgpercent=Float.parseFloat(fpg_percent.getText());
		if(fgate_score.getText().isEmpty()==false)
			gate_score=Float.parseFloat(fgate_score.getText());
    	
    	x_gt=fx_gt.isSelected();
    	x_eq=fx_eq.isSelected();
    	x_lt=fx_lt.isSelected();
    	xii_gt=fxii_gt.isSelected();
    	xii_eq=fxii_eq.isSelected();
    	xii_lt=fxii_lt.isSelected();
    	grad_gt=fgrad_gt.isSelected();
    	grad_eq=fgrad_eq.isSelected();
    	grad_lt=fgrad_lt.isSelected();
    	pg_gt=fpg_gt.isSelected();
    	pg_eq=fpg_eq.isSelected();
    	pg_lt=fpg_lt.isSelected();
    	gate_gt=fgate_gt.isSelected();
    	gate_eq=fgate_eq.isSelected();
    	gate_lt=fgate_lt.isSelected();
    	
    	date_from=fdate_from.getValue();
    	date_upto=fdate_upto.getValue();
    	
		//Display();
		is();
		validate();
		printFiltered(event);
	}
	
	static Scene mainscene;static Stage stage;
	public void goback(ActionEvent event)
	{
		pd=false;isname=false;isenrollno=false;isemail=false;iscategory=false;isgender=false;ispd=false;isdob=false;isphdStream=false;isgradDegree=false;ispgDegree=false;isXBoard=false;isXIIBoard=false;isgradDepartment=false;ispgDepartment=false;isug_university=false;ispg_university=false;isug_state=false;ispg_state=false;isxpercent=false;isxiipercent=false;isgradpercent=false;ispgpercent=false;isgate_score=false;isdate_from=false;isdate_upto=false;
		main.clear();
		main.addAll(cands);
		filtered.clear();
		stage.setScene(mainscene);
		
	}
	void printFiltered(ActionEvent event)
	{
		System.out.println(main.size());
		for(int i=0;i<main.size();i++)
			{
				main.get(i).Display(1);main.get(i).Display(2);
			}
		try {
			//((Node)(event.getSource())).getScene().getWindow().hide();
			//newstage = new Stage();
			
			stage=(Stage)fstream.getScene().getWindow();
			//stage.hide();
			mainscene=stage.getScene();
			//Parent root = FXMLLoader.load(getClass().getResource("result.fxml"));
			FXMLLoader loader = new FXMLLoader(getClass().getResource("result.fxml"));
			//Result result=new Result(main);
			//loader.setController(result);
			//Result r=loader.getController();
			
			Parent root=loader.load();
			//r.print=main;
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Filtered Result");
            stage.show();
           // System.out.println(col1);
         
        } catch (Exception ex) {
        	ex.printStackTrace();
		
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
}



