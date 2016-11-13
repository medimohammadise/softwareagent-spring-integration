package agentproject.my.persisitance.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import agentproject.my.persistance.model.MessageRule;

public interface MessageRuleRepository extends JpaRepository<MessageRule, Long> {
	 @Query("select messageRule from MessageRule messageRule where ?1 between messageRule.fromAge and messageRule.toAge and gender=?2")
	MessageRule findMessageRule(long age,String gender);
}
