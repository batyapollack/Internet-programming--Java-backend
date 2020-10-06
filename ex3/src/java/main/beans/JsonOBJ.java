package main.beans;
import org.springframework.stereotype.Component;
import java.io.Serializable;

/**
 * class JsonOBJ - class designed to return a json object from a controller
 * and return flag = false if name or password invalid , otherwise returns true
 */
@Component
public class JsonOBJ implements Serializable
{
    private Boolean flag;
    /**
     * Ctor of JsonOBJ - initialize member to false
     */
    public JsonOBJ( ) {
        this.flag = false;
    }

}



