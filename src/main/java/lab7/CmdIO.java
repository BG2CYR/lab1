package lab7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CmdIO {
	static int debug=0;
	static Calc calculate;
	public CmdIO()
	{
		
	}
	public static int docmd(String inputstr)
    {
    	if(inputstr.length()>0)
    	{
	    	if(inputstr.charAt(0)=='!')
	    	{
	    		inputstr=inputstr.replaceAll("!\\s*", "!");
	    		//System.out.println(inputstr);
	    		if(calculate!=null)
	    		{
		    		if(inputstr.length()>=5&&inputstr.substring(1, 4).compareTo("d/d")==0)//d/dx
		    		{
		    			int firstindex=4;
		    			while(inputstr.charAt(firstindex)==' ')
		    			{
		    				firstindex+=1;
		    			}
		    			String[] list=inputstr.substring(firstindex).split(" ");
		    			if(list.length>1)
		    			{
		    				System.out.println("too much var!!!");
		    			}
		    			else
		    			{
		    				//System.out.println("d"+list[0]);
		    				calculate.derivative(list[0]);
		    				if(debug==1)
		    				{
		    					calculate.showsimp();
		    				}
		    				calculate.showans();
		    			}
		    		}
		    		if(inputstr.length()>=10&&inputstr.substring(1, 9).compareTo("simplify")==0)//simplify
		    		{
		    			//System.out.println(inputstr.substring(9));
		    			String strcheck=inputstr.substring(9);
		    			strcheck=strcheck.replaceAll("\\s*=\\s*", "=");
		    			String[] tmp= strcheck.split(" ");
		    			String formedvar="";
		    			for(String i:tmp)
		    			{
		    				if(i.length()>0)
		    				{
			    				String[] equallist=i.split("=");
			    				if(equallist.length==2&&(isNumeric(equallist[1])||(equallist[1].charAt(0)=='-'&&isNumeric(equallist[1].substring(1)))))
			    				{
			    					//System.out.print(equallist[0]+":");
				    				//System.out.println(equallist[1]);
				    				formedvar+=equallist[0]+"="+equallist[1]+" ";
			    				}
			    				else
			    				{
			    					System.out.println("wrong equal");
			    					return 0;
			    				}
		    				}
		    			}
		    			//System.out.println(formedvar);
		    			calculate.simplify(formedvar);
		    			if(debug==1)
		    			{
		    				calculate.showsimp();
		    			}
		    			calculate.showans();
		    		}
		    		if(inputstr.length()>0&&inputstr.compareTo("!exit")==0)
		    		{
		    			System.out.println("exit");
		    			return 1;
		    		}
	    		}
	    		else
	    		{
	    			System.out.println("no express!!!");
	    		}
	    		
	    	}
	    	else
	    	{
	    		inputstr=inputstr.replaceAll("\\s*", "");
	    		calculate=new Calc(inputstr);
	    		if(debug==1)
	    		{
	    			calculate.showinput();
	    		}
	    		calculate.showexp();
	    	}
    	}
    	else
    	{
    	}
		return 0;
    }
    public static boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
		}
}
