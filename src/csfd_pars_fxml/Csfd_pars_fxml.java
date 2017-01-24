/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfd_pars_fxml;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Tomas
 */
public class Csfd_pars_fxml extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Super Program");
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMovieList.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setMinHeight(800.0);
        stage.setMinWidth(1280.0);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
