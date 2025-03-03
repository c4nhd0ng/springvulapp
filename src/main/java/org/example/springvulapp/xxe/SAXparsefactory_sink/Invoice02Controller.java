package org.example.springvulapp.xxe.SAXparsefactory_sink;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/xxe")
public class Invoice02Controller {
    @GetMapping("/invoice02")
    public String invoice02() {
        return "invoice";
    }
    @PostMapping("/invoice02")
    public String invoice02(@RequestParam("xmlData") String xmlData, Model model) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLToStringHandler handler = new XMLToStringHandler();
        saxParser.parse(new InputSource(new StringReader(xmlData)),handler);

        model.addAttribute("output", handler.getParsedData());

        return "invoice";
    }

    class XMLToStringHandler extends DefaultHandler {
        private StringBuilder extractedData = new StringBuilder();
        private List<String> elements = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            elements.add(qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String content = new String(ch, start, length).trim();
            if (!content.isEmpty()) {
                extractedData.append("Element: ").append(elements.get(elements.size() - 1))
                        .append(" => Content: ").append(content).append("\n");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            elements.remove(elements.size() - 1);
        }

        public String getParsedData() {
            return extractedData.toString();
        }
    }

}
