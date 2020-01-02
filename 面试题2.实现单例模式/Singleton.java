package 面试题2.实现单例模式;

public class Singleton {
    public static void main(String[] args) {
        for (int i = 0; i< 200; i++) {
            Thread th = new Thread(() -> {
                System.out.println(SingleToneSync.getInstance());
            });
            th.start();
        }
    }
}

//静态内部类
class SingleToneClass {

    private SingleToneClass(){}

    public static SingleToneClass getInstance() {
        return innerClass.instance;
    }

    private static class innerClass {

        private static SingleToneClass instance = new SingleToneClass();

    }

}

//饿汉模式
class HungerSingleTone {

    private HungerSingleTone(){}

    private static HungerSingleTone instance = new HungerSingleTone();

    public static HungerSingleTone getInstance() {
        return instance;
    }

}

//加锁
class SingleToneSync {

    private SingleToneSync() {}

    private static SingleToneSync instance;

    public static SingleToneSync getInstance() {
        if (instance == null) {
            synchronized (SingleToneSync.class) {
                if (instance == null) {
                    instance = new SingleToneSync();
                }
            }
        }
        return instance;
    }

}