package me.playgamesgo.modules.blockfront;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public final class TextImageUtils {
    public final static String characters = " !\"#$%&'()*+,-./" +
            "0123456789:;<=>?" +
            "@ABCDEFGHIJKLMNO" +
            "PQRSTUVWXYZ[\\]^_" +
            "`abcdefghijklmno" +
            "pqrstuvwxyz{|}~";

    public static BufferedImage scaleImage(BufferedImage src) {
        int scale = 4;
        int newW = src.getWidth() * scale;
        int newH = src.getHeight() * scale;

        Image tmp = src.getScaledInstance(newW, newH, Image.SCALE_REPLICATE);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_BYTE_GRAY);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    public static Map<Character, BufferedImage> getCharacterImageFromAtlas(BufferedImage image) {
        Map<Character, BufferedImage> characterImageMap = new HashMap<>();

        int charWidth = 8;
        int charHeight = 8;

        for (int i = 0; i < characters.length(); i++) {
            char c = characters.charAt(i);
            int x = (i % 16) * charWidth;
            int y = (i / 16) * charHeight + 16;

            BufferedImage charImage = image.getSubimage(x, y, charWidth, charHeight);
            characterImageMap.put(c, charImage);
        }

        return characterImageMap;
    }

    public static Map<Character, BufferedImage> getShiftedCharacterImageMap(Map<Character, BufferedImage> characterImageList) {
        Map<Character, BufferedImage> shiftedCharacterImageList = new HashMap<>();

        for (Map.Entry<Character, BufferedImage> entry : characterImageList.entrySet()) {
            char c = entry.getKey();
            BufferedImage charImage = entry.getValue();

            Map.Entry<Character, BufferedImage> characterImage = getCharacterImage(c, charImage);
            shiftedCharacterImageList.put(characterImage.getKey(), characterImage.getValue());
        }

        return shiftedCharacterImageList;
    }

    public static Map.Entry<Character, BufferedImage> getCharacterImage(char c, BufferedImage charImage) {
        int width = charImage.getWidth();
        int height = charImage.getHeight();

        BufferedImage shiftedImage = new BufferedImage(width - 1, height, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g2d = shiftedImage.createGraphics();
        g2d.setBackground(new Color(0, 0, 0, 0));
        g2d.drawImage(charImage, 0, 0, null);
        g2d.drawImage(charImage, 1, 0, null);
        g2d.dispose();

        return Map.entry(c, shiftedImage);
    }

    public static Map<Character, BufferedImage> getTrimmedCharacterImages(Map<Character, BufferedImage> characterImageList) {
        Map<Character, BufferedImage> trimmedCharacterImageList = new HashMap<>();

        for (Map.Entry<Character, BufferedImage> entry : characterImageList.entrySet()) {
            char c = entry.getKey();
            BufferedImage charImage = entry.getValue();

            Map.Entry<Character, BufferedImage> characterImage = getTrimmedCharacterImage(c, charImage);
            trimmedCharacterImageList.put(characterImage.getKey(), characterImage.getValue());
        }

        return trimmedCharacterImageList;
    }

    public static Map.Entry<Character, BufferedImage> getTrimmedCharacterImage(char c, BufferedImage charImage) {
        if (c == ' ') {
            return Map.entry(c, charImage.getSubimage(0, 0, charImage.getWidth() - 3, charImage.getHeight()));
        }

        int width = charImage.getWidth();
        int height = charImage.getHeight();

        int left = 0;
        int right = width - 1;

        for (int x = 0; x < width; x++) {
            boolean hasPixel = false;
            for (int y = 0; y < height; y++) {
                if ((charImage.getRGB(x, y) & 0xFF) > 0) {
                    hasPixel = true;
                    break;
                }
            }
            if (hasPixel) {
                left = x;
                break;
            }
        }

        for (int x = width - 1; x >= 0; x--) {
            boolean hasPixel = false;
            for (int y = 0; y < height; y++) {
                if ((charImage.getRGB(x, y) & 0xFF) > 0) {
                    hasPixel = true;
                    break;
                }
            }
            if (hasPixel) {
                right = x;
                break;
            }
        }

        BufferedImage trimmedImage = charImage.getSubimage(left, 0, right - left + 1, height);
        return Map.entry(c, trimmedImage);
    }

    public static boolean[][] getCharacterBitmap(BufferedImage charImage) {
        int width = charImage.getWidth();
        int height = charImage.getHeight();
        boolean[][] bitmap = new boolean[height][width];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bitmap[y][x] = (charImage.getRGB(x, y) & 0xFF) > 0;
            }
        }

        return bitmap;
    }
}
