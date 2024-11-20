package org.akshat.yummy.mapper;

import org.akshat.yummy.dto.ProductResponse;
import org.akshat.yummy.dto.ProductRequest;
import org.akshat.yummy.entity.Product;
import org.springframework.stereotype.Service;
@Service

public class ProductMapper {
    public Product toEntity(ProductRequest request) {
        return Product.builder()
                .pname(request.Name())
                .Price(request.Price())
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getPname(),
                product.getPrice()
        );
    }
}
