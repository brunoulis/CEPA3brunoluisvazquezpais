/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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
@Table(name = "equipos")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Equipos {
    /*
     * id_equipo INT NOT NULL AUTO_INCREMENT,
     * nombre VARCHAR(50) NOT NULL,
     * pais VARCHAR(50) NOT NULL,
     */
    @Id
    @Column(name = "id_equipo")
    private int idEquipo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "pais")
    private String pais;

    public Equipos(int idEquipo, String nombre, String pais) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.pais = pais;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Set<Motores> getLosmotores() {
        return losmotores;
    }

    public void setLosmotores(Set<Motores> losmotores) {
        this.losmotores = losmotores;
    }

    public Set<Pilotos> getLospilotos() {
        return lospilotos;
    }

    public void setLospilotos(Set<Pilotos> lospilotos) {
        this.lospilotos = lospilotos;
    }
    
    

    @OneToMany(mappedBy = "elidequipo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Motores> losmotores;

    @OneToMany(mappedBy = "elequipo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Pilotos> lospilotos;

}
