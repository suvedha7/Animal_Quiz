package com.example.first_quiz;

public class Question {
    public String imgs[]={
            "im1","im2","im3","im4","im5"
    };
    public String choices[][]={
            {"Cat","Cow","Bear"},
            {"Parrot","Dog","Tiger"},
            {"Fox","Lion","Bear"},
            {"Rabbit","Giraffe","Dolphin"},
            {"Zebra","Monkey","Horse"},
    };
    public String crtans[]={
            "Cat","Dog","Fox","Dolphin","Monkey"
    };
    private String qtype[]={
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
    };
    public String getImgs(int q) {
        String img=imgs[q];
        return img;
    }

    public String[] getChoices(int q) {
        String[] choice=choices[q];
        return choice;
    }

    public String getQtype(int q) {
        String type=qtype[q];
        return type;
    }

    public String getCrtans(int q) {
        String crtan=crtans[q];
        return crtan;
    }
    public int getlen(){
        return imgs.length;
    }
}
