import java.awt.geom.Area;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class ReadProperties {
	public static void main(String[] args) throws IOException {
		

		FileInputStream fis = new FileInputStream("E:\\\\Companyname.properties");
		Properties prop = new Properties();
		int test= prop.size();
		prop.load(fis);
//		System.out.println(prop);
		
		
		for(int i=1;i<=test;i++)
		{
		
			System.out.println(prop.getProperty("1"));
		}
	}
}