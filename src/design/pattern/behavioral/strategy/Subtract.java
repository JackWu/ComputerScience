package design.pattern.behavioral.strategy;

public class Subtract implements Strategy {
	
	public int execute(int a, int b){
        System.out.println("Called Subtract's execute()");
        return a - b;  // Do a subtraction with a and b
	}

}
