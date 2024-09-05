package javalearn;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class AppUnsafe {
    public static void main(String[] args) throws InstantiationException, NoSuchFieldException, IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        Friend friend = (Friend) unsafe.allocateInstance(Friend.class);
        friend.setName("tang");
        System.out.println(friend.getName());

        long nameOff = unsafe.objectFieldOffset(Friend.class.getDeclaredField("name"));
        unsafe.putObject(friend, nameOff, "yuan");
        System.out.println(friend.getName());
    }
}
