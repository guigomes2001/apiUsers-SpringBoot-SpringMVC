package com.users.apiUsers;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Entidade JPA 

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String name;
	
	private int age;
	private String birthDate;
	private String generous;
	private String email;
	
	// Construtor vazio necessário para o JPA e frameworks de injeção de dependência
	
	public Users() {
	}
	
	//Construtor com os próprios objetos inicializados
	
	public Users(String name, int age, String birthDate, String generous, String email) {
		this.name=name;
		this.age=age;
		this.birthDate=birthDate;
		this.generous=generous;
		this.email=email;
	}
	
	
	//Métodos getters e setters
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id=id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	
	public int getAge() {return age;}
	public void setAge(int age) {this.age=age;}
	
	public String getBirthDate() {return birthDate;}
	public void setBirthDate(String birthDate) {this.birthDate=birthDate;}
	
	public String getGenerous() {return generous;}
	public void setGenerous(String generous) {this.generous=generous;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email=email;}
	
}
