/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
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
@Table(name = "motores")
public class Motores implements Serializable {
    /*
     * id_motor INT NOT NULL AUTO_INCREMENT,
     * nombre VARCHAR(50) NOT NULL,
     * id_equipo INT NOT NULL,
     * dosal INT,
     */
    @Id
    @Column(name = "id_motor")
    private int id_motor;
    @Column(name = "nombre")
    private String nombre;

   @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_coche", foreignKey = @ForeignKey(name = "FK_Motores_Coches"))
    private Coches elidCoche; 

    @Column(name = "dosal")
    private int dorsal;

    public Motores(int id_motor, String nombre, int dorsal) {
        this.id_motor = id_motor;
        this.nombre = nombre;
        this.dorsal = dorsal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_motor() {
        return id_motor;
    }

    public void setId_motor(int id_motor) {
        this.id_motor = id_motor;
    }

    public Coches getElidCoche() {
        return elidCoche;
    }

    public void setElidCoche(Coches elidCoche) {
        this.elidCoche = elidCoche;
    }

    

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    
}
