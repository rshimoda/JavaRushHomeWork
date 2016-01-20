package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

public class ImageReaderFactory {
    public static ImageReader getReader(ImageTypes imageTypes) {
        ImageReader result;
        if (imageTypes == ImageTypes.BMP) result = new BmpReader();
        else if (imageTypes == ImageTypes.JPG) result = new JpgReader();
        else if (imageTypes == ImageTypes.PNG) result = new PngReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");
        return result;
    }
}
