package org.akshat.yummy.service;

import org.akshat.yummy.dto.CustomerRequest;
import org.akshat.yummy.dto.CustomerResponse;
import org.akshat.yummy.dto.CustomerLogin;
import org.akshat.yummy.dto.UpdateRequest;
import org.akshat.yummy.entity.Customer;
import org.akshat.yummy.mapper.CustomerMapper;
import org.akshat.yummy.repo.CustomerRepo;
import org.akshat.yummy.exception.CustomerNotFoundException;
import org.akshat.yummy.helper.EncryptionService;
import org.akshat.yummy.helper.JWTHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public String login(CustomerLogin request) {
        Customer customer = getCustomer(request.email());
        if(!encryptionService.validates(request.password(), customer.getPassword())) {
            return "Wrong Password or Email";
        }
        JWTHelper jwt = new JWTHelper();
        return jwt.generateToken(request.email());
    }

    public String updateCustomer(UpdateRequest request) {
        Optional<Customer> curVal = repo.findByEmail(request.email());
        if(request.firstName()!=null){
            curVal.get().setFirstName(request.firstName());
        }
        if(request.lastName()!=null){
            curVal.get().setFirstName(request.lastName());
        }
        if(request.addressLine1()!=null){
            curVal.get().setAddressLine1(request.addressLine1());
        }
        if(request.addressLine2()!=null){
            curVal.get().setAddressLine2(request.addressLine2());
        }
        if(request.city()!=null){
            curVal.get().setCity(request.city());
        }
        if(request.pincode()!=null){
            curVal.get().setPincode(request.pincode());
        }
        repo.save(curVal.get());
        return "account updated";
    }

}
