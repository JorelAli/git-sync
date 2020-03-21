package parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DirectoryStructure {

	String domain;
	List<Repository> root;
	List<Subdirectory> subDirs;
	
	public DirectoryStructure(String domain, List<Repository> root, List<Subdirectory> subDirs) {
		this.domain = domain;
		this.root = root;
		this.subDirs = subDirs;
	}
	
	public void cloneAllLocal() throws IOException, InterruptedException {
		System.out.println("Creating repositories in root directory ");
		for(Repository r : root) {
			r.cloneRepo(new File("."), domain);
		}
	}
	
	public void cloneAllSubDirs() throws IOException, InterruptedException {
		for(Subdirectory s : subDirs) { 
			s.createAndCloneAll(new File("."), domain);
		}
	}
	
}
