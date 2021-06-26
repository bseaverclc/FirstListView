package com.example.firstlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    //private String[] names = {"Brian", "Bill","Ted","Ted","Ted","Ted","Ted","Ted","Ted","Ted","Bye","Ted","Ted","Ted","Ted","Ted","Ted","Ted","Last"};
    //private Integer[] grades = {9,10,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12};
    private ArrayList<Athlete> athletes = new ArrayList<Athlete>();

    private DatabaseReference mDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting up the ListView
        MyListAdapter adapter=new MyListAdapter(this, athletes);
        listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // Add an athlete to firebase
        mDatabase = FirebaseDatabase.getInstance().getReference();
//        Athlete a = new Athlete("Event Athlete", "Seaver", "CLC", 12, "Crystal Lake Central");
//        athletes.add(a);
//        a.saveToFirebase();
//        a.addEvent("Test Event", "VAR", "TestMeet");
        //athletes.add(new Athlete("Jeff", "Owen", "CLC",10, "Crystal Lake Central"));


        //listView = findViewById(R.id.listView);
        // ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1 ,names);
        //listView.setAdapter(adapter);

 //        Read from the database
        mDatabase.child("users").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previous) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                System.out.println(dataSnapshot);

                String key = dataSnapshot.getKey();
                System.out.println("key is "+ key);
                Athlete a = dataSnapshot.getValue((Athlete.class));
                athletes.add(a);





                System.out.println("printing athletes" + athletes);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previous) {
                System.out.println(dataSnapshot);

                String key = dataSnapshot.getKey();
                System.out.println("key is "+ key);

                Athlete a = dataSnapshot.getValue((Athlete.class));
                athletes.add(a);
                System.out.println("printing athletes" + athletes);

                mDatabase.child("users").child(key).child("events").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String previous) {

                    }

                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String previous) {

//                        ArrayList<Event> myEvents = new ArrayList<Event>();
//                        for(DataSnapshot ds : dataSnapshot.getChildren()) {
//                            Event e = ds.getValue(Event.class);
//                            myEvents.add(e);
//                            System.out.println(e);
//                        }
                        System.out.println("event snapshot" + dataSnapshot);
                        Event ev = dataSnapshot.getValue(Event.class);
                          a.addEvent(ev);
                          ev.setUid(dataSnapshot.getKey());

                          System.out.println("getting an event from firebase ");
                          for(Event e: a.showEvents()){
                              System.out.println(e.getName());

                        }
                          adapter.notifyDataSetChanged();
                    }

                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot snapshot,String previousChildName) {

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        System.out.println("failed to read from database");
                        // Failed to read value
                        //Log.w(TAG, "Failed to read value.", error.toException());
                    }

                });

                adapter.notifyDataSetChanged();
                //Log.d(TAG, "Value is: " + value);
            }
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot snapshot,String previousChildName) {

            }


            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("failed to read from database");
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });




    }
}