
package data;

import com.example.jobsdigger.AddJobScreen;

import java.lang.reflect.Array;

public class MyCompany

{
    private String Email;
    private String password;
    private String Name;
    private String place;
    private String phone;
    private MyJobSearcher[]JobSearcher;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



}
