package Test3;

import java.util.Random;

public class TestRandomNumber {
    public TestRandomNumber() {
    }

    public static void main(String[] args) {
        String randomNum = getRandomPassword(8);
        System.out.println(randomNum);
    }

    /**
     * 返回随机产生的8位数
     */
    public static String getRandomPassword(int len) {
        String result = makeRandomPassword(len);
        if (result.matches(".*[a-z]{1,}.*") && result.matches(".*[A-Z]{1,}.*") && result.matches(".*\\d{1,}.*") &&
                result.matches(".*[~!@#$%^&*\\.?]{1,}.*")) {
            return result;
        }
        result = makeRandomPassword(len);
        return result;
    }

    /**
     * 产生8位随机数
     *
     * @param len 长度
     * @return
     */
    public static String makeRandomPassword(int len) {
        char charr[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int x = 0; x < len; ++x) {
            sb.append(charr[r.nextInt(charr.length)]);
        }
        return sb.toString();
    }
}