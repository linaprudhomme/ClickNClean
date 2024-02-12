package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Cleaner extends User{

    Planning planning;
    int cleanerID;
    Address departureAddress;
    int kmCount;
    int hourlyRate;
    List<String> availableDays;
    String motivation;
    String experience;
    String idPhoto;
    String profilePhoto;
    boolean confirmed;
    String biography;
    List<String> reviews;

    public Cleaner( String email, 
                    String pwd, 
                    String name, 
                    String surName, 
                    int phoneN, 
                    String birthDate, 
                    boolean suspended,
			        String accountDate,
                    int cleanerID, 
                    Address departureAddress,
                    int kmCount, 
                    int hourlyRate, 
                    Planning planning,
                    String motivation, 
                    String experience,
                    String idPhoto, 
                    String profilePhoto, 
                    boolean confirmed, 
                    String biography, 
                    List<String> reviews) {
                        
        super(email, pwd, name, surName, phoneN, birthDate, suspended,accountDate);
        this.cleanerID = cleanerID;
        this.departureAddress = departureAddress;
        this.kmCount = kmCount;
        this.hourlyRate = hourlyRate;
        this.planning = new Planning();
        this.motivation = motivation;
        this.experience = experience;
        this.idPhoto = idPhoto;
        this.profilePhoto = profilePhoto;
        this.confirmed = confirmed;
        this.biography = biography;
        this.reviews = reviews;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(LocalDate targetDate, LocalTime targetTime, int newStatus ) {
        this.planning.setAvailableSlots(targetDate, targetTime, newStatus);
    }

    public int getCleanerID() {
        return cleanerID;
    }

    public Address getDepartureAddress() {
        return departureAddress;
    }

    public void setDepartureAddress(Address departureAddress) {
        this.departureAddress = departureAddress;
    }

    public void setCleanerID(int cleanerID) {
        this.cleanerID = cleanerID;
    }

    public int getKmCount() {
        return this.kmCount;
    }

    public void setKmCount(int kmCount) {
        this.kmCount = kmCount;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public List<String> getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(List<String> availableDays) {
        this.availableDays = availableDays;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(String idPhoto) {
        this.idPhoto = idPhoto;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public boolean isconfirmed() {
        return confirmed;
    }

    public void setconfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }

    
}