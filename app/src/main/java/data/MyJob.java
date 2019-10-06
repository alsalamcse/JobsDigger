package data;

public class MyJob
{
    String key;
    String Subject;
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
                ", Subject='" + Subject+ '\'' +
                ", TermsofAcceptanc='" + TermsofAcceptanc + '\'' +
                ", place='" + place + '\'' +
                ", Companey='" + Companey + '\'' +
                '}';
    }





}
