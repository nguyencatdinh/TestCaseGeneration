package program;

import java.util.ArrayList;

import CodeAnalyzer.CodeAnalyzer;
import GA.GA;
import system.*;
import transform.AST.CompilationException;

public class Control 
{
	//In out control
	private InOut io;
	
	//Standard source file
	private String standardFile;
	//Standardized source
	private String standardSource;
	//Original source
	private String originalSource;
	
	//Code analyzer
	private CodeAnalyzer codeAnalyzer;
	
	//Generic Algorithm
	private GA m_GA;
	
	//Constructor
	public Control()
	{
		io = new InOut();
		codeAnalyzer = new CodeAnalyzer();
		m_GA = new GA();
	}
	
	//Read source file
	public String readSourceFile(String filename)
	{
		originalSource = io.readFile(filename);
		return originalSource;
	}
	
	
	//Standardize Source 
	public String standardizeSource(String filename)
	{
		standardFile = codeAnalyzer.getStandardSource(filename);
		standardSource = io.readFile(standardFile);
		return standardSource;
	}
	
	//Get parameter list
	public ArrayList<String> getParaList()
	{
		return this.codeAnalyzer.getParaNameList();
	}
	
	//Get condition list
	public ArrayList<String> getConditionList() throws CompilationException
	{
		return this.codeAnalyzer.getConditionList();
	}
	
	
	public ArrayList<Integer> getSlide() {
		return this.codeAnalyzer.getSlide();
	}

	//Run generic algorithm to get test case for unsolvable condition
	public String RunGA()
	{
		m_GA.run(codeAnalyzer);
		m_GA.reset();
		return this.codeAnalyzer.updateResult(m_GA.getRes());
		
	}
	
	//Generate test case for solvable condition
	public String GenerateSolvable()
	{
		return this.codeAnalyzer.GenerateSolvable();
	}
	
	//Show all test case
	public String showAllTestCase()
	{
		return this.codeAnalyzer.showAllTestCase();
	}

	//Scan program to collect conditions
	public String scanCondition() {
		return this.codeAnalyzer.scanCondition();
	}
	
	//Get all test cases with true output
	public ArrayList<Boolean> getTrueList()
	{
		return codeAnalyzer.getTrueList();
	}
	
	//Get all test cases with false output
	public ArrayList<Boolean> getFalseList()
	{
		return codeAnalyzer.getFalseList();
	}

	//Get the previous test case
	public ArrayList<Integer> getPrevTestCase() {
		return codeAnalyzer.getPrevTestCase();
	}
	
	//Get the next test case
	public ArrayList<Integer> getNextTestCase()
	{
		return codeAnalyzer.getNextTestCase();
	}
}
