package com.imooc.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/*
自定义Java类加载器
 */
public class MyClassLoader extends ClassLoader {

    private String classPath;

    public MyClassLoader(String classPath) {
        super(ClassLoader.getSystemClassLoader());
        this.classPath = classPath;
    }


    @Override
    protected Class<?> findClass(String name) {
        System.out.println("findClass");
        byte[] data = loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }


    private byte[] loadClassData(String name) {
        System.out.println("loadClassData");
        try {
            name = name.replace(".", "//");
            FileInputStream fileInputStream = new FileInputStream(new File(classPath + name + ".class"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int b;
            while ((b = fileInputStream.read()) != -1) {
                byteArrayOutputStream.write(b);
            }
            fileInputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
