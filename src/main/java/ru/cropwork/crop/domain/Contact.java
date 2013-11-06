package ru.cropwork.crop.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

 @Entity
 @Table(name = "CONTACT")
public class Contact implements Serializable {
	private Long id;
	private int version;
	private String firstName;
	private String lastName;
	private DateTime birthDate;
	private String description;
	private byte[] photo;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID")	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Version
	@Column(name = "VERSION")
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "BIRTH_DATE")
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	@DateTimeFormat(iso = ISO.DATE)
	public DateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(DateTime birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Basic(fetch = FetchType.LAZY)	// Указывает что столбец большого массива
	@Lob							// должен извлекаться ленивым образом
	@Column(name = "PHOTO")
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	@Transient
	public String getBirthDateString() {
		String birthDateString = "";
		if (birthDate != null) {
			birthDateString = org.joda.time.format.DateTimeFormat
					.forPattern("yyyy-MM-dd").print(birthDate);
		}
		return birthDateString;
		
	}
	
	
	public String toString() {
		return "Contact id=" + id + ", firstName="
				+ firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + ", description=" + description ;
	}

	
	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
