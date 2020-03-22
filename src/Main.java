import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

import parser.ParseException;
import parser.Parser;

public class Main {
	
	public static void main(String[] args) throws ParseException, IOException, InterruptedException {
		String s = Files.readAllLines(new File("config.gitsync").toPath()).stream().collect(Collectors.joining("\n"));
		Parser.parse(s).cloneAll();
	}
	
}
