package quiz.answers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Le singleton AnswerFactory avec les 2 versions de méthode de fabrique, une non OCP et 
 * une OCP. Les 2 supposent l'existence d'un constructeur à un paramètre de type String
 * pour chaque type de réponse.
 */
public class AnswerFactory  {

	public final static AnswerFactory FACTORY = new AnswerFactory() ;
	
	private AnswerFactory(){}
	
	public Answer<?> build(String answer) {// NON OCP
		
		try{
			return new NumericalAnswer(answer);		
		} catch (IllegalArgumentException e1) {
			
		try{
			return new MultiAnswer(answer) ;		
		} catch (IllegalArgumentException e3) {
			
		try{
			return new YesNoAnswer(answer) ;		
		} catch (IllegalArgumentException e2) {
			
		try{
			return new MultipleChoiceAnswer(answer) ;		
		} catch (IllegalArgumentException e4) {
			return new TextualAnswer(answer);
		}}}}
		
	}

	public Answer<?> build(String className , String answer) {
			Class<?> c ; Constructor<?> r ;
			try {
				c = Class.forName("quiz."+className);
			} catch (ClassNotFoundException e) {
				throw new IllegalArgumentException("Unknown class : " + className) ;
			}
			try {
				r = c.getConstructor(String.class) ;
			} catch (SecurityException e) {
				throw new IllegalArgumentException("Security violation") ;
			} catch (NoSuchMethodException e) {
				throw new IllegalArgumentException("Constructor is missing") ;
			}
			try {
				return (Answer<?>) r.newInstance(answer) ;
			} catch (IllegalAccessException e) {
				throw new IllegalArgumentException("Security violation") ;
			} catch (InvocationTargetException e) {
				throw new IllegalArgumentException("Invocation error") ;
			} catch (InstantiationException e) {
				throw new IllegalArgumentException("Construction error") ;
			}
	}

}
