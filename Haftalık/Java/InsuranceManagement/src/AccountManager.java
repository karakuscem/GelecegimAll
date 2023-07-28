import java.time.Instant;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;

public class AccountManager {
    TreeSet<Account> accounts;
    User currentUser;
    Account account;
    AccountManager(){
        accounts = new TreeSet<>();
        run();

    }
    public void run(){
        Scanner src =new Scanner(System.in);
        String choice ="  ";
        while (!choice.equals("3")){
            System.out.println("1 - Create an Account"+
                    "\n 2 - Login to Account "+
                    "\n 3 - Exit " +
                    "\n 4 - Admin Login ");
            System.out.print("Choice : ");
            choice=src.nextLine();


            if (choice.equals("1")){
                createAccount();
            } else if (choice.equals("2")) {
                System.out.print("Enter email : ");
                String email = src.nextLine();
                System.out.print("Enter password : ");
                String password = src.nextLine();

            login(email,password);
            } else if (choice.equals("4")) {
                System.out.println("Printing all accounts and passwords in the system ...");
                for (Account a: getAccounts())
                    System.out.println("Email : "+a.getUser().getEmail()+" \nPassword : "+a.getUser().getPassword());

                System.out.println("Printing all InsuranceList in the system ...");
                for (Insurance a:User.getInsuranceList())
                    System.out.println("\nCustomer name : "+a.getUser().getName()+"\nInsurance Name : "+a.getInsuranceName()+"\nTotal price : "+a.getInsurancePrice());
            }
        }
    }
    public void createAccount(){
        Scanner src =new Scanner(System.in);
        String name,surName,email,password,job,age;
        System.out.print("Enter name : "); name = src.nextLine();
        System.out.print("Enter surname : "); surName = src.nextLine();
        System.out.print("Enter email : "); email = src.nextLine();
        System.out.print("Enter password : "); password = src.nextLine();
        System.out.print("Enter job : "); job = src.nextLine();
        System.out.print("Enter age : "); age = src.nextLine();
        User user =new User(name,surName,email,password,job,age);
        
        System.out.print("Are you individual (1 for yes 0 for no) : ");
        name=src.nextLine();
        Account prop;
        if (name.equals("1")){
            prop =new Individual(user);
        }else {
            prop = new Enterprise(user);
        }
        accounts.add(prop);
 
 
    }
    public void login (String email , String password){
        for (Account account : accounts){
            try {
                account.login(email,password);
                if (account.isLogin()){
                    currentUser =account.getUser();
                    this.account =account;

                 if (account.getType() == 1){
                    individualUserProcess();
                 }else {
                     individualUserProcess();
                 } break;

                }
            }catch (InvalidAuthenticationException e){
                
            }
        }
    }
    public void individualUserProcess(){
        System.out.println("Welcome " +currentUser.getName());
        String choice ="1";
        while (!choice.equals("q")){
            Scanner src = new Scanner(System.in);
            System.out.println("\n1-) Show my infos");
            System.out.println("2-) Get Insurance");
            System.out.println("3-) Show Insurance List");
            System.out.println("4-) Add Address");
            System.out.println("5-) Show All Address");
            choice = src.nextLine();

            if (choice.equals("1")){
                account.showInfo();
            } else if (choice.equals("2")) {
                InsuranceManager insuranceManager =new InsuranceManager();
                account.addInsurance(insuranceManager.createInsurance(currentUser));
            } else if (choice.equals("3")) {
                for (Insurance insurance: account.getUser().getInsuranceList()) {
                    System.out.print(" \n  Name : "+ insurance.getInsuranceName());
                    System.out.println("Prace : "+insurance.getInsurancePrice());
                }
            } else if (choice.equals("4")) {
                account.addAddress(AddresManager.createHomeAddress());
            } else if (choice.equals("5")) {
                for (Address address:currentUser.getAddressList()){
                    System.out.println(currentUser.getAddressList());
                }
            }


        }
    }
    public  void enterpriseUserProcess(){}
    public  TreeSet<Account>getAccounts(){
        return accounts;
    }
}
