package OOP;

/**
 * 作者: lihui1
 * 日期: 2021/8/4 5:11 下午
 * 描述: 多态
 */
abstract class Polymorphic {
    abstract void show();
}

class PolymorphicA extends Polymorphic{

    @Override
    void show() {
        System.out.println("PolymorphicA");
    }
}

class PolymorphicB extends Polymorphic{

    @Override
    void show() {
        System.out.println("PolymorphicB");
    }
}
