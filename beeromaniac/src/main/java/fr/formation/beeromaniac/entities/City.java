package fr.formation.beeromaniac.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cities", indexes = {
	@Index(name = "cities_country_id_IDX", columnList = "country_id") })
public class City extends AbstractEntity {

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "cities_country_id_FK"),
	    nullable = false)
    private Country country;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String zipCode;

    protected City() {
	// Default no-arg constructor for libs
    }

}
