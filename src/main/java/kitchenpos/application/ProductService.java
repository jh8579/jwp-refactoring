package kitchenpos.application;

import kitchenpos.dao.ProductDao;
import kitchenpos.domain.Product;
import kitchenpos.dto.ProductDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductDao productDao;

    public ProductService(final ProductDao productDao) {
        this.productDao = productDao;
    }

    @Transactional
    public ProductDto create(final ProductDto productDto) {
        Product product = productDto.toProduct();
        Product savedProduct = productDao.save(product);
        return ProductDto.from(savedProduct);
    }

    public List<ProductDto> list() {
        return productDao.findAll()
                         .stream()
                         .map(ProductDto::from)
                         .collect(Collectors.toList());
    }
}
