package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountTest {

    @Test
    void newlyCreatedAccountShouldNotBeActive() {

        //given
        Account newAccount = new Account();

        //then
        assertFalse(newAccount.isActive());
    }

    @Test
    void activatedAccountShouldHaveActiveFlagSet() {

        //given
        Account newAccount = new Account();

        //when
        newAccount.activate();

        //then
        assertTrue(newAccount.isActive());

    }

}