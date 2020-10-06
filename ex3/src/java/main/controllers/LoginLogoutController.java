package main.controllers;

import main.beans.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
 * LoginLogoutController Controller - responsible for  receiving requests of
 *   that the path is : /login or /logout
 */
@Controller
public class LoginLogoutController
{
    /**
     * get the instance of Session
     */
    @Resource(name = "SessionUser")
    private SessionUser insSession;

    /**
     *    /**
     *      * * function loginGet - responsible for receiving requests of
     *      * * that the path is : /login
     * @param model - a model
     * @return login if user log out  else navigate to  ResultsGithub.
     */
    @RequestMapping("/login")
    public String loginGet(Model model) {
        if (insSession.getFlag())
            return "redirect:/ResultsGithub";

        model.addAttribute("msgError", " ");
        return "login";
    }


    /**
     * function that returns login page and update the flag of session
     *  function logout - responsible for receiving requests of
     *  that the path is : /logout
     *  @return  "redirect:/login" - login page if user logout
     */

    @RequestMapping("/logout")
    public String logout() {
        insSession.setFlag(false);
        return "redirect:/login";
    }
}
