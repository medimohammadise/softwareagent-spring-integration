package um.edu.agentcourse;

import java.util.concurrent.CyclicBarrier;

import javax.swing.JOptionPane;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class MessageReciever extends Agent{
	protected void setup() {
		System.out.println("hello agent my name is "+getLocalName());
		String localname = "Peter";
		AID id = new AID(localname, AID.ISLOCALNAME);
		addBehaviour(
		new CyclicBehaviour() {
			
			@Override
			public void action() {
				ACLMessage message=receive();
				if (message!=null)
					JOptionPane.showMessageDialog(null, message.getContent());
				else
					block();
				
			}
		}
		);
	}
}
