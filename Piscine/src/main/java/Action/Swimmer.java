package Action;
import ressource.*;
import java.util.*;


public class Swimmer extends SequentialScheduler{
	private RessourceUser<Cubicle> user_cubicle;
	private RessourceUser<Basket> user_basket;
	
	private ForeseeableAction undress_action;
	private ForeseeableAction swim_action;
	private ForeseeableAction dress_action;
	
	private String name;
	private BasketPool basket_pool;
	private CubiclePool cubicle_pool;
	
	private int undress_time;
	private int dress_time;
	private int swim_time;
	private int inc;
	private int inc2;
	private int swim_inc;


	/*
	 * Constructor of an object Swimmer 
	 * @param name : the name of the swimmer
	 * @param baskets : an object BasketPool
	 * @param cubicle : an object CubiclePool
	 * @param a : a integer that represents the time that the swimmer takes in undressing
	 * @param c : a integer that represents the time that the swimmer takes in dressing
	 * @param b : a integer that represents the time that the swimmer takes in swimming
	 */
	public Swimmer(String name, BasketPool baskets, CubiclePool cubicle, int a, int b, int c){
		this.undress_time=a;
		this.dress_time=c;
		this.swim_time=b;
		this.inc=1;
		this.inc2=1;
		this.swim_inc=1;
		
		this.name=name;
		this.user_basket = new RessourceUser<Basket>();
		this.user_cubicle = new RessourceUser<Cubicle>();
		this.undress_action = new ForeseeableAction(a);
		this.swim_action = new ForeseeableAction(b);
		this.dress_action = new ForeseeableAction(c);
		this.basket_pool = baskets;
		this.cubicle_pool = cubicle;
		TakeRessourceAction<Cubicle> take_cubicle = new TakeRessourceAction<Cubicle>(this.cubicle_pool, this.user_cubicle, this.getName() +"'s turn\n"+this.getName()+" trying to take ressource from cubicle... ");
		TakeRessourceAction<Basket> take_basket = new TakeRessourceAction<Basket>(this.basket_pool, this.user_basket, this.getName() +"'s turn\n"+this.getName()+" trying to take ressource from basket...");
		FreeRessourceAction<Cubicle>free_cubicle = new FreeRessourceAction<Cubicle>(this.cubicle_pool, this.user_cubicle, this.getName() +"'s turn\n"+this.getName()+ " freeing ressource from cubicle");
		FreeRessourceAction<Basket> free_basket = new FreeRessourceAction<Basket>(this.basket_pool, this.user_basket, this.getName() +"'s turn\n"+this.getName()+ " freeing ressource from basket");
		TakeRessourceAction<Cubicle> take_cubicle2 = new TakeRessourceAction<Cubicle>(this.cubicle_pool, this.user_cubicle, this.getName() +"'s turn\n"+this.getName()+" trying to take ressource from cubicle... ");
		FreeRessourceAction<Cubicle> free_cubicle2 = new FreeRessourceAction<Cubicle>(this.cubicle_pool, this.user_cubicle, this.getName() +"'s turn\n"+this.getName()+ " freeing ressource from cubicle");
		
		try{
			this.addAction(take_basket);
			this.addAction(take_cubicle);
			this.addAction(this.undress_action);
			this.addAction(free_cubicle);
			this.addAction(this.swim_action);
			this.addAction(take_cubicle2);
			this.addAction(this.dress_action);
			this.addAction(free_cubicle2);
			this.addAction(free_basket);
			
			
			
		}
		catch(ActionFinishedException f){
			
		}
		catch(SchedulerStardedException e){
			
		}
		
	}
	public void realStep(){
		
		super.realStep();
		if(!this.stopCondition()){
			
			if( (this.undress_action.getState()==ActionState.IN_PROGRESS || this.undress_action.getState()==ActionState.FINISHED) && this.inc<=this.undress_time){
				System.out.println(this.getName() +"'s turn");
				System.out.println("undressing ("+this.inc+"/"+this.undress_time+")");
				this.inc++;

				
			}
			
			else if( (this.dress_action.getState()==ActionState.IN_PROGRESS || this.dress_action.getState()==ActionState.FINISHED) && this.inc2<=this.dress_time){
				System.out.println(this.getName() +"'s turn");
				System.out.println("dressing ("+this.inc2+"/"+this.dress_time+")");
				this.inc2++;
				
			}
			else if((this.swim_action.getState()==ActionState.IN_PROGRESS || this.swim_action.getState()==ActionState.FINISHED)&& this.swim_inc<=this.swim_time){
				System.out.println(this.getName() +"'s turn");
				System.out.println("swimming ("+this.swim_inc+"/"+this.swim_time+")");
				this.swim_inc++;
				
			}
		}
		
		
	}
	/*
	 * It is a getter that gives us the name of the swimmer
	 * @return : the name of the swimmer
	 */
	public String getName(){
		return this.name;
	}

}
