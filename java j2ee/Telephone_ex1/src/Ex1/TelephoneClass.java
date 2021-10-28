package Ex1;
import java.util.*;
public class TelephoneClass 
{
	HashMap<Long,String> hm = new HashMap<Long,String>();
	ArrayList<Long> callList = new ArrayList<Long>();
	ArrayList<CallerD> missedcall = new ArrayList<CallerD>();//Creating CallerD
	void createCaller()
	{
		hm.put(new Long("9898080099"),"Hari M");
		hm.put(new Long("9898087654"),"Lankesh M");
		hm.put(new Long("9898897843"),"Lucky");
	}
}
