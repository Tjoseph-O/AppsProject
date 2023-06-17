package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    Bank joshNickBank;

    @BeforeEach
    void setUp() { joshNickBank = new Bank();}

    @Test public void objectOfBankExist() {assertNotNull(joshNickBank);}
    @Test public void testingIf_iCan_createAn_accountNumber(){
        joshNickBank.openAccount("1111");
        assertEquals(1, joshNickBank.getSizeOfAccounts());
    }
    @Test public void bankCan_createMultipleAccounts(){
        joshNickBank.openAccount("1111");
        joshNickBank.openAccount("1111");
        joshNickBank.openAccount("1111");
        joshNickBank.openAccount("1111");
        assertEquals(4, joshNickBank.getSizeOfAccounts());
    }
    @Test public void bankCanDepositToAccountAndAlsoCheckBalance(){
        joshNickBank.openAccount("1111");
        assertEquals(1, joshNickBank.getSizeOfAccounts());
        joshNickBank.depositToAccount("1122330", 500);
        assertEquals(500, joshNickBank.checkAccountBalance("1111", "1122330"));
    }
    @Test public void bankCanDepositAgain(){
        joshNickBank.openAccount("1111");
        assertEquals(1, joshNickBank.getSizeOfAccounts());
        joshNickBank.depositToAccount("1122330", 5000);
        assertEquals(5000, joshNickBank.checkAccountBalance("1111", "1122330"));
    }

    @Test public void iCanDoInterBank_transfer(){
        joshNickBank.openAccount("1111");
        joshNickBank.openAccount("2222");
        assertEquals(2, joshNickBank.getSizeOfAccounts());
        joshNickBank.depositToAccount("1122330", 5000);
        joshNickBank.intraBankTransfer(1000,"1122330","1122331","1111" );
        assertEquals(4_000, joshNickBank.checkAccountBalance("1111", "1122330"));
        assertEquals(1000, joshNickBank.checkAccountBalance("2222", "1122331"));
    }

    @Test public void iWantToBe_ableTo_withdraw(){
        joshNickBank.openAccount("3333");
        joshNickBank.depositToAccount("1122330", 20_000);
        joshNickBank.withdraw("1122330", "3333", 10_000);
        assertEquals(10_000,joshNickBank.checkAccountBalance("3333","1122330"));

    }

    @Test public void testIf_iCan_transferMore_thanIHave_inMyAccount(){
        joshNickBank.openAccount("3333");
        joshNickBank.openAccount("4444");
        joshNickBank.depositToAccount("1122330", 100_000);
        joshNickBank.intraBankTransfer(900_000,"1122330", "1122331","3333");
        assertEquals(100_000, joshNickBank.checkAccountBalance("3333", "1122330"));
        assertEquals(0, joshNickBank.checkAccountBalance("4444", "1122331"));



    }
}
