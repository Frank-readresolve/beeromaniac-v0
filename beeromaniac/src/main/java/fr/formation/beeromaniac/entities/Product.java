package fr.formation.beeromaniac.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "products",
	uniqueConstraints = {
		@UniqueConstraint(name = "products_ean_UNIQUE",
			columnNames = { "ean" }),
		@UniqueConstraint(name = "products_reference_UNIQUE",
			columnNames = { "reference" }) },
	indexes = { @Index(name = "products_brand_id_IDX",
		columnList = "brand_id") })
public class Product extends AbstractEntity {

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "products_brand_id_FK"),
	    nullable = false)
    private Brand brand;

    @Column(columnDefinition = "SMALLINT(5) UNSIGNED", nullable = false)
    private int reference;

    @Column(columnDefinition = "CHAR(13)", nullable = false)
    private String ean;

    @Column(length = 50, nullable = false)
    private String designation;

    @Column(columnDefinition = "ENUM('CAN', 'BOTTLE')", nullable = false)
    @Enumerated(EnumType.STRING)
    private Container container;

    @Column(columnDefinition = "SMALLINT(5) UNSIGNED", nullable = false)
    private int volume;

    @Column(columnDefinition = "DECIMAL(4, 2) UNSIGNED", nullable = false)
    private float abv;

    @Column(columnDefinition = "DECIMAL(3, 1) UNSIGNED", nullable = false)
    private float price;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime creationDate;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime modificationDate;

    @Column
    private String imageUrl;

    protected Product() {
	// Default no-arg constructor for libs
    }

    @Override
    public int hashCode() {
	return Objects.hash(ean);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!(obj instanceof Product)) {
	    return false;
	}
	Product other = (Product) obj;
	return Objects.equals(ean, other.ean);
    }

}
