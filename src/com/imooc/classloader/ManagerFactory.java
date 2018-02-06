package com.imooc.classloader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 加载manager的工厂
 */
public class ManagerFactory {

    private static final Map<String, LoadInfo> loadTimeMap = new HashMap<>();
        private static final String CLASS_PATH = "/home/liux/IdeaProjects/classloader/out/production/classloader/";

    public static final String MY_MANAGER = "com.imooc.classloader.MyManager";

    public static BaseManager getManger(String className) {
        File loadFile = new File(CLASS_PATH + className.replaceAll("\\.", "/") + ".class");
//        System.out.println(loadFile.getAbsolutePath());
        long lastModified = loadFile.lastModified();
        if (loadTimeMap.get(className) == null) {
            System.out.println("111");
            load(className, lastModified);
        } else if (loadTimeMap.get(className).getLoadTime() != lastModified) {
            System.out.println("222");
            load(className, lastModified);
        }
        return loadTimeMap.get(className).getManager();
    }

    private static void load(String className, long lastModified) {
        System.out.println("load");
        MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
        Class<?> loadClass = null;

        loadClass = myClassLoader.findClass(className);

        if (loadClass != null) {
            BaseManager manager = newInstance(loadClass);
            LoadInfo loadInfo = new LoadInfo(myClassLoader, lastModified);
            loadInfo.setManager(manager);
            loadTimeMap.put(className, loadInfo);
        }
    }

    private static BaseManager newInstance(Class<?> loadClass) {
        System.out.println("newInstance");
        try {
            return (BaseManager) loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

}
