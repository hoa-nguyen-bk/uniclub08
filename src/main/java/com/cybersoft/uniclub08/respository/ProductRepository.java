package com.cybersoft.uniclub08.respository;

import com.cybersoft.uniclub08.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
