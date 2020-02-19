package org.lzk.mybatis.restful.entity;

public class Message {
    private Long id;
    private String text;
    private String summary;

    public Message(Long id, String text, String summary) {
        this.id = id;
        this.text = text;
        this.summary = summary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}