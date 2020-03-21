package parser;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Subdirectory {

	public String name;
	public List<Repository> repos;
	
	public Subdirectory(String name, List<Repository> repos) {
		this.name = name;
		this.repos = repos;
	}
	
	public void createAndCloneAll(File parent, String domain) throws IOException, InterruptedException {
		System.out.println("Creating repositories in directory " + name);
		boolean existsOneVisible = false;
		for(Repository repo : repos) {
			if(!repo.hidden) {
				existsOneVisible = true;
				break;
			}
		}
		
		if(existsOneVisible) {
			File file = new File(parent, name);
			file.mkdir();
			for(Repository repo : repos) {
				repo.cloneRepo(file, domain);
			}
		} else {
			System.out.println("All repositories in " + name + " are hidden; not creating this subdirectory");
		}
		
		
	}
	
}
