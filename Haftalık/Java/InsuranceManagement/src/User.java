import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
public class User {
    private final ArrayList<Address> addressList;
    static private  final ArrayList<Insurance> InsuranceList =new ArrayList<>();
private final String name;
private final String surName;
private final String email;
private final String password;
private  final String job;
private final String age;
private Date lastLogin ;

    public User( String name, String surName, String email, String password, String job, String age) {
        this.addressList = new ArrayList<>();
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
        this.job = job;
        this.age = age;
        lastLogin =new Date();
        lastLogin=Date.from(Instant.now());
    }

    public ArrayList<Address> getAddressList() {
        return addressList;
    }
    public static ArrayList<Insurance> getInsuranceList(){
        return InsuranceList;
    }

    public String getName() {
        return name;
    }



    public String getsName() {
        return surName;
    }



    public String getEmail() {
        return email;
    }



    public String getPassword() {
        return password;
    }


    public String getAge() {
        return age;
    }



    public String getLastLogin() {
        return lastLogin.toString();
    }

    public void setLastLogin() {
        lastLogin = Date.from(Instant.now());
    }


}


