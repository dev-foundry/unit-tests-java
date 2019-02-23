package pl.devfoundry.testing.account;

import java.util.List;
import java.util.stream.Collectors;

class AccountService {

    private AccountRepository accountRepository;

    AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    List<Account> getAllActiveAccounts() {
        return accountRepository.getAllAccounts().stream()
                .filter(Account::isActive)
                .collect(Collectors.toList());
    }

    List<String> findByName(String name) {
        return accountRepository.getByName(name);
    }

}
