package edu.itla.fortiori.config.base;

import java.util.Map;

public interface ConfigurationManager {
	public void load() throws Exception ;
	public String getConfig(String config);
	public Map<String,String> getAllConfig();	
}
