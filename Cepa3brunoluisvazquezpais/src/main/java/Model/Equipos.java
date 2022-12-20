/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author luisv
 */
@Entity
@Table(name = "Equipos", catalog = "f1")
public class Equipos implements Serializable {

	private int idEquipo;
	private String nombre;
	private String pais;
	private Set<Motores> motoreses = new HashSet<Motores>(0);
	private Set<Pilotos> pilotoses = new HashSet<Pilotos>(0);
	private Set<Chasis> chasises = new HashSet<Chasis>(0);

	public Equipos() {
	}

	public Equipos(int idEquipo, String nombre, String pais) {
		this.idEquipo = idEquipo;
		this.nombre = nombre;
		this.pais = pais;
	}

	public Equipos(int idEquipo, String nombre, String pais, Set<Motores> motoreses, Set<Pilotos> pilotoses,
			Set<Chasis> chasises) {
		this.idEquipo = idEquipo;
		this.nombre = nombre;
		this.pais = pais;
		this.motoreses = motoreses;
		this.pilotoses = pilotoses;
		this.chasises = chasises;
	}

	@Id

	@Column(name = "id_equipo", unique = true, nullable = false)
	public int getIdEquipo() {
		return this.idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "pais", nullable = false, length = 50)
	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipos")
	public Set<Motores> getMotoreses() {
		return this.motoreses;
	}

	public void setMotoreses(Set<Motores> motoreses) {
		this.motoreses = motoreses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipos")
	public Set<Pilotos> getPilotoses() {
		return this.pilotoses;
	}

	public void setPilotoses(Set<Pilotos> pilotoses) {
		this.pilotoses = pilotoses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipos")
	public Set<Chasis> getChasises() {
		return this.chasises;
	}

	public void setChasises(Set<Chasis> chasises) {
		this.chasises = chasises;
	}

}
