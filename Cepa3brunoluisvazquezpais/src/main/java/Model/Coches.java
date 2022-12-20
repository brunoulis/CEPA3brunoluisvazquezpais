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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "Coches", catalog = "f1")
public class Coches implements Serializable {

	private int dosal;
	private Chasis chasis;
	private Motores motores;
	private Pilotos pilotos;

	public Coches() {
	}

	public Coches(int dosal, Chasis chasis, Motores motores, Pilotos pilotos) {
		this.dosal = dosal;
		this.chasis = chasis;
		this.motores = motores;
		this.pilotos = pilotos;
	}

	@Id

	@Column(name = "dosal", unique = true, nullable = false)
	public int getDosal() {
		return this.dosal;
	}

	public void setDosal(int dosal) {
		this.dosal = dosal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_chasis", nullable = false)
	public Chasis getChasis() {
		return this.chasis;
	}

	public void setChasis(Chasis chasis) {
		this.chasis = chasis;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_motor", nullable = false)
	public Motores getMotores() {
		return this.motores;
	}

	public void setMotores(Motores motores) {
		this.motores = motores;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_piloto", nullable = false)
	public Pilotos getPilotos() {
		return this.pilotos;
	}

	public void setPilotos(Pilotos pilotos) {
		this.pilotos = pilotos;
	}

}
