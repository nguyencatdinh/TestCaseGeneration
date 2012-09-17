package GA;

import java.util.ArrayList;
//import java.util.Random;

import CodeAnalyzer.CodeAnalyzer;

public class GA implements Cons
{
	public static final int k_iPOPULATION_SIZE = 10;
	
	public ArrayList<Testcase> m_Population;
	
	public ArrayList<Testcase> m_ChildPopulation;
	
	public Testcase m_AllTimeBestTestcase;
	
	public void reset()
	{
		if(m_Population != null)
		{
			m_Population.clear();
			m_ChildPopulation.clear();
		}
	}
	
	private void GenerateRandomPopulation(CodeAnalyzer codeAnalyzer)
	{
		m_Population = new ArrayList<Testcase>();
		for (int i = 0; i < k_iPOPULATION_SIZE; i++)
		{
			m_Population.add(new Testcase(codeAnalyzer));
		}
	}
	
	private boolean IsDone()
	{
		if (m_AllTimeBestTestcase.isAcesssAllBranch()) 
		{
			for(int i=0; i<m_AllTimeBestTestcase.m_iBranchNum; i+=2)
			{
				System.out.println(m_AllTimeBestTestcase.m_CanAcessBranch[i]);
				System.out.println(m_AllTimeBestTestcase.m_CanAcessBranch[i+1]);
				int j;
				String truetc = "[";
				String falsetc = "[";
				for(j=0; j< m_AllTimeBestTestcase.m_iParamNum ; j++)
				{
					truetc += m_AllTimeBestTestcase.m_aiParams[i][j];
					falsetc += m_AllTimeBestTestcase.m_aiParams[i+1][j];
					if(j < m_AllTimeBestTestcase.m_iParamNum -1)
					{
						truetc += ", ";
						falsetc += ", ";
					}
				}
				truetc += "]";
				falsetc += "]";
				System.out.println(truetc);
				System.out.println(falsetc);
			}
			
			return true;
		}
		return false;
	}
	
	private Testcase GetBestTestCase()
	{
		Testcase bestTestCase = m_Population.get(0);
		int maxAccessedBranchNum = bestTestCase.GetAcessedBranchNum();
		for (Testcase t : m_Population)
		{
			if (t.GetAcessedBranchNum() > maxAccessedBranchNum) 
			{
				bestTestCase = t;
				maxAccessedBranchNum = bestTestCase.GetAcessedBranchNum();
			}
		}
		return bestTestCase;
	}
	
	@SuppressWarnings("unchecked")
	public void run(CodeAnalyzer codeAnalyzer)
	{
		if(codeAnalyzer.getNumCon() != 0)
		{
			GenerateRandomPopulation(codeAnalyzer);
			
			m_ChildPopulation = new ArrayList<Testcase>();
			
			m_AllTimeBestTestcase = GetBestTestCase();
			
			int count = 0;
			
			while (!IsDone() && count <1000)
			{
				Testcase bestTestCase = GetBestTestCase();
				if (m_AllTimeBestTestcase.GetAcessedBranchNum() < bestTestCase.GetAcessedBranchNum())
				{
					m_AllTimeBestTestcase = bestTestCase;
				}
				for (int i = 0; i < k_iPOPULATION_SIZE; i++)
				{
					Testcase t = m_Population.get(i);
					if (t != bestTestCase)
					{
//						Random r = new Random();
						Testcase child = bestTestCase.Clone();
						int res = child.Hybid(t);
						if(res != 0)
						{
							child.Mutate(codeAnalyzer, res);
						}
						m_ChildPopulation.add(child);
					}
				}
				m_ChildPopulation.add(m_AllTimeBestTestcase);
				
				m_Population = (ArrayList<Testcase>) m_ChildPopulation.clone();
				m_ChildPopulation = new ArrayList<Testcase>();
				count ++;
			}
		//m_AllTimeBestTestcase.PrintResult();
		}
		
	}
	
	public Object[][] getRes()
	{
		if(m_AllTimeBestTestcase != null)
		{
			Object[][] res = new Object[m_AllTimeBestTestcase.m_iBranchNum][m_AllTimeBestTestcase.m_iParamNum+1];
			for (int i = 0; i < m_AllTimeBestTestcase.m_iBranchNum; i ++)
			{
				int j;
				for (j = 0; j < m_AllTimeBestTestcase.m_iParamNum; j++)
				{
					res[i][j]= m_AllTimeBestTestcase.m_aiParams[i][j];
				}
				if(m_AllTimeBestTestcase.m_CanAcessBranch[i] == 0)
				{
					res[i][j] = 0;
				}
				else
				{
					res[i][j] = 1;
				}
			}
			return res;
		}
		else
			return null;
	}

}
