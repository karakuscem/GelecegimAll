import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public abstract class Insurance {
    private String insuranceName;
    private double insurancePrice;
    private Date insuranceDate;
    private final User user;

    public Insurance(String insuranceName, double insurancePrice, Date insuranceDate, User user) {
        this.insuranceName = insuranceName;
        this.insurancePrice = insurancePrice;
        this.insuranceDate = insuranceDate;
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    public abstract double calculate(double insurancePrice);

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public double getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(double insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public Date getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(Date insuranceDate) {
        this.insuranceDate = insuranceDate;
    }
}
class HealtInsurance extends  Insurance{
    public HealtInsurance(String insuranceName, double insurancePrice, Date insuranceDate, User user) {
        super(insuranceName, insurancePrice, insuranceDate, user);
    }

    @Override
    public double calculate(double insurancePrice) {
        System.out.println(" 12 month insurance plan cost is : "+insurancePrice*12);
        return insurancePrice*12;
    }
}
class ResidanceInsrance extends Insurance{


    public ResidanceInsrance(String insuranceName, double insurancePrice, Date insuranceDate, User user) {
        super(insuranceName, insurancePrice, insuranceDate, user);

    }
    @Override
    public double calculate(double insurancePrice) {
        System.out.println("24 mount insurance plan cost is : "+insurancePrice*24);
        return insurancePrice*24;
    }
}
class TravelInsurance extends Insurance{


    public TravelInsurance(String insuranceName, double insurancePrice, Date insuranceDate, User user) {
        super(insuranceName, insurancePrice, insuranceDate, user);

    }
    @Override
    public double calculate(double insurancePrice) {
        System.out.println( "6 mount insurance plan cost is : "+insurancePrice*6);

        return insurancePrice*6;
    }
}
class CarInsurance extends  Insurance{
    public CarInsurance(String insuranceName, double insurancePrice, Date insuranceDate, User user) {
        super(insuranceName, insurancePrice, insuranceDate, user);

    }

    @Override
    public double calculate(double insurancePrice) {
        System.out.println("24 mount insurance plan cost is : "+insurancePrice*24);
        return insurancePrice*24;
    }
}

class InsuranceManager{
    User user;

    public InsuranceManager() {
    }
    public Insurance createInsurance(User user){
        Scanner src = new Scanner(System.in);
        System.out.println("Select one of Insurance : "+
                "\n 1 - Healt "+
                "\n 2 - Residance "+
                "\n 3 - Travel " +
                "\n 4 - Car ");
        String choice =src.nextLine();
        System.out.print("Enter amount :");
        double price =src.nextInt();

        if (choice.equals("1")) return new HealtInsurance("Healt Insurance",1.98,Date.from(Instant.now()), user);
        if (choice.equals("2")) return new ResidanceInsrance("Residance Insurance",1.46,Date.from(Instant.now()),user);
        if (choice.equals("3")) return new TravelInsurance("Travel Insurance ",1.30,Date.from(Instant.now()),user);
        return new CarInsurance("Car Insurance",1.50,Date.from(Instant.now()),user);
    }
}
