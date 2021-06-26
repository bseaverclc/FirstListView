package com.example.firstlistview;
import java.util.ArrayList;

public class Event {
    private String name, level, markString, meetName, uid;
    private Float mark, points;
    private Integer heat, place;
    private ArrayList<String> relayMembers;

    public Event(){

    }

    public Event(String name, String level, String meetName){
        this.name = name;
        this.level = level;
        this.meetName = meetName;
        this.mark = Float.valueOf(0);
        this.markString = "";

        if( name.contains("4x")){
            relayMembers = new ArrayList<String>();
        }

    }

    public String getName(){return name;}
    public String getLevel(){return level;}
    public String getMeetName(){return meetName;}
    public String getMarkString(){return markString;}
    public String getUid(){return uid;}




    public void setUid(String uid){
        this.uid = uid;
    }

    public void setMarkString(String markString){
        this.markString = markString;
    }




    //build Event from Firebase
//    init(key: String, dict: [String:Any] ) {
//        uid = key
//        name = dict["name"] as! String
//        level = dict["level"] as! String
//        mark = dict["mark"] as! Float
//        markString = dict["markString"] as! String
//        if let p = dict["place"] as? Int{
//            place = p
//        }
//        else{place = nil}
//        points = dict["points"] as! Double
//        if let heater = dict["heat"]{
//            heat = heater as! Int
//        }
//        if let relay = dict["relayMembers"]{
//            relayMembers = relay as? [String]
//        }
//
//        meetName = dict["meetName"] as! String
//
//    }
}
