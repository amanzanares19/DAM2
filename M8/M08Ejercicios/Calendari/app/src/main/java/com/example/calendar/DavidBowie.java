package com.example.calendar;

public class DavidBowie {

    private String coverName;
    private int imgCover;

    public DavidBowie(String coverName, int imgCover) {
        this.coverName = coverName;
        this.imgCover = imgCover;
    }

    public String getCoverName() {
        return coverName;
    }

    public void setCoverName(String coverName) {
        this.coverName = coverName;
    }

    public int getImgCover() {
        return imgCover;
    }

    public void setImgCover(int imgCover) {
        this.imgCover = imgCover;
    }

    @Override
    public String toString() {
        return "DavidBowie{" +
                "coverName='" + coverName + '\'' +
                ", imgCover=" + imgCover +
                '}';
    }
}
