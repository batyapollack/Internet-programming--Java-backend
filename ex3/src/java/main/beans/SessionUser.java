package main.beans;
import org.springframework.stereotype.Component;
import java.io.Serializable;

/**
 * Class SessionUser -responsible for returns or updating that status flag of session
 * according to the user situation (login/logout)
 */
@Component
public class SessionUser implements Serializable {
    private Boolean flag ;

    /**
     * Ctor SessionUser - initialize the flag member
     */
    public SessionUser() {
        this.flag = false;
    }

    /**
     * function that returns flag that defines the user status
     * @return flag - Boolean member that defines the user status
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * function that update flag that defines the user status
     * @param flag -Boolean member that defines the user status
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}