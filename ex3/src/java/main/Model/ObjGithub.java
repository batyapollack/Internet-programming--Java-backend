package main.Model;

/**
 * class that present object that we get from girhub
 */
public class ObjGithub
{
    /**
     * ctor
     */
    public ObjGithub()
    {

    }


    private String login;
    private String html_url;
    private String followers;

    /**
     * func getLogin return the name of user did login
     * @return -String login
     */
    public String getLogin() {
        return login;
    }

    /**
     * func getLogin set the name of user did login
     * @param login -String login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * func getHtml_url return the html_url of user
     * @return -String html_url
     */
    public String getHtml_url() {
        return html_url;
    }

    /**
     *func getHtml_url set the html_url of user
     * @param html_url -String html_url
     */
    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    /**
     * getFollowers - returns the followes of user
     * @return : String that contains follower's user
     */
    public String getFollowers() {
        return followers;
    }

    /**
     * setFollowers - set the followes of user
     * @param followers : String that contains follower's user
     */
    public void setFollowers(String followers) {
        this.followers = followers;
    }
}