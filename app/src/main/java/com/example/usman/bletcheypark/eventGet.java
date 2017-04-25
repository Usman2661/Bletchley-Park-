package com.example.usman.bletcheypark;

/**
 * Created by Safian on 4/10/2017 AD.
 */

public class eventGet {
    //Data Variables
    private String eventName;
    private String eventDate;
    private String eventDescription;
    private String eventImage;



    //Getters and Setters
    public String getImageUrl() {
        return eventImage;
    }

    public void setImageUrl(String imageUrl) {
        this.eventImage = imageUrl;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDate() {
        return eventDate;
    }

    public void setDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
