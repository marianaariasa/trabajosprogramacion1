package co.edu.uniquindio.poo.empresajfx.viewController;

import co.edu.uniquindio.poo.empresajfx.App;
import co.edu.uniquindio.poo.empresajfx.controller.ProductoController;
import co.edu.uniquindio.poo.empresajfx.model.Producto;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ProductoViewController {

    ProductoController productoController;
    ObservableList<Producto> listProductos = FXCollections.observableArrayList();
    Producto selectedProducto;
    private App app;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TableView<Producto> tblListProducto;

    @FXML
    private TableColumn<Producto, String> tbcCodigo;

    @FXML
    private TableColumn<Producto, String> tbcNombre;

    @FXML
    private TableColumn<Producto, Double> tbcPrecio;

    @FXML
    void onAgregarProducto() {
        agregarProducto();
    }

    @FXML
    void onActualizarProducto() {
        actualizarProducto();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onEliminar() {
        eliminarProducto();
    }

    @FXML
    void initialize() {
        productoController = new ProductoController(App.empresa);
        initView();
    }

    private void initView() {
        // Traer los datos del producto a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerProductos();

        // Limpiar la tabla
        tblListProducto.getItems().clear();

        // Agregar los elementos a la tabla
        tblListProducto.setItems(listProductos);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbcCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcPrecio.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPrecio()));
    }

    private void obtenerProductos() {
        listProductos.addAll(productoController.obtenerListaProductos());
    }

    private void listenerSelection() {
        tblListProducto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedProducto = newSelection;
            mostrarInformacionProducto(selectedProducto);
        });
    }

    private void mostrarInformacionProducto(Producto producto) {
        if (producto != null) {
            txtCodigo.setText(producto.getCodigo());
            txtNombre.setText(producto.getNombre());
            txtPrecio.setText(String.valueOf(producto.getPrecio()));
        }
    }

    private void agregarProducto() {
        Producto producto = buildProducto();
        if (producto == null) {
            return;
        }
        if (productoController.crearProducto(producto)) {
            listProductos.add(producto);
            limpiarCamposProducto();
        } else {
            mostrarMensaje("Ya existe un producto con ese código");
        }
    }

    private Producto buildProducto() {
        try {
            double precio = Double.parseDouble(txtPrecio.getText());
            return new Producto(txtCodigo.getText(), txtNombre.getText(), precio);
        } catch (NumberFormatException e) {
            mostrarMensaje("El precio debe ser un número");
            return null;
        }
    }

    private void eliminarProducto() {
        if (productoController.eliminarProducto(txtCodigo.getText())) {
            listProductos.remove(selectedProducto);
            limpiarSeleccion();
        }
    }

    private void actualizarProducto() {
        Producto actualizado = buildProducto();
        if (selectedProducto != null && actualizado != null &&
                productoController.actualizarProducto(selectedProducto.getCodigo(), actualizado)) {
            tblListProducto.refresh();
            limpiarSeleccion();
        }
    }

    private void limpiarSeleccion() {
        tblListProducto.getSelectionModel().clearSelection();
        limpiarCamposProducto();
    }

    private void limpiarCamposProducto() {
        txtCodigo.clear();
        txtNombre.clear();
        txtPrecio.clear();
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING, mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public void setApp(App app) {
        this.app = app;
    }
}