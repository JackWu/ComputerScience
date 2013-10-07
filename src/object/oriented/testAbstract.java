package object.oriented;

public abstract class testAbstract implements testInterface {
	
	abstract void drawe(String something);
	
	abstract void destructSoemthing(String something);
	
	void shoutOutLoud(String text){
		System.out.println("I am shouting");
	}

	static void invisible(){
		System.out.println("I am invisible");
	}
}

class something extends testAbstract{

	@Override
	public void hi() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bye() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void drawe(String something) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void destructSoemthing(String something) {
		// TODO Auto-generated method stub
		
	}
	
	
}
