package fr.formation.beeromaniac.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "countries",
	uniqueConstraints = {
		@UniqueConstraint(name = "countries_iso_UNIQUE",
			columnNames = { "iso" }),
		@UniqueConstraint(name = "countries_name_UNIQUE",
			columnNames = { "name" }) })
public class Country extends AbstractEntity {

    @Column(columnDefinition = "CHAR(2)", nullable = false)
    private String iso;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(columnDefinition = "DECIMAL(4, 2) UNSIGNED", nullable = false)
    private float deliveryPrice;

    @Column(columnDefinition = "TINYINT(3) UNSIGNED", nullable = false)
    private short avgDeliveryTime;

    protected Country() {
	// Default no-arg constructor for libs
    }

}
