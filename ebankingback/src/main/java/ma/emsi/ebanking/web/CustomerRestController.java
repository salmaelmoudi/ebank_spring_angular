package ma.emsi.ebanking.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.ebanking.dtos.AccountOperationDTO;
import ma.emsi.ebanking.dtos.CustomerDTO;
import ma.emsi.ebanking.entities.Customer;
import ma.emsi.ebanking.exceptions.BankAccountNotFoundException;
import ma.emsi.ebanking.exceptions.CustomerNotFoundException;
import ma.emsi.ebanking.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@Slf4j
public class CustomerRestController {
    private BankAccountService bankAccountService;
    @GetMapping ("/customers")
    public List<CustomerDTO> customers() {
        return bankAccountService.listCustomers();
    }
    @GetMapping ("/customers/search")
    public List<CustomerDTO> searchCustomers(@RequestParam(name ="keyword",defaultValue = "") String keyword) {
        return bankAccountService.searchCustomers("%"+keyword+"%");
    }

    @GetMapping ("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable(name = "id") Long customerId) throws CustomerNotFoundException {

        return bankAccountService.getCustomer(customerId);
    }
    @PostMapping ("/customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return bankAccountService.saveCustomer(customerDTO);
    }
    @PutMapping ("/customers/{id}")
    public CustomerDTO updateCustomer(@PathVariable(name = "id") Long customerId, @RequestBody CustomerDTO customerDTO) throws CustomerNotFoundException {
        customerDTO.setId(customerId);
        return bankAccountService.updateCustomer(customerDTO);
    }
    @DeleteMapping ("/customers/{id}")
    public void deleteCustomer(@PathVariable(name = "id") Long customerId) throws CustomerNotFoundException {
        bankAccountService.deleteCustomer(customerId);
    }

}