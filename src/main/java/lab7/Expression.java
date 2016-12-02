package lab7;

import java.util.ArrayList;

public class Expression {
	public ArrayList<SubExpression> data;
	public Expression()
	{
		data = new ArrayList<SubExpression>();
	}
	public void addsub(SubExpression datatoadd)
	{
		data.add(datatoadd);
	}
}
