## simple-webp-converter 

This repository is a simple wrapper of [qwong/j-webp](https://github.com/qwong/j-webp).

Provide an easy way to convert webp images.

### Convert other image to webp
#### Simply use
Two params of encode are `String originImagePath,String webpImagePath`.

```
WebpEncoder.encode(originImageFilePath,webpImageFilePath);
```
#### Using compression params
##### You need to create a EncoderConfig object.

There are two constructor of this class.
###### constructor of this class with one param:
* `compressionMode` the compression mode , you can choose one from`CompressionModes.MODE_EXPLICIT`,`CompressionModes.MODE_DEFAULT`,`CompressionModes.MODE_COPY_FROM_METADATA`, `CompressionModes.MODE_DISABLED`,but only CompressionModes.MODE_EXPLICIT can make the other two params useful

the other params would be default
```
EncoderConfig encoderConfig = new EncoderConfig(CompressionModes.MODE_DEFAULT);
```
###### constructor of this class with three params:

* `compressionMode` the compression mode , you can choose one from`CompressionModes.MODE_EXPLICIT`,`CompressionModes.MODE_DEFAULT`,`CompressionModes.MODE_COPY_FROM_METADATA`, `CompressionModes.MODE_DISABLED`,but only CompressionModes.MODE_EXPLICIT can make the other two params useful

* `compressionType` only compressionMode set to `CompressionModes.MODE_EXPLICIT` can make this params usefulthe compression type , you can choose one from`CompressionTypes.LOSSLESS_COMPRESSION`,`CompressionTypes.LOSSY_COMPRESSION`

* `compressionQuality` only compressionMode set to `CompressionModes.MODE_EXPLICIT` can make this params useful,1f = 100%,0.7f = 70%(default)
     
```
EncoderConfig encoderConfig = new EncoderConfig(CompressionModes.MODE_EXPLICIT, CompressionTypes.LOSSY_COMPRESSION,1f);
```
##### Encode with EncoderConfig object

```
WebpEncoder.encode(originImageFilePath,webpImageFilePath,encoderConfig);
```

### Convert webp image to others
Three params of encode are `String webpImageFilePath,String type,String originImageFilePath`.

**I only test type 'jpg' and 'png'**
```
WebpDecoder.decode(webpImageFilePath,"jpg",originImageFilePath);
```



