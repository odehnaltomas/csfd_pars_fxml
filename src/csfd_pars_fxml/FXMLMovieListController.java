package csfd_pars_fxml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLMovieListController {
    
    @FXML
    private TableColumn<Movie, String> name_col;

    @FXML
    private TableColumn<Movie, String> dub_col;

    @FXML
    private TableColumn<Movie, String> subtit_col;
    
    @FXML
    private TableView<Movie> table;

    @FXML
    void initialize() {
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'FXMLMovieList.fxml'.";
        
        InfoManager infoManager = new InfoManager();
        
        System.out.println(InfoManager.pocet);
        
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        dub_col.setCellValueFactory(new PropertyValueFactory<>("dubbings"));
        subtit_col.setCellValueFactory(new PropertyValueFactory<>("subtitles"));
        
        table.setItems(getMovies());
        
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            System.out.println(table.getSelectionModel().getSelectedItem().getUrl());
            
        }
});
    }
    
    private ObservableList<Movie> getMovies() {
        ObservableList<Movie> movies = FXCollections.observableArrayList();
        
        File folder = new File("C:\\Users\\Tomas\\Documents\\NetBeansProjects\\csfd_pars_fxml\\filmy");
        File[] listOfFiles = folder.listFiles();
        
        for(int i = 0; i < listOfFiles.length; i++) {
            //System.out.println(listOfFiles[i].toString());
            try (BufferedReader buffReader = new BufferedReader(new FileReader(new File(listOfFiles[i].toString() + "\\dubbing_subtitles_url.txt")))) {
                String dubbings = buffReader.readLine();
                String subtitles = buffReader.readLine();
                String url = buffReader.readLine();
                
                movies.add(new Movie(listOfFiles[i].getName(), dubbings, subtitles, url));
            }
            catch(FileNotFoundException e) {
                System.err.println("Soubor nenalezen!");
            }
            catch(IOException e) {
                System.err.println("nějaká jiná chyba!");
            }
        }
        
        Collections.sort(movies);
        
        return movies;
    }

}