import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Pedido extends JFrame {
    private JTable Catalogo;
    private JTextField PrecioUnitario;
    private JPanel Pedido;
    private JTable tableCatalogo;
    private JTable tablePedido;
    private JTextField IdProducto;
    private JButton confirmarPedidoButton;
    private JButton regresarButton;
    private JTextField IdUsuario;
    private JTextField CantidadP;
    private JTextField IdPedido;
    private JTextField FechaPedido;
    private JTextField Descripcion;
    private JTextField Total;
    private JButton agregarPedidoButton;
    private JButton agregarProductoButton;
    private JButton mostrarCatalogoButton;
    private JButton mostrarPedidoButton;
    private JButton mostrarButton;


    Connection conexion;
    PreparedStatement ps;
    String[] campoCatalogo = {"Id", "Nombre", "Categoria", "Precio","Cantidad_Actual"};
    String[] registros = new String[10];
    DefaultTableModel modTabla = new DefaultTableModel(null, campoCatalogo);
    Statement st;
    ResultSet rs;
    List<Detalle_Pedido> productosV = new ArrayList<>();

    public Pedido(){}

    class Detalle_Pedido{
        String ID_PEDIDO;
        String Id;
        String CANTIDAD_PRODUCTO;
        String DESCRIPCION;
        String PRECIO_UNITARIO;

        public Detalle_Pedido (String ID_PEDIDO, String Id, String CANTIDAD_PRODUCTO, String DESCRIPCION, String PRECIO_UNITARIO){
            this.ID_PEDIDO = ID_PEDIDO;
            this.Id = Id;
            this.CANTIDAD_PRODUCTO = CANTIDAD_PRODUCTO;
            this.DESCRIPCION = DESCRIPCION;
            this.PRECIO_UNITARIO = PRECIO_UNITARIO;
        }
    }

    void conectar(){
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/PostresMariaJose","root","OH{c<6H1#cQ%F69$i");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    void agregarPedido () throws SQLException {

        conectar();

        int id_pedi = -1;

        String sqlPEDIDO = "INSERT INTO PEDIDO (Id,FECHA_PEDIDO, TOTAL) VALUES (?,?,?)";
        ps= conexion.prepareStatement(sqlPEDIDO,Statement.RETURN_GENERATED_KEYS);

        String Id = IdPedido.getText().trim();
        String FECHA_PEDIDO = FechaPedido.getText();
        String TOTAL = Total.getText().trim().replace(",",".");

        ps.setString(1, Id);
        ps.setString(2, FECHA_PEDIDO);
        ps.setString(3, TOTAL);

        ps.executeUpdate();

        rs = ps.getGeneratedKeys();

        if (rs.next()){

            id_pedi= rs.getInt(1);

            IdPedido.setText(String.valueOf(id_pedi));

        } else {
            throw new RuntimeException("Error al obtener el ID_PEDIDO generado");

            String sqlDETALLE_PEDIDO
        }
    }



    void agregarProducto(){

            conectar();

            String ID_PEDIDO = IdPedido.getText().trim();
            String Id = IdProducto.getText().trim();
            String CANTIDAD_PRODUCTO = CantidadP.getText().trim();
            String DESCRIPCION = Descripcion.getText().trim();
            String PRECIO_UNITARIO = PrecioUnitario.getText().trim().replace(",",".");

            Detalle_Pedido producto1 = new Detalle_Pedido(ID_PEDIDO, Id, CANTIDAD_PRODUCTO, DESCRIPCION, PRECIO_UNITARIO);
            productosV.add(producto1);

            JOptionPane.showMessageDialog(null,"Producto agregado al pedido");

        }

    }






