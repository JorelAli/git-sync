package parser;

import java.io.File;
import java.io.IOException;

public class Repository {

	private boolean hidden;
	private String name;
	
	public Repository(String name, boolean hidden) {
		this.name = name;
		this.hidden = hidden;
	}
	
	public boolean isHidden() {
		return this.hidden;
	}
	
	public void cloneRepo(File parentFolder, String domain) throws IOException, InterruptedException {
		if(!hidden) {
			if(new File(parentFolder, name).exists()) {
				System.out.println("    Repository " + name + " already exists!");
				return;
			}
			System.out.print("    Cloning repository " + name);
			Process p = Runtime.getRuntime().exec("git clone " + domain + name, null, parentFolder);
			if(p.waitFor() == 0) {
				System.out.println(" ... Done!");
			} else {
				System.out.println(" ... Failed to clone " + name + "!");
			}
		}
	}
}
