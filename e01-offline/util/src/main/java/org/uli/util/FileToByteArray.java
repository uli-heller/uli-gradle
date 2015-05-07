/**
 * 
 */
package org.uli.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class FileToByteArray {
    private static final String DEFAULT_FILENAME="-";
    private static final int BUFFER_SIZE=1024;
    private String filename;
    private InputStream inputStream;
    
    public FileToByteArray(String filename) throws FileNotFoundException {
        this.filename = filename;
        this.inputStream = new FileInputStream(new File(filename));
    }
    
    public FileToByteArray(InputStream inputStream) {
        this.filename = DEFAULT_FILENAME;
        this.inputStream = inputStream;
    }
    
    public String getFilename() {
        return this.filename;
    }
    
    public byte[] getBytes() throws IOException {
        return this.getBytes(this.inputStream);
    }
    
    private byte[] getBytes(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = new byte[BUFFER_SIZE];
        int numBytes;
        while ((numBytes = is.read(bytes)) >= 0) {
            baos.write(bytes, 0, numBytes);
        }
        bytes = baos.toByteArray();
        baos.close();
        return bytes;
    }
}
