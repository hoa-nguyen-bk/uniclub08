package com.cybersoft.uniclub08.services.imp;

import com.cybersoft.uniclub08.entity.Color;
import com.cybersoft.uniclub08.entity.Product;
import com.cybersoft.uniclub08.entity.Size;
import com.cybersoft.uniclub08.entity.Variant;
import com.cybersoft.uniclub08.respository.ProductRepository;
import com.cybersoft.uniclub08.respository.VariantRepository;
import com.cybersoft.uniclub08.services.ProductServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductServicesImp implements ProductServices {
//    @Autowired
//    private FileServices fileServices;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private VariantRepository variantRepository;

    @Transactional
    @Override
    public void insertProduct(MultipartFile file, String name, String desc, double price, int idSize, int idColor, int quantity){
        Product product = new Product();
        product.setName(name);
        product.setDescription(desc);
        product.setPrice(price);

        Product productInserted = productRepository.save(product);
        Color color = new Color();
        color.setId(idColor);

        Size size = new Size();
        size.setId(idSize);

        Variant variant = new Variant();
        variant.setSize(size);
        variant.setProduct(productInserted);
        variant.setColor(color);
        variant.setQuantity(quantity);
        variant.setImages(file.getOriginalFilename());


        fileServices.save(file);
        variantRepository.save(variant);
    }
}