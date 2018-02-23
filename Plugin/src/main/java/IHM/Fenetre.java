package IHM;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame{
	/**
	 * Class of IHM    
	 * */
	private static final long serialVersionUID = 1L;
	private JMenuBar menu = new JMenuBar();
	private JMenu file = new JMenu("File");
	private JMenu tools =new JMenu("Tools");
	private JMenu help= new JMenu("Help");
	
	private JMenuItem new_file= new JMenuItem("New");
	private JMenuItem open= new JMenuItem("Open");

	private JMenuItem save= new JMenuItem("Save");
	private JMenuItem exit= new JMenuItem("Exit");
	private JTextArea text;
	
	/*The constructor of the IHM*/
	public Fenetre(){
		
		this.text = new JTextArea();
	
		JScrollPane scroll = new JScrollPane(this.text);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 0, 300, 100);
		
		
		
		this.setSize(800, 600);
		
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    
	    this.file.add(this.new_file);
	    this.file.add(this.open);
	    this.file.add(this.save);
	    this.file.add(this.exit);
	    this.setSize(this.getWidth(), this.getHeight());
	    this.exit.addActionListener(new ActionListener(){

	        public void actionPerformed(ActionEvent event){

	          System.exit(0);

	        }

	      });
	    this.new_file.addActionListener(new NewFile(this.text));
	    this.open.addActionListener(new OpenFile(this.text));
	    this.save.addActionListener(new SaveFile(this.text));
	    this.menu.add(this.file);
	    this.menu.add(this.tools);
	    this.menu.add(this.help);
	    
	    this.setJMenuBar(menu);
	    this.add(scroll);    
		this.setVisible(true);
	}
	/*
	 * A getter of the MenuBAr
	 * @return JMenuBAr Object 
	 * */
	public JMenuBar getMenu(){
		return this.menu;
	}
	/*
	 * A getter of The TextArea
	 * @return JTextArea Object
	 * */
	public JTextArea getTextArea(){
		return this.text;
	}

}
