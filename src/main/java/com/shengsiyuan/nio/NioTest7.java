package com.shengsiyuan.nio;

import java.nio.ByteBuffer;

/**
 * 可随时将一个bytebuffer转换为只读buffer，但不能将一个只读buffer转换为bytebuffer
 */

public class NioTest7 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        System.out.println(buffer.getClass());

        for(int i=0;i<buffer.capacity();i++){
            buffer.put((byte)i);
        }

        ByteBuffer readonlyBuffer = buffer.asReadOnlyBuffer();

        System.out.println(readonlyBuffer.getClass());
    }
}
