package fr.formation.beeromaniac.entities;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users",
	uniqueConstraints = { @UniqueConstraint(name = "users_username_UNIQUE",
		columnNames = { "username" }) })
public class User extends AbstractEntity {

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "ENUM('ROLE_CUSTOMER', 'ROLE_ADMIN') DEFAULT 'ROLE_CUSTOMER'",
	    nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(columnDefinition = "ENUM('true', 'false') DEFAULT 'false'",
	    nullable = false)
    @Convert(converter = BooleanConverter.class)
    private boolean enabled;

    protected User() {
	// Default no-arg constructor for libs
    }

}
