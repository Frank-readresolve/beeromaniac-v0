package fr.formation.beeromaniac.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "customers",
	uniqueConstraints = { @UniqueConstraint(name = "customers_email_UNIQUE",
		columnNames = { "email" }) },
	indexes = {
		@Index(name = "customers_user_id_IDX", columnList = "user_id"),
		@Index(name = "customers_address_id_IDX",
			columnList = "address_id") })
public class Customer extends AbstractEntity {

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "customers_address_id_FK"),
	    nullable = false)
    private Address address;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "customers_user_id_FK"))
    private User user;

    @Column(length = 50, nullable = false)
    private String firstname;

    @Column(length = 50, nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String email;

    @Column(length = 20)
    private String phone;

    protected Customer() {
	// Default no-arg constructor for libs
    }

}
