package kitchenpos.domain;

import java.math.BigDecimal;
import java.util.Objects;

import kitchenpos.dto.ProductDto;

public class Product {
    private Long id;
    private String name;
    private BigDecimal price;

    public Product() {
    }

    public Product(Long id, String name, BigDecimal price) {
        validatePrice(price);

        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, BigDecimal price) {
       this(null, name, price);
    }

    private static void validatePrice(BigDecimal price) {
        if (Objects.isNull(price) || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }
}
