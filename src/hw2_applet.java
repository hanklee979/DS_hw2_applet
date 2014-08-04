import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.Font;

// 260min pm05:47

public class hw2_applet extends JApplet {
	public hw2_applet() {
	}

	private JTextField textfield_number_start;
	private JTextField textfield_number_end;
	private JTextArea input_matrix = new JTextArea();
	private JTextArea textArea_2 = new JTextArea();
	private JTextArea textArea_3 = new JTextArea();

	// textfield
	int number_start;
	int number_end;
	
	// deal matrix
	String Array_BeforeSplit = "";
	String[] Array_AfterSplit = new String[50];	
	ArrayList<Integer> matrix_int = new ArrayList<Integer>();
	
	// matrix (array)
	int A[][] = new int[5][5];
	int A2[][] = new int[5][5];
	int A3[][] = new int[5][5];
	int A4[][] = new int[5][5];
	int sum[][] = new int[5][5];
	
	// turn to array
	void deal_matrix(){
		Array_BeforeSplit = input_matrix.getText();	
		Array_AfterSplit = Array_BeforeSplit.split("[, \n]+");
		
		// turn string to int
		for(int i = 0 ; i < Array_AfterSplit.length ; i++){
			matrix_int.add( Integer.valueOf( Array_AfterSplit[i] ) );
		}		
		
		// determine size of matrix
		switch( Array_AfterSplit.length ){
			case 25:
				for(int i = 0 ; i < 5 ; i++){
					for(int j = 0 ; j < 5 ; j++){				
						A[i][j] = matrix_int.get( i * 5 + j );
					}
				}
				break;
				
			case 16:
				for(int i = 0 ; i < 4 ; i++){
					for(int j = 0 ; j < 4; j++){				
						A[i][j] = matrix_int.get( i * 4 + j );
					}
				}
				break;
			
			case 9:
				for(int i = 0 ; i < 3 ; i++){
					for(int j = 0 ; j < 3; j++){				
						A[i][j] = matrix_int.get( i * 3 + j );
					}
				}
				break;
				
			case 4:
				for(int i = 0 ; i < 2 ; i++){
					for(int j = 0 ; j < 2; j++){				
						A[i][j] = matrix_int.get( i * 2 + j );
					}
				}
				break;
		}		
	}
	
	// get A2,A3,A4 and sum
	void calculate(){
		
		// calculate A2
		for(int i = 0 ; i < 5 ; i++){
			for(int j = 0 ; j < 5 ; j++){
				A2[i][j] = A[i][0] * A[0][j] + A[i][1] * A[1][j] + A[i][2] * A[2][j] + A[i][3] * A[3][j];
			}
		}
		
		// calculate A3
		for(int i = 0 ; i < 5 ; i++){
			for(int j = 0 ; j < 5 ; j++){
				A3[i][j] = A2[i][0] * A[0][j] + A2[i][1] * A[1][j] + A2[i][2] * A[2][j] + A2[i][3] * A[3][j];
			}
		}
		
		// calculate A4
		for(int i = 0 ; i < 5 ; i++){
			for(int j = 0 ; j < 5 ; j++){
				A4[i][j] = A3[i][0] * A[0][j] + A3[i][1] * A[1][j] + A3[i][2] * A[2][j] + A3[i][3] * A[3][j];
			}
		}	
		
		// calculate sum
		for(int i = 0 ; i < 5 ; i++){
			for(int j = 0 ; j < 5 ; j++){
				sum[i][j] = A[i][j] + A2[i][j] + A3[i][j] + A4[i][j];
			}
		}		
	}
	
	public void init(){
		getContentPane().setLayout(null);
		
		// Label
		JLabel label = new JLabel("\u4E3B\u984C\uFF1A\u627E\u51FA\u6709\u5411\u5716\u7684\u5169\u9EDE\u8DEF\u5F91\u53CA\u76F8\u95DC\u8A08\u7B97");
		label.setBounds(10, 10, 248, 15);
		getContentPane().add(label);
		JLabel label_1 = new JLabel("\u8F38\u5165\u6709\u5411\u5716\u77E9\u9663\u8CC7\u6599\uFE59\u4EE5\uFF0C\u5206\u9694\u4E14\u7BC0\u9EDE\u4EE5\u7DE8\u865F1\u30012\u30013\u2026\u2026\uFF0C\u6700\u591A5\u500B\u7BC0\u9EDE\uFE5A");
		label_1.setBounds(10, 35, 440, 15);
		getContentPane().add(label_1);
		JLabel label_3 = new JLabel("\u8F38\u5165\u8D77\u9EDE\u7DE8\u865F\uFF1A");
		label_3.setBounds(16, 167, 97, 15);
		getContentPane().add(label_3);
		JLabel label_4 = new JLabel(" \uFF0C\u7D42\u9EDE\uFF1A");
		label_4.setBounds(216, 167, 66, 15);
		getContentPane().add(label_4);
		
		// textfield
		textfield_number_start = new JTextField();
		textfield_number_start.setBounds(110, 164, 96, 21);
		getContentPane().add(textfield_number_start);
		textfield_number_start.setColumns(10);
		
		textfield_number_end = new JTextField();
		textfield_number_end.setBounds(274, 164, 96, 21);
		getContentPane().add(textfield_number_end);
		textfield_number_end.setColumns(10);
		
		
		// textarea
		input_matrix.setBounds(55, 52, 327, 102);
		getContentPane().add(input_matrix);
		textArea_2.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		textArea_2.setBounds(58, 212, 327, 98);
		getContentPane().add(textArea_2);
		textArea_3.setTabSize(4);
		textArea_3.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		textArea_3.setBounds(55, 353, 327, 325);
		getContentPane().add(textArea_3);
		
		
		// show route
		JButton show_route = new JButton("\u627E\u51FA\u6240\u6709\u8DEF\u5F91");
		show_route.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deal_matrix();
				
				// get start and end node
				 number_start = Integer.valueOf( textfield_number_start.getText() );
				 number_end   = Integer.valueOf( textfield_number_end.getText() );
				
				// record line 
				int n1 = 0,n2 = 0,n3 = 0; 
				 
				textArea_2.setText("節點 " + number_start + " 至節點 " + number_end + " 之所有路徑：\n");
				
				if(number_start == number_end)
					textArea_2.setText( textArea_2.getText() + "(1) 經1個邊: 無符合路線\n" );					
				else if(number_start > Math.sqrt(Array_AfterSplit.length) || number_end > Math.sqrt(Array_AfterSplit.length))	
					textArea_2.setText( textArea_2.getText() + "(1) 經1個邊: 無符合路線\n" );	
				else
					textArea_2.setText( textArea_2.getText() + "(1) 經1個邊:" + number_start + "->" + number_end + "\n");
				
				// 判定路線是否存在，若是則記錄經過的點
				for(int i = 4 ; i >= 0 ; i--){
					if(A[number_start - 1][i] > 0 && A[i][number_end - 1] > 0 && i != (number_start-1) && i != (number_end-1)){
						n1 = i+1;
					}
				}
				
				if(n1 != 0)
					textArea_2.setText( textArea_2.getText() + "(2) 經2個邊:" + number_start + "->" + n1 + "->" + number_end+ "\n");					
				else
					textArea_2.setText( textArea_2.getText() + "(2) 經2個邊: 無符合路線\n") ;
				
				// initialize
				n1 = 0;
				
				// 判定路線是否存在，若是則記錄經過的點
				for(int i = 4; i >= 0 ;i--){
					for(int k = 4; k >= 0 ;k--){
						if(A[number_start-1][i] > 0 && A[i][k] > 0 && A[k][number_end-1] > 0 && i != (number_start-1) && i != (number_end-1) && k != (number_start-1) && k != (number_end-1)){
							n1 = i+1;
							n2 = k+1;
						}
					}
				}
				
				if(n1 != 0 && n2 != 0)
					textArea_2.setText( textArea_2.getText() + "(3) 經3個邊:" + number_start + "->" + n1 + "->" + n2 + "->" + number_end+ "\n");					
				else
					textArea_2.setText( textArea_2.getText() + "(3) 經3個邊: 無符合路線\n") ;
				
				// initialize
				n1 = 0;
				n2 = 0;

				// 判定路線是否存在，若是則記錄經過的點
				for(int i = 4; i >= 0 ;i--){
					for(int j = 4; j >= 0 ;j--){
						for(int k = 4; k >= 0 ;k--){		
							if(A[number_start-1][i] > 0 && A[i][j] > 0 && A[j][k] > 0 && A[k][number_end-1] > 0 && i != (number_start-1) && i != (number_end-1) && j != (number_start-1) && j != (number_end-1)&& k != (number_start-1) && k != (number_end-1)){
								n1 = i+1;
								n2 = j+1;
								n3 = k+1;
							}
						}
					}
				}		
				
				if(n1 != 0 && n2 != 0 && n3 != 0)
					textArea_2.setText( textArea_2.getText() + "(4) 經4個邊:" + number_start + "->" + n1 + "->" + n2 + "->" + n3 + "->" + number_end+ "\n");					
				else
					textArea_2.setText( textArea_2.getText() + "(4) 經4個邊: 無符合路線\n") ;
				
			}
		});
		show_route.setBounds(13, 187, 118, 23);
		getContentPane().add(show_route);
		
		
		// show result
		JButton show_result = new JButton("\u5217\u51FA\u77E9\u9663\u8A08\u7B97\u7D50\u679C");
		show_result.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deal_matrix();
				calculate();
				
				// A x A
				textArea_3.setText("A x A = \n");
				for(int i = 0 ; i < Math.sqrt(Array_AfterSplit.length) ; i++){
					for(int j = 0 ; j < Math.sqrt(Array_AfterSplit.length) ; j++){
						// new line or ,
						if( j == Math.sqrt(Array_AfterSplit.length) - 1 )
							textArea_3.setText( textArea_3.getText() + A2[i][j] + "\n");	
						else
							textArea_3.setText( textArea_3.getText() + A2[i][j] + "," );								
					}
				}
				
				// A x A x A
				textArea_3.setText( textArea_3.getText() + "A x A x A = \n");
				for(int i = 0 ; i < Math.sqrt(Array_AfterSplit.length) ; i++){
					for(int j = 0 ; j < Math.sqrt(Array_AfterSplit.length) ; j++){
						// new line or ,
						if( j == Math.sqrt(Array_AfterSplit.length) - 1 )
							textArea_3.setText( textArea_3.getText() + A3[i][j] + "\n");	
						else
							textArea_3.setText( textArea_3.getText() + A3[i][j] + "," );								
					}
				}				
				
				// sum
				textArea_3.setText( textArea_3.getText() + "\nS = \n");
				for(int i = 0 ; i < Math.sqrt(Array_AfterSplit.length) ; i++){
					for(int j = 0 ; j < Math.sqrt(Array_AfterSplit.length) ; j++){
						// new line or ,
						if( j == Math.sqrt(Array_AfterSplit.length) - 1 )
							textArea_3.setText( textArea_3.getText() + sum[i][j] + "\n");	
						else
							textArea_3.setText( textArea_3.getText() + sum[i][j] + "," );								
					}
				}				
				
				
			}				
		});
		show_result.setBounds(10, 320, 148, 23);
		getContentPane().add(show_result);
		
		
		// clear
		JButton clear = new JButton("\u6E05\u9664\u6240\u6709\u5C0D\u8A71\u6846\u5167\u5BB9 ");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input_matrix.setText ( "" ) ;		
				textArea_2.setText ( "" ) ;		
				textArea_3.setText ( "" ) ;						
				textfield_number_start.setText ( "" );
				textfield_number_end.setText ( "" );
				
				for(int i = 0 ; i < 5 ; i++){
					for(int j = 0 ; j < 5 ; j++){
						A[i][j] = 0;
						A2[i][j] = 0;
						A3[i][j] = 0;
						A4[i][j] = 0;
						sum[i][j]= 0;
					}
				}
			}
		});
		clear.setBounds(55, 688, 158, 22);
		getContentPane().add(clear);
		
		
		// show default matrix 
		JButton create_default = new JButton("\u7522\u751F\u9810\u8A2D\u77E9\u9663");
		create_default.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input_matrix.setText ( "0,1,0,1,\n"
									 + "1,0,0,0,\n" 
									 + "1,1,0,1,\n"
									 + "0,1,0,0"  );			
			}
		});
		create_default.setBounds(260, 688, 120, 22);
		getContentPane().add(create_default);


	}
}
