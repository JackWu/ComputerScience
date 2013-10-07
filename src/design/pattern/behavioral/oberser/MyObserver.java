package design.pattern.behavioral.oberser;

public class MyObserver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter Text >");
		
		final EventSource eventSource = new EventSource();
		
		final ResponseHandler responseHandler = new ResponseHandler();
		
		eventSource.addObserver(responseHandler);
		
		Thread thread = new Thread(eventSource);
		thread.start();

	}

}
