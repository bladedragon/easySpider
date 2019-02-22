package spidertools;

import java.util.ArrayList;


/**
 * 课表Bean
 */
public class Kebiao {
    private String classnum;
    private String classname;
    private String teacher;
    private String state;
    private String classify;
    private String type;
    private ArrayList<String> week;
    private ArrayList<String> time;
    private ArrayList<String> place;
    private ArrayList<String> weeks;


    public ArrayList<String> getWeek() {
        return week;
    }

    public ArrayList<String> getTime() {
        return time;
    }

    public ArrayList<String> getPlace() {
        return place;
    }

    public ArrayList<String> getWeeks() {
        return weeks;
    }

    public void setWeek(ArrayList<String> week) {
        this.week = week;
    }

    public void setTime(ArrayList<String> time) {
        this.time = time;
    }

    public void setPlace(ArrayList<String> place) {
        this.place = place;
    }

    public void setWeeks(ArrayList<String> weeks) {
        this.weeks = weeks;
    }


    public void setClassnum(String classnum) {
        this.classnum = classnum;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getClassnum() {
        return classnum;
    }

    public String getClassname() {
        return classname;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getState() {
        return state;
    }

    public String getClassify() {
        return classify;
    }

    public String getType() {
        return type;
    }


}
