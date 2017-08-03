package com.unicorn.sxshenwutong.news.entity;

public class News {

    /**
     * imageurl : image/news/82fb6ee3-28a4-4fd2-a1cf-a3dfa5b8de237720.png
     * id : 5f0fe930-24fc-4265-a7ae-e46c8ed0d16f
     * title : 111111111111
     * newstypeid : 4
     * newstype : 1
     * pubdate : 2017-06-09 10:08:04.0
     */

    private String imageurl;
    private String id;
    private String title;
    private String newstypeid;
    private String newstype;
    private String pubdate;

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewstypeid() {
        return newstypeid;
    }

    public void setNewstypeid(String newstypeid) {
        this.newstypeid = newstypeid;
    }

    public String getNewstype() {
        return newstype;
    }

    public void setNewstype(String newstype) {
        this.newstype = newstype;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

}
