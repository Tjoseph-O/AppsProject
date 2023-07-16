package bankApp;

import javax.swing.*;

public class Main {
    private static Bank nick = new Bank();



    public static void main(String[] args) {
        mainMenu();

    }

    public static void mainMenu(){
        String  entries = """
                *************************
                *************************
                Welcome To JoshNick Bank
                1-> create Account
                2-> Deposit
                3-> Withdraw
                4-> Transfer
                5-> Balance
                6-> Exit
                ***********************
                ***********************""";
        String userInput = input(entries);
        switch (userInput.charAt(0)){
            case '1' -> createAccount();
            case '2' -> deposit();
            case '3' -> withDraw();
            case '4' -> transfer();
        }
    }
    public static void createAccount(){
        String firstName = input("Enter your firstName");
        digitCheck(firstName);
        String lastName = input("Enter your lastName");
        digitCheck(lastName);
        String passWord = input("Enter your four digit pin");
        alphaCheck(passWord);
        display(nick.openAccount(firstName,lastName,passWord));
        display("Account Creation Sucessful");
        mainMenu();
    }

    private static void digitCheck(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) >= '0' && name.charAt(i) <= '9') {
                createAccount();
                //throw new JoshNickException("Digit is not allowed");
            }
        }
    }
    private static void alphaCheck(String pin) {
        for (int i = 0; i < pin.length(); i++) {
            if (pin.charAt(i) < '0' || (pin.charAt(i) > '9')) {
                createAccount();
            }
        }
    }


    public static void deposit(){
        String accountNumberToDeposit = input("receiver's Account");
        digitCheck(accountNumberToDeposit);
        int amount = Integer.parseInt(input("Enter amount"));

//        display(nick.depositToAccount(accountNumberToDeposit,amount));
        display("Deposit Sucessful");
        mainMenu();
    }

    public static void withDraw(){
        String accountNumberToWithDraw = input("account Number");
        digitCheck(accountNumberToWithDraw);
        int amountToWithDraw = Integer.parseInt(input("withdrawal Amount"));
        digitCheck(accountNumberToWithDraw);
        String passWord = input("password");
        digitCheck(passWord);

        display("withDraw Sucessful");
        mainMenu();
    }

    public static void transfer(){
        int amount = Integer.parseInt(input("Transfer Amount"));
        String senderAccountNumber = input("Your Account Number");
        String receiverAccountNumber = input("Receiver's Number");
        String password = input("password");
        display("Transfer  Sucessful");


    }

    public static void balance(){

    }



    private static void display(String message) {
        JOptionPane.showMessageDialog(null,message);
           // JOptionPane.showInputDialog(null,message);
    }

    public static String input(String message){

        return JOptionPane.showInputDialog(message);
    }
}
