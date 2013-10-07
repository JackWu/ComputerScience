package design.pattern.creational.factorymethod;

public interface Vehicle {
	public void drive();
	public void clean();

}

class Car implements Vehicle{
	  @Override
	  public void drive(){
	    System.out.println("Driving a car...");
	  }
	   
	  @Override
	  public void clean(){
	    System.out.println("Cleaning a car...");
	  }
	}
	class Bus implements Vehicle{
	  @Override
	  public void drive(){
	    System.out.println("Driving a Bus...");
	  }
	   
	  @Override
	  public void clean(){
	    System.out.println("Cleaning a Bus...");
	  }
	}