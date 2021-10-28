package Ex1;
import java.util.*;
//Helper class - an incoming call - hold number, name of the caller, and time of the call
public class CallerD 
{
		Date date = new Date();//Date creation
		String name;//Name of the caller
		Integer telNo;//Telephone no
		
		//Constructor for initialization
		CallerD(Date d, String n,Integer t)
		{
			date =d;
			name = n;
			telNo = t;
		}
}
	