package um.edu.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jade.Boot;
import um.edu.agentcourse.SchedulerAgent;
import um.edu.agentcourse.persistance.delegate.UserProfileDelegate;

@Controller
public class TestController {
	@Autowired
	UserProfileDelegate userProfileDelegate;
	private @Autowired AutowireCapableBeanFactory beanFactory;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String showIndex() {
    	Boot b=new Boot();
    	String[] args = {"-gui","-agents","\"MessageSender\":um.edu.agentcourse.MessageSender;\"MessageReciever\":um.edu.agentcourse.MessageReciever;\"SchedulerAgent\":um.edu.agentcourse.SchedulerAgent;",
    			"-name","foo-platform"};
		b.main(args);
	     return "Hello world";
    }
}
