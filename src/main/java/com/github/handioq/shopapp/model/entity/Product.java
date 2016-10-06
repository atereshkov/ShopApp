package com.github.handioq.shopapp.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.ALL})
    private Set<Image> images;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        return images != null ? images.equals(product.images) : product.images == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (images != null ? images.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", images=" + images +
                '}';
    }
}
