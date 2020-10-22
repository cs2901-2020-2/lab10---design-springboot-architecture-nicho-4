package data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.hash.Hashing;

import javax.persistence.*;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario implements Serializable {

    @Column(name = "hash")
    private String hash;

    @Column(name = "sexo")
    private int sexo;

    @Column(name = "codigo", unique = true)
    private Long codigo;

    @Column(name = "primerNombre")
    private String primerNombre;

    @Column(name = "vigencia")
    private int vigencia;

    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "passwd")
    private String passwd;

    @Column(name = "segundoNombre")
    private String segundoNombre;

    @Column(name = "fechaCese")
    private Date fechaCese;

    @Column(name = "dni", unique = true)
    private String dni;

    @Column(name = "nombreCompleto", unique = true)
    private String nombreCompleto;

    public Usuario(String hash, int sexo, Long codigo, String primerNombre, int vigencia, String apellidoPaterno, String apellidoMaterno, String email, String nombre, String passwd, String segundoNombre, Date fechaCese, String dni, String nombreCompleto) {
        this.hash = hash;
        this.sexo = sexo;
        this.codigo = codigo;
        this.primerNombre = primerNombre;
        this.vigencia = vigencia;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.nombre = nombre;
        this.passwd = passwd;
        this.segundoNombre = segundoNombre;
        this.fechaCese = fechaCese;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public Date getFechaCese() {
        return fechaCese;
    }

    public void setFechaCese(Date fechaCese) {
        this.fechaCese = fechaCese;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

}
