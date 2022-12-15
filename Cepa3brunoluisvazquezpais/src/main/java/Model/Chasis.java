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
@Table(name = "chasis")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Chasis implements Serializable {
    /*
     * id_chasis INT NOT NULL AUTO_INCREMENT,
     * nombre VARCHAR(50) NOT NULL,
     * id_equipo INT NOT NULL,
     */
    @Id
    @Column(name = "id_chasis")
    private int id_chasis;
    @Column(name = "nombre")
    private String nombre;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_equipo", referencedColumnName = "idEquipo", unique = true, foreignKey = @ForeignKey(name = "fk_chasis_equipo"))
    private Equipos equipo;
}
