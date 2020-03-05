
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DecodeTest {
    static String tmpPath = "src/test/resources/decode/tmp";
    static String decodePath = "src/test/resources/decode";

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
    @DisplayName("DecodeToJpgTest")
    void decodeJpgTest(){
        File[] files = new File(decodePath).listFiles();
        for(File file : files){
            if(file.isDirectory()){
                continue;
            }
            String[] f = file.getName().split("\\.");
            f[f.length-1]="jpg";
            String fileName = String.join(".",f);
            String tmpFile = Paths.get(tmpPath,fileName).toString();
            try {
                WebpDecoder.decode(file.getAbsolutePath(),"jpg",tmpFile);;
            } catch (IOException e) {
                e.printStackTrace();
            }
            Assertions.assertTrue(new File(tmpFile).exists());
        }
    }

    @Test
    @DisplayName("DecodeToPngTest")
    void decodePngTest(){
        File[] files = new File(decodePath).listFiles();
        for(File file : files){
            if(file.isDirectory()){
                continue;
            }
            String[] f = file.getName().split("\\.");
            f[f.length-1]="png";
            String fileName = String.join(".",f);
            String tmpFile = Paths.get(tmpPath,fileName).toString();
            try {
                WebpDecoder.decode(file.getAbsolutePath(),"png",tmpFile);;
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
