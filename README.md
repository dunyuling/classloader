# classloader
#1
参考视频来源:https://www.imooc.com/video/16070

#2
具体class文件的路径见:ManagerFactorY::CLASS_PATH
具体操作时改变MyManager::logic::System.out.println,通过控制台信息的改变,标识确实实现了类的热加载


#3
在idea中运行时需要以下两个步骤:
1.开启自动编译选型
2.按快捷键 Shift+Ctrl+Alt+/ ，选择 Registry,勾选compile.automake.allow.when.app.running 
相见:http://blog.csdn.net/u013938484/article/details/77541050
