package com.example.gameofquestions.TheoryPagE;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;



@Entity(tableName = "theory")
public class Theory {
    @PrimaryKey(autoGenerate = true)
    private int id; // default value
    @ColumnInfo(name = "text")
    private String theoryText;
    @ColumnInfo(name = "date")
    private long theoryDate;

    @Ignore
    private boolean checked = false;

    public Theory() {
    }

    public Theory(String theoryText, long theoryDate) {
        this.theoryText = theoryText;
        this.theoryDate = theoryDate;
    }

    public String getTheoryText() {
        return theoryText;
    }

    public void setTheoryText(String theoryText) {
        this.theoryText = theoryText;
    }

    public long getTheoryDate() {
        return theoryDate;
    }

    public void setTheoryDate(long theoryDate) {
        this.theoryDate = theoryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }


    @Override
    public String toString() {
        return "Theory{" +
                "id=" + id +
                ", theoryDate=" + theoryDate +
                '}';
    }
}
