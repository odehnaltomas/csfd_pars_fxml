/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfd_pars_fxml;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Locale;



/**
 *
 * @author Tomas
 */
public class Movie implements Comparable<Movie>{
    
    private String name;
    private String dubbings;
    private String subtitles;
    private String url;
    private String path;
    //TODO: +trailer/y, obrázek/ky
    
    private ArrayList<String> directing;
    private ArrayList<String> writers;
    private ArrayList<String> camera;
    private ArrayList<String> soundtrackComposers;
    private ArrayList<String> cast;
    private ArrayList<String> contents;
    
    
    public Movie(String name, String dubbings, String subtitles, String url, String path){
        this.name = name;
        this.dubbings = dubbings;
        this.subtitles = subtitles;
        this.url = url;
    }
    
    //***SET METHODS***
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDubbings(String dubbings) {
        this.dubbings = dubbings;
    }
    
    public void setsubtitles(String subtitles) {
        this.subtitles = subtitles;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    public void setDirecting(ArrayList<String> directing) {
        this.directing = directing;
    }
    
    public void setWriters(ArrayList<String> writers) {
        this.writers = writers;
    }
    
    public void setCamera(ArrayList<String> camera) {
        this.camera = camera;
    }
    
    public void setSoundtrackComposers(ArrayList<String> soundtrackComposers) {
        this.soundtrackComposers = soundtrackComposers;
    }
    
    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }
    
    public void setContents(ArrayList<String> contents) {
        this.contents = contents;
    }
    
    
    //***GET METHOTDS***
    public String getName() {
        return this.name;
    }
    
    public String getDubbings() {
        return this.dubbings;
    }
    
    public String getSubtitles() {
        return this.subtitles;
    }
    
    public String getUrl() {
        return this.url;
    }
    
    public String getPath() {
        return this.path;
    }
    
    public ArrayList<String> setDirecting() {
        return this.directing;
    }
    
    public ArrayList<String> setWriters() {
        return this.writers;
    }
    
    public ArrayList<String> setCamera() {
        return this.camera;
    }
    
    public ArrayList<String> setSoundtrackComposers() {
        return this.soundtrackComposers;
    }
    
    public ArrayList<String> setCast() {
        return this.cast;
    }
    
    public ArrayList<String> setContents() {
        return this.contents;
    }
    
    
    /**
     * Compare two Movies by name with localization
     * @param mov
     * @return 
     */
    @Override
    public int compareTo(Movie mov) {
        Collator collator = Collator.getInstance(new Locale("cs"));
        return collator.compare(this.name, mov.getName());
    }
    
    
}
