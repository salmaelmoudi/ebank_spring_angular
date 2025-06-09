package ma.emsi.ebanking.repositories;

import ma.emsi.ebanking.entities.BankAccount;
import ma.emsi.ebanking.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}