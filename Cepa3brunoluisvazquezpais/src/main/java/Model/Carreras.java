/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
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
@Table(name = "carreras")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Carreras {
    /*
     * id_carrera INT NOT NULL AUTO_INCREMENT,
     * nombre VARCHAR(50) NOT NULL,
     * fecha DATE NOT NULL,
     * id_pista INT NOT NULL,
     */
    @Id
    @Column(name = "id_carrera")
    private int id_carrera;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "id_pista")
    private int id_pista;

}
