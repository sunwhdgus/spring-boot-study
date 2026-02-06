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

    // [비즈니스 로직 3] 상품 수정 기능
    // ID로 찾아서, 내용을 바꾸고, 다시 저장한다.

    public void updateProduct(Long id, String newName, Integer newPrice) {
        // 1. 대상을 찾는다 (없으면 에러 띄움)
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id =" + id));

        // 2. 내용을 바꾼다
        product.setName(newName);
        product.setPrice(newPrice);

        // 3. 덮어씌운다 (이미 있는 ID면 알아서 수정됨)
        productRepository.save(product);
    }

    // [비즈니스 로직 4] 상품 삭제 기능
    // ID로 찾아서 삭제한다.
    public void deleteProduct(Long id) { productRepository.deleteById(id); }
}
