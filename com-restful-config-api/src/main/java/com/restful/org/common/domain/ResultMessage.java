package com.restful.org.common.domain;

/**
 * 结果demo
 *
 * @author qinhaohao
 * @create 2017-12-28 16:04
 **/
public class ResultMessage {
    private String action;
    private String url;
    private long timestamp;
    private long duration;
    private Object data;
    private int status;

    public ResultMessage() {
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResultMessage{" +
                "action='" + action + '\'' +
                ", url='" + url + '\'' +
                ", timestamp=" + timestamp +
                ", duration=" + duration +
                ", data=" + data +
                ", status=" + status +
                '}';
    }
}
