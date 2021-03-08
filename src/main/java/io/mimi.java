package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author 86176
 * @package io
 * @date 2021/2/26 1:27
 */
public class mimi {
    public static void main(String[] args) throws IOException {
        method1();
    }

    public static void method1() {
        new mimi().new test();
        RandomAccessFile aFile = null;
        FileChannel fileChannel = null;
        try {
            aFile = new RandomAccessFile("test\\hello.txt", "rw");
            fileChannel = aFile.getChannel();
            String s = """
                            gtergertg
                    gterggtt        gertg
                    vrevretvrtvgvtebtbtbt
                    grtegetyl,ldokewqmdeqfmrejifmcrwejivmiwerjv
                    deqvmwefrffwqiosmimzamiqjmzwijc eirv nrv rvn
                    vrwvmrtvinmv
                                
                     fdsvgffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffvg
                     nfjnfjynbhbtebvte
                    loooppppp!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
                            """;
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, s.length());
//            map.rewind();
            System.out.println("hh");
            map.put(s.getBytes(StandardCharsets.UTF_8));
            map.rewind();
            byte[] n = new byte[(int) s.length()];
            System.out.println(aFile.length());
            System.out.println(s.length());
            for (int i = 0; i < s.length(); i++) {
                n[i] = map.get();
            }
            System.out.println(new String(n));
//            ByteBuffer buf = ByteBuffer.allocate(1024);
//            int bytesRead = fileChannel.read(buf);
//            System.out.println(bytesRead);
//            while(bytesRead != -1)
//            {
//                buf.flip();
//                while(buf.hasRemaining())
//                {
//                    System.out.print((char)buf.get());
//                }
//                buf.compact();
//                bytesRead = fileChannel.read(buf);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileChannel.close();
                if (aFile != null) {
                    aFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void me() throws IOException {

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("test\\hello1.txt"))) {
            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print(buf[i]);
                    System.out.print((char) buf[i]);
                }
                bytesRead = in.read(buf);
            }

        }

    }
    private class test{



    }
}
