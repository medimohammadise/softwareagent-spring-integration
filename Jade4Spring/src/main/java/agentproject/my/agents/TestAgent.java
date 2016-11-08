package agentproject.my.agents;

import javax.sql.DataSource;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import jade.core.Agent;

public class TestAgent extends Agent {
	@Autowired
	DataSource dataSource;
	protected void setup() {
		System.out.println("Agent created");
		//System.out.println(appContext.getContextPath());
	}
	
}
