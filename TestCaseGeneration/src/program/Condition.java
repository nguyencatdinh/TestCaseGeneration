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

import org.eclipse.wb.swt.SWTResourceManager;

import transform.AST.CompilationException;

public class Condition {
	
	Control control;
	protected Shell shlConditionDetail;
	private StyledText styledText0;
	private StyledText styledText1;
	private StyledText styledText2;
	private StyledText styledText3;
	private Button btnGet;
	private Combo comboBox1;
	
	private Label lblSourceCode;
	
	private Font font;
	

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open(Control con) {
		Display display = Display.getDefault();
		control = con;
		createContents();
		shlConditionDetail.open();
		shlConditionDetail.layout();
		while (!shlConditionDetail.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlConditionDetail = new Shell();
		shlConditionDetail.setSize(915, 453);
		shlConditionDetail.setText("Condition Detail");
		
		font = new Font(Display.getCurrent(), "Courier New", 12, SWT.NONE);
		
		
		styledText0 = new StyledText(shlConditionDetail, SWT.BORDER|SWT.H_SCROLL|SWT.V_SCROLL);
		styledText0.setEditable(false);
		styledText0.setBounds(10, 110, 385, 150);
		styledText0.setFont(font);
        
        styledText1 = new StyledText(shlConditionDetail, SWT.BORDER|SWT.H_SCROLL|SWT.V_SCROLL);
		styledText1.setEditable(false);
		styledText1.setBounds(10, 266, 385, 135);
		styledText1.setFont(font);
		
		styledText2 = new StyledText(shlConditionDetail, SWT.BORDER|SWT.H_SCROLL|SWT.V_SCROLL);
		styledText2.setEditable(false);
		styledText2.setBounds(503, 110, 385, 150);
		styledText2.setFont(font);
		
		styledText3 = new StyledText(shlConditionDetail, SWT.BORDER|SWT.H_SCROLL|SWT.V_SCROLL);
		styledText3.setEditable(false);
		styledText3.setBounds(503, 266, 385, 135);
		styledText3.setFont(font);
		
		
		btnGet = new Button(shlConditionDetail, SWT.NONE);
		btnGet.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				int i = comboBox1.getSelectionIndex();
			}
		});
		btnGet.setBounds(253, 39, 142, 26);
		btnGet.setText("Get Condition");
		
		
		
		lblSourceCode = new Label(shlConditionDetail, SWT.NONE);
		lblSourceCode.setText("Conditions");
		lblSourceCode.setBounds(10, 11, 87, 26);
		
		comboBox1 = new Combo(shlConditionDetail, SWT.NONE);
		ArrayList<String> listCondition;
		try {
			listCondition = control.getConditionList();
			for(int i=0; i<listCondition.size(); i++)
			{
				comboBox1.add(listCondition.get(i), i);
			}
		} catch (CompilationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comboBox1.setBounds(10, 39, 237, 36);
		
		
		Button btnExit = new Button(shlConditionDetail, SWT.NONE);
		btnExit.setText("Exit");
		btnExit.setBounds(411, 39, 142, 26);
		
		Button btnTransform = new Button(shlConditionDetail, SWT.NONE);
		btnTransform.setText(">>");
		btnTransform.setBounds(419, 177, 67, 26);
		
		Button button = new Button(shlConditionDetail, SWT.NONE);
		button.setText(">>");
		button.setBounds(419, 320, 67, 26);
		
		Label lblNormalForm = new Label(shlConditionDetail, SWT.NONE);
		lblNormalForm.setText("Normal form");
		lblNormalForm.setBounds(10, 78, 87, 26);
		
		Label lblZForm = new Label(shlConditionDetail, SWT.NONE);
		lblZForm.setText("Z3 form");
		lblZForm.setBounds(507, 78, 87, 26);
		
		
	}
	

}
