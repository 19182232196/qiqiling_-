package Test19;

import java.net.InetAddress;

public class testDemo {
    public static void main(String[] args)throws Exception{
        InetAddress localhost = InetAddress.getLocalHost();
        InetAddress remotehost =InetAddress.getByName("www.itcat.com");

        System.out.println("主机 IP: "+localhost.getHostAddress());
        System.out.println("客户机 IP: "+remotehost.getHostAddress());
        System.out.println("三秒内是否送达: "+remotehost.isReachable(3000));
        System.out.println("客户机名: "+remotehost.getHostName());
    }
}
