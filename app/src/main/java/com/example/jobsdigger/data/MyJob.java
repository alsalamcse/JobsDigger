package com.example.jobsdigger.data;

public class MyJob
{
   private String key;
   private String Subject;
   private String TermsofAcceptanc;
    private String place;
   private String Companey;
    private String Owner;

    public MyJob(){

    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String name) {
        Subject = name;
    }

    public String getTermsofAcceptanc() {
        return TermsofAcceptanc;
    }

    public void setTermsofAcceptanc(String termsofAcceptanc) {
        TermsofAcceptanc = termsofAcceptanc;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCompaney()
    {
        return Companey;
    }
    public void setCompaney(String companey) {
        Companey = companey;
    }

    public String getOwner()
    {
    return Owner;
}

    public void setOwner(String owner) {
        Owner = owner;
    }
    @Override
    public String toString() {
        return "MyJob{" +
                "key='" + key + '\'' +
                ", Subject='" + Subject + '\'' +
                ", TermsofAcceptanc='" + TermsofAcceptanc + '\'' +
                ", place='" + place + '\'' +
                ", Companey='" + Companey + '\'' +
                ", Owner='" + Owner + '\'' +
                '}';
    }
}
