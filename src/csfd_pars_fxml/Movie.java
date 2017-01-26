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
    
    /** Name of movie directory **/
    private String name;
    
    /** Avalible dubbings to movie **/
    private String dubbings;
    
    /** Avalible subtitles to movie **/
    private String subtitles;
    
    /** Url to movie page on http://www.csfd.cz/ **/
    private String url;
    
    /** Path to movie directory **/
    private String path;
    
    /** Name of movie file **/
    private String movieFileName;
    
    
    /**
     * Constructor, that create object of Movie class
     * @param name Name of movie directory
     * @param dubbings Avalible dubbings to movie
     * @param subtitles Avalible subtitles to movie
     * @param url Url to movie page on http://www.csfd.cz/
     * @param path Path to movie directory
     * @param movieFileName Name of movie file
     */
    public Movie(String name, String dubbings, String subtitles, String url, String path, String movieFileName){
        this.name = name;
        this.dubbings = dubbings;
        this.subtitles = subtitles;
        this.url = url;
        this.path = path;
        this.movieFileName = movieFileName;
    }
    
    
    //***SET METHODS***
    /**
     * Set new name of movie directory
     * @param name New name of movie directory
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Set new movie dubbings
     * @param dubbings New movie dubbings
     */
    public void setDubbings(String dubbings) {
        this.dubbings = dubbings;
    }
    
    /**
     * Set new movie subtitles 
     * @param subtitles New subtitles
     */
    public void setSubtitles(String subtitles) {
        this.subtitles = subtitles;
    }
    
    /**
     * Set new URL to http://www.csfd.cz/ to specific movie
     * @param url New URL to movie page
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    /**
     * Set new path to movie directory
     * @param path New path to movie directory
     */
    public void setPath(String path) {
        this.path = path;
    }
    
    /**
     * Set new name of movie file
     * @param movieFileName New name of movie file
     */
    public void setMovieFileName(String movieFileName) {
        this.movieFileName = movieFileName;
    }
    
    
    //***GET METHOTDS***
    /**
     * Get name of movie directory
     * @return Return name of movie directory
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Get movie dubbings
     * @return Return movie dubbings
     */
    public String getDubbings() {
        return this.dubbings;
    }
    
    /**
     * Get movie subtitles
     * @return Return movie subtitles
     */
    public String getSubtitles() {
        return this.subtitles;
    }
    
    /**
     * Get URL to site http://www.csfd.cz/ to movie page
     * @return Return URL to specific movie page
     */
    public String getUrl() {
        return this.url;
    }
    
    /**
     * Get path to movie directory
     * @return Return path to movie directory
     */
    public String getPath() {
        return this.path;
    }
    
    /**
     * Get name of movie file
     * @return Return name of movie file
     */
    public String getMovieFileName() {
        return this.movieFileName;
    }
    
    
    /**
     * Compare two Movies by name (include localization)
     * @param movie Object of Movie class
     * @return Return comparsion of two Movie object
     */
    @Override
    public int compareTo(Movie movie) {
        Collator collator = Collator.getInstance(new Locale("cs"));
        return collator.compare(this.name, movie.getName());
    }
    
    
}
