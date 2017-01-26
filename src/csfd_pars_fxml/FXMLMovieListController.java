package csfd_pars_fxml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;

public class FXMLMovieListController {
    
    private final String[] movieDirectories = {
            "C:\\Users\\Tomas\\Documents\\NetBeansProjects\\filmy",
            "C:\\Users\\Tomas\\Documents\\NetBeansProjects\\filmy2"
            };
    
    private InfoManager infoManager;
    
    @FXML
    private TableColumn<Movie, String> name_col;

    @FXML
    private TableColumn<Movie, String> dub_col;

    @FXML
    private TableColumn<Movie, String> subtit_col;
    
    @FXML
    private TableView<Movie> table;
    
    @FXML
    private WebView webView;
            
    @FXML
    void initialize() {
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'FXMLMovieList.fxml'.";
        
        this.infoManager = new InfoManager();
        
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        dub_col.setCellValueFactory(new PropertyValueFactory<>("dubbings"));
        subtit_col.setCellValueFactory(new PropertyValueFactory<>("subtitles"));
        
        table.setItems(getMovies());
        
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            //System.out.println(table.getSelectionModel().getSelectedItem().getUrl());
            this.showMovieInfo(table.getSelectionModel().getSelectedItem());
        }
        });
    }
    
    
    /**
     * Show movie information or error message. Show local html file.
     * @param movie Object of class Movie
     */
    private void showMovieInfo(Movie movie) {
        try {
            File site = this.infoManager.loadSite(movie);
            webView.getEngine().load(site.toURI().toString());
            //System.out.println(site.toURI());
        }
        catch(Exception e) {
            //System.out.println(e.getMessage());
            File site = new File(System.getProperty("user.dir") + "\\Errors\\" + e.getMessage());
            webView.getEngine().load(site.toURI().toString());
        }
    }
    
    
    private ObservableList<Movie> getMovies() {
        ObservableList<Movie> movies = FXCollections.observableArrayList();
        
        File[][] listOfDirectories = new File[movieDirectories.length][];
        for(int i = 0; i < movieDirectories.length; i++) {
            File dir = new File(movieDirectories[i]);
            listOfDirectories[i] = dir.listFiles();
        }
        /*
        File folder = new File("C:\\Users\\Tomas\\Documents\\NetBeansProjects\\filmy");
        File[] listOfFiles = folder.listFiles();*/
        
        for(File[] listOfFiles: listOfDirectories) {
            for(File file: listOfFiles) {
                //System.out.println(listOfFiles[i].toString());
                try (BufferedReader buffReader = new BufferedReader(new FileReader(new File(file.toString() + "\\dubbing_subtitles_url.txt")))) {
                    String dubbings = buffReader.readLine();
                    String subtitles = buffReader.readLine();
                    String url = buffReader.readLine();
                    String movieFileName = "";

                    File[] movieFiles = file.listFiles();
                    for(File movieFile: movieFiles) {
                        if(file.isFile()) {
                            String[] fileName = file.getName().split("\\.(?=[^\\.]+$)");
                            if(fileName[0].equalsIgnoreCase(movieFile.getName())) {
                                movieFileName = fileName[0] + fileName[1];
                            }
                        }
                    }

                    movies.add(new Movie(file.getName(), dubbings, subtitles, url, file.toString(), movieFileName));
                }
                catch(FileNotFoundException e) {
                    System.err.println("Soubor nenalezen!");
                }
                catch(IOException e) {
                    System.err.println("nějaká jiná chyba!");
                }
            }

            
        }
        Collections.sort(movies);
        return movies;
    }
    
    
    /**
     * Open VLC player and movie.
     * @param event Has information about MouseEvent
     */
    @FXML
    void playMovie(MouseEvent event) {
        if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
            Movie movie = table.getSelectionModel().getSelectedItem();
            
            //System.out.println("jo");
            ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe", movie.getPath() + "\\" + movie.getMovieFileName());
            try {
                Process start = pb.start();
            }
            catch(Exception e) {
                
            }
        }
    }

}