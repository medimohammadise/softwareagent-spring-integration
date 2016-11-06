package um.edu.agentcourse.persistance.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import um.edu.agentcourse.persistance.model.UserProfiles;

public interface UserProfileRepository extends JpaRepository<UserProfiles, Long> {

}
