package org.easymis.workflow.app.nlp;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.util.InvalidFormatException;
/**
分析器parser
 */
public class Parser {

    public static void main(String args[]) throws InvalidFormatException,   IOException {
        // http://sourceforge.net/apps/mediawiki/opennlp/index.php?title=Parser#Training_Tool

        String path = "E:/test/en-parser-chunking.bin";
        InputStream is = new FileInputStream(path);

        ParserModel model = new ParserModel(is);

        opennlp.tools.parser.Parser parser = ParserFactory.create(model);

        String sentence = "Programcreek is a very huge and useful website.";
        Parse topParses[] = ParserTool.parseLine(sentence, (opennlp.tools.parser.Parser) parser, 1);

        for (Parse p : topParses)
            p.show();

        is.close();

        /*
         * (TOP (S (NP (NN Programcreek) ) (VP (VBZ is) (NP (DT a) (ADJP (RB
         * very) (JJ huge) (CC and) (JJ useful) ) ) ) (. website.) ) )
         */
    }
}
