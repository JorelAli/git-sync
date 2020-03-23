package parser;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Repository {

	private String name;
	private String domain;
	private boolean hidden;
	
	public Repository(String name, String domain, boolean hidden) {
		this.name = name;
		this.domain = domain;
		this.hidden = hidden;
	}
	
	public boolean isHidden() {
		return this.hidden;
	}
	
	public void cloneRepo(File parentFolder, Map<String, String> domains) throws IOException, InterruptedException {
		if(!hidden) {
			if(new File(parentFolder, name).exists()) {
				System.out.println("    Repository " + name + " already exists!");
				return;
			}
			System.out.print("    Cloning repository " + name);
			Process p = Runtime.getRuntime().exec("git clone " + domains.get(domain) + name, null, parentFolder);
			if(p.waitFor() == 0) {
				System.out.println(" ... Done!");
			} else {
				System.out.println(" ... Failed to clone " + name + "!");
			}
		}
	}
}
