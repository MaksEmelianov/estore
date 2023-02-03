package com.estore.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    @NotNull(message = "Can't be null")
    @Size(min = 5, max = 250, message = "Minimum of 5 characters")
    private String title;

    @Column(name = "vendor_code")
    @NotNull(message = "Can't be null")
    @Pattern(regexp = "([0-9]+)", message = "Invalid data")
    @Size(min = 8, max = 8, message = "Must be 8 characters")
    private String vendorCode;

    @Column(name = "short_Description")
    private String shortDescription;

    @Column(name = "full_Description")
    private String fullDescription;

    @Column(name = "price")
    @NotNull(message = "Can't be null")
    @DecimalMin(value = "1", message = "The minimum value is 1")
    @Digits(integer = 5, fraction = 2)
    private Double price;

    @Column(name = "created")
    @CreationTimestamp
    private LocalDateTime created;

    @Column(name = "updated")
    @UpdateTimestamp
    private LocalDateTime updated;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "Can't be null")
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
    @Column(name = "imageList")
    private List<ProductImage> imageList;

    public void addImage(ProductImage productImage) {
        if (imageList == null) {
            imageList = new ArrayList<>();
        }
        imageList.add(productImage);
    }

    @Override
    public String toString() {
        return "Product title = '" + title + "'";
    }
}
