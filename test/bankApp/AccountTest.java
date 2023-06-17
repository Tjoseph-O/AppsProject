package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Account account;
    @BeforeEach
    void setUp() { account = new Account("password");}
    @Test public void objectExist(){
        assertNotNull(account);
    }
    @Test
    public void canIDepositInMyAccount() {
        account.deposit(50_000);
        assertEquals(50000, account.checkBalance("password"));
    }
    @Test public void CanIDepositTwice(){
        account.deposit(50_000);
        account.deposit(100_000);
        assertEquals(150000,account.checkBalance("password"));
    }
    @Test public void iWantTo_be_ableTo_withdraw(){
        account.deposit(50_000);
        account.deposit(100_000);
        account.withdraw(60_000, "password");
        assertEquals(90000,account.checkBalance("password"));
    }
    @Test public void testWithdrawalWhenThe_passwordIsWrong(){
        account.deposit(50_000);
        account.deposit(100_000);
        account.withdraw(60_000, "password");
        account.withdraw(40000, "joseph");
        assertEquals(90000,account.checkBalance("password"));
    }
    @Test public void accountBalanceReturnZeroWhenAWrongPasswordIsUsed(){
        account.deposit(50_000);
        assertEquals(0,account.checkBalance("pass"));
    }
}