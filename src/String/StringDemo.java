package String;

/**
 * ==
 *
 */
public class StringDemo {

    public static void main(String args[]){

        char c[] = {'a', 'b'};

        String str = new String(c);

        System.out.println(str.replace('b', 'm'));

        str = "java";
        System.out.println(str);

        final char value[] = {'j', 'a', 'v', 'a'};
        value[0] = 'p';
        String valueStr = new String(value);
        System.out.println("valueStr =" + valueStr);
        
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        String s5 = "a" + "b";
        String s6 = s1+"b";

        System.out.println(s3 == s4);//false
        System.out.println(s3 == s5);//true
        System.out.println(s3 == s6);//false
        System.out.println(s4 == s5);//false
        System.out.println(s4 == s6);//false

    }
}
