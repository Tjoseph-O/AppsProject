package bankApp;

public class Account {
    private String firstName;
    private String lastName;

    private String passWord;

    private int balance;
    private String accountNumber;
    private String password;

    public Account(String password) {
        this.password = password;
    }
    public  void deposit(int amount) {
        balance += amount;
        System.out.println(balance);

    }

    public int checkBalance(String password) {
        if (this.password.equals(password)) return balance;
        return 0;
    }

//    public void withdraw(int withdrawal, String password) {
//        if (this.password.equals(password)) {
//            if (balance >= withdrawal)
//                balance -= withdrawal;else System.out.println("Insufficient Funds");
//        }else System.out.println("wrong password");
//    }
    public void withdraw(int withdrawal, String password){
        if(!this.password.equals(password)) System.out.println("Enter correct password");
        else if (withdrawal > balance || withdrawal <0) System.out.println("insufficient fund");
        else balance -= withdrawal;

    }
    public void setAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber(){return accountNumber;}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public  String toString(){

        return String.format("""
                NAME: %s%n
                ACCOUNT NUMBER: %s%n
                BALANCE: %s%n
                """,(firstName + "" + lastName) , accountNumber, balance);

    }
}
