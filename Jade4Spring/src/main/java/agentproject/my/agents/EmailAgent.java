package agentproject.my.agents;

import javax.sql.DataSource;
import javax.swing.JOptionPane;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import agentproject.my.delegate.UserProfileDelegate;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class EmailAgent extends Agent {
	@Autowired
	JavaMailSender  mailSender;
	protected void setup() {
		EmailReciverBehaviour emailReciverBehaviour=new EmailReciverBehaviour();
		emailReciverBehaviour.setAgent(this);
		emailReciverBehaviour.setMailSender(mailSender);
		addBehaviour(emailReciverBehaviour);
	}
	

}
