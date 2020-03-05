import com.luciad.imageio.webp.WebPReadParam;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Keshane
 * a webp decoder class to decode webp
 */
public class WebpDecoder {

    /**
     * default method to encode webp image by default compression param
     * @param webpImagePath the origin webp image path
     * @param type the type you want to convert to
     * @param objectImagePath the object image path
     * @throws IOException read file may cause IOException
     */
    public static void decode(String webpImagePath , String type , String objectImagePath ) throws IOException {
        // Obtain a WebP ImageReader instance
        ImageReader reader = ImageIO.getImageReadersByMIMEType("image/webp").next();

        // Configure decoding parameters
        WebPReadParam readParam = new WebPReadParam();
        readParam.setBypassFiltering(true);

        // Configure the input on the ImageReader
        reader.setInput(new FileImageInputStream(new File(webpImagePath)));

        // Decode the image
        BufferedImage image = reader.read(0, readParam);

        ImageIO.write(image, type, new File(objectImagePath));
    }
}
