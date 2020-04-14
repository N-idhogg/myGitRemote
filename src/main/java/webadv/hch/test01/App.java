package webadv.hch.test01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		File file = new File("src/password.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        Scanner s = new Scanner(System.in);
        String[] strs = new String [2];
        System.out.print("输入账号：");
        strs[0] = s.nextLine();
        System.out.print("输入密码：");
        strs[1] = s.nextLine();
        StringBuffer bf = new StringBuffer();
        String str = "";
        int i = 0;
        boolean flag=true;
        while ((str = br.readLine()) != null) {
            if (!sha256hex(str).equals(sha256hex(strs[i++]))) {
				flag=false;
             	break;
            }
	    }
		if(flag){
			System.out.println("登录成功!");	
		} else {
			System.out.println("登录失败");
		}
        br.close();
    }
    public static String sha256hex(String input) {
    	
        return DigestUtils.sha256Hex(input);
    }
}
