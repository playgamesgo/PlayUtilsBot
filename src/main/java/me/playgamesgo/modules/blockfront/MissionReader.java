package me.playgamesgo.modules.blockfront;

import net.sourceforge.tess4j.ITessAPI;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Word;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public final class MissionReader {
    public static List<Word> readUncompletedLines(BufferedImage image) {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(BlockfrontModule.getConfig().getTesseractPath());
        tesseract.setLanguage(BlockfrontModule.getConfig().getTesseractLanguage());

        List<Word> lineResults = tesseract.getWords(image, ITessAPI.TessPageIteratorLevel.RIL_TEXTLINE);
        return lineResults.stream().filter(word -> word.getText().startsWith("*")).toList();
    }

    public static List<String> readMission(BufferedImage image, List<Word> words, int wordScale, Map<Character, BufferedImage> atlas) {
        words = words.stream().map(word -> new Word(word.getText(), word.getConfidence(),
                new Rectangle(
                        (int) (word.getBoundingBox().getX() / wordScale),
                        (int) (word.getBoundingBox().getY() / wordScale),
                        (int) (word.getBoundingBox().getWidth() / wordScale),
                        (int) (word.getBoundingBox().getHeight() / wordScale)
                ))).toList();

        List<String> missionLines = new ArrayList<>();
        Map<boolean[][], Character> charBitmaps = atlas.entrySet().stream().collect(Collectors.toMap(
                entry -> TextImageUtils.getCharacterBitmap(entry.getValue()), Map.Entry::getKey));

        for (Word word : words) {
            StringBuilder lineBuilder = new StringBuilder();
            int currentX = (int) word.getBoundingBox().getX();

            while (currentX <= word.getBoundingBox().getX() + word.getBoundingBox().getWidth()) {
                currentX += matchCharacterBitmaps(image, charBitmaps, word, lineBuilder, currentX);
            }

            missionLines.add(lineBuilder.toString().trim());
        }

        return missionLines;
    }

    public static int matchCharacterBitmaps(BufferedImage image, Map<boolean[][], Character> charBitmaps, Word word, StringBuilder lineBuilder, int currentX) {
        Set<Map.Entry<boolean[][], Character>> entries = charBitmaps.entrySet();
        entries = entries.stream().sorted((e1, e2) -> {
            int index1 = TextImageUtils.characters.indexOf(e1.getValue());
            int index2 = TextImageUtils.characters.indexOf(e2.getValue());
            return Integer.compare(index1, index2);
        }).collect(Collectors.toCollection(LinkedHashSet::new));

        for (Map.Entry<boolean[][], Character> charEntry : entries) {
            if (matchCharacterBitmap(image, word.getBoundingBox(), currentX, charEntry.getKey())) {
                lineBuilder.append(charEntry.getValue());
                return charEntry.getKey()[0].length + 1;
            }
        }

        return 1;
    }

    public static boolean matchCharacterBitmap(BufferedImage image, Rectangle boundingBox, int currentX, boolean[][] charBitmap) {
         for (int x = 0; x < charBitmap[0].length; x++) {
            for (int y = 0; y < charBitmap.length; y++) {
                int imageX = currentX + x;
                int imageY = ((int) boundingBox.getY() + y) + 2;

                if (imageX >= image.getWidth() || imageY >= image.getHeight()) {
                    return false;
                }

                int rgb = image.getRGB(imageX, imageY);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = rgb & 0xFF;
                boolean pixelBlack = (r + g + b) < 30;

                if (pixelBlack != charBitmap[y][x]) {
                    return false;
                }
            }
        }

        return true;
    }
}
