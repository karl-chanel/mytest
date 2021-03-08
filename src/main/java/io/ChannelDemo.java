package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 86176
 * @package io
 * @date 2021/2/25 0:22
 */
public class ChannelDemo {
    public static void main(String args[]) throws IOException {
//        String relativelyPath = System.getProperty("user.dir");
//        FileInputStream input = new FileInputStream(relativelyPath + "/1.txt");
//        ReadableByteChannel source = input.getChannel();
//        FileOutputStream output = new FileOutputStream(relativelyPath + "/3.txt");
//        WritableByteChannel destination = output.getChannel();
//        copyData(source, destination);
//        source.close();
//        destination.close();
//        System.out.println("Copy Data finished.");
        ete();
    }

    private static void copyData(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(20);
        while (src.read(buffer) != -1) {
            // The buffer is used to drained
            buffer.flip();
            // keep sure that buffer was fully drained
            while (buffer.hasRemaining()) {
                dest.write(buffer);
            }
            buffer.clear(); // Now the buffer is empty, ready for the filling
        }
    }

    private static void ete() {
        String s;
        Path file = null;
        BufferedReader bufferedReader = null;
        String relativelyPath = System.getProperty("user.dir");
        try {
            file = Paths.get(relativelyPath + "/3.txt");
            InputStream inputStream = Files.newInputStream(file);

            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}

