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
@Table(name = "pilotos")
public class Pilotos implements Serializable {
    /*
     * id_piloto INT NOT NULL AUTO_INCREMENT,
     * nombre VARCHAR(50) NOT NULL,
     * apellido VARCHAR(50) NOT NULL,
     * edad INT NOT NULL,
     * id_equipo INT NOT NULL,
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_piloto")
    private int id_piloto;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "edad")
    private int edad;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_equipo", foreignKey = @ForeignKey(name = "fk_id_equipo"))
    private Equipos elidEquipo;

    @OneToMany(mappedBy = "elPiloto", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Coches> loscoches;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "Conduce", joinColumns = {
            @JoinColumn(name = "id_piloto", foreignKey = @ForeignKey(name = "fk_id_piloto")) }, inverseJoinColumns = {
                    @JoinColumn(name = "id_coche", foreignKey = @ForeignKey(name = "fk_id_coche")) })
    private Set<Coches> losCoches = new HashSet<>();

    public void addCoche(Coches c) {
        losCoches.add(c);
        c.addPiloto(this);
    }

    public Pilotos() {
    }

    public Pilotos(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public int getId_piloto() {
        return id_piloto;
    }

    public void setId_piloto(int id_piloto) {
        this.id_piloto = id_piloto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Equipos getElidEquipo() {
        return elidEquipo;
    }

    public void setElidEquipo(Equipos elidEquipo) {
        this.elidEquipo = elidEquipo;
    }

    public Set<Coches> getLoscoches() {
        return loscoches;
    }

    public void setLoscoches(Set<Coches> loscoches) {
        this.loscoches = loscoches;
    }

    public Set<Coches> getLosCoches() {
        return losCoches;
    }

    public void setLosCoches(Set<Coches> losCoches) {
        this.losCoches = losCoches;
    }
    
    

}
