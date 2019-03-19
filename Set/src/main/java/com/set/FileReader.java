package com.set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FileReader {
    private static final Logger logger = LoggerFactory.getLogger(FileReader.class);

    public static boolean readFile(String fileName, List<String> words) {
        if (null == fileName || null == words) {
            logger.error("The fileName is null or words is null.");
            return false;
        }

        Scanner scanner = null;
        try {
            File file = new File(fileName);
            if (file.exists()) {
                FileInputStream is = new FileInputStream(file);
                scanner = new Scanner(is);
                scanner.useLocale(Locale.ENGLISH);
            } else {
                return false;
            }
        } catch (FileNotFoundException e) {
            logger.error("Read file failed, error is {}", e);
            return false;
        }

        // 分词操作
        if (scanner.hasNextLine()) {

            String content = scanner.useDelimiter("\\A").next();
            int start = firstCharacterIndex(content, 0);
            for (int i = start; i < content.length(); ) {
                if (i == content.length() || !Character.isLetter(content.charAt(i))) {
                    words.add(content.substring(start, i).toLowerCase());
                    start = firstCharacterIndex(content, i + 1);
                    i = start + 1;
                } else {
                    i++;
                }
            }

        }
        return false;
    }

    /**
     * str字符串中从start开始第一个为字符的索引
     *
     * @param str
     * @param start
     * @return
     */
    public static int firstCharacterIndex(String str, int start) {
        for (int i = start; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i)))
                return i;
        }
        return str.length();
    }
}
