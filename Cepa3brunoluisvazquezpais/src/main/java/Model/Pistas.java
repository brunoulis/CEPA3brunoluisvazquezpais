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
@Table(name = "pistas")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pistas {
    /*
     * id_pista INT NOT NULL AUTO_INCREMENT,
     * nombre VARCHAR(50) NOT NULL,
     * pais VARCHAR(50) NOT NULL,
     */
    @Id
    @Column(name = "idPista")
    private int id_pista;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "pais")
    private String pais;

}
