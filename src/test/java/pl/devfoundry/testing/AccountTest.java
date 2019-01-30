package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AccountTest {


    @Test
    public void myFirstTest() {
        Account newAccount = new Account();

        assertFalse(newAccount.isActive(), "Newly created account is not activated");
    }
}