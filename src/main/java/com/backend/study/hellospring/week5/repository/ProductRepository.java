package com.backend.study.hellospring.week5.repository;

import com.backend.study.hellospring.week5.entity.Product;
import org.springframework.data.repository.CrudRepository;

//<관리할 엔티티, PK의 타입>
public interface ProductRepository extends CrudRepository<Product, Long> {
}
