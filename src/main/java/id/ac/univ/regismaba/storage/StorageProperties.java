package id.ac.univ.regismaba.storage;

import java.io.File;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
//	File uploads = new File(System.getenv("UPLOAD_LOCATION"));
//	
//    private String location = uploads.getAbsolutePath().toString() + "\\c6-upload";

    private String location = "c6-upload";
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}