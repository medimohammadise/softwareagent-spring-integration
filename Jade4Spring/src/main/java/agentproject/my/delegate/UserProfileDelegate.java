package agentproject.my.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import agentproject.my.persisitance.domain.MessageRuleRepository;
import agentproject.my.persisitance.domain.UserProfileRepository;
import agentproject.my.persistance.model.MessageRule;
import agentproject.my.persistance.model.UserProfiles;


@Component
public class UserProfileDelegate {
	@Autowired 
	UserProfileRepository userProfileRepository;
	
	@Autowired
	MessageRuleRepository messageRuleRepository;
	public List<UserProfiles> getUserProfiles(){
		return userProfileRepository.findAll();
	}
	public MessageRule getMessageRules(long age){
		return messageRuleRepository.findMessageRule(age);
	}

}
