package com.example.fithub;

import java.util.Date;

public class Challenge {

    public String userID, title, description, image, dateCompleted;

    public Challenge(){

    }

    public Challenge(String userID, String title, String description, String image, String dateCompleted){
        this.userID = userID;
        this.title = title;
        this.description = description;
        this.image = image;
        this.dateCompleted = dateCompleted;

    }

}
