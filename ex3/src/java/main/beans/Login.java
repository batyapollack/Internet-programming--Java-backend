package main.beans;
import org.springframework.stereotype.Component;
import java.io.Serializable;

/**
 * Class Login - Responsible for reciving an object from the client
 * that contains name and password that he entered
 */
@Component
public class Login implements Serializable
{
    private String name;
    private String password;
    /**
     * Default Ctor
     */
    public Login( ) { }

    /**
     * function that returns the name that client entered
     * @return name -  name that client entered
     */
    public String getName() {
        return name;
    }

    /**
     * function that update the member of name
     * @param name - name that client entered
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * function that returns the password that client entered
     * @return password - password that client entered
     */
    public String getPassword() {
        return password;
    }

}