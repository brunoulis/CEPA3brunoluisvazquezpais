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
@Table(name = "Coches", catalog = "f1")
public class Coches implements Serializable {

    @Id
    @Column(name = "dosal", unique = true, nullable = false)
    private int dosal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chasis", nullable = false)
    private Chasis chasis;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_motor", nullable = false)
    private Motores motores;

    @ManyToMany(cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY,
            mappedBy = "losPilotos")
    private Set<Pilotos> losPilotos = new HashSet<>();

    public Coches() {
    }

    public Coches(int dosal, Chasis chasis, Motores motores) {
        this.dosal = dosal;
        this.chasis = chasis;
        this.motores = motores;

    }

    public int getDosal() {
        return this.dosal;
    }

    public void setDosal(int dosal) {
        this.dosal = dosal;
    }

    public Chasis getChasis() {
        return this.chasis;
    }

    public void setChasis(Chasis chasis) {
        this.chasis = chasis;
    }

    public Motores getMotores() {
        return this.motores;
    }

    public void addPilotos(Pilotos p) {
        if (!this.losPilotos.contains(p)) {
            losPilotos.add(p);
            p.addCoches(this);
        }

    }

    public void setMotores(Motores motores) {
        this.motores = motores;
    }

    public String mostrarPilotos() {
        String res = "";
        for (Pilotos p : losPilotos) {
            res += p.getNombre() + "\n";

        }
        return res;
    }

}
