package org.easymis.workflow.app.nlp;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;
/**
名字查找，比如说要识别哪些是人名

*
 */
public class NameFinder {
    public static void main(String args[]) throws IOException {

        String paragraph = "Hi. How are you? This is Mike.";
        String path = "E:/test/en-ner-person.bin";
        InputStream is = new FileInputStream(path);

        TokenNameFinderModel model = new TokenNameFinderModel(is);
        is.close();

        NameFinderME nameFinder = new NameFinderME(model);

        String[] sentence = new String[] { "Mike", "Smith", "is", "a", "good", "person" };

        Span nameSpans[] = nameFinder.find(sentence);

        for (Span s : nameSpans)
        System.out.println(s.toString());
    }
}
