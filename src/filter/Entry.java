package filter;
//@author Name: Adesh Pandey , Rishabh Gupta Roll no: 2014004,2014086
import javafx.beans.property.SimpleStringProperty;
import project.Candidate;

public class Entry
{
	public SimpleStringProperty Enrollno=null,Name=null,Link=null;
	public Entry(Candidate e)
	{
		Enrollno=new SimpleStringProperty(e.Enrollno.toString());
		Name=new SimpleStringProperty(e.Name.toString());
		Link=new SimpleStringProperty("\tLINK to "+e.Name.toString()+" @ "+e.Enrollno.toString());
	}
	public String getEnrollno()
	{
		return Enrollno.get();
	}
	public String getName()
	{
		return Name.get();
	}
	public String getLink()
	{
		return Link.get();
	}
}