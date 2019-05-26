/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.service;
import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 *
 * @author Md Belayet Hossin
 */
@ConfigurationProperties
@Service
public class StorageProperties {

    String root = System.getProperty("user.home");
    
  //  @Value("${app.repo_image.name}")
    String dir_name ="southcity";
    
    String rootPath = root+ File.separator + dir_name;
    String pathurl = "/";

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String url() {
        try {
            URL filePath = Paths.get(rootPath).toUri().toURL();

            String pathurl = filePath.toString();
            return pathurl;
        } catch (Exception e) {
            return pathurl;
        }
    }

}
