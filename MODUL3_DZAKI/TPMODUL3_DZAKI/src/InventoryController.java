import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class InventoryController {

    @FXML
    private TableView<Album> tableInventory;

    @FXML
    private TableColumn<Album, String> columnAlbumName;

    @FXML
    private TableColumn<Album, String> columnArtist;

    @FXML
    private TableColumn<Album, Integer> columnTotal;

    @FXML
    private TableColumn<Album, Integer> columnAvailable;

    @FXML
    private TableColumn<Album, Integer> columnRented;

    @FXML
    private TextField textAlbumName;

    @FXML
    private TextField textArtist;

    @FXML
    private TextField textTotal;

    @FXML
    private TextField textRented;

    private ObservableList<Album> albumList;

    @FXML
    private void handleRentSelected(){
        Album selectedAlbum = tableInventory.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            if (selectedAlbum.getAvailable() > 0) {
                selectedAlbum.setAvailable(selectedAlbum.getAvailable() - 1);
                selectedAlbum.setRented(selectedAlbum.getRented() + 1);
                tableInventory.refresh();
            } else {
                System.out.println("Album tidak tersedia untuk disewa");
            }
        } else {
            System.out.println("Tidak ada album yang dipilih");
        }
    }

    @FXML
    private void handleDeleteSelected() {
        Album selectedAlbum = tableInventory.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            albumList.remove(selectedAlbum);
            tableInventory.refresh();
            showAlert(Alert.AlertType.INFORMATION, "Album Dihapus", 
                          "Album " + selectedAlbum.getAlbumName() + " berhasil dihapus");
        } else {
            System.out.println("Tidak ada album yang dipilih");
        }
    }

    @FXML
    private void handleAddAlbum() {
        if (textAlbumName != null && textArtist != null && textTotal != null && textRented != null) {
            try {
                String albumName = textAlbumName.getText();
                String artist = textArtist.getText();
                int total = Integer.parseInt(textTotal.getText());
                int rented = Integer.parseInt(textRented.getText());

                if (total < rented) {
                    System.out.println("Jumlah rented tidak boleh lebih besar dari total");
                    return;
                }

                int available = total - rented;
                Album newAlbum = new Album(albumName, artist, total, available, rented);

                albumList.add(newAlbum);
                tableInventory.refresh();
                showAlert(Alert.AlertType.INFORMATION, "Album Berhasil Ditambahkan", 
                      "Album " + albumName + " berhasil ditambahkan");
            } catch (NumberFormatException e) {
                System.out.println("Pastikan input jumlah adalah angka.");
            }
        } else {
            System.out.println("Tidak ada penambahan");
        }
    }

    @FXML
    private void handleUpdateAlbum() {  
        Album selectedAlbum = tableInventory.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            try {
                String albumName = textAlbumName.getText();
                String artist = textArtist.getText();
                int total = Integer.parseInt(textTotal.getText());
                int rented = Integer.parseInt(textRented.getText());

                if (total < rented) {
                    System.out.println("Jumlah rented tidak boleh lebih besar dari total");
                    return;
                }

                selectedAlbum.setAlbumName(albumName);
                selectedAlbum.setArtist(artist);
                selectedAlbum.setTotal(total);
                selectedAlbum.setAvailable(total - rented);
                selectedAlbum.setRented(rented);

                tableInventory.refresh();
                showAlert(Alert.AlertType.INFORMATION, "Album Berhasil Diupdate", 
                      "Album " + albumName + " berhasil diupdate");
            } catch (NumberFormatException e) {
                System.out.println("Pastikan input jumlah adalah angka.");
            }
        } else {
            System.out.println("Tidak ada album yang dipilih.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText("Message");
    alert.setContentText(message);
    alert.showAndWait();
    }

    public void initialize() {
        columnAlbumName.setCellValueFactory(new PropertyValueFactory<>("albumName"));
        columnArtist.setCellValueFactory(new PropertyValueFactory<>("artist"));
        columnTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        columnAvailable.setCellValueFactory(new PropertyValueFactory<>("available"));
        columnRented.setCellValueFactory(new PropertyValueFactory<>("rented"));
    
        albumList = FXCollections.observableArrayList(
            new Album("Bury Me at Makeout Creek", "Mitski", 8, 3, 5),
            new Album("Riot!", "Param..", 6, 3, 3),
            new Album("Perfect Velvet", "Red Velvet", 8, 4, 4)
        );
    
        tableInventory.setItems(albumList);
    }
    
}