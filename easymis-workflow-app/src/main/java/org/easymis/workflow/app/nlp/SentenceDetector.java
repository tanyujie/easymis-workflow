package org.easymis.workflow.app.nlp;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
/**
句子探测代码
*
 */
public class SentenceDetector {
	public static void main(String args[]) throws IOException {
	    String paragraph = "Hi. How are you? This is Mike.";
	    String path="E:/test/en-sent.bin";

	    // always start with a model, a model is learned from training data
	    InputStream is = new FileInputStream(path);
	    SentenceModel model = new SentenceModel(is);
	    SentenceDetectorME sdetector = new SentenceDetectorME(model);

	    String sentences[] = sdetector.sentDetect(paragraph);

	    System.out.println(sentences[0]);
	    System.out.println(sentences[1]);
	    is.close();
	}

}
