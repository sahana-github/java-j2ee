package Ex1;
import java.util.*;
//Options 1 a b and c are done here
public class RecordManageMissedCall 
{
	//LinkedList (Java Collection) to manage missed call details
	static LinkedList<MissedCallDetails> amiss;
	static void HandleMissedCallActivities()
	{
		//Creation of linked list
		amiss = new LinkedList<MissedCallDetails>();
		while(true)
		{
			//Few options to manage missed call
			System.out.println("Enter a choice");
			System.out.println("1: add missed call \n 2.Display and delete on request \n 3. Delete based on number \n 4. Print");
			//Missed Call needs to refer to the database of callers 
			int choice = DatabaseCallers.sc.nextInt();
			
			switch(choice)//Performs 1c 
			{
			case 1: //add missed call
				System.out.println("Enter the missed call telephone number");
				Calendar cb = Calendar.getInstance();
				Long telnum= DatabaseCallers.sc.nextLong();
				String name; // = DataBaseCallers.sc.next();
				//check for name in the Database
				//If contact no is already available in database, retrieve the name
				if(DatabaseCallers.hm.containsKey(telnum))
					name = DatabaseCallers.hm.get(telnum);
				else
					name = "Private Caller";//In case, contact no is new
				MissedCallDetails mcd = new MissedCallDetails(cb,telnum,name);
				//Restricting missed call storage to 10 (1b option)
				if(amiss.size()==10)//for eleventh entry onwards
				{
				//for eleventh entry onwards enter from the beginning
				 amiss.removeLast();//Removes the last entry of the LinkedList	
				}
				
				amiss.addFirst(mcd);
				
				break;
			case 2: // Display number and ask for user to delete
				ListIterator<MissedCallDetails> it = amiss.listIterator();
				LinkedList<MissedCallDetails> removeList = new LinkedList<MissedCallDetails>();
				int i=0;
				while(it.hasNext())
				{ i++;
					System.out.println("Number is ");
					MissedCallDetails m1 = it.next();
					System.out.println(m1.tel_num);
					System.out.println("Do you want to delete the details related to this number? Indicate by 1 : delete, 2: move next call , 3: display call details \n");
					int cho = DatabaseCallers.sc.nextInt();
					if(cho==1)
						removeList.add(m1);//Removed no
					else if(cho==3)//Display the no
					{//display
						m1.display();
						}
				}
				if(i==0)
					System.out.println("No missed calls");
				amiss.removeAll(removeList);
				
				break;
			case 3: //Delete based on the number specified by the user
				System.out.println("Delete based on the number given by user");
				System.out.println("Enter the number");
				Long num = DatabaseCallers.sc.nextLong();
				ListIterator<MissedCallDetails> it1 = amiss.listIterator();//Creating an iterator for easy iteration
				boolean flag = false;
				i=0;
				while(it1.hasNext())
				{ i++;//Indication of how many items have been checked so far
					MissedCallDetails m1 = it1.next();
					if(m1.tel_num==num)//Trying to match the entered no with the those in ListIterator<MissedCallDetails>
					{
						flag =true;//The no is found...Set the flag true
						amiss.remove(m1);
						break;
					}
				}
				if(i!=0)
				{
				if(flag==true)
					System.out.println("Phone number with details "+ num +"deleted");
				else//when i!=0 and flag is still false, you can say that such a no does not exist
					System.out.println("No such number exists");
				}
				else//Otherwise, no missed call
					System.out.println("No missed Call");
				break;
			case 4:
				//print missed call details through another iterator (Perform 1 a)
				ListIterator<MissedCallDetails> it2 = amiss.listIterator();
				while(it2.hasNext())
				{
					MissedCallDetails m1 = it2.next();
					m1.display();
				}
				 break;
				
			default: return;	
			}
	}
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		DatabaseCallers.ForHoldingData();//Creating the database first
		System.out.println("Receive missed Calls");
		//DataBaseCallers.sc
		HandleMissedCallActivities();//Calling the function with many choices
		DatabaseCallers.display();	//Displays all the entries in the list
	}
}


