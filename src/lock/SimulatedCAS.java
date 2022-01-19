package lock;

/**
 * 作者: lihui1
 * 日期: 2021/8/4 8:04 下午
 * 描述: CAS等价代码
 */
public class SimulatedCAS {

    private volatile int value;

    public synchronized int compareAndSwap(int expectedValue, int newValue){
        int oldValue = value;
        //如果内存中的值value和期望值expectedValue相等, 则将值更新为新值newValue
        if (oldValue == expectedValue){
            value = newValue;
        }
        return oldValue;
    }
}
