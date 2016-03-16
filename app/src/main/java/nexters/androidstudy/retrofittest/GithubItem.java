package nexters.androidstudy.retrofittest;

/**
 * Created by SEONGBONG on 2016-03-15.
 */
public class GithubItem {
    private String login;
    private String url;

    public GithubItem() {
    }

    public GithubItem(String login, String url) {
        this.login = login;
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public String getUrl() {
        return url;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "GithubItem{" +
                "login='" + login + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
