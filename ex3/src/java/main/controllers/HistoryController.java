package main.controllers;
import main.beans.SessionUser;
import main.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
 *  HistoryController Controller - responsible for displaying the history
 * for search results in github
 * displaying uase name with url to github
 * and several times we looked for him
 */
@Controller
public class HistoryController {

    /**
     * get the instance of Session
     */
    @Resource(name = "SessionUser")
    private SessionUser insSession;

    /**
     * get the instance of repository-Data structure access
     */
    @Autowired
    private UserRepository repository;
    private UserRepository getRepo() {
        return repository;
    }

    /**
     * function displayHistory - responsible for receiving requests of
     * that the path is : /ResultsHistory
     * @param model - Model type , responsible to transfer data to html
     * @return displayHistory - view that displaying results history
     */
    @RequestMapping("/ResultsHistory")
    public String displayHistory(Model model) {
        if ( insSession != null && insSession.getFlag()) {
            model.addAttribute("users", getRepo().findFirst10ByOrderByCountDesc());
            return "displayHistory";
        }
        return "redirect:/login";
    }


    /**
     * function clearHistory - responsible for receiving requests of
     * that the path is : /clearHistory
     * @param model - Model type , responsible to transfer data to html
     * @return displayHistory if user login , otherwise return login page
     */
    @RequestMapping("/clearHistory")
    public String clearHistory(Model model)
    {
        if(insSession.getFlag() && insSession!=null) {
            getRepo().deleteAll();
            return "displayHistory";
        }
        return "redirect:/login";
    }

}