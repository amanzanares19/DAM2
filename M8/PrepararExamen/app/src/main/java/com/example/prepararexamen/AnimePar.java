package com.example.prepararexamen;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class AnimePar implements Parcelable {

    private int id;
    private String name;
    private String description;
    private String type;
    private int year;
    private String image;
    private String favorite;

    public AnimePar(int id, String name, String description, String type, int year, String image, String favorite) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.year = year;
        this.image = image;
        this.favorite = favorite;
    }

    protected AnimePar(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        type = in.readString();
        year = in.readInt();
        image = in.readString();
        favorite = in.readString();
    }

    public static final Creator<AnimePar> CREATOR = new Creator<AnimePar>() {
        @Override
        public AnimePar createFromParcel(Parcel in) {
            return new AnimePar(in);
        }

        @Override
        public AnimePar[] newArray(int size) {
            return new AnimePar[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return "AnimePar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                ", image='" + image + '\'' +
                ", favorite='" + favorite + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(type);
        dest.writeInt(year);
        dest.writeString(image);
        dest.writeString(favorite);
    }
}
