package com.javarush.task.task39.task3913;

import java.util.Date;

public class Log {
    private final String ip;
    private final String user;
    private final Date date;
    private final Event event;
    private final int idEvent;
    private final Status status;

    public Log(String ip, String user, Date date, Event event, int idEvent, Status status) {
        this.ip = ip;
        this.user = user;
        this.date = date;
        this.event = event;
        this.idEvent = idEvent;
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public String getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public Event getEvent() {
        return event;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ip = " + ip + ".\n"
                + "user = " + user + ".\n"
                + "date = " + date.toString() + ".\n"
                + "event = " + event.toString() + " " + idEvent + ".\n"
                + "status = " + status.toString() + ".\n";
    }

}
