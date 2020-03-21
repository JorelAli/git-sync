import parser.ParseException;
import parser.Parser;

public class Main {
	
	public static void main(String[] args) throws ParseException {
		Parser.parse("(if hello)");
	}
	
}
