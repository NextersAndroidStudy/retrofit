package nexters.androidstudy.retrofittest;

/**
 * Created by SEONGBONG on 2016-03-15.
 */
public class RecyclerItem {
    private String login;
    private String url;

    public RecyclerItem() {
    }

    public RecyclerItem(String login, String url) {
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
        return "RecyclerItem{" +
                "logIn='" + login + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
