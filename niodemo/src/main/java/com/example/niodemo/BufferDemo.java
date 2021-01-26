package com.example.niodemo;

import java.nio.Buffer;
import java.nio.CharBuffer;

/***
 * capacity 容量
 * limit 限制
 * position 位置
 * mark 标记
 * 0 <= mark <= position <= limit <= capacity
 * */
public class BufferDemo {
    public static void main(String[] args) {
        Buffer buffer;
        char[] chars = new char[]{'a', 'b', 'c'};
        CharBuffer charBuffer = CharBuffer.wrap(chars);
        //定义下次reset后的位置,下次开始写入的位置；
        charBuffer.mark();
        //代表缓冲区中下一个要读取写入的位置
        charBuffer.position();
        //缓冲区中的读写限制
        charBuffer.limit();
        //缓冲区剩余空控件
        charBuffer.remaining();
    }
}
/**
 * Created By leiyao6 on
 */