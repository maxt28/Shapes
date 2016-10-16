import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

abstract public class Serializer {
    private static final String SERIALIZED_FILE_NAME_XML = "file_xml.xml";

    public static void serializeToXML(ArrayList<Shape> shapes) {
        try {

            Document doc;
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root element
            doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("group");
            doc.appendChild(rootElement);

            for (Shape shape: shapes) {


                // shape elements
                Element elementShape = doc.createElement("Shape");
                rootElement.appendChild(elementShape);

                //setting shape's attributes
                elementShape.setAttribute("id", String.valueOf(shape.getId()));
                elementShape.setAttribute("figure", String.valueOf(shape.getShapeName()));

                // width element
                Element width = doc.createElement("width");
                width.appendChild(doc.createTextNode(String.valueOf(shape.getWidth())));
                elementShape.appendChild(width);

                // height element
                Element height = doc.createElement("height");
                height.appendChild(doc.createTextNode(String.valueOf(shape.getHeight())));
                elementShape.appendChild(height);
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(SERIALIZED_FILE_NAME_XML));

            transformer.transform(source, result);
            System.out.println("XML file saved!");


        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
