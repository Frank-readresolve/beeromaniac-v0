package fr.formation.beeromaniac.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "addresses", indexes = {
	@Index(name = "addresses_city_id_IDX", columnList = "city_id") })
public class Address extends AbstractEntity {

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "addresses_city_id_FK"),
	    nullable = false)
    private City city;

    @Column(length = 100, nullable = false)
    private String road;

    protected Address() {
	// Default no-arg constructor for libs
    }

}
