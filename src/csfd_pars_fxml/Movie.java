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
    private String fileName;
    private String dubbings;
    private String subtitles;
    private String url;
    //TODO: data z csfd
    /*
    private ArrayList<String> directing;
    private ArrayList<String> story;
    private ArrayList<String> camera;
    private ArrayList<Sting> soundtrack;
    private ArrayList<String> actors;
    private ArrayList<String> content;
    +trailer/y, obrázek/ky
    */
    
    
    public Movie(String name, String dubbings, String subtitles, String url){
        this.name = name;
        this.dubbings = dubbings;
        this.subtitles = subtitles;
        this.url = url;
    }
    
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
    
    @Override
    public int compareTo(Movie mov) {
        Collator collator = Collator.getInstance(new Locale("cs"));
        return collator.compare(this.name, mov.getName());
    }
    
    
}
