package ma.emsi.ebanking;


import ma.emsi.ebanking.dtos.BankAccountDTO;
import ma.emsi.ebanking.dtos.CurrentBankAccountDTO;
import ma.emsi.ebanking.dtos.CustomerDTO;
import ma.emsi.ebanking.dtos.SavingBankAccountDTO;
import ma.emsi.ebanking.entities.*;
import ma.emsi.ebanking.enums.AccountStatus;
import ma.emsi.ebanking.enums.OperationType;
import ma.emsi.ebanking.exceptions.BalanceNotSufficientException;
import ma.emsi.ebanking.exceptions.BankAccountNotFoundException;
import ma.emsi.ebanking.exceptions.CustomerNotFoundException;
import ma.emsi.ebanking.repositories.AccountOperationRepository;
import ma.emsi.ebanking.repositories.BankAccountRepository;
import ma.emsi.ebanking.repositories.CustomerRepository;
import ma.emsi.ebanking.services.BankAccountService;
import ma.emsi.ebanking.services.BankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbankingApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(BankAccountService bankAccountService) {
		return args -> {
			Stream.of("Lamiae","Hajar","Widad").forEach(name->{
				CustomerDTO customer=new CustomerDTO();
				customer.setName(name);
				customer.setEmail(name+"@gmail.com");
				bankAccountService.saveCustomer(customer);
			});
			bankAccountService.listCustomers().forEach(cust->{
				try {
					bankAccountService.saveCurrentBankAccount(Math.random()*90000, 9000, cust.getId());
					bankAccountService.saveSavingBankAccount(Math.random()*120000, 5.5, cust.getId());

				} catch (CustomerNotFoundException e) {
					e.printStackTrace();
				}

			});
			List<BankAccountDTO> bankAccounts= bankAccountService.bankAccountList();
			for (BankAccountDTO bankAccount : bankAccounts) {
				for (int i = 0; i < 10; i++) {
					String accountId;
					if (bankAccount instanceof SavingBankAccountDTO) {
						accountId = ((SavingBankAccountDTO) bankAccount).getId();
					} else {
						accountId = ((CurrentBankAccountDTO) bankAccount).getId();
					}
					bankAccountService.credit(accountId, 1000 + Math.random() * 120000, "Credit");
					bankAccountService.debit(accountId, 1000 + Math.random() * 9000, "Debit");
				}
			}
		};
	}



	// @Bean
	CommandLineRunner start(CustomerRepository customerRepository,
							AccountOperationRepository accountOperationRepository,
							BankAccountRepository bankAccountRepository) {
		return args -> {
			Stream.of("Hanane","Sanaa","Ahmed").forEach(name->{
				Customer customer=new Customer();
				customer.setName(name);
				customer.setEmail(name+"@gmail.com");
				customerRepository.save(customer);

			});
			customerRepository.findAll().forEach(cust->{
				CurrentAccount currentAccount=new CurrentAccount();
				currentAccount.setId(UUID.randomUUID().toString());
				currentAccount.setBalance(Math.random()*90000);
				currentAccount.setCreatedAt(new Date());
				currentAccount.setStatus(AccountStatus.CREATED);
				currentAccount.setCustomer(cust);
				currentAccount.setOverdraft(9000);
				bankAccountRepository.save(currentAccount);

				SavingAccount savingAccount=new SavingAccount();
				savingAccount.setId(UUID.randomUUID().toString());
				savingAccount.setBalance(Math.random()*90000);
				savingAccount.setCreatedAt(new Date());
				savingAccount.setStatus(AccountStatus.CREATED);
				savingAccount.setCustomer(cust);
				savingAccount.setInterestRate(5.5);
				bankAccountRepository.save(savingAccount);


			});
			bankAccountRepository.findAll().forEach(acc -> {
				for (int i = 0; i < 10; i++) {
					AccountOperation accountOperation = new AccountOperation();
					accountOperation.setOperationDate(new Date());
					accountOperation.setAmount(Math.random() * 12000);
					accountOperation.setType(Math.random() > 0.5 ? OperationType.DEBIT : OperationType.CREDIT);
					accountOperation.setBankAccount(acc);
					accountOperationRepository.save(accountOperation);
				}

			});
		};
	}
}