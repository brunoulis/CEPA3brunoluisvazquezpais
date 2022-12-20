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
@Table(name = "Chasis", catalog = "f1")
public class Chasis implements Serializable {

	private int idChasis;
	private Equipos equipos;
	private String nombre;
	private Set<Coches> cocheses = new HashSet<Coches>(0);

	public Chasis() {
	}

	public Chasis(int idChasis, Equipos equipos, String nombre) {
		this.idChasis = idChasis;
		this.equipos = equipos;
		this.nombre = nombre;
	}

	public Chasis(int idChasis, Equipos equipos, String nombre, Set<Coches> cocheses) {
		this.idChasis = idChasis;
		this.equipos = equipos;
		this.nombre = nombre;
		this.cocheses = cocheses;
	}

	@Id

	@Column(name = "id_chasis", unique = true, nullable = false)
	public int getIdChasis() {
		return this.idChasis;
	}

	public void setIdChasis(int idChasis) {
		this.idChasis = idChasis;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chasis")
	public Set<Coches> getCocheses() {
		return this.cocheses;
	}

	public void setCocheses(Set<Coches> cocheses) {
		this.cocheses = cocheses;
	}

}
