package model;

import java.time.LocalDate;
import java.util.ArrayList;
import tools.Db;

public class Mission {
    Property property;
    LocalDate missionDate;
    double duration;
    double cost;
    double commission;
    String ownerId;
    String cleanerId;
    ArrayList<Cleaner> cleanerList;
    String startTime;
    String state;


    public Mission(
        Property property,
        LocalDate missionDate,
        double duration,
        double cost,
        double commission,
        String ownerId,
        String cleanerId,
        String startTime,
        String state
    ) {
        this.property = property;
        this.missionDate = missionDate;
        this.duration = duration;
        this.cost = cost;
        this.commission = commission;
        this.ownerId = ownerId;
        this.cleanerId = cleanerId;
        this.startTime = startTime;
        this.state = state;
    }

    public LocalDate getMissionDate() {
        return missionDate;
    }

    public void setMissionDate(LocalDate missionDate) {
        this.missionDate = missionDate;
    }

    public double getDuration() {
        return duration;
    }

    public double getCost() {
        return cost;
    }

    public double getCommission() {
        return commission;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getCleanerId() {
        return cleanerId;
    }

    public void setCleanerId(String cleanerId) {
        this.cleanerId = cleanerId;
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }




}
