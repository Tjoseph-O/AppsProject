package bankApp;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    
    
    public void openAccount(String password) {
        String accountNumber = "112233" + accounts.size();
        Account account = new Account(password);
        account.setAccount(accountNumber);
        accounts.add(account);
    }
    public int getSizeOfAccounts() {
        return accounts.size();
    }
    public void depositToAccount(String accountNumber, int amount) {
        Account account = findAccountNumber(accountNumber);
        account.deposit(amount);
    }

    private Account findAccountNumber(String accountNumber) {
        for (Account account : accounts) if (account.getAccountNumber().equals(accountNumber)) return account;
        return null;
    }
    public int checkAccountBalance(String password, String accountNumber) {
        Account account = findAccountNumber(accountNumber);
        assert account != null;
        return account.checkBalance(password);

    }


    public void intraBankTransfer(int amount, String sendersAccountNumber, String receiverAccountNumber, String password) {



        
        Account sender = findAccountNumber(sendersAccountNumber);
        Account  receiver = findAccountNumber(receiverAccountNumber);
        sender.withdraw(amount, password);
        receiver.deposit(amount);
    }

    public void withdraw(String accountNumber, String password, int amount) {
        Account account = findAccountNumber(accountNumber);
        account.withdraw(amount, password);

    }
}
