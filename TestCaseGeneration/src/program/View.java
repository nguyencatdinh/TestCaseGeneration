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
import org.eclipse.wb.swt.SWTResourceManager;

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
	private Button btnViewDetail;
	private Button btnGenerateAllTcs;
	private Label lblConditions;
	private Label lblLogs;
	private StyledText styledTextAST;
	private Label lblSourceCode;
	private Label lblAstTree;
	private Button btnViewAst;
	
	private Font font;
	private Condition window;
	

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
		shell.setSize(1383, 1008);
		shell.setText("Test Case Generation");
		txtLog = new StyledText(shell, SWT.BORDER|SWT.H_SCROLL|SWT.V_SCROLL);
		txtLog.setEditable(false);
		txtLog.setBounds(688, 646, 670, 307);
		font = new Font(Display.getCurrent(), "Courier New", 12, SWT.NONE);
        txtLog.setFont(font);
        
        styledText = new StyledText(shell, SWT.BORDER|SWT.H_SCROLL|SWT.V_SCROLL);
        styledText.setEditable(false);
        styledText.setBounds(10, 46, 581, 565);
        styledText.setFont(font);
        
        styledTextAST = new StyledText(shell, SWT.BORDER|SWT.H_SCROLL|SWT.V_SCROLL);
        styledTextAST.setEditable(false);
        styledTextAST.setFont(font);
		styledTextAST.setBounds(769, 46, 589, 565);

        table1 = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		//font = new  Font(Display.getCurrent(), "Courier New", 12, SWT.NONE);
		table1.setFont(font);
		table1.setBounds(10, 646, 237, 307);
		table1.setHeaderVisible(true);
		table1.setLinesVisible(true);
		
		columnPara = new TableColumn(table1, SWT.CENTER);
		columnPara.setWidth(136);
		columnPara.setText("Parameters");
		
		columnValue = new TableColumn(table1, SWT.LEFT);
		columnValue.setWidth(98);
		columnValue.setText("Value");
		
		table2 = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table2.setFont(font);
		table2.setBounds(269, 646, 399, 307);
		table2.setHeaderVisible(true);
		table2.setLinesVisible(true);
		
		columnCondition = new TableColumn(table2, SWT.RIGHT);
		columnCondition.setWidth(219);
		columnCondition.setText("Conditions");
		
		columnTrue = new TableColumn(table2, SWT.LEFT);
		columnTrue.setWidth(90);
		columnTrue.setText("True");
		
		columnFalse = new TableColumn(table2, SWT.LEFT);
		columnFalse.setWidth(97);
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
		            btnGen.setEnabled(false);
		        	btnFirst.setEnabled(false);
		        	btnScan.setEnabled(false);
		        	btnShow.setEnabled(false);
		        	btnPrev.setEnabled(false);
		        	btnNext.setEnabled(false);
		        	btnViewDetail.setEnabled(false);
		        	btnGenerateAllTcs.setEnabled(false);
		        	btnViewAst.setEnabled(false);
		        }
			}
		});
		btnOpen.setBounds(616, 46, 142, 36);
		btnOpen.setText("Open Source");
		
		btnStandard = new Button(shell, SWT.NONE);
		btnStandard.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String standardizeSource = control.standardizeSource(sourceFile);
				changeSourceText(standardizeSource);
				printParameterList();
				try {
					printConditionsList();
				} catch (CompilationException e) {
					e.printStackTrace();
				}
				btnStandard.setEnabled(false);
				btnViewAst.setEnabled(true);
				btnScan.setEnabled(true);
			}
		});
		btnStandard.setBounds(616, 88, 142, 34);
		btnStandard.setText("Standard Source");
		btnStandard.setEnabled(false);
		
		btnViewAst = new Button(shell, SWT.NONE);
		btnViewAst.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String astTree = control.astTree(sourceFile);
				styledTextAST.setText(astTree);
				btnViewAst.setEnabled(false);
			}
		});
		btnViewAst.setText("View AST");
		btnViewAst.setEnabled(false);
		btnViewAst.setBounds(616, 128, 142, 36);
		
		
		btnScan = new Button(shell, SWT.NONE);
		btnScan.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				txtLog.setText(control.scanCondition());
				btnScan.setEnabled(false);
				btnViewDetail.setEnabled(true);
				btnGenerateAllTcs.setEnabled(true);
				btnFirst.setEnabled(true);
			}
		});
		btnScan.setText("Scan Condition");
		btnScan.setEnabled(false);
		btnScan.setBounds(616, 170, 142, 36);
		
		
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
		btnFirst.setBounds(616, 296, 142, 36);
		btnFirst.setEnabled(false);
		
		btnGen = new Button(shell, SWT.NONE);
		btnGen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
				//control.GenerateSolvable();
				txtLog.setText(control.GenerateUnsolvable());
				btnGen.setEnabled(false);
				btnShow.setEnabled(true);
			}

		});
		btnGen.setText("Generate Unsolvable");
		btnGen.setBounds(616, 338, 142, 36);
		btnGen.setEnabled(false);
		
		btnShow = new Button(shell, SWT.NONE);
		btnShow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				txtLog.setText(control.showAllTestCase());
				UpdateConditionList();
				btnShow.setEnabled(false);
				btnNext.setEnabled(true);
				btnPrev.setEnabled(true);
			}
		});
		btnShow.setText("Show All TestCase");
		btnShow.setEnabled(false);
		btnShow.setBounds(616, 380, 142, 36);
		
		btnExit = new Button(shell, SWT.NONE);
		btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.dispose();
			}
		});
		btnExit.setText("Exit");
		btnExit.setBounds(616, 464, 142, 36);
		btnExit.setEnabled(true);
		
		btnPrev = new Button(shell, SWT.NONE);
		btnPrev.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				ArrayList<Object> testcase = control.getPrevTestCase();
				UpdateTestCase(testcase);
				//UpdateSlide();
			}
		});
		btnPrev.setText("Prev");
		btnPrev.setEnabled(false);
		btnPrev.setBounds(616, 422, 66, 36);
		
		btnNext = new Button(shell, SWT.NONE);
		btnNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				ArrayList<Object> testcase = control.getNextTestCase();
				UpdateTestCase(testcase);
				//UpdateSlide();
			}
		});
		btnNext.setText("Next");
		btnNext.setEnabled(false);
		btnNext.setBounds(688, 422, 70, 36);
		
		Label lblLog = new Label(shell, SWT.NONE);
		lblLog.setBounds(10, 617, 87, 26);
		lblLog.setText("Parameters");
		
		lblConditions = new Label(shell, SWT.NONE);
		lblConditions.setText("Conditions");
		lblConditions.setBounds(272, 617, 87, 26);
		
		lblLogs = new Label(shell, SWT.NONE);
		lblLogs.setText("Logs");
		lblLogs.setBounds(688, 617, 87, 26);
		
		btnViewDetail = new Button(shell, SWT.NONE);
		btnViewDetail.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				window = new Condition();
				window.open(control);
			}
		});
		btnViewDetail.setText("View Con Detail");
		btnViewDetail.setEnabled(false);
		btnViewDetail.setBounds(616, 212, 142, 36);
		
		btnGenerateAllTcs = new Button(shell, SWT.NONE);
		btnGenerateAllTcs.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				txtLog.setText(control.GenerateSolvable());
				txtLog.append(control.GenerateUnsolvable());
				btnGenerateAllTcs.setEnabled(false);
				btnFirst.setEnabled(false);
				btnShow.setEnabled(true);
			}
		});
		btnGenerateAllTcs.setText("Generate All TCs");
		btnGenerateAllTcs.setEnabled(false);
		btnGenerateAllTcs.setBounds(616, 254, 142, 36);
		
		
		
		lblSourceCode = new Label(shell, SWT.NONE);
		lblSourceCode.setText("Source code");
		lblSourceCode.setBounds(10, 11, 87, 26);
		
		lblAstTree = new Label(shell, SWT.NONE);
		lblAstTree.setText("AST Tree");
		lblAstTree.setBounds(769, 11, 87, 26);
		
		
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
	
	protected void UpdateTestCase(ArrayList<Object> testcase)
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
                int line = slide.get(i);
                // find the offset of the beginning of the line
                int offsetLine = this.styledText.getOffsetAtLine(line -1);
                while (this.styledText.getTextRange(offsetLine, 1).equals("\t")
                        || this.styledText.getTextRange(offsetLine, 1).equals(" ")) {
                    offsetLine++;
                }
                // the lenght of text need to be highlight
                int length = this.styledText.getOffsetAtLine(line) - offsetLine;
                
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
