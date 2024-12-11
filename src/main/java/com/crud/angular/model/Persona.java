package com.crud.angular.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor //Siempre ponerlo al hacerlo Entity
@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String apellido;
	private int edad;
	
	@ManyToOne //Significa que una persona puedeser de un pais pero un pais puede tener muchas personas
	@JoinColumn(name = "id_pais")
	private Pais pais;
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;
	
	public Persona(String nombre, String apellido, int edad, Pais pais, Estado estado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.pais = pais;
		this.estado = estado;
	}
	
	
}
