
package com.example.demo.user;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializableTest {

    public static void main(String[] args) {

        Person p1 = (Person) deSerialByte(serialByte(new User("user", "1234", 15)));

        //Person p2 = (Person)deSerialByte(serialByte(new Person("person",10)));

        System.out.println("p1:" + p1.toString());

        //System.out.println("p2:"+p2.toString());
    }

    //序列化一个对象（可以存储到一个文件也可以存储到字节数组）这里存储到自己数组
    public static byte[] serialByte(Object obj) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();
            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    //反序列化一个对象
    public static Object deSerialByte(byte[] by) {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new ByteArrayInputStream(by));
            return ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
