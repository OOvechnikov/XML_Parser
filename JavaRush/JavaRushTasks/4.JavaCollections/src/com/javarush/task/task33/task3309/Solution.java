package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* 
Комментарий внутри xml
*/

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();

        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);

        String xmlData = writer.toString();
        return xmlData.replaceAll("<" + tagName + ">", "<!--" + comment + "-->" + "\n" + "<" + tagName + ">")
                .replaceAll("<" + tagName + "/>", "<!--" + comment + "-->" + "\n" + "<" + tagName + "/>");
//        String[] array = xmlData.split("\n");
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < array.length; i++) {
//            if (array[i].contains(tagName) && !array[i].contains("CDATA")) {
//                result.append("<!--").append(comment).append("-->").append("\n");
//            }
//            result.append(array[i]).append("\n");
//        }
//
//        return result.toString();
    }

    public static void main(String[] args) throws JAXBException {
        String expl = "<cat>\n" +
                "<name>Murka</name>\n" +
                "<age>5</age>\n" +
                "<weight>4</weight>\n" +
                "<name>Murka</name>\n" +
                "<name><!CDATA[...]></name>\n" +
                "</cat>";

        String[] array = expl.split("\n");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i].contains("name") && !array[i].contains("CDATA")) {
                result.append("<!--").append("comment").append("-->").append("\n");
            }
            result.append(array[i]).append("\n");

        }
        System.out.println(result);
    }
}
