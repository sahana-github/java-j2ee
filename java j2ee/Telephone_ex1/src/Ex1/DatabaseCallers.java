package Ex1;
//Java Collections like HashMap is available in java.util package
import java.util.*;
import java.util.Map.Entry;
public class DatabaseCallers 
{
	//Phone no and contact name is saved in a HashMap
	public static HashMap<Long,String> hm;
	public static Scanner sc = new Scanner(System.in);
	static void createEnteries(int n)
	{ 
		//Creation of hash map
		hm = new HashMap<Long,String>();
		for(int i=0;i<n;i++)
		{
			//Getting input for phone no and contact name
			System.out.println("Enter the phone number and Contact name");
			Long phno = sc.nextLong();
			String name = sc.next();
			//Populating the same in hash map
			hm.put(phno, name);		
		}
	}
	public static void ForHoldingData() 
	{
		// TODO Auto-generated method stub
	//No of entries one is going to deal with
     System.out.println("Enter how many details do you require?");
     int n = sc.nextInt();
     createEnteries(n);
	}
	public static void display()
	{
		//Creating set from hash map (key-value pairs)
		Set<Entry<Long,String>> hashSet=hm.entrySet();
        for(Entry<Long,String> entry:hashSet ) 
        {
            System.out.println("Key="+entry.getKey()+", Value="+entry.getValue());
        }
	}

}
