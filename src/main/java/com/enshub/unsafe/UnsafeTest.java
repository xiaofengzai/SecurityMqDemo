package com.enshub.unsafe;

import com.enshub.disruptor.User;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        String password = new String("l00k@myHor$e");
        String fake = new String(password.replaceAll(".", "?"));
        System.out.println(password); // l00k@myHor$e
        System.out.println(fake); // ????????????
        System.out.println(System.identityHashCode(password));

        //unsafe.copyMemory(fake, 0L, null,System.identityHashCode(password), password.length());

        System.out.println(password); // ????????????
        System.out.println(fake); // ????????????
    }
}
