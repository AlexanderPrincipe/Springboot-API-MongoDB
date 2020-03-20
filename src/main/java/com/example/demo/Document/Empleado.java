package com.example.demo.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import static java.awt.PageAttributes.MediaType.A;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;



@Document(collection = "Empleado")
public class Empleado implements Serializable {
    @Id
    @NotNull
    private int codigo;

    @NotNull
    private String nombre;

    @NotNull
    private String apellidoPaterno;
    
    @NotNull
    private String apellidoMaterno;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private String fechaNacimiento;
    
    @Email(message = "Correo no valido")
    private String correo;
    
    @Pattern(regexp = "[A-D]")
    private String categoria;
    
    @NotNull
    private String conocimientos[];

    public String[] getConocimientos() {
        return conocimientos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setConocimientos(String[] conocimientos) {
        this.conocimientos = conocimientos;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public int calcularSalario() {
        int salario = 0;
        if (null != getCategoria()) switch (getCategoria()) {
            case "A":
                salario = (int)(Math.random()*(15000-8000+1)+8000);
                break;
            case "B":
                salario = (int)(Math.random()*(7999-5000+1)+5000);
                break;
            case "C":
                salario = (int)(Math.random()*(4999-3000+1)+3000);
                break;
            case "D":
                salario = (int)(Math.random()*(2999-2000+1)+2000);
                break;
            default:
                break;
        }
    
        return salario;
    }
 
}
