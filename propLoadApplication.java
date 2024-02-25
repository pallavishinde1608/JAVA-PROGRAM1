package g;

import java.io.FileInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

public class propLoadApplication {

	public static void main(String[] args)throws Exception {
		Path currentDirectoryPath=FileSystems.getDefault().getPath("");
		String currentDirectoryName=currentDirectoryPath.toAbsolutePath().toString();
		String completePath=currentDirectoryName+"\\src\\sources\\db.properties";
		System.out.println("current directory = \""+currentDirectoryName +"\"");
		Properties p=new Properties();
		FileInputStream finf=new FileInputStream(completePath);
         p.load(finf);
         String driverClassName=p.getProperty("driver");
         String urlName=p.getProperty("url");
         String username=p.getProperty("userName");
         String password=p.getProperty("password");
         System.out.println(driverClassName);
         System.out.println(username);
         System.out.println(password);
         System.out.println(urlName);
	}

}
