import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaCliente extends JFrame {
    public JPanel PantallaCliente; // Panel para organizar los componentes
    private JLabel label1;
    private JButton realizarPedidoButton; // Botón para realizar pedido


    public PantallaCliente() {
        // Configuración del JFrame
        setTitle("Cliente");
        setContentPane(PantallaCliente);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        realizarPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Redirigir a la pantalla de Pedido
                new Pedido();
                dispose(); // Cerrar la ventana actual
            }
        });
    }

    public static void main(String[] args) {
        new PantallaCliente();
    }
}

