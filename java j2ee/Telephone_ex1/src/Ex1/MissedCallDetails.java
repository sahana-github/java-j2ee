package Ex1;
import java.util.*;

public class MissedCallDetails 
{
	//Details of missed call (Calendar, telephone no, name)
	Calendar calObj;
	Long tel_num;
	String name;
	//Constructor for initialization
	MissedCallDetails(Calendar cob, Long tn, String n)
	{
		calObj = cob;
		tel_num = tn;
		name = n;
	}
	//Display function 
	void display()
	{ 
		//Add date to the Calendar..It gets incremented by 1 day
		calObj.add(Calendar.DATE, 1);
	    //SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Current Time is  "+calObj.getTime());
		System.out.println("Telephone number is  "+tel_num);
		System.out.println("Name is  "+name);
	}

}
