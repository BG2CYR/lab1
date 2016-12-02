package lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class app {
	public static void main(String[] args) {
		CmdIO a=new CmdIO();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		
		while(true)
		{
			System.out.print(">>>");
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			int end=a.docmd(str);
			if(end==1)break;
		}
	}

}
