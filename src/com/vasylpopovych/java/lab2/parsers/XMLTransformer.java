package com.vasylpopovych.java.lab2.parsers;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.util.logging.Logger;

public class XMLTransformer {
    private static final Logger logger = Logger.getLogger(XMLTransformer.class.getName());

    public void transform(String inputXML, String xslFile, String outputXML) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Templates template = factory.newTemplates(new StreamSource(new File(xslFile)));
            Transformer transformer = template.newTransformer();

            Source source = new StreamSource(new File(inputXML));
            Result result = new StreamResult(new File(outputXML));

            transformer.transform(source, result);
            logger.info("Transformation succeeded. Output is in " + outputXML);
        } catch (TransformerException e) {
            logger.severe("Transformation error: " + e.getMessage());
        }
    }
}