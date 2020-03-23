package parser;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Subdirectory {

	private String name;
	private List<Repository> repos;
	private List<Subdirectory> subDirs;
	
	public Subdirectory(String name, List<Repository> repos, List<Subdirectory> subDirs) {
		this.name = name;
		this.repos = repos;
		this.subDirs = subDirs;
	}
	
	private int countRepos() {
		int count = 0;
		count += subDirs.stream().mapToInt(Subdirectory::countRepos).sum();
		count += repos.stream().mapToInt(r -> r.isHidden() ? 0 : 1).sum();
		return count;
	}
	
	public void createAndCloneAll(File parent, Map<String, String> domains) throws IOException, InterruptedException {
		if(countRepos() != 0) {
			File file = new File(parent, name);
			file.mkdir();
			
			System.out.println("\nCreating repositories in directory " + file.getPath());
			for(Repository repo : repos) {
				repo.cloneRepo(file, domains);
			}
			
			for(Subdirectory d : subDirs) {
				d.createAndCloneAll(new File(parent, name), domains);
			}
		}
	}
	
}
