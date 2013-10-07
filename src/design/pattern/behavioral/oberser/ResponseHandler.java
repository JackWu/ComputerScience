package design.pattern.behavioral.oberser;

import java.util.Observable;
import java.util.Observer;

public class ResponseHandler implements Observer {

	private String resp;
	public void update(Observable obj, Object arg){
		if(arg instanceof String){
			resp = (String) arg;
			System.out.println("\"Received Response:: " + resp);		}
	}
}
