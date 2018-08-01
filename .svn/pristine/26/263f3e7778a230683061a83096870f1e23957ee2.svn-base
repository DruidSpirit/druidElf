package reptile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.util.Date;
import java.util.Random;

import org.joda.time.DateTime;

/**
 * @author wangyang
 *
 */
public class TestReptile {

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		//String url = "http://www.sjtxt.la/soft/1/Soft_001_1.html";//http://www.aqtxt.com/xuanhuan/
		/*String str1="192.168.0.201";
		String str2="255.255.255.0";
		String[] command1 = { "netsh", "interface", "ip", "set", "address",
		"name=", "Local Area Connection" ,"source=static", "addr=",str1,
		"mask=", str2};
		Process pp = java.lang.Runtime.getRuntime().exec(command1);*/
		String ip = "192.168.2.153:8080";
		String[] r = ip.split(":");
		System.getProperties().setProperty("http.proxyHost", r[0]);
        System.getProperties().setProperty("http.proxyPort", r[1]);
		try {
			/*pp = java.lang.Runtime.getRuntime().exec(command1);*/
			ReptileService start = new ReptileService();
			InetAddress addr = InetAddress.getLocalHost();
			 System.out.println("Local HostAddress:"+addr.getHostAddress());
			start.ipChange("http://192.168.2.192:8080/ycw/marketTrend/toMarketTrend.action");
			// System.out.print( pp);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
}
