package fr.formation.beeromaniac.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(20) UNSIGNED")
    private Long id;

    protected AbstractEntity() {
	// Default no-arg constructor for implementors
    }

    @SuppressWarnings("unused")
    private void setId(Long id) {
	this.id = id;
    }

    public final Long getId() {
	return id;
    }

}
