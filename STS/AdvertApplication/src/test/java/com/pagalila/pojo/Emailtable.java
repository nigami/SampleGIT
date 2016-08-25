package com.pagalila.pojo;
// Generated Mar 30, 2016 8:01:48 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Emailtable generated by hbm2java
 */
@Entity
@Table(name = "emailtable", catalog = "lab8")
public class Emailtable implements java.io.Serializable {

	private Long id;
	private Usertable usertable;
	private String emailId;

	public Emailtable() {
	}

	public Emailtable(Usertable usertable, String emailId) {
		this.usertable = usertable;
		this.emailId = emailId;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "usertable"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Usertable getUsertable() {
		return this.usertable;
	}

	public void setUsertable(Usertable usertable) {
		this.usertable = usertable;
	}

	@Column(name = "emailId", nullable = false, length = 225)
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
