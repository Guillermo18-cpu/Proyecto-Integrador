import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pedido {
    private JPanel panel1;
    private JButton confirmarPedidoButton;
    private JButton volverButton;
    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    public Pedido() {
        // Configuración del JFrame
        JFrame frame = new JFrame("Realizar Pedido");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        confirmarPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Redirigir a la pantalla de Pago
                new Pago();
                frame.dispose(); // Cerrar la ventana actual
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Redirigir a la pantalla de Cliente
                new PantallaCliente();
                frame.dispose(); // Cerrar la ventana actual
            }
        });
    }

    public static void main(String[] args) {
        new Pedido();
    }
}
