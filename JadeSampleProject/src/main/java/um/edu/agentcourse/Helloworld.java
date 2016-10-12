package um.edu.agentcourse;

import jade.core.AID;
import jade.core.Agent;

public class Helloworld extends Agent{
	protected void setup() {
		System.out.println("hello agent my name is "+getLocalName());
		String localname = "Peter";
		AID id = new AID(localname, AID.ISLOCALNAME);
	}
}
