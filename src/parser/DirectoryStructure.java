package parser;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DirectoryStructure {

	private Map<String, String> domains;
	private List<Repository> root;
	private List<Subdirectory> subDirs;
	
	public DirectoryStructure(Map<String, String> domains, List<Repository> root, List<Subdirectory> subDirs) {
		this.domains = domains;
		this.root = root;
		this.subDirs = subDirs;
	}
	
	public void cloneAll() throws IOException, InterruptedException {
		cloneAllLocal();
		cloneAllSubDirs();
	}
	
	private void cloneAllLocal() throws IOException, InterruptedException {
		if(root.stream().mapToInt(r -> r.isHidden() ? 0 : 1).sum() != 0) {
			System.out.println("\nCreating repositories in root directory");
			for(Repository r : root) {
				r.cloneRepo(new File("."), domains);
			}
		}
	}
	
	private void cloneAllSubDirs() throws IOException, InterruptedException {
		for(Subdirectory s : subDirs) { 
			s.createAndCloneAll(new File("."), domains);
		}
	}
	
}
