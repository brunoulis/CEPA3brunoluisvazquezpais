/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 *
 * @author luisv
 */
@Entity
@Table(name = "Pistas", catalog = "f1")
public class Pistas implements Serializable {

	private int idPista;
	private String nombre;
	private String pais;
	

	public Pistas() {
	}

	public Pistas(int idPista, String nombre, String pais) {
		this.idPista = idPista;
		this.nombre = nombre;
		this.pais = pais;
	}

	

	@Id

	@Column(name = "id_pista", unique = true, nullable = false)
	public int getIdPista() {
		return this.idPista;
	}

	public void setIdPista(int idPista) {
		this.idPista = idPista;
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

	

}
