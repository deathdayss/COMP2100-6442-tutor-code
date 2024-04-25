package persistentdata.processdata;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWritePerson {
    public static Person readPersonFromBespokeById(int id, String fileName, String fileName2) {
        BufferedReader reader = null;
        try {
            // read the person data
            reader = new BufferedReader(new FileReader("src/persistentdata/sampledata/" + fileName));
            Person person = null;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                int readId =  Integer.parseInt(tokens[0]);
                if (readId == id) {
                    person = new Person(id, tokens[1], tokens[2], Integer.parseInt(tokens[3]), new ArrayList<>());
                    break;
                }
            }
            // read the hobby data
            BufferedReader hobbiesReader = new BufferedReader(new FileReader("src/persistentdata/sampledata/" + fileName2));
            String hobbyLine;
            while ((hobbyLine = hobbiesReader.readLine()) != null) {
                String[] tokens = hobbyLine.split(",");
                int readId =  Integer.parseInt(tokens[0]);
                if (readId == id) {
                    person.getHobbies().add(tokens[1]);
                }
            }
            return person;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Person readPersonFromJsonById(int id, String fileName) {
        try {
            Object o = new JSONParser().parse(new FileReader("src/persistentdata/sampledata/" + fileName));
            JSONArray jsonArrayPerson = (JSONArray) o;
            Person person = null;
            for (Object value : jsonArrayPerson) {
                JSONObject jsonObjectPerson = (JSONObject) value;
                int readId = ((Long) jsonObjectPerson.get("id")).intValue();
                if (readId == id) {
                    person = new Person(id,
                            (String) jsonObjectPerson.get("firstName"),
                            (String) jsonObjectPerson.get("lastName"),
                            ((Long) jsonObjectPerson.get("age")).intValue(),
                            (ArrayList<String>) jsonObjectPerson.get("hobby"));
                }
            }
            return person;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Person readPersonFromXmById(int id, String fileName) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("src/persistentdata/sampledata/" + fileName));
            NodeList list = doc.getElementsByTagName("person");
            Person person = null;
            for (int i = 0; i < list.getLength(); ++i) {
                Element element = (Element) list.item(i);
                int readId = Integer.parseInt(element.getAttribute("id"));
                if (readId == id) {
                    NodeList hobbyList = element.getElementsByTagName("hobby");
                    ArrayList<String> hobbies = new ArrayList<>();
                    for (int j = 0; j < hobbyList.getLength(); ++j) {
                        hobbies.add(hobbyList.item(j).getTextContent());
                    }
                    return new Person(id,
                            element.getElementsByTagName("firstName").item(0).getTextContent(),
                            element.getElementsByTagName("lastName").item(0).getTextContent(),
                            Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent()),
                            hobbies);
                }
            }
            return person;

        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writePersonToBespoke(List<Person> persons, String fileName, String fileName2) {
        String fileInfoPath = "src/persistentdata/sampledata/" + fileName;
        String fileHobbiesPath = "src/persistentdata/sampledata/" + fileName2;
        try {
            FileWriter fileWriter = new FileWriter(fileInfoPath);
            FileWriter fileHobbiesWriter = new FileWriter(fileHobbiesPath);
            boolean writeHobbies = false;
            for (int i = 0; i < persons.size(); ++i) {
                Person person = persons.get(i);
                String writePersonText = person.getId() + "," + person.getFirstName() + "," + person.getLastName() + "," + person.getAge();
                if (i > 0) {
                    writePersonText = "\n" + writePersonText;
                }
                fileWriter.write(writePersonText);
                for (int j = 0; j < person.getHobbies().size(); ++j) {
                    String writeHobbyText = person.getId() + "," + person.getHobbies().get(j);
                    if (writeHobbies) {
                        writeHobbyText = "\n" + writeHobbyText;
                    }
                    fileHobbiesWriter.write(writeHobbyText);
                    writeHobbies = true;
                }
            }
            fileWriter.close();
            fileHobbiesWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writePersonToJson(List<Person> persons, String fileName) {
        String filePath = "src/persistentdata/sampledata/" + fileName;
        JSONArray jsonArrayPersons = new JSONArray();
        for (Person person : persons) {
            JSONObject jsonObjectPerson = new JSONObject();
            jsonArrayPersons.add(jsonObjectPerson);
            jsonObjectPerson.put("id", person.getId());
            jsonObjectPerson.put("firstName", person.getFirstName());
            jsonObjectPerson.put("lastName", person.getLastName());
            jsonObjectPerson.put("age", person.getAge());
            jsonObjectPerson.put("hobby", person.getHobbies());
        }
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(jsonArrayPersons.toJSONString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Element createAndAppendElementWithTextContent(Document doc, Element parentElement, String tagName, String textContent) {
        Element childElement = doc.createElement(tagName);
        childElement.setTextContent(textContent);
        parentElement.appendChild(childElement);
        return childElement;
    }

    public static void writePersonToXml(List<Person> persons, String fileName) {
        String filePath = "src/persistentdata/sampledata/" + fileName;

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("people");
            doc.appendChild(rootElement);

            for (Person person : persons) {
                Element personElement = doc.createElement("person");
                rootElement.appendChild(personElement);
                personElement.setAttribute("id", Integer.toString(person.getId()));
                createAndAppendElementWithTextContent(doc, personElement, "firstName", person.getFirstName());
                createAndAppendElementWithTextContent(doc, personElement, "lastName", person.getLastName());
                createAndAppendElementWithTextContent(doc, personElement, "age", Integer.toString(person.getAge()));
                Element hobbyListElement = doc.createElement("hobbyList");
                personElement.appendChild(hobbyListElement);
                if (person.getHobbies() != null) {
                    for (String hobby : person.getHobbies()) {
                        createAndAppendElementWithTextContent(doc, hobbyListElement, "hobby", hobby);
                    }
                }
            }
            try (FileOutputStream output =
                         new FileOutputStream(filePath)) {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(output);

                transformer.transform(source, result);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TransformerException e) {
                throw new RuntimeException(e);
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }

    }

}