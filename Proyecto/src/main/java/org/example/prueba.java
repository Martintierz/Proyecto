package org.example;

public class prueba {

}
/*
final boolean[] respuestas = new boolean[2];

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
 */

