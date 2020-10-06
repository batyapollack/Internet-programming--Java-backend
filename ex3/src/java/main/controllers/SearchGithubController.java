package main.controllers;

import main.beans.SessionUser;
import main.repo.ReadUserFromGithub;
import main.repo.User;
import main.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.net.MalformedURLException;

@Controller
public class SearchGithubController
{
    /**
     * get the instance of Session
     */
    @Resource(name = "SessionUser")
    private SessionUser insSession;

    /**
     * * Marks a constructor, field, setter method or config method as to be autowired by
     *  * Spring's dependency injection facilities
     */
    @Autowired
    private UserRepository repository;
    private UserRepository getRepo() {
        return repository;
    }


    /**

     * @param model - Java-5-specific interface that defines a holder for model attributes.
     * @return "redirect:/login" - login page if user logout
     *     or searchGithub that show the results
     */

    @GetMapping("/ResultsGithub")
    public String getResults(Model model) {
        if (insSession.getFlag() && insSession != null) {
            model.addAttribute("html_url", "");
            model.addAttribute("login", "");
            model.addAttribute("followers", "");
            model.addAttribute("msg", "");
            return "searchGithub";
        }
        return "redirect:/login";
    }


    /**
     *
     * @param userName String user name
     * @param user -   containts the user name, url name and count of searching
     * @param model - Java-5-specific interface that defines a holder for model attributes.
     * @return "redirect:/login" - login page if user logout
     * or searchGithub that show the results
     */
    @PostMapping("/ResultsGithub")
    public String result(@RequestParam(value = "userName", required = false, defaultValue = " ") String userName, @Valid User user, Model model) {
        if (insSession.getFlag())
        {
            ReadUserFromGithub readUserFromGithub = new ReadUserFromGithub(user, userName, model, getRepo());
            try {
                readUserFromGithub.read();
            } catch (MalformedURLException e)
            {
                return "errorGithub";
            } catch (IOException e) {
                model.addAttribute("msg", "This user not exist!");
            }
            return "searchGithub";
        }
        return "redirect:/login";
    }



}
