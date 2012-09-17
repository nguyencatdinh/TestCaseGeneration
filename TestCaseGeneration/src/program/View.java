package program;

import java.util.ArrayList;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

import transform.AST.CompilationException;

public class View {
	
	Control control;
	protected Shell shell;
	private Table table1;
	private Table table2;
	private StyledText txtLog;
	private StyledText styledText;
	private TableColumn columnPara;
	private TableColumn columnValue;
	private TableColumn columnCondition;
	private TableColumn columnTrue;
	private TableColumn columnFalse;
	private Button btnOpen;
	private Button btnStandard;
	
	String sourceFile;
	private Button btnGen;
	private Button btnExit;
	private Button btnFirst;
	private Button btnScan;
	private Button btnShow;
	private Button btnPrev;
	private Button btnNext;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			View window = new View();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		control = new Control();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(940, 750);
		shell.setText("Test Case Generation");
		txtLog = new StyledText(shell, SWT.BORDER|SWT.H_SCROLL|SWT.V_SCROLL);
		txtLog.setEditable(false);
		txtLog.setBounds(10, 423, 912, 284);
		Font font = new Font(Display.getCurrent(), "Courier New", 12, SWT.NONE);
        txtLog.setFont(font);
        
        styledText = new StyledText(shell, SWT.BORDER|SWT.H_SCROLL|SWT.V_SCROLL);
        styledText.setEditable(false);
        styledText.setBounds(10, 10, 580, 407);
        styledText.setFont(font);

        table1 = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		font = new  Font(Display.getCurrent(), "Courier New", 10, SWT.NONE);
		table1.setFont(font);
		table1.setBounds(600, 10, 160, 197);
		table1.setHeaderVisible(true);
		table1.setLinesVisible(true);
		
		columnPara = new TableColumn(table1, SWT.CENTER);
		columnPara.setWidth(100);
		columnPara.setText("Parameters");
		
		columnValue = new TableColumn(table1, SWT.LEFT);
		columnValue.setWidth(60);
		columnValue.setText("Value");
		
		table2 = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table2.setFont(font);
		table2.setBounds(602, 213, 320, 204);
		table2.setHeaderVisible(true);
		table2.setLinesVisible(true);
		
		columnCondition = new TableColumn(table2, SWT.RIGHT);
		columnCondition.setWidth(180);
		columnCondition.setText("Conditions");
		
		columnTrue = new TableColumn(table2, SWT.LEFT);
		columnTrue.setWidth(70);
		columnTrue.setText("True");
		
		columnFalse = new TableColumn(table2, SWT.LEFT);
		columnFalse.setWidth(70);
		columnFalse.setText("False");
		
		btnOpen = new Button(shell, SWT.NONE);
		btnOpen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				FileDialog openfile = new FileDialog(shell);
				sourceFile = openfile.open();
		        
		        if (sourceFile != null) {
		            String source = control.readSourceFile(sourceFile);
		            changeSourceText(source);
		            txtLog.setText("");
		            btnStandard.setEnabled(true);
		        }
			}
		});
		btnOpen.setBounds(800, 10, 100, 20);
		btnOpen.setText("Open Source");
		
		btnStandard = new Button(shell, SWT.NONE);
		btnStandard.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String standardSource = control.standardSource(sourceFile);
				changeSourceText(standardSource);
				printParameterList();
				try {
					printConditionsList();
				} catch (CompilationException e) {
					e.printStackTrace();
				}
				btnStandard.setEnabled(false);
				btnScan.setEnabled(true);
			}
		});
		btnStandard.setBounds(800, 35, 100, 20);
		btnStandard.setText("Standard Source");
		btnStandard.setEnabled(false);
		
		btnScan = new Button(shell, SWT.NONE);
		btnScan.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				txtLog.setText(control.scanCondition());
				btnScan.setEnabled(false);
				btnFirst.setEnabled(true);
			}
		});
		btnScan.setText("Scan Condition");
		btnScan.setEnabled(false);
		btnScan.setBounds(800, 60, 100, 20);
		
		btnFirst = new Button(shell, SWT.NONE);
		btnFirst.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				txtLog.setText(control.GenerateSolvable());
				btnFirst.setEnabled(false);
				btnGen.setEnabled(true);
			}

		});
		btnFirst.setText("Generate Solvable");
		btnFirst.setBounds(800, 85, 100, 20);
		btnFirst.setEnabled(false);
		
		btnGen = new Button(shell, SWT.NONE);
		btnGen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
				//control.GenerateSolvable();
				txtLog.setText(control.RunGA());
				btnGen.setEnabled(false);
				btnShow.setEnabled(true);
			}

		});
		btnGen.setText("Generate Unsolvable");
		btnGen.setBounds(800, 110, 100, 20);
		btnGen.setEnabled(false);
		
		btnShow = new Button(shell, SWT.NONE);
		btnShow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				txtLog.setText(control.showAllTestCase());
				UpdateConditionList();
				btnShow.setEnabled(false);
			}
		});
		btnShow.setText("Show All TC");
		btnShow.setEnabled(false);
		btnShow.setBounds(800, 135, 100, 20);
		
		btnExit = new Button(shell, SWT.NONE);
		btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.dispose();
			}
		});
		btnExit.setText("Exit");
		btnExit.setBounds(800, 187, 100, 20);
		btnExit.setEnabled(true);
		
		btnPrev = new Button(shell, SWT.NONE);
		btnPrev.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				ArrayList<Integer> testcase = control.getPrevTestCase();
				UpdateTestCase(testcase);
				//UpdateSlide();
			}
		});
		btnPrev.setText("Prev");
		btnPrev.setEnabled(true);
		btnPrev.setBounds(800, 161, 50, 20);
		
		btnNext = new Button(shell, SWT.NONE);
		btnNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				ArrayList<Integer> testcase = control.getNextTestCase();
				UpdateTestCase(testcase);
				//UpdateSlide();
			}
		});
		btnNext.setText("Next");
		btnNext.setEnabled(true);
		btnNext.setBounds(850, 161, 50, 20);
	}
	

	protected void UpdateConditionList() {
		ArrayList<Boolean> trueList = control.getTrueList();
		ArrayList<Boolean> falseList = control.getFalseList();
		int c=1;
		TableItem[] items = table2.getItems();
		for(int i=0; i<trueList.size(); i++)
		{
			if(trueList.get(i)== true)
				items[i].setText(c, "X");
			else
				items[i].setText(c, "O");
		}
		c=2;
		for(int i=0; i<falseList.size(); i++)
		{
			if(falseList.get(i)== true)
				items[i].setText(c, "X");
			else
				items[i].setText(c, "O");
		} 
	}
	
	protected void UpdateTestCase(ArrayList<Integer> testcase)
	{
		int c=1;
		TableItem[] items = table1.getItems();
		for(int i=0; i<testcase.size(); i++)
		{
			items[i].setText(c, testcase.get(i).toString());
		}
	}

	protected void SetValue(ArrayList<String> testcase) 
	{
		int c=1;
		TableItem[] items = table1.getItems();
		for(int i=0; i<testcase.size(); i++)
		{
			items[i].setText(c, testcase.get(i));
		}
	}

	protected void printConditionsList() throws CompilationException 
	{
		table2.removeAll();
		ArrayList<String> listCondition = control.getConditionList();
		int c=0;
		for(int i=0; i<listCondition.size(); i++)
		{
			TableItem item = new TableItem(table2, SWT.CENTER);
			item.setText(c, listCondition.get(i));
		}
	}
	
	protected void UpdateSlide()
	{
		//Color criteriaColor = new Color(Display.getCurrent(), 255, 166, 107);
		Color highlightColor = Display.getCurrent().getSystemColor(SWT.COLOR_CYAN);
				
		ArrayList<Integer> slide = control.getSlide();
		if(slide != null)
		{
			int size = slide.size();
			StyleRange[] ranges = new StyleRange[size];
            for (int i = 0; i < size; i++) {
                int line = slide.get(i) - 1 ;
                // find the offset of the beginning of the line
                int offsetLine = this.styledText.getOffsetAtLine(line);
                while (this.styledText.getTextRange(offsetLine, 1).equals("\t")
                        || this.styledText.getTextRange(offsetLine, 1).equals(" ")) {
                    offsetLine++;
                }
                // the lenght of text need to be highlight
                int length = this.styledText.getOffsetAtLine(line + 1) - offsetLine;
                
                // create new StyleRange
                
                ranges[i] = new StyleRange(offsetLine, length, null, highlightColor);
                
            }
            this.styledText.setStyleRanges(ranges);
		}
	}

	protected void printParameterList() 
	{
		table1.removeAll();
		ArrayList<String> listPara = control.getParaList();
		int c=0;
		for(int i=0; i<listPara.size(); i++)
		{
			TableItem item = new TableItem(table1, SWT.CENTER);
			item.setText(c, listPara.get(i));
		}
	}

	private void changeSourceText(String source) {
		styledText.setText(source);		
	}
}
