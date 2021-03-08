package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 86176
 * @package io
 * @date 2021/2/24 17:37
 */
public class file {
    public static void main(String[] args) throws IOException {
//        File f = new File("src\\main\\java\\hello\\siri.java");

        File f = new File("src\\main\\resources\\app.log");
        RandomAccessFile a = new RandomAccessFile("src\\main\\resources\\app.log", "r");
        FileChannel ch = a.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int i = ch.read(buffer);

        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
        System.out.println(f.separator);
        try (FileReader re = new FileReader(f, StandardCharsets.UTF_8)) {
            int n = 0;
            char[] c = new char[10];
            while ((n = re.read(c)) != -1) {
                // System.out.println("===================================================");
                System.out.print(new String(c));
            }

        }
    }
}
