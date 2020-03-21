package parser;

import java.io.File;
import java.io.IOException;

public class Repository {

	boolean hidden;
	String name;
	
	public Repository(String name, boolean hidden) {
		this.name = name;
		this.hidden = hidden;
	}
	
	public void cloneRepo(File parentFolder, String domain) throws IOException, InterruptedException {
		if(!hidden) {
			if(new File(parentFolder, name).exists()) {
				System.out.println(name + " already exists!");
				return;
			}
			System.out.print("\tCloning repository " + name);
			Process p = Runtime.getRuntime().exec("git clone " + domain + name, null, parentFolder);
			if(p.waitFor() == 0) {
				System.out.println(" ... Done!");
			} else {
				System.out.println(" ... Failed to clone " + name);
			}
		}
	}
}
