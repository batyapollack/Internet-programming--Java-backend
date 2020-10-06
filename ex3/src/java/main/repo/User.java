package main.repo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * User class that containts the user name, url name and count of searching
 */
@Entity
public class User
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //@NotBlank(message = "Name is mandatory")
    private String userName;

    //@NotBlank(message = "Url is mandatory")
    private String url;

    //@NotBlank(message = "count is mandatory")
    private int count;

    public User() {}

    public User(String userName, String url) {
        this.userName = userName;
        this.url = url;
        this.count = 1;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    /**
     * func getUserName
     * @return  String of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     *  func getCount
     * @return count of user search
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @param count :count of user search
     */
    public void setCount(int count) {
        this.count += 1;
    }


    /**
     * getUrl : get function
     * @return  String of urlName
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @return concatinate of members of User
     */
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName=" + userName + ", url=" + url +", count="+count + '}';
    }
}

