package fr.formation.beeromaniac.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "carts",
	uniqueConstraints = { @UniqueConstraint(
		name = "carts_customer_id_creation_date_UNIQUE",
		columnNames = { "customer_id", "creation_date" }) },
	indexes = { @Index(name = "carts_customer_id_IDX",
		columnList = "customer_id") })
public class Cart extends AbstractEntity {

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "carts_customer_id_FK"),
	    nullable = false)
    private Customer customer;

    @Column(name = "creation_date", columnDefinition = "DATETIME",
	    nullable = false)
    private LocalDateTime creationDate;

    @OneToMany
    @JoinColumn(name = "cart_id",
	    foreignKey = @ForeignKey(name = "carts_items_cart_id_FK"),
	    nullable = false)
    private Set<CartItem> items;

    protected Cart() {
	// Default no-arg constructor for libs
    }

}
