import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class hw2_applet extends JApplet {

	private JTextField number_start;
	private JTextField number_end;
	private JTextArea input_matrix = new JTextArea();
	private JTextArea textArea_1 = new JTextArea();
	private JTextArea textArea_2 = new JTextArea();
	private JTextArea textArea_3 = new JTextArea();

	
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
		label_3.setBounds(10, 300, 97, 15);
		getContentPane().add(label_3);
		JLabel label_4 = new JLabel(" \uFF0C\u7D42\u9EDE\uFF1A");
		label_4.setBounds(210, 300, 66, 15);
		getContentPane().add(label_4);
		
		// textfield
		number_start = new JTextField();
		number_start.setBounds(104, 297, 96, 21);
		getContentPane().add(number_start);
		number_start.setColumns(10);
		
		number_end = new JTextField();
		number_end.setBounds(268, 297, 96, 21);
		getContentPane().add(number_end);
		number_end.setColumns(10);
		
		// textarea
		input_matrix.setBounds(55, 60, 327, 87);
		getContentPane().add(input_matrix);
		
		textArea_1.setBounds(55, 190, 327, 87);
		getContentPane().add(textArea_1);
		
		textArea_2.setBounds(55, 358, 327, 87);
		getContentPane().add(textArea_2);
		
		textArea_3.setBounds(55, 488, 327, 229);
		getContentPane().add(textArea_3);
		
		
		// button
		JButton paint = new JButton("\u7E6A\u88FD\u6709\u5411\u5716");
		paint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		paint.setBounds(7, 157, 105, 23);
		getContentPane().add(paint);
		
		
		
		JButton show_route = new JButton("\u627E\u51FA\u6240\u6709\u8DEF\u5F91");
		show_route.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		show_route.setBounds(7, 325, 118, 23);
		getContentPane().add(show_route);
		
		
		
		JButton show_result = new JButton("\u5217\u51FA\u77E9\u9663\u8A08\u7B97\u7D50\u679C");
		show_result.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		show_result.setBounds(7, 455, 148, 23);
		getContentPane().add(show_result);
		
		
		// clear
		JButton clear = new JButton("\u6E05\u9664\u6240\u6709\u5C0D\u8A71\u6846\u5167\u5BB9 ");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input_matrix.setText ( "" ) ;
				textArea_1.setText ( "" ) ;			
				textArea_2.setText ( "" ) ;		
				textArea_3.setText ( "" ) ;						
				number_start.setText ( "" );
				number_end.setText ( "" );
			}
		});
		clear.setBounds(55, 727, 158, 23);
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
		create_default.setBounds(262, 727, 120, 23);
		getContentPane().add(create_default);


	}
}
