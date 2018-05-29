package org.surthi.app.xml.parser;

import java.io.File;
import java.io.FileInputStream;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import com.sun.org.apache.xerces.internal.parsers.SAXParser;

public class SAXParserMain {
  public static void main(String... args) throws Exception {
    final String xmlFileName = "";
    final ContentHandler handler = new SampleContentHandlerImpl();
    FileInputStream in = new FileInputStream(new File(
        "C:\\Users\\rsurthi\\IdeaProjects\\core-java\\src\\org\\surthi\\app\\xml\\parser\\sample.xml"));
    SAXParser parser = new SAXParser();
    parser.setContentHandler(handler);
    InputSource source = new InputSource();
    source.setByteStream(in);
    parser.parse(source);
  }
}


class SampleContentHandlerImpl implements ContentHandler {
  private String dataString = "";

  @Override
  public void setDocumentLocator(Locator locator) {

  }

  @Override
  public void startDocument() {
    System.out.println("Started reading document....");
  }

  @Override
  public void endDocument() {
    System.out.println("Completed reading document....");
  }

  @Override
  public void startPrefixMapping(String prefix, String uri) {

  }

  @Override
  public void endPrefixMapping(String prefix) {

  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes atts) {
    System.out.println("Started reading element: " + qName);
  }

  @Override
  public void endElement(String uri, String localName, String qName) {
    System.out.println("Completed REading element....." + localName + ", Data: " + dataString);
  }

  @Override
  public void characters(char[] ch, int start, int length) {
    String content = new String(ch, start, length);
    if (content.length() > 0) {
      dataString += content;
    }
  }

  @Override
  public void ignorableWhitespace(char[] ch, int start, int length) {

  }

  @Override
  public void processingInstruction(String target, String data) {
    if (target.equals("Name")) {
      data = "FullName";
    }
  }

  @Override
  public void skippedEntity(String name) {

  }
}
