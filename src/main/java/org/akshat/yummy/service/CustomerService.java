package org.akshat.yummy.service;

import org.akshat.yummy.dto.CustomerRequest;
import org.akshat.yummy.dto.CustomerResponse;
import org.akshat.yummy.dto.CustomerLogin;
import org.akshat.yummy.entity.Customer;
import org.akshat.yummy.mapper.CustomerMapper;
import org.akshat.yummy.repo.CustomerRepo;
import org.akshat.yummy.exception.CustomerNotFoundException;
import org.akshat.yummy.helper.EncryptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;
import static java.lang.String.format;
@Service
@RequiredArgsConstructor

public class CustomerService {
    private final CustomerRepo repo;
    private final CustomerMapper mapper;
    private final EncryptionService encryptionService;

    public String createCustomer(CustomerRequest request) {
        Customer customer = mapper.toEntity(request);
        customer.setPassword(encryptionService.encode(customer.getPassword()));
        repo.save(customer);
        return "Account created";
    }
    public Customer getCustomer(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update Customer:: No customer found with the provided ID:: %s", email)
                ));
    }
    public CustomerResponse retrieveCustomer(String email) {
        Customer customer = getCustomer(email);
        return mapper.toCustomerResponse(customer);
    }

    public void deleteCustomer(String email) {
        repo.delete(getCustomer(email));
    }
}
