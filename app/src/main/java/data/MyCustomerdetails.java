package data;

public class MyCustomerdetails
{


    private String Key;
    private String education;
    private String age;
    private String history;
    private String skills;
    private String lang;
    private String inter;
    private String ref;
    private String cou;
    private String idnum;
    private String owner;

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }



    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
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

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
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
    @Override
    public String toString() {
        return "customerdetails{" +
                "education='" + education + '\'' +
                ", age='" + age + '\'' +
                ", history='" + history + '\'' +
                ", skills='" + skills + '\'' +
                ", lang='" + lang + '\'' +
                ", inter='" + inter + '\'' +
                ", ref='" + ref + '\'' +
                ", cou='" + cou + '\'' +
                ", idnum='" + idnum + '\'' +
                ",owner='"+owner+'\''+
                ",Key='"+Key+'\''+
                '}';
    }



}
