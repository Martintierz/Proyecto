package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://proyecto.cxkg06iamsx0.us-east-1.rds.amazonaws.com/proyecto", "admin", "Admin.12345678");
            System.out.println("|-----Se ha conectado a la Base de Datos-----|");

            interfaz Interfaz = new interfaz(conexion);
            Interfaz.mostrarinterfaz();

        } catch (Exception e) {

            System.out.println("Error");
        }
    }
}
