package com.pagalila.pojo;
// Generated Mar 30, 2016 8:01:48 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Usertable generated by hbm2java
 */
@Entity
@Table(name = "usertable", catalog = "lab8")
public class Usertable implements java.io.Serializable {

	private Long id;
	private String name;
	private String password;
	private Emailtable emailtable;
	private Set adverttables = new HashSet(0);

	public Usertable() {
	}

	public Usertable(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public Usertable(String name, String password, Emailtable emailtable, Set adverttables) {
		this.name = name;
		this.password = password;
		this.emailtable = emailtable;
		this.adverttables = adverttables;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "usertable")
	public Emailtable getEmailtable() {
		return this.emailtable;
	}

	public void setEmailtable(Emailtable emailtable) {
		this.emailtable = emailtable;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usertable")
	public Set getAdverttables() {
		return this.adverttables;
	}

	public void setAdverttables(Set adverttables) {
		this.adverttables = adverttables;
	}

}
