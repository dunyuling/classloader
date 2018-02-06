package com.imooc.classloader;

public class MsgHandler implements Runnable {

    @Override
    public void run() {
        while (true) {
            BaseManager baseManager = ManagerFactory.getManger(ManagerFactory.MY_MANAGER);
            baseManager.logic();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        BaseManager baseManager = ManagerFactory.getManger(ManagerFactory.MY_MANAGER);
//        baseManager.logic();
    }
}
