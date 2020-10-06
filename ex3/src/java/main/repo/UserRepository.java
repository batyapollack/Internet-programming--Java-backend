package main.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * interface that contain UserRepository and contain 2 functions
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * @param userName : String userName
     * @return User- that contains the user name, url name and count of searching
     */
    User findByUserNameLike(String userName);

    /**
     *
     * @return : List of User : list of User-hat contains the user name,
     * url name and count of searching
     */
    List<User> findFirst10ByOrderByCountDesc();
}
