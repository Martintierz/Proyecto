package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class interfaz {

    private JFrame plano = new JFrame("Autoescuelas Cruzes y Caminos");
    private JButton boton1 = new JButton("REGISTRARSE");
    private JButton boton2 = new JButton("INICIA SESION");
    private JLabel mensaje = new JLabel("Binvenido a la Autoescuela");
    private Connection conexion;

    public interfaz(Connection conexion){
        this.conexion = conexion;
    }

    public void mostrarinterfaz() {

        plano.setSize(300, 400);
        plano.setLayout(new GridLayout(3,1 ));
        plano.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        plano.add(mensaje);
        plano.add(boton1);
        plano.add(boton2);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(boton1);
                ventanaActual.dispose();

                JFrame plano2 = new JFrame("Registrate en la Autoescuela Cruces y Caminos");
                JLabel nombre = new JLabel("Introduce tu Nombre");
                JTextField nombreU = new JTextField();
                JLabel apellido = new JLabel("Introduce tu Apellido");
                JTextField apellidoU = new JTextField();
                JLabel ID_Alumno = new JLabel("Introduce un ID");
                JTextField ID_AlumnoU = new JTextField();
                JLabel fecha = new JLabel("Introduce tu fecha de nacimiento");
                JTextField fechaU = new JTextField();
                JLabel fechaInscripcion = new JLabel("Introduce tu fecha de inscripcion");
                JTextField fechaInscripcionU = new JTextField();
                JButton registrarse = new JButton("Registrarse");
                JButton volver = new JButton("Volver");


                plano2.setSize(600, 750);
                plano2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                plano2.setLayout(new GridLayout(9, 2,  15 , 50));

                plano2.add(new JLabel());
                plano2.add(new JLabel());
                plano2.add(ID_Alumno);
                plano2.add(ID_AlumnoU);
                plano2.add(nombre);
                plano2.add(nombreU);
                plano2.add(apellido);
                plano2.add(apellidoU);
                plano2.add(fecha);
                plano2.add(fechaU);
                plano2.add(fechaInscripcion);
                plano2.add(fechaInscripcionU);
                plano2.add(volver);
                plano2.add(registrarse);

                volver.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                        JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(volver);
                        ventanaActual.dispose();

                        plano.setVisible(true);

                    }
                });

                fechaU.addActionListener( e -> {

                    String texto = fechaU.getText();
                    DateTimeFormatter cambio = DateTimeFormatter.ofPattern("DD/MM/AA");

                    try{

                        LocalDate Fecha = LocalDate.parse(texto, cambio);
                        JOptionPane.showMessageDialog(plano2, "Fecha válida" + Fecha);
                    }catch (DateTimeParseException exception){

                        System.out.println(plano2 + "Error formato invalido");
                    }
                });

                fechaInscripcionU.addActionListener( e -> {

                    String texto = fechaInscripcionU.getText();
                    DateTimeFormatter cambio = DateTimeFormatter.ofPattern("DD/MM/AA");

                    try{

                        LocalDate FechaI = LocalDate.parse(texto, cambio);
                        JOptionPane.showMessageDialog(plano2, "Fecha válida" + FechaI);
                    }catch (DateTimeParseException exception){

                        System.out.println(plano2 + "Error formato no valido");
                    }
                });

                plano2.setVisible(true);

                registrarse.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String sql = "INSERT INTO estudiante (ID_Estudiante, nombre, apellido, FechaNacimento, FechaIscripcion) VALUES (?, ?, ?, ?, ?)";
                            PreparedStatement stmt = conexion.prepareStatement(sql);

                            stmt.setInt(1, Integer.parseInt(ID_AlumnoU.getText()));
                            stmt.setString(2, nombreU.getText());
                            stmt.setString(3, apellidoU.getText());

                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate fechaNacimientoLocal = LocalDate.parse(fechaU.getText(), formatter);
                            LocalDate fechaInscripcionLocal = LocalDate.parse(fechaInscripcionU.getText(), formatter);

                            java.sql.Date fechaNacimientoSQL = java.sql.Date.valueOf(fechaNacimientoLocal);
                            java.sql.Date fechaInscripcionSQL = java.sql.Date.valueOf(fechaInscripcionLocal);

                            stmt.setDate(4, fechaNacimientoSQL);
                            stmt.setDate(5, fechaInscripcionSQL);

                            int filasInsertadas = stmt.executeUpdate();

                            if (filasInsertadas > 0) {
                                JOptionPane.showMessageDialog(null, "Registro exitoso");
                            } else {
                                JOptionPane.showMessageDialog(null, "No se pudo insertar el registro");
                            }

                        } catch (DateTimeParseException dtpe) {
                            JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use dd/MM/yyyy");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error de registro: " + ex.getMessage());
                        }
                    }
                });

            }

        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(boton2);
                ventanaActual.dispose();

                JFrame plano3 = new JFrame("Inicia Sesion en Autoescuelas Cruces y Caminos");
                JLabel nombre = new JLabel("Introduce tu nombre");
                JTextField nombreT = new JTextField();
                JLabel apellidos = new JLabel("Introduce tu apellido");
                JTextField apellidosT = new JTextField();
                JLabel ID_Alumnos = new JLabel("Introduce tu ID");
                JTextField ID_AlumnosT = new JTextField();
                JButton inicio = new JButton("INICIA SESION");
                JButton volver = new JButton("Volver");

                plano3.setSize(500, 450);
                plano3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                plano3.setLayout(new GridLayout(5, 2 , 15, 50));

                plano3.add(new JLabel());
                plano3.add(new JLabel());
                plano3.add(nombre);
                plano3.add(nombreT);
                plano3.add(apellidos);
                plano3.add(apellidosT);
                plano3.add(ID_Alumnos);
                plano3.add(ID_AlumnosT);
                plano3.add(volver);
                plano3.add(inicio);

                volver.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                        JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(volver);
                        ventanaActual.dispose();

                        plano.setVisible(true);

                    }
                });

                inicio.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int idEstudiante = Integer.parseInt(ID_AlumnosT.getText().trim());
                            String nombreEstudiante = nombreT.getText().trim();
                            String apellidoEstudiante = apellidosT.getText().trim();

                            String sql = "SELECT * FROM estudiante WHERE ID_Estudiante = ? AND nombre = ? AND apellido = ?";
                            PreparedStatement stmt = conexion.prepareStatement(sql);
                            stmt.setInt(1, idEstudiante);
                            stmt.setString(2, nombreEstudiante);
                            stmt.setString(3, apellidoEstudiante);

                            ResultSet rs = stmt.executeQuery();

                            if (rs.next()) {

                                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");

                                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(inicio);
                                ventanaActual.dispose();

                                JFrame plano4 = new JFrame("Elige lo que quieres hacer");
                                JPanel panel1 = new JPanel();
                                JPanel panel2 = new JPanel();
                                JLabel texto = new JLabel("Elige una de las siguientes opciones");
                                JButton testFacil = new JButton("Test Practica");
                                JButton testDificil = new JButton("Test Examen");
                                JButton clasesPracticas = new JButton("Clases Practicas");
                                JButton docentes = new JButton("Docentes");
                                JButton historial = new JButton("Historial de Fallos");
                                JButton volver = new JButton("Volver");

                                plano4.setSize(800, 500);
                                plano4.setLayout(new GridLayout(2, 1));
                                plano4.add(panel1);
                                plano4.add(panel2);

                                panel1.add(texto);
                                panel2.setLayout(new GridLayout(3, 2, 0, 0));
                                panel2.add(clasesPracticas);
                                panel2.add(testFacil);
                                panel2.add(testDificil);
                                panel2.add(docentes);
                                panel2.add(historial);
                                panel2.add(volver);

                                volver.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        plano4.dispose();
                                        plano3.setVisible(true);
                                    }
                                });

                                final boolean[] respuestas = new boolean[2];

                                testFacil.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent) {
                                        JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(testFacil);
                                        ventanaActual.dispose();

                                        JFrame pantallaTest1 = new JFrame("Primera Pregunta");
                                        JPanel panel1 = new JPanel();
                                        JPanel panel2 = new JPanel();
                                        JLabel enunciado = new JLabel("¿Cómo se acelera un turismo?");
                                        JButton pregunta1 = new JButton("Con el acelerador");
                                        JButton pregunta2 = new JButton("Pidiéndoselo amablemente");
                                        JButton siguiente = new JButton("Siguiente");
                                        JButton volver = new JButton("Volver");

                                        pantallaTest1.setSize(600, 300);
                                        pantallaTest1.setLayout(new GridLayout(2, 1));
                                        pantallaTest1.add(panel1);
                                        pantallaTest1.add(panel2);
                                        panel1.add(enunciado);
                                        panel2.setLayout(new GridLayout(2, 2));
                                        panel2.add(pregunta1);
                                        panel2.add(pregunta2);
                                        panel2.add(volver);
                                        panel2.add(siguiente);

                                        pregunta1.addActionListener(e -> {
                                            pregunta1.setBackground(Color.GREEN);
                                            pregunta2.setBackground(null);
                                            respuestas[0] = true;
                                        });

                                        pregunta2.addActionListener(e -> {
                                            pregunta2.setBackground(Color.RED);
                                            pregunta1.setBackground(null);
                                            respuestas[0] = false;
                                        });

                                        siguiente.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent actionEvent) {
                                                pantallaTest1.dispose();

                                                JFrame pantallaTest2 = new JFrame("Segunda Pregunta");
                                                JPanel panel1 = new JPanel();
                                                JPanel panel2 = new JPanel();
                                                JLabel enunciado = new JLabel("¿Hay que comprobar los frenos periódicamente?");
                                                JButton pregunta1 = new JButton("Sí");
                                                JButton pregunta2 = new JButton("No, se arreglan solos");
                                                JButton siguiente = new JButton("Siguiente");
                                                JButton volver = new JButton("Volver");

                                                pantallaTest2.setSize(600, 300);
                                                pantallaTest2.setLayout(new GridLayout(2, 1));
                                                pantallaTest2.add(panel1);
                                                pantallaTest2.add(panel2);
                                                panel1.add(enunciado);
                                                panel2.setLayout(new GridLayout(2, 2));
                                                panel2.add(pregunta1);
                                                panel2.add(pregunta2);
                                                panel2.add(volver);
                                                panel2.add(siguiente);

                                                pregunta1.addActionListener(e -> {
                                                    pregunta1.setBackground(Color.GREEN);
                                                    pregunta2.setBackground(null);
                                                    respuestas[1] = true;
                                                });

                                                pregunta2.addActionListener(e -> {
                                                    pregunta2.setBackground(Color.RED);
                                                    pregunta1.setBackground(null);
                                                    respuestas[1] = false;
                                                });

                                                siguiente.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        pantallaTest2.dispose();

                                                        JFrame resultado = new JFrame("Resultado del test");
                                                        resultado.setSize(400, 200);
                                                        resultado.setLayout(new BorderLayout());

                                                        JLabel mensaje = new JLabel("", SwingConstants.CENTER);
                                                        mensaje.setFont(new Font("Arial", Font.BOLD, 18));

                                                        if (respuestas[0] && respuestas[1]) {
                                                            mensaje.setText("¡Has aprobado!");

                                                        } else {
                                                            mensaje.setText("Has suspendido.");
                                                        }

                                                        resultado.add(mensaje, BorderLayout.CENTER);
                                                        resultado.setVisible(true);
                                                    }
                                                });

                                                volver.addActionListener(e -> {
                                                    pantallaTest2.dispose();
                                                    pantallaTest1.setVisible(true);
                                                });

                                                pantallaTest2.setVisible(true);
                                            }
                                        });

                                        volver.addActionListener(e -> {
                                            pantallaTest1.dispose();
                                        });


                                        pantallaTest1.setVisible(true);
                                    }
                                });

                                final boolean[] respuestas2 = new boolean[2];

                                testDificil.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent) {
                                        JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(testDificil);
                                        ventanaActual.dispose();

                                        JFrame pantallaTest1 = new JFrame("Primera Pregunta");
                                        JPanel panel1 = new JPanel();
                                        JPanel panel2 = new JPanel();
                                        JLabel enunciado = new JLabel("¿Quien tiene preferencia en una rotonda?");
                                        JButton pregunta1 = new JButton("El que este dentro de ella");
                                        JButton pregunta2 = new JButton("No se");
                                        JButton siguiente = new JButton("Siguiente");
                                        JButton volver = new JButton("Volver");

                                        pantallaTest1.setSize(600, 300);
                                        pantallaTest1.setLayout(new GridLayout(2, 1));
                                        pantallaTest1.add(panel1);
                                        pantallaTest1.add(panel2);
                                        panel1.add(enunciado);
                                        panel2.setLayout(new GridLayout(2, 2));
                                        panel2.add(pregunta1);
                                        panel2.add(pregunta2);
                                        panel2.add(volver);
                                        panel2.add(siguiente);

                                        pregunta1.addActionListener(e -> {
                                            pregunta1.setBackground(Color.GREEN);
                                            pregunta2.setBackground(null);
                                            respuestas2[0] = true;
                                        });

                                        pregunta2.addActionListener(e -> {
                                            pregunta2.setBackground(Color.RED);
                                            pregunta1.setBackground(null);
                                            respuestas2[0] = false;
                                        });

                                        siguiente.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent actionEvent) {
                                                pantallaTest1.dispose();

                                                JFrame pantallaTest2 = new JFrame("Segunda Pregunta");
                                                JPanel panel1 = new JPanel();
                                                JPanel panel2 = new JPanel();
                                                JLabel enunciado = new JLabel("¿Cuando es la primera revision ITV?");
                                                JButton pregunta1 = new JButton("A los 4 años de Matricularse el vehiculo");
                                                JButton pregunta2 = new JButton("Cuando tu quieras");
                                                JButton siguiente = new JButton("Siguiente");
                                                JButton volver = new JButton("Volver");

                                                pantallaTest2.setSize(600, 300);
                                                pantallaTest2.setLayout(new GridLayout(2, 1));
                                                pantallaTest2.add(panel1);
                                                pantallaTest2.add(panel2);
                                                panel1.add(enunciado);
                                                panel2.setLayout(new GridLayout(2, 2));
                                                panel2.add(pregunta1);
                                                panel2.add(pregunta2);
                                                panel2.add(volver);
                                                panel2.add(siguiente);

                                                pregunta1.addActionListener(e -> {
                                                    pregunta1.setBackground(Color.GREEN);
                                                    pregunta2.setBackground(null);
                                                    respuestas2[1] = true;
                                                });

                                                pregunta2.addActionListener(e -> {
                                                    pregunta2.setBackground(Color.RED);
                                                    pregunta1.setBackground(null);
                                                    respuestas2[1] = false;
                                                });

                                                siguiente.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        pantallaTest2.dispose();

                                                        JFrame resultado = new JFrame("Resultado del test");
                                                        resultado.setSize(400, 200);
                                                        resultado.setLayout(new BorderLayout());

                                                        JLabel mensaje = new JLabel("", SwingConstants.CENTER);
                                                        mensaje.setFont(new Font("Arial", Font.BOLD, 18));

                                                        if (respuestas2[0] && respuestas2[1]) {
                                                            mensaje.setText("¡Has aprobado!");
                                                        } else {
                                                            mensaje.setText("Has suspendido.");
                                                        }

                                                        resultado.add(mensaje, BorderLayout.CENTER);
                                                        resultado.setVisible(true);
                                                    }
                                                });

                                                volver.addActionListener(e -> {
                                                    pantallaTest2.dispose();
                                                    pantallaTest1.setVisible(true);
                                                });

                                                pantallaTest2.setVisible(true);
                                            }
                                        });

                                        volver.addActionListener(e -> {
                                            pantallaTest1.dispose();
                                        });

                                        pantallaTest1.setVisible(true);
                                    }
                                });

                                docentes.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(docentes);
                                        ventanaActual.dispose();

                                        JFrame ventanaDocentes = new JFrame("Lista de Docentes");
                                        ventanaDocentes.setSize(600, 400);
                                        ventanaDocentes.setLayout(new BorderLayout());

                                        JTextArea areaTexto = new JTextArea();
                                        areaTexto.setEditable(false);
                                        JScrollPane scrollPane = new JScrollPane(areaTexto);

                                        JButton volver = new JButton("Volver");

                                        ventanaDocentes.add(scrollPane, BorderLayout.CENTER);
                                        ventanaDocentes.add(volver, BorderLayout.SOUTH);

                                        volver.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                ventanaDocentes.dispose();
                                                plano4.setVisible(true);
                                            }
                                        });

                                        try {

                                            if (conexion != null) {
                                                String query = "SELECT ID_Profesores, nombre, apellido, FechaNacimiento, FechaContrato FROM profesor";
                                                PreparedStatement pst = conexion.prepareStatement(query);
                                                ResultSet rs = pst.executeQuery();

                                                while (rs.next()) {
                                                    int id = rs.getInt("ID_Profesores");
                                                    String nombre = rs.getString("nombre");
                                                    String apellido = rs.getString("apellido");
                                                    Date nacimiento = rs.getDate("FechaNacimiento");
                                                    Date contrato = rs.getDate("FechaContrato");

                                                    areaTexto.append("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Nacimiento: " + nacimiento + ", Contrato: " + contrato );
                                                }

                                                rs.close();
                                                pst.close();
                                                conexion.close();
                                            } else {
                                                areaTexto.setText("Error con la conexion de la base datos.");
                                            }

                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                            areaTexto.setText("Error al caragar los profesores.");
                                        }

                                        ventanaDocentes.setVisible(true);
                                    }
                                });

                                clasesPracticas.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(clasesPracticas);
                                        ventanaActual.dispose();

                                        JFrame ventanaClases = new JFrame("Clases Prácticas");
                                        ventanaClases.setSize(700, 400);
                                        ventanaClases.setLayout(new BorderLayout());

                                        JTextArea areaTexto = new JTextArea();
                                        areaTexto.setEditable(false);
                                        JScrollPane scrollPane = new JScrollPane(areaTexto);

                                        JButton volver = new JButton("Volver");
                                        ventanaClases.add(scrollPane, BorderLayout.CENTER);
                                        ventanaClases.add(volver, BorderLayout.SOUTH);

                                        volver.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                ventanaClases.dispose();
                                                plano4.setVisible(true);
                                            }
                                        });

                                        try {

                                            if (conexion != null) {
                                                String query = "SELECT ID_Coche, Modelo, Matricula, ID_Profesores, ID_Estudiante, ID_Autoescuela, `Nº_clase` FROM ClasesPracticas";
                                                PreparedStatement pst = conexion.prepareStatement(query);
                                                ResultSet rs = pst.executeQuery();

                                                while (rs.next()) {
                                                    int idCoche = rs.getInt("ID_Coche");
                                                    String modelo = rs.getString("Modelo");
                                                    String matricula = rs.getString("Matricula");
                                                    int idProfesor = rs.getInt("ID_Profesores");
                                                    int idEstudiante = rs.getInt("ID_Estudiante");
                                                    int idAutoescuela = rs.getInt("ID_Autoescuela");
                                                    int numClase = rs.getInt("Nº_clase");

                                                    areaTexto.append("ID Coche: " + idCoche + ", Modelo: " + modelo + ", Matrícula: " + matricula + ", ID Profesor: " + idProfesor + ", ID Estudiante: " + idEstudiante + ", ID Autoescuela: " + idAutoescuela + ", Nº Clase: " + numClase);
                                                }

                                                rs.close();
                                                pst.close();
                                                conexion.close();
                                            } else {
                                                areaTexto.setText("Error al conectar con la base de datos.");
                                            }
                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                            areaTexto.setText("Error al obtener las clases prácticas.");
                                        }

                                        ventanaClases.setVisible(true);
                                    }
                                });

                                plano4.setVisible(true);

                            } else {

                                JOptionPane.showMessageDialog(null, "Datos incorrectos. Verifica el ID, nombre y apellido.");
                            }

                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "El ID debe ser un número.");
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error al consultar la base de datos.");
                        }
                    }
                });

                plano3.setVisible(true);
            }
        });

        plano.setVisible(true);

    }
}
