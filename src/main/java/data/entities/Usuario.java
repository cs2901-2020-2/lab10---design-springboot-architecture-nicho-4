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

    @Column(name = "codigo")
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

    @Column(name = "dni")
    private String dni;

    @Column(name = "nombreCompleto")
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

    public int getSexo() {
        return sexo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public int getVigencia() {
        return vigencia;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public Date getFechaCese() {
        return fechaCese;
    }

    public String getDni() {
        return dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
}
