package agentproject.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class JadeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	 @ResponseBody
	public String test(){
		return "Hello World";
	}

}
