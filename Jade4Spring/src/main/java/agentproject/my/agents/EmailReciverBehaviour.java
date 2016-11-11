package agentproject.my.agents;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class EmailReciverBehaviour extends CyclicBehaviour {
	private JavaMailSender  mailSender;
  	@Override
	public void action() {
		ACLMessage message= getAgent().receive();
		System.out.println("Recieving message"+message);
		
		
		if (message!=null)
		{
			MimeMessage mailMessage=constructEmailMessage(message.getContent(),"oracle.mohammadi@gmail.com");
			mailSender.send(mailMessage);	
			JOptionPane.showMessageDialog(null, message.getContent());
		}
		else
			block();

	}
  	 private final MimeMessage constructEmailMessage(String message,String recipientAddress) {
  		MimeMessage mimMessage= mailSender.createMimeMessage();
  		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(mimMessage, true);
		
  	    final String subject = "Happy BirthDay";
  	    
  	    
  	    
  	  helper.setFrom("m.mohammadi.se@gmail.com");
		helper.setTo(recipientAddress);
		helper.setSubject(subject);
		helper.setText(message,true);

		FileSystemResource file = new FileSystemResource("C:\\Users\\mehdi\\Pictures\\LinkedIn.jpg");
		helper.addAttachment(file.getFilename(), file);
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
