/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "pilotos")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pilotos implements Serializable {
    /*
     * id_piloto INT NOT NULL AUTO_INCREMENT,
     * nombre VARCHAR(50) NOT NULL,
     * apellido VARCHAR(50) NOT NULL,
     * edad INT NOT NULL,
     * id_equipo INT NOT NULL,
     */
    @Id
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

}
