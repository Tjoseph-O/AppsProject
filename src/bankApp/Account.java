package bankApp;

public class Account {

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

    public void withdraw(int withdrawal, String password) {
        if (this.password.equals(password)) {
            if (balance >= withdrawal) balance -= withdrawal;
        }else System.out.println("wrong password");
    }
    public void setAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber(){return accountNumber;}
}
