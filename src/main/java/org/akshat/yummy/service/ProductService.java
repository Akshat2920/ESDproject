package org.akshat.yummy.service;

import org.akshat.yummy.dto.ProductResponse;
import org.akshat.yummy.dto.ProductRequest;
import org.akshat.yummy.dto.ProductUpdate;
import org.akshat.yummy.entity.Product;
import org.akshat.yummy.exception.ProductNotFoundException;
import org.akshat.yummy.mapper.ProductMapper;
import org.akshat.yummy.repo.ProductRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo repo;
    private final ProductMapper mapper;

    public String addProduct(ProductRequest request) {
        Product product = mapper.toEntity(request);
        repo.save(product);
        return "Product added successfully";
    }

    public Product getProduct(String Name) {
        return repo.findByPname(Name)
                .orElseThrow(() -> new ProductNotFoundException(
                        format("%s not found", Name)));
    }

    public ProductResponse retrieveProduct(String Name) {
        Product product = getProduct(Name);
        return mapper.toProductResponse(product);
    }

    public String updateProduct(ProductUpdate request, String Name) {
        Product product = getProduct(Name);
        if(request.Name()!=null)
            product.setPname(request.Name());
        if(request.Price()!=null)
            product.setPrice(request.Price());
        repo.save(product);
        return "Product updated successfully";
    }

    public String deleteProduct(String Name) {
        repo.delete(getProduct(Name));
        return "Product deleted successfully";
    }

    public List<Product> getTopProducts(Integer minPrice, Integer maxPrice) {
        return repo.findProductbyPrice(minPrice, maxPrice);
    }
}
