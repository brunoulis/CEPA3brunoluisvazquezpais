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
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "Motores", catalog = "f1")
public class Motores implements Serializable {

	private int idMotor;
	private Equipos equipos;
	private String nombre;
	private Integer dosal;
	private Set<Coches> cocheses = new HashSet<Coches>(0);

	public Motores() {
	}

	public Motores(int idMotor, Equipos equipos, String nombre) {
		this.idMotor = idMotor;
		this.equipos = equipos;
		this.nombre = nombre;
	}

	public Motores(int idMotor, Equipos equipos, String nombre, Integer dosal, Set<Coches> cocheses) {
		this.idMotor = idMotor;
		this.equipos = equipos;
		this.nombre = nombre;
		this.dosal = dosal;
		this.cocheses = cocheses;
	}

	@Id

	@Column(name = "id_motor", unique = true, nullable = false)
	public int getIdMotor() {
		return this.idMotor;
	}

	public void setIdMotor(int idMotor) {
		this.idMotor = idMotor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_equipo", nullable = false)
	public Equipos getEquipos() {
		return this.equipos;
	}

	public void setEquipos(Equipos equipos) {
		this.equipos = equipos;
	}

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "dosal")
	public Integer getDosal() {
		return this.dosal;
	}

	public void setDosal(Integer dosal) {
		this.dosal = dosal;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "motores")
	public Set<Coches> getCocheses() {
		return this.cocheses;
	}

	public void setCocheses(Set<Coches> cocheses) {
		this.cocheses = cocheses;
	}

}
