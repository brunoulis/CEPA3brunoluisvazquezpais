/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "coches")

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
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_motor", foreignKey = @ForeignKey(name = "FK_Coches_Motores"))
    private Motores elMotor;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_chasis", foreignKey = @ForeignKey(name = "FK_Coches_Chasis"))
    private Chasis elChasis;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "Conduce", joinColumns = {
            @JoinColumn(name = "dosal", referencedColumnName = "dosal") }, inverseJoinColumns = {
                    @JoinColumn(name = "id_piloto", referencedColumnName = "id_piloto") })
    private Set<Pilotos> losPilotos = new HashSet<Pilotos>();

    public void addPiloto(Pilotos p) {
        if(!this.losPilotos.contains(p)){
            losPilotos.add(p);
            p.addCoche(this);
        }

    }

    public Coches(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Motores getElMotor() {
        return elMotor;
    }

    public void setElMotor(Motores elMotor) {
        this.elMotor = elMotor;
    }

    public Chasis getElChasis() {
        return elChasis;
    }

    public void setElChasis(Chasis elChasis) {
        this.elChasis = elChasis;
    }

    public Set<Pilotos> getLosPilotos() {
        return losPilotos;
    }

    public void setLosPilotos(Set<Pilotos> losPilotos) {
        this.losPilotos = losPilotos;
    }

    @Override
    public String toString() {
        return "Coches{" + "dorsal=" + dorsal + ", el Motor=" + elMotor + ", el Chasis=" + elChasis + ", los Pilotos=" + losPilotos + '}';
    }
    
    public String mostrarPilotos(){
        String res= "";
        for (Pilotos p : losPilotos) {
            res += p.getNombre() + "\n";
        }
        return res;
    }
    

}
