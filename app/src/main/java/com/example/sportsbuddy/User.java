package com.example.sportsbuddy;

import com.google.firebase.database.PropertyName;

public class User {
   public String mfirstName;
    public String msecondname;
    public String muid;
    public String memail;
    public User(){

    }



    public User (String firstName, String secondName, String uid, String email) {
        this.mfirstName = firstName;
        this.msecondname = secondName;
        this.muid=uid;
        this.memail=email;
    }

    public User (String firstName, String secondName,String muid) {
    }
@PropertyName ( "FIRST NAME" )
    public String getFirstName () {
        return mfirstName;
    }
    @PropertyName ("SECOND NAME" )
    public String getSecondName () {
        return msecondname;
    }
    @PropertyName ( "userid" )
    public String getUid () {
        return muid;
    }
    @PropertyName ( "E-MAIL" )
    public String getEmail () {
        return memail;
    }
    @PropertyName ( "FIRST NAME" )
    public void setFirstName (String firstName) {
        this.mfirstName = firstName;
    }
    @PropertyName ( "SECOND NAME" )
    public void setSecondName (String secondName) {
        this.msecondname = secondName;
    }
    @PropertyName ( "userid" )
    public void setUid (String uid) {
        this.muid = uid;
    }
    @PropertyName ( "E-MAIL" )
    public void setEmail (String email) {
        this.memail = email;
    }
}
