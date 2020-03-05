package Config;

/**
 * @author Keshane
 * a class to storage encoder config params
 */
public class EncoderConfig {

    private int compressionMode;
    private int compressionType;
    private float compressionQuality = 0.7f;

    /**
     * constructor of this class with more param
     * @param compressionMode the compression mode , you can choose one from
     *                        CompressionModes.MODE_EXPLICIT,CompressionModes.MODE_DEFAULT,
     *                        CompressionModes.MODE_COPY_FROM_METADATA, CompressionModes.MODE_DISABLED,
     *                        but if you set CompressionModes.MODE_EXPLICIT you may use
     *                        EncoderConfig(int compressionMode, int compressionType, float compressionQuality)
     */
    public EncoderConfig(int compressionMode) {
        this.compressionMode = compressionMode;
    }

    /**
     * constructor of this class with more param
     * @param compressionMode the compression mode , you can choose one from
     *                        CompressionModes.MODE_EXPLICIT,CompressionModes.MODE_DEFAULT,
     *                        CompressionModes.MODE_COPY_FROM_METADATA, CompressionModes.MODE_DISABLED,
     *                        but only CompressionModes.MODE_EXPLICIT can let the other two params useful
     * @param compressionType only compressionMode set to CompressionModes.MODE_EXPLICIT can let this params useful
     *                        the compression type , you can choose one from
     *                        CompressionTypes.LOSSLESS_COMPRESSION
     *                        CompressionTypes.LOSSY_COMPRESSION
     * @param compressionQuality only compressionMode set to CompressionModes.MODE_EXPLICIT can let this params useful
     *                           1f = 100%
     *                           0.7f = 70%(default)
     */
    public EncoderConfig(int compressionMode, int compressionType, float compressionQuality) {
        this.compressionMode = compressionMode;
        this.compressionType = compressionType;
        this.compressionQuality = compressionQuality;
    }

    @Override
    public String toString() {
        return "EncoderConfig{" +
                "compressionMode=" + compressionMode +
                ", compressionType=" + compressionType +
                ", compressionQuality=" + compressionQuality +
                '}';
    }

    public int getCompressionMode() {
        return compressionMode;
    }

    public void setCompressionMode(int compressionMode) {
        this.compressionMode = compressionMode;
    }

    public int getCompressionType() {
        return compressionType;
    }

    public void setCompressionType(int compressionType) {
        this.compressionType = compressionType;
    }

    public float getCompressionQuality() {
        if(this.compressionQuality==0){
            return 0.7f;
        }else{
            return compressionQuality;
        }
    }

    public void setCompressionQuality(float compressionQuality) {
        this.compressionQuality = compressionQuality;
    }
}
