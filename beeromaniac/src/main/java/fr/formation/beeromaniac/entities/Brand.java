package fr.formation.beeromaniac.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "brands",
	uniqueConstraints = {
		@UniqueConstraint(name = "brands_reference_UNIQUE",
			columnNames = { "reference" }),
		@UniqueConstraint(name = "brands_name_UNIQUE",
			columnNames = { "name" }) })
public class Brand extends AbstractEntity {

    @Column(columnDefinition = "SMALLINT(5) UNSIGNED", nullable = false)
    private int reference;

    @Column(length = 50, nullable = false)
    private String name;

    protected Brand() {
	// Default no-arg constructor for libs
    }

    @Override
    public int hashCode() {
	return Objects.hash(reference);
    }

}
