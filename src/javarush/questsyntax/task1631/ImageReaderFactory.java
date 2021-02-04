package javarush.questsyntax.task1631;

import javarush.questsyntax.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes) {
        if (imageTypes.equals(ImageTypes.BMP)) return new BmpReader();
        if (imageTypes.equals(ImageTypes.JPG)) return new JpgReader();
        if (imageTypes.equals(ImageTypes.PNG)) return new PngReader();
        else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
