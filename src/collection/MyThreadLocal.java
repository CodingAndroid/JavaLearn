package collection;

import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadLocal<T> {

    private final int threadLocalHashCode = nextHashCode();

    private static final int HASH_INCREMENT = 0x61c88647;

    private static AtomicInteger nextHashCode =
            new AtomicInteger();

    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }

    static class MyThreadLocalMap {

        static class Entry extends WeakReference<MyThreadLocal<?>> {

            Object value;

            Entry(MyThreadLocal<?> k, Object v){
                super(k);
                this.value = v;
            }
        }

        private static int INITIAL_CAPACITY = 16;

        private int size = 0;

        private Entry[] table;

        private int threshold;

        private void setThreshold(int length){
            this.threshold = length * 2 / 3;
        }

        private static int nextIndex(int i, int len) {
            return ((i + 1 < len) ? i + 1 : 0);
        }

        /**
         * Decrement i modulo len.
         */
        private static int prevIndex(int i, int len) {
            return ((i - 1 >= 0) ? i - 1 : len - 1);
        }

        MyThreadLocalMap(MyThreadLocal<?> firstKey, Object firstValue){
            table = new Entry[INITIAL_CAPACITY];
            int i = firstKey.threadLocalHashCode & (INITIAL_CAPACITY - 1);
            table[i] = new Entry(firstKey, firstValue);
            size = 1;
            setThreshold(INITIAL_CAPACITY);
        }

        private MyThreadLocalMap(MyThreadLocalMap parentMap){

        }

        private void set(MyThreadLocal<?> key, Object value){
            Entry[] tab = table;
            int length = tab.length;
            int i = key.threadLocalHashCode & (length - 1);

            for (Entry e = tab[i]; e != null; e = tab[i = nextIndex(i, length)]){
                MyThreadLocal<?> k = e.get();
                if (k == key){
                    e.value = value;
                    return;
                }

                if (k == null){
                    // TODO: 2020/6/16  replaceStaleEntry(key, value, i);
                    return;
                }
            }

            tab[i] = new Entry(key, value);
            int sz = ++size;

            if (sz >= threshold){
                // TODO: 2020/6/16 rehash();
            }

        }

        private void resize(){
            Entry[] oldTable = table;
            int oldLen = oldTable.length;
            int newLen = oldLen * 2;
            Entry[] newTable = new Entry[newLen];
            int count = 0;

            for (int i = 0; i < newLen; i++){
                Entry e = oldTable[i];
                if (e != null){
                    MyThreadLocal<?> k = e.get();
                    if (k == null){
                        e.value = null;
                    } else {
                        int h = k.threadLocalHashCode & (newLen - 1);
                        while (newTable[h] != null)
                            h = nextIndex(h, newLen); //nextIndex 就是让在不超过数组长度的基础上, 把数组的索引位置 + 1
                        newTable[h] = e;
                        count++;
                    }
                }
            }
            setThreshold(newLen);
            size = count;
            table = newTable;
        }
    }
}
