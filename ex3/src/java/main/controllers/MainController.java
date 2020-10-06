package main.controllers;
import main.Model.SuccessLogin;
import main.beans.Login;
import main.beans.SessionUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class MainController
{
    /**
     * value of userName
     */
    @Value("${Utils.name}")
    private String name;
    public String getName() {
        return name;
    }

    /**
     * value of password
     */
    @Value("${Utils.password}")
    private String pass;
    public String getPass() {
        return pass;
    }

    /**
     * get the instance of Session
     */
    @Resource(name = "SessionUser")
    private SessionUser insSession;

    /**
     * function main -start the program run
     * responsible for receiving requests of
     *  that the path is : /
     * @return page login if user logout , otherwise - page of ResultsGithub
     */
    @GetMapping("/")
    public String main() {

        if (insSession != null && insSession.getFlag() )
            return "redirect:/ResultsGithub"; //get
        return "redirect:/login";
    }

    /**
     *
     * @param login  Responsible for reciving an object from the client
     *  * that contains name and password that he entered
     * @param model interface that defines a holder for model attributes.
     * @return SuccessLogin - that return is user succeed to login
     */

    @PostMapping("/jsonlogin")
    public @ResponseBody
    SuccessLogin getJson(@Valid @RequestBody Login login, Model model) {
        String name = login.getName();
        String pass = login.getPassword();
        SuccessLogin obj = new SuccessLogin();

        if (name.equals(getName()) && pass.equals(getPass())) {
            insSession.setFlag(true);
            obj.setSuccess(true);
        } else {
            model.addAttribute("msgError", " Wrong in input, please try again!");
            model.addAttribute("obj", false);
            obj.setSuccess(false);
        }
        return obj;
    }

}

