package limmen.kth.se.id2208.hw1;

import limmen.kth.se.id2208.hw1.parsing.Parser;

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
        System.out.println("Parsing");
        Parser parser = new Parser();
        parser.parseWithDOM_SAX_JAXB();
        parser.buildWithXSLT();
        System.out.println("Parsing done\n see xml/documents/application_profile_generated_task1.xml \n and "  +
                "xml/documents/application_profile_generated_task2.xml");
    }
}
