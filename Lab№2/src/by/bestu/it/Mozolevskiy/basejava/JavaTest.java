package by.bestu.it.Mozolevskiy.basejava;

/**
* @author MAD
* @version 1.0
* */

import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static java.lang.Math.*;

public class JavaTest {
    static int sint;
    final int f = 1;
    public final int pf = 2;
    public static final int psf = 3;

    public static void main(String[] args) {
        /**
        * @params
        * */

        String str = "123";
        char ch = 'a';
        int i = 1;
        double d = 1.1;
        short sh = 2;
        byte b = 3;
        b = (byte)(b + i);
        long l = i + 2147483647L;
        boolean bool = false;
        long num1 = 9223372036854775807L;
        long num2 = 0x7fff_ffff_fffL;
        char ascii = '\u0061';
        char ch1 = 'a';
        char ch2 = 97;

        System.out.println(str + i);
        System.out.println(str + ch);
        System.out.println(str + d);
        System.out.println(b);
        System.out.println(l);
        System.out.println(sint);
        System.out.println(bool && !bool);
        System.out.println(bool ^ !bool);
        //System.out.println(bool1 + bool2);
        System.out.println(3.45 % 2.4);
        System.out.println(ascii);
        System.out.println(ascii + ch1 + ch2);
        System.out.println(1.0 / 0.0);
        System.out.println(0.0 / 0.0);
        System.out.println(log(-345));
        System.out.println(Float.intBitsToFloat(0x7F800000));
        System.out.println(Float.intBitsToFloat(0xFF800000));
        System.out.println();

        System.out.println(Math.PI);
        System.out.println(Math.round(Math.PI));
        System.out.println(Math.E);
        System.out.printf("%.2f%n", Math.E);
        System.out.println(Math.min(Math.PI, Math.E));
        System.out.println(Math.random());

        System.out.println();

        Boolean e1 = false;
        Character e2 = '1';
        Integer e3 = 1;
        Byte e4 = 2;
        Short e5 = 3;
        Long e6 = 4L;
        Double e7 = 1.1;

        System.out.println(e3 >> 3);
        System.out.println(e4 * 4);

        System.out.println(e5 & e6);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println();

        int box = 10;
        Object obj = box;
        Integer ob1 = box;
        int unbox = (int)obj;
        byte unbox_byte = (byte)(int)obj;
        System.out.println(unbox);
        System.out.println(unbox_byte);

        int pi = Integer.parseInt("123");
        String hs = Integer.toHexString(1);
        int com = Integer.compare(0, 1);
        String ts = Integer.toString(777);
        int bc = Integer.bitCount(128);
        boolean isn = Double.isNaN(0.0 / 0.0);
        System.out.println(pi);
        System.out.println(hs);
        System.out.println(com);
        System.out.println(ts);
        System.out.println(bc);
        System.out.println(isn);
        System.out.println();

        String s34 = "2345";
        int s1 = new Integer(s34);
        int s2 = Integer.valueOf(s34);
        int s3 = Integer.parseInt(s34);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        byte[] array =  s34.getBytes(StandardCharsets.UTF_8);
        String fromArray = new String(array);
        boolean boolean1 = Boolean.parseBoolean(s34);
        boolean boolean2 = Boolean.valueOf(s34);
        System.out.println(boolean1);
        System.out.println(boolean2);
        String s35 = "2345";
        System.out.println(s34 == s35);
        System.out.println(s34.equals(s35));
        System.out.println(s34.compareTo(s35));
        s34 = null;
        System.out.println(s34 == s35);
        System.out.println(Objects.equals(s34, s35));
        //System.out.println(s35.compareTo(s34));
        String[] split = s35.split("");
        for (var item : split) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println(s35.contains("2"));
        System.out.println(s35.hashCode());
        System.out.println(s35.indexOf("2"));
        System.out.println(s35.length());
        System.out.println(s35.replace("2", "4"));
        System.out.println();

        char[][] c1;
        char[] c2[];
        char c3[][];
        c1 = new char[3][];
        c1[0] = new char[0];
        c1[1] = new char[1];
        c1[2] = new char[2];
        c2 = new char[][]{{'1', '2'}, {'3', '4'}};
        c3 = new char[][]{{'a', 'b'}, {'c', 'd'}};
        boolean comRez = c2 == c3;
        c2 = c3;
        for (var strAr : c3) {
            for(var item : strAr) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        System.out.println(comRez);
//        for(int k = 0; k < 3; k++) {
//            System.out.println(c2[0][k]);
//        }
        System.out.println();

        WrapperString ws = new WrapperString("String");
        ws.replace('r', 'p');
        System.out.println(ws.getStr());

        WrapperString ws2 = new WrapperString("String") {
            @Override
            public void replace(char oldChar, char newChar) {
                System.out.println(oldChar);
            }

            public void delete(char newChar) {
                System.out.println(newChar);
            }
        };

        ws2.replace('a', 'b');
    }
}
