/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "Carreras", catalog = "f1")
public class Carreras implements Serializable {

    static final long serialVersionUID = 137L;
    @Id
    @Column(name = "id_carrera", unique = true, nullable = false)
    private int idCarrera;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha", nullable = false, length = 10)
    private Date fecha;

    public Carreras() {
    }

    public Carreras(int idCarrera, String nombre, Date fecha) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public int getIdCarrera() {
        return this.idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Pista",
            referencedColumnName = "id_Pista",
            unique = true,
            foreignKey = @ForeignKey(name = "FK_GRP_PISTAS"))
    private Pistas id_pista;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_pista", nullable = false)
//	public Pistas getPistas() {
//		return this.pistas;
//	}

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Pistas getId_pista() {
        return id_pista;
    }

    public void setId_pista(Pistas id_pista) {
        this.id_pista = id_pista;
    }

}
