import Config.CompressionModes;
import Config.CompressionTypes;
import Config.EncoderConfig;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.logging.Logger;


public class EncodeTest {
    static Logger log = Logger.getLogger("EncodeTest");
    static String encodePath = "src/test/resources/encode";
    static String tmpPath = "src/test/resources/encode/tmp";

    @BeforeEach
    void initTmp(){
        try {
            if(new File(tmpPath).exists()){
                return;
            }
            Files.createDirectory(Paths.get(tmpPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("EncodeTestDefault")
    void defaultEncodeTest(){
        File[] files = new File(encodePath).listFiles();
        for(File file : files){
            if(file.isDirectory()){
                continue;
            }
            String[] f = file.getName().split("\\.");
            f[f.length-1]="webp";
            String fileName = String.join(".",f);
            String tmpFile = Paths.get(tmpPath,fileName).toString();
            try {
                WebpEncoder.encode(file.getAbsolutePath(),tmpFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Assertions.assertTrue(new File(tmpFile).exists());
        }
    }

    @Test
    @DisplayName("EncodeTestWithCompression")
    void compressionTest(){
        File[] files = new File(encodePath).listFiles();
        for(File file : files){
            if(file.isDirectory()){
                continue;
            }
            String[] f = file.getName().split("\\.");
            f[f.length-1]="webp";
            String fileName = String.join(".",f);
            String tmpFile = Paths.get(tmpPath,fileName).toString();
            EncoderConfig encoderConfig = new EncoderConfig(CompressionModes.MODE_EXPLICIT, CompressionTypes.LOSSY_COMPRESSION,1f);
            try {
                WebpEncoder.encode(file.getAbsolutePath(),tmpFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Assertions.assertTrue(new File(tmpFile).exists());
        }
    }

    @AfterEach
    void deleteTmp(){
        File tmp = new File(tmpPath);
        if(tmp.exists()){
            File[] files = tmp.listFiles();
            for(File file: files){
                file.delete();
            }
        }
        tmp.delete();
    }

}
