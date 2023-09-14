package Test;
public class StringBufferTest {

    public static void main(String[] args) {
        StringBuffer strbuf = new StringBuffer("123456789");
        strbuf.append("str");
        System.out.println(strbuf); // 输出: 123456789str
        System.out.println(strbuf.insert(5, "str"));
        System.out.println(strbuf.deleteCharAt(5));
        System.out.println(strbuf.delete(2, 5));
        System.out.println(strbuf.replace(2, 2, "s"));
    }
}
