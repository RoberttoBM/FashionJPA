package com.demo.fashion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "VENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByIdven", query = "SELECT v FROM Venta v WHERE v.idven = :idven")
    , @NamedQuery(name = "Venta.findByServicio", query = "SELECT v FROM Venta v WHERE v.servicio = :servicio")
    , @NamedQuery(name = "Venta.findByPrecio", query = "SELECT v FROM Venta v WHERE v.precio = :precio")
    , @NamedQuery(name = "Venta.findByProducto", query = "SELECT v FROM Venta v WHERE v.producto = :producto")
    , @NamedQuery(name = "Venta.findByImporte", query = "SELECT v FROM Venta v WHERE v.importe = :importe")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator (name="IDCLI", sequenceName = "SeqIDCLI", initialValue = 5, allocationSize = 100 )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDVEN")
    private Long idven;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "SERVICIO")
    private String servicio;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private BigDecimal precio;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "PRODUCTO")
    private String producto;

    @Basic(optional = false)
    @NotNull
    @Column(name = "IMPORTE")
    private BigDecimal importe;

    @JoinColumn(name = "CLIENTE_IDCLI", referencedColumnName = "IDCLI")
    @ManyToOne(optional = false)
    private Cliente clienteIdcli;

    @JoinColumn(name = "PERSONAL_IDPER", referencedColumnName = "IDPER")
    @ManyToOne(optional = false)
    private Personal personalIdper;

    public Venta() {
    }

    public Venta(Long idven) {
        this.idven = idven;
    }

    public Venta(Long idven, String servicio, BigDecimal precio, String producto, BigDecimal importe) {
        this.idven = idven;
        this.servicio = servicio;
        this.precio = precio;
        this.producto = producto;
        this.importe = importe;
    }

    public Long getIdven() {
        return idven;
    }

    public void setIdven(Long idven) {
        this.idven = idven;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Cliente getClienteIdcli() {
        return clienteIdcli;
    }

    public void setClienteIdcli(Cliente clienteIdcli) {
        this.clienteIdcli = clienteIdcli;
    }

    public Personal getPersonalIdper() {
        return personalIdper;
    }

    public void setPersonalIdper(Personal personalIdper) {
        this.personalIdper = personalIdper;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idven != null ? idven.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idven == null && other.idven != null) || (this.idven != null && !this.idven.equals(other.idven))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.fashion.entity.Venta[ idven=" + idven + " ]";
    }

}
