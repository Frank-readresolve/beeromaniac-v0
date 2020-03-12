package fr.formation.beeromaniac.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "carts_items",
	uniqueConstraints = { @UniqueConstraint(
		name = "carts_items_cart_id_product_id_UNIQUE",
		columnNames = { "cart_id", "product_id" }) },
	indexes = {
		@Index(name = "carts_items_cart_id_IDX",
			columnList = "cart_id"),
		@Index(name = "carts_items_product_id_IDX",
			columnList = "product_id") })
public class CartItem extends AbstractEntity {

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "carts_items_product_id_FK"),
	    nullable = false)
    private Product product;

    @Column(columnDefinition = "SMALLINT(5) UNSIGNED", nullable = false)
    private int quantity;

    protected CartItem() {
	// Default no-arg constructor for libs
    }

    @Override
    public int hashCode() {
	return Objects.hash(product);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!(obj instanceof CartItem)) {
	    return false;
	}
	CartItem other = (CartItem) obj;
	// See Product.equals(Object)
	return Objects.equals(product, other.product);
    }

}
