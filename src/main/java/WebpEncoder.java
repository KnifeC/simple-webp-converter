import Config.CompressionModes;
import Config.EncoderConfig;
import com.luciad.imageio.webp.WebPWriteParam;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Keshane
 * a webp encoder class to encode webp
 */
public class WebpEncoder {

    /**
     * default method to encode webp image by default compression param
     * @param originImagePath the path of origin image
     * @param webpImagePath the path of webp image
     * @throws IOException read file may cause IOException
     */
    public static void encode(String originImagePath , String webpImagePath) throws IOException {
        // Obtain an image to encode from somewhere
        BufferedImage image = ImageIO.read(new File(originImagePath));
        // Obtain a WebP ImageWriter instance
        ImageWriter writer = ImageIO.getImageWritersByMIMEType("image/webp").next();
        // Configure encoding parameters
        WebPWriteParam writeParam = new WebPWriteParam(writer.getLocale());
        writeParam.setCompressionMode(WebPWriteParam.MODE_DEFAULT);
//        writeParam.setCompressionMode(WebPWriteParam.MODE_EXPLICIT);
//        //if compression mode set WebPWriteParam.MODE_EXPLICIT then use this
//        writeParam.setCompressionType(writeParam.getCompressionTypes()[WebPWriteParam.LOSSY_COMPRESSION]);
//        writeParam.setCompressionQuality(1f);
        // Configure the output on the ImageWriter
        writer.setOutput(new FileImageOutputStream(new File(webpImagePath)));
        // Encode
        writer.write(null, new IIOImage(image, null, null), writeParam);
    }

    /**
     * default method to encode webp image by custom compression param
     * @param originImagePath originImagePath the path of origin image
     * @param webpImagePath webpImagePath the path of webp image
     * @param config an EncoderConfig object
     * @throws IOException read file may cause IOException
     */
    public static void encode(String originImagePath , String webpImagePath , EncoderConfig config) throws IOException {
        BufferedImage image = ImageIO.read(new File(originImagePath));
        ImageWriter writer = ImageIO.getImageWritersByMIMEType("image/webp").next();
        WebPWriteParam writeParam = new WebPWriteParam(writer.getLocale());
        if(config.getCompressionMode() == CompressionModes.MODE_EXPLICIT){
//        if compression mode set WebPWriteParam.MODE_EXPLICIT then use this
            writeParam.setCompressionMode(config.getCompressionMode());
            writeParam.setCompressionType(writeParam.getCompressionTypes()[config.getCompressionType()]);
            writeParam.setCompressionQuality(config.getCompressionQuality());
        }
        writeParam.setCompressionMode(config.getCompressionMode());
        writer.setOutput(new FileImageOutputStream(new File(webpImagePath)));
        writer.write(null, new IIOImage(image, null, null), writeParam);
    }
}
