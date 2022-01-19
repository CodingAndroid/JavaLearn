package 多线程.threadlocal;

import 多线程.model.User;

public class ThreadLocalDemo02 {

    public static void main(String[] args) {
        new Service1().process();
    }
}

class UserContextHolder{
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}

class Service1 {

    public void process(){
        User user = new User("Java");
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}

class Service2 {

    public void process(){
        User user = UserContextHolder.holder.get();
        System.out.println("Service2拿到用户名: " + user.name);
        new Service3().process();
    }
}

class Service3 {

    public void process(){
        User user = UserContextHolder.holder.get();
        System.out.println("Service3拿到用户名: " + user.name);
    }
}
