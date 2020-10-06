package main.repo;
import com.google.gson.Gson;
import main.Model.ObjGithub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * class read user from github
 */

public class ReadUserFromGithub
{
    /**

     * @param user : containts the user name, url name and count of searching
     * @param userName : String userName
     * @param model : * Java-5-specific interface that defines a holder for model attributes.
     * @param repo UserRepository.
     */
    public ReadUserFromGithub(User user, String userName, Model model, UserRepository repo)
    {
        this.user = user;
        this.userName = userName;
        this.model = model;
        this.repo = repo;

    }


    private User user;
    private Model model;
    private String userName;
    private UserRepository repo;
    /**
     *
     * @throws MalformedURLException - Exception MalformedURLException
     * @throws IOException - Exception IOException
     */
    public void read() throws MalformedURLException,IOException
    {
            userName = userName.trim();
            model.addAttribute("msg", "");
            if(userName.length() == 0)
            {
                model.addAttribute("msg", "Empty,no search user");
                return;
            }

            URL url = new URL("https://api.github.com/users/" + userName);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            ObjGithub objGithub = new Gson().fromJson(reader, ObjGithub.class);
            if (objGithub.getFollowers().equals("0"))
                model.addAttribute("msg", "This user has no followers");
            model.addAttribute("followers", objGithub.getFollowers());
            model.addAttribute("login", objGithub.getLogin());
            model.addAttribute("html_url", objGithub.getHtml_url());

            User u = repo.findByUserNameLike(userName);
            if (u == null)
            {
                u = new User(objGithub.getLogin(), objGithub.getHtml_url());
                repo.save(u);

            } else {
                u.setCount(u.getCount() + 1);
               repo.save(u);
            }
        }


}
