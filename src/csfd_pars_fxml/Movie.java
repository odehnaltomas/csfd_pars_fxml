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
    
    
    public Movie(String name, String dubbings, String subtitles, String url, String path){
        this.name = name;
        this.dubbings = dubbings;
        this.subtitles = subtitles;
        this.url = url;
        this.path = path;
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
