package com.example.jobsdigger.data;

public class MyCustomerdetails {


    private String Key;
    private String age;
    private String history;
    private String skills;
    private String lang;
    private String inter;
    private String cou;
    private String idnum;
    private String FullName;
    private String Phone;
    private String owner;

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getInter() {
        return inter;
    }

    public void setInter(String inter) {
        this.inter = inter;
    }


    public String getCou() {
        return cou;
    }

    public void setCou(String cou) {
        this.cou = cou;
    }

    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "MyCustomerdetails{" +
                "Key='" + Key + '\'' +
                ", age='" + age + '\'' +
                ", history='" + history + '\'' +
                ", skills='" + skills + '\'' +
                ", lang='" + lang + '\'' +
                ", inter='" + inter + '\'' +
                ", cou='" + cou + '\'' +
                ", idnum='" + idnum + '\'' +
                ", FullName='" + FullName + '\'' +
                ", Phone='" + Phone + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
