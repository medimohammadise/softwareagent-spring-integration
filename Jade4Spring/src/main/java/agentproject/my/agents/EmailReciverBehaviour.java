package agentproject.my.agents;

import java.io.File;
import java.net.URL;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import agentproject.my.persistance.model.MessageRule;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.util.leap.Properties;

public class EmailReciverBehaviour extends CyclicBehaviour {
	private JavaMailSender  mailSender;
	
  	@Override
	public void action() {
		ACLMessage recievedMessage= getAgent().receive();
		MessageRule messageRule=null;
		if (recievedMessage!=null)
		{
			
			MimeMessage mailMessage=constructEmailMessage(recievedMessage.getAllUserDefinedParameters());
			mailSender.send(mailMessage);	
			//JOptionPane.showMessageDialog(null, messageRule.getMessage());
		}
		else
			block();

	}
  	 private final MimeMessage constructEmailMessage(Properties properties) {
  		File file=null;
  		MimeMessage mimMessage= mailSender.createMimeMessage();
  		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(mimMessage, true);
		
  	    final String subject = "Happy BirthDay! I'm email agent!";
  	    helper.setFrom("m.mohammadi.se@gmail.com");
		helper.setTo(properties.getProperty("to"));
		helper.setSubject(subject);
		helper.setText(properties.getProperty("message"),true);
		URL url=getClass().getClassLoader().getResource("images/"+properties.getProperty("id")+".jpg");
		if (url!=null)
		{
			System.out.println("url :"+url.toString()); 
			file = new File(getClass().getClassLoader().getResource("images/"+properties.getProperty("id")+".jpg").getFile());
			 helper.addAttachment("poster.jpg", file);
		}
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	  
  	    return mimMessage;
  	}
  	public JavaMailSender getMailSender() {
		return mailSender;
	}
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

}
