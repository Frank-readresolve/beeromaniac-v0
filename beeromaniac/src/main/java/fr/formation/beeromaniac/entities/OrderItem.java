package fr.formation.beeromaniac.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "orders_items",
	uniqueConstraints = { @UniqueConstraint(
		name = "orders_items_order_id_product_id_unit_price_UNIQUE",
		columnNames = { "order_id", "product_id", "unit_price" }) },
	indexes = {
		@Index(name = "orders_items_order_id_IDX",
			columnList = "order_id"),
		@Index(name = "orders_items_product_id_IDX",
			columnList = "product_id") })
public class OrderItem extends AbstractEntity {

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "orders_items_order_id_FK"),
	    nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "orders_items_product_id_FK"),
	    nullable = false)
    private Product product;

    @Column(columnDefinition = "SMALLINT(5) UNSIGNED", nullable = false)
    private int quantity;

    @Column(name = "unit_price", columnDefinition = "DECIMAL(3, 1) UNSIGNED",
	    nullable = false)
    private float unitPrice;

    @Column(columnDefinition = "DECIMAL(10, 2) UNSIGNED", nullable = false)
    private double totalPrice;

    protected OrderItem() {
	// Default no-arg constructor for libs
    }

}
