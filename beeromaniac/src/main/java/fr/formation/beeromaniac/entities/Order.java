package fr.formation.beeromaniac.entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "orders",
	uniqueConstraints = {
		@UniqueConstraint(name = "orders_reference_UNIQUE",
			columnNames = { "reference" }) },
	indexes = {
		@Index(name = "orders_customer_id_IDX",
			columnList = "customer_id"),
		@Index(name = "orders_address_id_IDX",
			columnList = "address_id") })
public class Order extends AbstractEntity {

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "orders_customer_id_FK"),
	    nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "orders_address_id_FK"),
	    nullable = false)
    private Address address;

    @Column(columnDefinition = "CHAR(36)", nullable = false)
    private UUID reference;

    @Column(nullable = false)
    private LocalDate orderDate;

    @Column(nullable = false)
    private LocalDate expectedDeliveryDate;

    @Column(columnDefinition = "DECIMAL(4, 2) UNSIGNED", nullable = false)
    private float deliveryPrice;

    @Column(columnDefinition = "DECIMAL(10, 2) UNSIGNED", nullable = false)
    private double totalItems;

    @Column(columnDefinition = "DECIMAL(10, 2) UNSIGNED", nullable = false)
    private double grandTotal;

    protected Order() {
	// Default no-arg constructor for libs
    }

}
