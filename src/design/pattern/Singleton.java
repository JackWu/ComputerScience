package design.pattern;

/**
 * Expense of Increse coupling
 * Application must have explicit knowledge of of the singleton class.
 * Completely removing the ability to code to interface.
 * Difficulty to swap out implementations arbitrarily.
 * @author LucasWu
 *
 */

public class Singleton {

	private static Singleton instance;
	
	static {
		instance = new Singleton();
	}
	
	public static Singleton getInstance(){
		return instance;
	}
	
}
