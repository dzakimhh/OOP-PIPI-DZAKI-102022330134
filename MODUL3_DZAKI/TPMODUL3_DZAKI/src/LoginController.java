import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

public class LoginController {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label labelNama;

    @FXML
    private Label labelNIM;

    @FXML
    private Label labelUsername;

    public void initialize() {
        labelNama.setText("");
        labelNIM.setText("");
        labelUsername.setText("");
    }

    @FXML
        private void handleLoginButton() {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if ("Dzaki Muhamad Hilmi".equals(username) && "102022330134".equals(password)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InventoryPage.fxml"));
                Parent root = loader.load();
                InventoryController inventoryController = loader.getController();
                System.out.println("InventoryController: " + inventoryController);

                Stage stage = (Stage) txtUsername.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Kesalahan dalam input data");
                alert.setHeaderText("Error");
                alert.setContentText("Silahkan cek data yang anda masukan");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Kesalahan dalam input data");
            alert.setHeaderText("Error");
            alert.setContentText("Silahkan cek data yang anda masukan");
            alert.showAndWait();
        }
    }
}