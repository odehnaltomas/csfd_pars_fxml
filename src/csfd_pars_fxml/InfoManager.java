/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfd_pars_fxml;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Tomas
 */
public class InfoManager {
    /*
    public static final String DIRECTING_FILE = "00_directing.txt";
    public static final String WRITERS_FILE = "01_writers.txt";
    public static final String CAMERA_FILE = "02_camera.txt";
    public static final String SOUNDTRACK_COMPOSERS_FILE = "03_soundtrackComposers.txt";
    public static final String CAST_FILE = "04_cast.txt";
    public static final String CONTENTS_FILE = "05_contents.txt";
    */
    
    public File loadSite(Movie movie) throws Exception {
        File infoSite = new File(movie.getPath(), "info\\info.html");
        if(infoSite.exists()) {
            //System.out.println("ano");
            return infoSite;
        }
        else {
            try {
                this.parseAndSave(movie);
                return new File(movie.getPath(), "info\\info.html");
            }
            catch(Exception e) {
                throw e;
            }
        }
    }
    
    
    private void parseAndSave(Movie movie) throws Exception{
        Document document = null;
        if(movie.getUrl() == null){
            System.out.println("tady");
            throw new Exception("noUrl.html");
        }
        
        try {
        document = Jsoup.connect(movie.getUrl())
                .data("query", "Java")
                .userAgent("Mozilla")
                .timeout(3000)
                .get();
        }
        catch(Exception e) {
            throw new Exception("noConnection.html");
        }
        
        new File(movie.getPath() + "\\info").mkdir();
        
        File site = new File(movie.getPath() + "\\info\\info.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(site));
        /*
        bw.write("<html>");
        bw.write("<head>");
        bw.write("<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">");
        bw.write("</head>");
        bw.write("<body>");
        bw.write("<h1>" + movie.getName() + "</h1>");
        bw.write("</body>");
        bw.write("</html>");*/
        
        bw.write("<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">");
        File img = this.downloadImage(this.editUrl(document.select("div#poster img").first().absUrl("src")), movie.getPath() + "\\info\\poster.jpg");
        
        bw.write("<img src=\"" + img.toURI() + "\" style=\"height:450px\">");
        
        
        bw.write(document.select("h1").text() + "<br>");
        Elements names = document.select("ul.names li");
        int i = 0;
        for(Element name: names) {
            Element image = name.select("img").first();
            img = this.downloadImage(image.absUrl("src"), movie.getPath() + "\\info\\" + i + ".gif");
            i++;
            
            bw.write("<img src=\"" + img.toURI() + "\">");
            bw.write(name.text() + ", ");
        }
        
        bw.write("<br>");
        bw.write(document.select("p.genre").text() + "<br>");
        bw.write(document.select("p.origin").text() + "<br>");
        
        Elements creators = document.select("div.creators div");
        for(Element creator: creators) {
            bw.write(creator.select("h4").text() + ": ");
            
            Elements people = creator.select("a");
            for(Element person: people) {
                bw.write(person.text() + ", ");
            }
            bw.write("<br>");
        }
        
        Elements contents = document.select("div#plots div.content li");
        
        for(Element content: contents) {
            bw.write(content.text() + "<br>");
        }
        
        bw.close();
    }
    
    private File downloadImage(String url, String imgPath) {
        try {
            URL url_new = new URL(url);
            InputStream in = url_new.openStream();
            OutputStream out = new BufferedOutputStream(new FileOutputStream(new java.io.File(imgPath)));
            
            for(int b; (b = in.read()) != -1;) {
                out.write(b);
            }
            
            out.close();
            in.close();
        }
        catch(Exception e) {
            System.out.println("Obrázek nešel stáhnout!");
        }
        return new File(imgPath);
    }
    
    
    private String editUrl(String url) {
        //System.out.println(url.substring(0, url.length()-5));
        return url.substring(0, url.length()-5);
    }
}
