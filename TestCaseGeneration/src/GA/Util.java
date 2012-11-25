package GA;

import java.util.ArrayList;
import java.util.Random;

import system.Parameter;

import CodeAnalyzer.CodeAnalyzer;


public class Util implements Cons
{
	static public boolean s_isDebug = true;
	
	private static Random r = new Random();
	
	private static long s_lTimer = k_iTIMER_NOT_SET_YET;
	
	
	public static Object[] Random(CodeAnalyzer codeAnalyzer)
	{
		int num = codeAnalyzer.getNumPar();
		ArrayList<Parameter> listPar = codeAnalyzer.getParaList();
		Object[] a = new Object[num];
		for (int i = 0; i < num; i++)
		{
			switch(listPar.get(i).getType())
			{
			case "Int":
				a[i] = r.nextInt()%100;
				break;
			case "Real":
			case "Float":
			case "Double":
				a[i] = r.nextDouble()*10;
				break;
			}
		}
		return a;
	}
	
	public static Object Random(CodeAnalyzer codeAnalyzer, int pos)
	{
		Object a = new Object();
		ArrayList<Parameter> listPar = codeAnalyzer.getParaList();
		switch(listPar.get(pos).getType())
		{
		case "Int":
			a = r.nextInt()%100;
			break;
		case "Real":
		case "Float":
		case "Double":
			a = r.nextDouble()*10;
			break;		
		}
		return a;
	}
	
	public static double GetRandomProbability()
	{
		return r.nextDouble();
	}
	
	public static boolean Random()
	{
		return r.nextBoolean();
	}
	
	public static void PRINT(String s)
	{
		if (s_isDebug) System.out.println(s);
	}
	

	public static boolean BOOL(int value)
	{
		if (value == k_iTRUE) return true;
		else return false;
	}
	
	public static int ABS(int value)
	{
		return (value < 0 ? -value : value);
	}
	
	public static void setTimer()
	{
		s_lTimer = System.currentTimeMillis();
		System.out.println(s_lTimer);
	}
	
	public static int getTimer()
	{
		if (s_lTimer == k_iTIMER_NOT_SET_YET) return k_iTIMER_NOT_SET_YET;
		else
		{
			int ret = (int)(System.currentTimeMillis() - s_lTimer - 990);
			return ret;
		}
	}
	
	public static int endTimer()
	{
		if (s_lTimer == k_iTIMER_NOT_SET_YET) return k_iTIMER_NOT_SET_YET;
		else
		{
			int ret = (int)(System.currentTimeMillis() - s_lTimer);
			s_lTimer = k_iTIMER_NOT_SET_YET;
			return ret;
		}
	}
	
}
