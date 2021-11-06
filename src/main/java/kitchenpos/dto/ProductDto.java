package kitchenpos.dto;

import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import kitchenpos.domain.Product;

public class ProductDto {
    private Long id;

    @NotEmpty
    private String name;

    @Min(value = 0)
    private BigDecimal price;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductDto(String name, BigDecimal price) {
        this(null, name, price);
    }

    public Product toProduct() {
        if (Objects.isNull(id)) {
            return new Product(name, price);
        }
        return new Product(id, name, price);
    }

    public static ProductDto from(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice());
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
