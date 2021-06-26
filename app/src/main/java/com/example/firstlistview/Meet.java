package com.example.firstlistview;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;

/*
public class Meet {


    public static boolean canManage = false;
    public static boolean canCoach = false;
    private String name,gender,uid,coachCode = "",managerCode = "",userId = "";
    private Date date;
    private HashMap<String,String> schools;
    private ArrayList<String> levels, events;
    private ArrayList<Integer> indPoints, relPoints;
    private ArrayList<Boolean> beenScored;

   public Meet(String key, HashMap<String, Object> dict){
     uid = key;
     if (dict.get("name") != null){
         name = (String)dict.get("name");
     }
     else{
         name = "Blank";
     }

   }

    // build objects from firebase
    init(key: String, dict: [String:Any]  ){
        uid = key
        print(uid)
        if let n = dict["name"] as? String{
            name = n
        }
        else{
            name = "Blank"
        }


        let formatter1 = DateFormatter()
        formatter1.dateFormat = "MM/dd/yy"
        if let d = formatter1.date(from: dict["date"] as! String){
            date = d
        }
        else{ date = Date()}

        if let g = dict["gender"] as? String{
            gender = g
        }
        else{gender = "M"}


        if let s = dict["schools"] as? [String:String]{
            schools = s
        }
        else{schools = [:]}




        levels = [String]()
        if let levelsArray = dict["levels"] as? NSArray{
            for i in 0..<levelsArray.count{
                levels.append(levelsArray[i] as! String)
            }
        }

        events = [String]()
        if let eventsArray = dict["events"] as? NSArray{
            for i in 0..<eventsArray.count{
                events.append(eventsArray[i] as! String)
            }
        }

        indPoints = [Int]()
        if let indPointsArray = dict["indPoints"] as? NSArray{
            for i in 0..<indPointsArray.count{
                indPoints.append(indPointsArray[i] as! Int)
            }
        }

        relPoints = [Int]()
        if let relPointsArray = dict["relPoints"] as? NSArray{
            for i in 0..<relPointsArray.count{
                relPoints.append(relPointsArray[i] as! Int)
            }
        }

        beenScored = [Bool]()
        if let beenScoredArray = dict["beenScored"] as? NSArray{
            for i in 0..<beenScoredArray.count{
                beenScored.append(beenScoredArray[i] as! Bool)
            }
        }
        if let c = dict["coachCode"] as? String{
            coachCode = c
        }
        if let m = dict["managerCode"] as? String{
            managerCode = m
        }
        if let u = dict["userId"] as? String
        {
            userId = u
        }


    }

    // Creating a new Meet
    init(name n : String, date d:Date, schools s: [String:String], gender g: String, levels l : [String], events e : [String], indPoints ip:  [Int], relpoints rp : [Int],  beenScored se: [Bool], coach: String, manager: String ){
        name = n
        date = d
        schools = s
        gender = g
        levels = l
        events = e
        indPoints = ip
        relPoints = rp
        beenScored = se
        coachCode = coach
        managerCode = manager
        userId = AppData.userID
//        if n != "Blank"{
//        saveMeetToFirebase()
//        }
    }
}
*/
