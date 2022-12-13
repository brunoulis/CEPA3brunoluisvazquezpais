/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Motores {
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
    @Column(name = "id_equipo")
    private int id_equipo;
    @Column(name = "dosal")
    private int dorsal;

}
