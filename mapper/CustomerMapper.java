package org.akshat.yummy.mapper;

import org.akshat.yummy.dto.CustomerRequest;
import org.akshat.yummy.entity.Customer;
import org.springframework.stereotype.Service;
@Service

public class CustomerMapper {
    public Customer toEntity(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .addressLine1(request.addressLine1())
                .addressLine2(request.addressLine2())
                .city(request.city())
                .pincode(request.pincode())
                .build();
    }
}
