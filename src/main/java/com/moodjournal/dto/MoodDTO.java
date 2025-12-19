package com.moodjournal.dto;

import java.time.LocalDate;

public class MoodDTO {
    private int id;
    private String mood;
    private String note;
    private LocalDate date;
    private int userId;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMood() { return mood; }
    public void setMood(String mood) { this.mood = mood; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}

