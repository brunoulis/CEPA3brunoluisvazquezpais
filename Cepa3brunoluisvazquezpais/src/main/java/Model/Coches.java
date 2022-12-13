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
@Table(name = "coches")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Coches {
    /*
     * dosal INT NOT NULL,
     * id_motor INT NOT NULL,
     * id_chasis INT NOT NULL,
     * id_piloto INT NOT NULL,
     */
    @Id
    @Column(name = "dosal")
    private int dorsal;
    @Column(name = "id_motor")
    private int id_motor;
    @Column(name = "id_chasis")
    private int id_chasis;
    @Column(name = "id_piloto")
    private int id_piloto;

}
