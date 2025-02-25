/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Jack Murrieta
 */
public class UsuarioEntidad {
    int idUsuario;
    String user;
    String contrasenaHash;
    String rol;
    int idLaboratorio;

    // usuario para el inicio de sesion 
    
    public UsuarioEntidad(String user, String contrasenaHash) {
        this.user = user;
        this.contrasenaHash = contrasenaHash;
    }

    public UsuarioEntidad(int idUsuario, String user, String contrasenaHash, String rol, int idLaboratorio) {
        this.idUsuario = idUsuario;
        this.user = user;
        this.contrasenaHash = contrasenaHash;
        this.rol = rol;
        this.idLaboratorio = idLaboratorio;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }
    


    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContrasenaHash() {
        return contrasenaHash;
    }

    // Método para establecer la contraseña y convertirla a hash automáticamente
    public void setContrasena(String contrasena) {
        this.contrasenaHash = hashPassword(contrasena);
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // Método para encriptar la contraseña con SHA-256
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());

            // Convertimos el hash a hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al hashear la contraseña", e);
        }
    }

    // Método para verificar si una contraseña coincide con el hash guardado
    public boolean verificarContrasena(String contrasena) {
        return this.contrasenaHash.equals(hashPassword(contrasena));
    }
    
}
