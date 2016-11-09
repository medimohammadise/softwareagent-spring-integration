package agentproject.my.persisitance.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import agentproject.my.persistance.model.UserProfiles;



public interface UserProfileRepository extends JpaRepository<UserProfiles, Long> {

}
