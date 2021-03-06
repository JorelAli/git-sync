/* Parser.java */
/* Generated By:JavaCC: Do not edit this line. Parser.java */
package parser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("unused")
public class Parser implements ParserConstants {

        public static DirectoryStructure parse(String input) throws ParseException {
                InputStream inputStream = new ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8")));
                return new Parser(inputStream).input();
        }

/** Main endpoint */
  final public DirectoryStructure input() throws ParseException {Map<String, String> domains; List<Repository> repos; Subdirectory d; List<Subdirectory> subDirs = new ArrayList<Subdirectory>();
    domains = domains();
    repos = repos();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IN:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      d = inside();
subDirs.add(d);
    }
    jj_consume_token(0);
{if ("" != null) return new DirectoryStructure(domains, repos, subDirs);}
    throw new Error("Missing return statement in function");
  }

  final public Repository repo() throws ParseException {boolean hidden; Token name; Token domain;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case PLUS:{
      jj_consume_token(PLUS);
hidden = false;
      break;
      }
    case MINUS:{
      jj_consume_token(MINUS);
hidden = true;
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    domain = jj_consume_token(NAME);
    name = jj_consume_token(NAME);
{if ("" != null) return new Repository(name.image, domain.image, hidden);}
    throw new Error("Missing return statement in function");
  }

  final public Subdirectory inside() throws ParseException {Token t; List<Repository> repos; Subdirectory sd; List<Subdirectory> nested = new ArrayList<Subdirectory>();
    jj_consume_token(IN);
    t = jj_consume_token(NAME);
    jj_consume_token(OPENCBRACKET);
    repos = repos();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IN:{
        ;
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      sd = inside();
nested.add(sd);
    }
    jj_consume_token(CLOSECBRACKET);
{if ("" != null) return new Subdirectory(t.image, repos, nested);}
    throw new Error("Missing return statement in function");
  }

  final public List<Repository> repos() throws ParseException {Repository repo; List<Repository> repos = new ArrayList<Repository>();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:
      case MINUS:{
        ;
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      repo = repo();
repos.add(repo);
    }
{if ("" != null) return repos;}
    throw new Error("Missing return statement in function");
  }

  final public Map<String, String> domains() throws ParseException {StringBuilder builder; Token as; Token t; Map<String, String> domains = new HashMap<String, String>();
    label_4:
    while (true) {
builder = new StringBuilder();
      jj_consume_token(USING);
      jj_consume_token(QUOTE);
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case CHAR:{
          ;
          break;
          }
        default:
          jj_la1[4] = jj_gen;
          break label_5;
        }
        t = jj_consume_token(CHAR);
builder.append(t.image);
      }
      jj_consume_token(ENDQUOTE);
      jj_consume_token(AS);
      as = jj_consume_token(NAME);
String result = builder.toString();
                        if(!result.endsWith("/")) {
                                result = result + "/";
                        }
                        System.out.println(as.image + " -> " + result);
                        domains.put(as.image, result);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case USING:{
        ;
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        break label_4;
      }
    }
{if ("" != null) return domains;}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public ParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[6];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x40,0x6,0x40,0x6,0x800,0x20,};
   }

  /** Constructor with InputStream. */
  public Parser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Parser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Parser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
      jj_input_stream = new SimpleCharStream(stream, 1, 1);
   } else {
      jj_input_stream.ReInit(stream, 1, 1);
   }
   if (token_source == null) {
      token_source = new ParserTokenManager(jj_input_stream);
   }

    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Parser(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[17];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 6; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 17; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
