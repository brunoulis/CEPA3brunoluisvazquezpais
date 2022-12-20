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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author luisv
 */
@Entity
@Table(name = "Pilotos", catalog = "f1")
public class Pilotos implements Serializable {

	private int idPiloto;
	private Equipos equipos;
	private String nombre;
	private String apellido;
	private int edad;
	private Set<Coches> cocheses = new HashSet<Coches>(0);

	public Pilotos() {
	}

	public Pilotos(int idPiloto, Equipos equipos, String nombre, String apellido, int edad) {
		this.idPiloto = idPiloto;
		this.equipos = equipos;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public Pilotos(int idPiloto, Equipos equipos, String nombre, String apellido, int edad, Set<Coches> cocheses) {
		this.idPiloto = idPiloto;
		this.equipos = equipos;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.cocheses = cocheses;
	}

	@Id

	@Column(name = "id_piloto", unique = true, nullable = false)
	public int getIdPiloto() {
		return this.idPiloto;
	}

	public void setIdPiloto(int idPiloto) {
		this.idPiloto = idPiloto;
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

	@Column(name = "apellido", nullable = false, length = 50)
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "edad", nullable = false)
	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
        //Hacemos la relacion n:m con 
	@ManyToMany(cascade=CascadeType.PERSIST,
                fetch=FetchType.LAZY)
        @JoinTable(name="correr",
            joinColumns = {@JoinColumn(name="idPiloto", foreignKey= @ForeignKey(name= "FK_COR_PIL") )},
            inverseJoinColumns ={@JoinColumn(name="idCoches", foreignKey= @ForeignKey(name= "FK_COR_COCH"))}
        )
        private Set<Coches> losCoches=new HashSet<>();
	
        public void addCoches(Coches c){
            if(!this.losCoches.contains(c)){
                losCoches.add(c);
                c.addPilotos(this);
            }
        }
        

}
