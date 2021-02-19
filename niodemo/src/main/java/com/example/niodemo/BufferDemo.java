package com.example.niodemo;

import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
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
      byte[] bytes = { 2};
      ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
      byteBuffer.isReadOnly();
      ByteBuffer a = byteBuffer.compact();
      System.out.println("isReadyOnly:"+byteBuffer.isReadOnly());

      CharBuffer charBuffer = CharBuffer.wrap("abcdefg",2,5);
        System.out.println("isReadyOnly:"+charBuffer.isReadOnly());

    }
}
/**
 * Created By leiyao6 on
 */