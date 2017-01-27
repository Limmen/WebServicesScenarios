package limmen.kth.se.id2208.hw1.parsing;

/**
 * Entry point of the program. Creates parser and parses the input XML files and extracts relevant information to
 * produce application_profile.xml using JAXB, SAX, DOM, XSLT (for practice and getting familiar with the libraries).
 *
 * @author Kim Hammar on 2017-01-26.
 */
public class Startup {

    /**
     * Main method, boots up the parser and call its API to perform parsing
     *
     * @param args
     */
    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.parseWithDOM_SAX_JAXB();
        parser.buildWithXSLT();
    }
}
