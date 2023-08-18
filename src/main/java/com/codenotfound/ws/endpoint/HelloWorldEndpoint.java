
package com.codenotfound.ws.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.codenotfound.types.helloworld.Greeting;
import com.codenotfound.types.helloworld.ObjectFactory;
import com.codenotfound.types.helloworld.Person;

@Endpoint
public class HelloWorldEndpoint {


	@PayloadRoot(namespace = "http://codenotfound.com/types/helloworld", localPart = "person")
	@ResponsePayload
	public Greeting sayHello(@RequestPayload Person request) 
	{
		

		String greeting = "Hello " + request.getFirstName() + " " + request.getLastName() + "!";

					    	    
		ObjectFactory factory = new ObjectFactory();

		Person person = factory.createPerson();

	    person.setFirstName(request.getFirstName());
	    person.setLastName(request.getLastName());

		
		Greeting response = factory.createGreeting();
		response.setGreeting(greeting);


		return response;
	}
}