import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	JPanel panel;
	DefaultTableModel model = new DefaultTableModel(); 
	JTable table = new JTable(model); 
	public MyFrame(){
		super();
		this.setSize(480, 600);
		this.setVisible(true);
		this.setTitle("N-hetmanów");
		this.setResizable(false);
		/*
		this.panel = new JPanel();
		this.panel.setBackground(Color.WHITE);
		this.panel.setSize(480, 480);
		this.add(this.panel);*/
		

		add(table);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void setPanel(List<Point> list){
		
	}
	public void draw(List<Point> list) {
		for(int i=0;i<Properties.N;i++){
			model.addColumn(i);
		}
		for(int i=0;i<Properties.N;i++){
			model.addRow(Helper.createTab(list.get(i).x));
		}		
	}
}
