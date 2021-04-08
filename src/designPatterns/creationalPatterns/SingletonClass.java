package designPatterns.creationalPatterns;

public final class SingletonClass {

    // variable of type String
    public String s;

    //create an object of SingleObject
    private static SingletonClass instance;

    //make the constructor private so that this class cannot be
    //instantiated
    private SingletonClass()
    {
        s = "Hello I am a string part of Singleton class";
    }

    //Get the only object available
    // synchronized anahtarını ekleyerek her thread’in bir sonrakini beklemesini sağladık ,
    // aynı anda 2 thread bu methodu kullanamaz.
    //Thread Safe Singleton
    public synchronized static SingletonClass getInstance(){
        if (instance == null)//her defasında nesne olusrumayı engeller
            instance = new SingletonClass();

         return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}

/*
Singleton desgin pattern çalışma zamanında yalnızca 1 object yaratılmasını garanti eden tasarım desenidir.
Kullanımına ihtiyaç duyulan durum şudur :
Birden çok sınıfın aynı instance’ı kullanması gerekmektedir.
Tüm uygulama için yalnızca bir nesne olması gerekmektedir.
Sadece bir nesne olduğu (unique) garanti edilmelidir.
Bu gereklilikler için bir sınıf yaratırız ve sınıfın kendi instance’ını yönetmesini sağlarız.
 */