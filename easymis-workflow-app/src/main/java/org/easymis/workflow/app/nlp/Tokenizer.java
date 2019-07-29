package org.easymis.workflow.app.nlp;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

/**
分词的例子
 */
public class Tokenizer {
	   public static void main(String args[]) throws InvalidFormatException, IOException {
	        String paragraph = "Hi. How are you? This is Mike.";
	        String path = "E:/test/en-token.bin";
	        InputStream is = new FileInputStream(path);

	        TokenizerModel model = new TokenizerModel(is);

	        TokenizerME tokenizer = new TokenizerME(model);

	        String tokens[] = tokenizer.tokenize("Hi. How are you? This is Mike.");

	        for (String a : tokens)
	        System.out.println(a);

	        is.close();
	    }
}
