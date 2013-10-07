package design.pattern.creational.factorymethod;

public class FactoryMethodPattern {
	   public static void main(String[] args) {
	     
	    handleVehicle(new CarDriver());
	    handleVehicle(new BusDriver());
	  }
	  static void handleVehicle(VehicleDriver vDriver){
	    System.out.println("Handling a new vehicle. Pre lambda way");
	    vDriver.driveVehicle();
	    vDriver.cleanVehicle();
	  }
	}