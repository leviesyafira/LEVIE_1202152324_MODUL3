package com.example.levie.levie_1202152324_m3;


public class water {
    String title, description, detail;
    int image;

    public water(String title, String description, String detail, int image){
        //mendeklarasikan
        this.title = title;
        this.description = description;
        this.detail = detail;
        this.image = image;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public String getDetail(){
        return detail;
    }

    public int getImage(){
        return image;
    }
}
