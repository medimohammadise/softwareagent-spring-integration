package um.edu.agentcourse.persistance.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import um.edu.agentcourse.persistance.domain.UserProfileRepository;
import um.edu.agentcourse.persistance.model.UserProfiles;
@Component
public class UserProfileDelegate {
	@Autowired 
	UserProfileRepository userProfileRepository;
	
	public List<UserProfiles> getUserProfiles(){
		return userProfileRepository.findAll();
	}

}
