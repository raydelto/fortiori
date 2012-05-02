package edu.itla.fortiori.config;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import edu.itla.fortiori.config.base.ConfigurationManager;

/*
 * @author Raydelto Hernández
 */
public class PropertyConfigurationManager implements ConfigurationManager{
	private Properties properties;
	private final String CONFIG_FILE = "fortiori.config";
	private static PropertyConfigurationManager instance;
	private Map<String,String> allConfig;
	
	public static synchronized PropertyConfigurationManager getInstance(){
		if(instance == null){
			instance = new PropertyConfigurationManager();
		}
		return instance;
	}
	
	private PropertyConfigurationManager(){
		try{
			load();
		}catch(Exception e){
			System.err.println("Error while loading configuration: " + e);
			e.printStackTrace();
		}
	}
	@Override
	public void load() throws Exception {
		allConfig = new HashMap<String,String>();
		System.out.println("Loading properties");
		properties = new Properties();
		properties.load(new FileInputStream(CONFIG_FILE));
		//TODO: Implement log4j for logging		
		//Loading the Config Map
		for(Object key:properties.keySet()){
			allConfig.put((String)key, getConfig((String)key));
		}
		System.out.println("Properties load finished");
		
	}

	@Override
	public String getConfig(String config) {
		// TODO Auto-generated method stub
		return properties.get(config).toString();
	}

	@Override
	public Map<String, String> getAllConfig() {
		// TODO Auto-generated method stub
		
		return allConfig;
	}
	
	public static void main(String[] args) throws Exception {
		PropertyConfigurationManager p = new PropertyConfigurationManager();
		p.load();
		System.out.println(p.getAllConfig());
		System.out.println(p.getConfig("name"));
	}
}
