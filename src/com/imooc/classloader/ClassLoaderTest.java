package com.imooc.classloader;

public class ClassLoaderTest {
    public static void main(String args[]) {
        new Thread(new MsgHandler()).start();
    }
}
