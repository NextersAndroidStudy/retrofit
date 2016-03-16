package nexters.androidstudy.retrofittest;

/**
 * Created by SEONGBONG on 2016-03-16.
 */
public class NaverSearchItem {
    private String rss;
    private String channel;
    private String lastBuildDate;
    private String total;
    private String start;
    private String display;
    private String item;
    private String title;
    private String link;
    private String description;
    private String bloggername;
    private String bloggerlink;

    public NaverSearchItem(String rss, String channel, String lastBuildDate, String total, String start, String display, String item, String title, String link, String description, String bloggername, String bloggerlink) {
        this.rss = rss;
        this.channel = channel;
        this.lastBuildDate = lastBuildDate;
        this.total = total;
        this.start = start;
        this.display = display;
        this.item = item;
        this.title = title;
        this.link = link;
        this.description = description;
        this.bloggername = bloggername;
        this.bloggerlink = bloggerlink;
    }

    public NaverSearchItem() {
    }

    public String getRss() {
        return rss;
    }

    public void setRss(String rss) {
        this.rss = rss;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBloggername() {
        return bloggername;
    }

    public void setBloggername(String bloggername) {
        this.bloggername = bloggername;
    }

    public String getBloggerlink() {
        return bloggerlink;
    }

    public void setBloggerlink(String bloggerlink) {
        this.bloggerlink = bloggerlink;
    }

    @Override
    public String toString() {
        return "NaverSearchItem{" +
                "rss='" + rss + '\'' +
                ", channel='" + channel + '\'' +
                ", lastBuildDate='" + lastBuildDate + '\'' +
                ", total='" + total + '\'' +
                ", start='" + start + '\'' +
                ", display='" + display + '\'' +
                ", item='" + item + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", bloggername='" + bloggername + '\'' +
                ", bloggerlink='" + bloggerlink + '\'' +
                '}';
    }
}
