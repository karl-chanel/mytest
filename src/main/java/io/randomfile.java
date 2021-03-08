package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author 86176
 * @package io
 * @date 2021/2/25 19:29
 */
public class randomfile {
    public static void main(String[] args) throws IOException {
//        RandomAccessFile ran = new RandomAccessFile("test\\hello1.txt", "rw");
//        // ran.write("hello loop".getBytes(StandardCharsets.UTF_8));
//        FileChannel channel = ran.getChannel();
//        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 100);
        RandomAccessFile f = new RandomAccessFile("test\\hello1.txt", "rw");
        FileChannel channel1 = f.getChannel();
        ByteBuffer b = ByteBuffer.allocate(1024);
        channel1.read(b);
        b.flip();

        byte[] ndd = new byte[89];
        b.get(ndd);
        System.out.println(new String(ndd));
        System.out.println(new String(b.array()));
        MappedByteBuffer mapbuffer = channel1.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
       // channel1.read(mapbuffer);
     //   mapbuffer.flip();
     //   System.out.println(mapbuffer.toString());


//        byte[] bu = new byte[100];
//        int read = ran.read(bu);
//        String s = new String(bu);
//        System.out.println(s+read);
    }
}
