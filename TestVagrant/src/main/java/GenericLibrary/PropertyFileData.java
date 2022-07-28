package GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileData implements AutoConstant
{
	
	public String getData(String key)
	{
		String data = null;
		try {

			FileInputStream fs =  new FileInputStream(PropertyPath);
				Properties p = new Properties();
				p.load(fs);
				data =p.getProperty(key);
		} catch (Exception e) {
			System.out.println("Unable to fetch the data from Property file due to::"+e.getMessage().toString());
		}
		return data;
		
	}
}
