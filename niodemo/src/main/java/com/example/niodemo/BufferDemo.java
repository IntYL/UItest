package com.example.niodemo;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/***
 * capacity 容量
 * limit 限制
 * position 位置
 * mark 标记
 * 0 <= mark <= position <= limit <= capacity
 * */
public class BufferDemo {
    public static void main(String[] args) throws Exception {
        byte[] bytes = {2};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer.isReadOnly();
        ByteBuffer a = byteBuffer.compact();
        System.out.println("isReadyOnly:" + byteBuffer.isReadOnly());
        int[] ss = new int[]{1, 2, 3, 4, 5, 6, 7};
        for (int s : ss) {

        }

        CharBuffer charBuffer = CharBuffer.wrap("abcdefg", 2, 5);
        System.out.println("isReadyOnly:" + charBuffer.isReadOnly());
        File file = new File("sss");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();
        fileChannel.size();
    }
}
/**
 * Created By leiyao6 on
 */