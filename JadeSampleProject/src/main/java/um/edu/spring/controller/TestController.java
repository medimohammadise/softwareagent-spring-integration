package um.edu.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jade.Boot;

@Controller
public class TestController {
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
