package data;

public class MyJob
{
    String key;
    String Name;
    String TermsofAcceptanc;
    String place;
    String Companey;

    public MyJob(){

    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public String getCompaney() {
        return Companey;
    }

    public void setCompaney(String companey) {
        Companey = companey;
    }
    @Override
    public String toString() {
        return "MyJob{" +
                "key='" + key + '\'' +
                ", Name='" + Name + '\'' +
                ", TermsofAcceptanc='" + TermsofAcceptanc + '\'' +
                ", place='" + place + '\'' +
                ", Companey='" + Companey + '\'' +
                '}';
    }





}
