package lab7;

import java.util.HashMap;
import java.util.Map;

public class SubExpression {
	int ratio;//系数
	public Map<String, Integer> exponential;//指数
	public SubExpression()
	{
		exponential = new HashMap<String, Integer>();
	}
	public void setratio(int ratio)
	{
		this.ratio=ratio;
	}
	public int getratio()
	{
		return this.ratio;
	}
	public void addexponential(String varname,int varexponential)
	{
		this.exponential.put(varname, varexponential);
	}
}
