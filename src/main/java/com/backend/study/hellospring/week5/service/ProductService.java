package com.backend.study.hellospring.week5.service;

import com.backend.study.hellospring.week5.entity.Product;
import com.backend.study.hellospring.week5.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // [비즈니스 로직 1] 상품 등록 기능
    // 누군가 이름과 가격을 주면 -> 포장해서 -> 창고에 넣는다
    public void createProduct(String name, Integer price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        productRepository.save(product);
    }

    // [비즈니스 로직 2] 상품 조회 기능
    // ID를 주면 -> 창고에서 찾아온다
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
