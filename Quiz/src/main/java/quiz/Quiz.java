package quiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;

import Affichage.AnswerPanel;
import Affichage.Fenetre;
import Affichage.QuestionPanel;
import quiz.answers.Answer; ;

public class Quiz implements ActionListener{
	
	private List<Question> questions ;
	private JPanel panelQuestion;
	private JFrame fenetre;
	
	private BufferedReader in ;
	private PrintStream out ;
	

	public Quiz(Reader in , PrintStream out) {
		this.questions = new LinkedList<Question>() ;
		this.in = new BufferedReader(in) ;
		this.out = out ;
		}
	
	public Quiz() {
		this(new InputStreamReader(System.in) , System.out) ;
	}

	public void add(Question question) {questions.add(question) ;}
	
	private int ask(Question question) {
		Answer<?> answer = question.getAnswer() ;	
		out.println(question.getStatement()) ;
		String userAnswer = null;
		do {
			out.print("(" + answer.getGoodType() + ")") ;
			try {
				userAnswer = in.readLine() ;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (! answer.hasGoodType(userAnswer)) ;
		if (answer.isCorrect(userAnswer)) {
			int points = question.getPoints() ;
			out.println("correct (" + format(points) + ")") ;
			return points ;
		} else {
			out.println("incorrect, la bonne réponse était " + answer.toString()) ;
			return 0 ;
		}
	}
	
	private static String format(int points) {
		return "" + points + " point" + (points > 1?"s":"") ;
	}
	
	public void askAll(boolean graph) {
		
		if(graph){
			JPanel contener = new JPanel();
			
			for(Question q : this.questions){
				QuestionPanel qpanel = new QuestionPanel(q);
				contener.add(qpanel.qPanel());
			}
		
			contener.setLayout(new BoxLayout(contener, BoxLayout.Y_AXIS));
			this.panelQuestion=contener;
		
			
			
			this.fenetre = new Fenetre();
		
			
			
			JButton button = new JButton("Verifier!");
			button.setPreferredSize(new Dimension(30,30));
			button.setMaximumSize(new Dimension(30,30));
			button.setMinimumSize(new Dimension(30,30));
			JScrollPane scroll = new JScrollPane(this.panelQuestion);
			scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setBounds(0, 0, 600, this.fenetre.getHeight()-175);
			
			JPanel panel = new JPanel();
			JPanel scrollpanel = new JPanel(null);
			scrollpanel.setMaximumSize(this.fenetre.getSize());
			scrollpanel.setMinimumSize(this.fenetre.getSize());
			scrollpanel.setPreferredSize(this.fenetre.getSize());
		    scrollpanel.add(scroll);
			panel.setLayout(new BorderLayout());
			
			button.addActionListener(this);
			panel.add(button);
			
			
			
			
			this.fenetre.add(scrollpanel);
			this.fenetre.pack();
			this.fenetre.add(panel, BorderLayout.SOUTH);
			
		}
		else{
			int result = 0 ;
			for (Question question : this.questions) {
				result += this.ask(question) ;
				
			}
			
			out.println("Vous avez obtenu " + format(result)) ;
		}
		
	}
	
	
	
	
	
	public  void actionPerformed(ActionEvent e){
		boolean check=true;
		int result=0;
		Component[] components = this.panelQuestion.getComponents();
		JPanel correction = new JPanel();
		correction.setLayout(new BoxLayout(correction, BoxLayout.Y_AXIS));
		
		for(Component c : components) {
				if(c.getClass().equals(QuestionPanel.class)) {
						QuestionPanel q = (QuestionPanel)c;
						AnswerPanel answer =(AnswerPanel) q.getAnswerPanel();
						
						if(!answer.getAnswer().hasGoodType(answer.getUserAnswer())) {
							check=false;
							break;
						}
				if(answer.getAnswer().isCorrect(answer.getUserAnswer())) {
					result+=q.getQuestion().getPoints();
				}
				else{
					JPanel good_answer = new JPanel();
					good_answer.add(new JLabel(q.getQuestion().getStatement()));
					good_answer.add(new JLabel("Bonne réponse: "+answer.getAnswer().toString()));
					good_answer.setLayout(new BoxLayout(good_answer, BoxLayout.Y_AXIS));
					
					correction.add(good_answer);
				}
						
				}
		}
				
			
			
		
		 if(check==false) {
			 JFrame frame = new JFrame();
			 frame.setSize(400,200);
			 JPanel panel = new JPanel();
			 JLabel label = new JLabel("Veuillez repondre a toutes les questions");
			 panel.add(label);
			 panel.add(new JLabel("Verifier le type de réponse pour chaque questions!"));
			 frame.add(panel);
			 frame.setLocationRelativeTo(null);
			 frame.setVisible(true);
			 
		 }
		 else {
			 this.fenetre.getContentPane().setVisible(false);
			 JFrame frame = new JFrame();
			 frame.setSize(500,300);
			 JPanel panel = new JPanel();
			 JLabel label = new JLabel("Vous avez obtenu: "+result);
			 panel.add(label);
			 panel.add(correction);
			 frame.add(panel);
			 frame.setLocationRelativeTo(null);
			 frame.setVisible(true);
		 }
		 
			
		
					
			
  }
		

}
