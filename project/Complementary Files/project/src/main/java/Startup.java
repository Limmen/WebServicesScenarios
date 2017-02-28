import matching.SemanticMatcher;
import matching.SyntacticMatcher;

/**
 * @author Kim Hammar on 2017-02-28.
 */
public class Startup {

    public static void main(String[] args) {
        try {
            SyntacticMatcher syntacticMatcher = new SyntacticMatcher();
            syntacticMatcher.calculateMatchings();

            SemanticMatcher semanticMatcher = new SemanticMatcher();
            semanticMatcher.calculateMatchings();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
