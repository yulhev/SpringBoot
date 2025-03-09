package lt.vilniustech.YHev.first.service;

import lt.vilniustech.YHev.first.model.Customer;
import org.springframework.stereotype.Service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;

/**
 * Service class responsible for transforming Java objects into XML representations.
 * Uses JAXB (Java Architecture for XML Binding) to serialize Customer data into XML format.
 */
@Service
public class XMLTransformServ {

    /**
     * Converts a given Customer object into an XML file and stores it in a predefined directory.
     *
     * @param customer The Customer object to be converted into XML.
     * @return The absolute path of the generated XML file, or null if an error occurs.
     */
    public String transformXML(Customer customer) {
        try {
            // ✅ Create JAXB context for the Customer class
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // ✅ Format XML output for readability
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // ✅ Define the output directory and create it if it doesn't exist
            File outputDir = new File("D:/Homeworks/Basics of Distributed Systems/first-spring/xmlFiles/");
            if (!outputDir.exists()) {
                outputDir.mkdirs(); // ✅ Create directory if not exists
            }

            // ✅ Define the XML file name based on the Customer ID
            File file = new File(outputDir, "customer_" + customer.getId() + ".xml");

            // ✅ Convert Java object to XML and save it to the file
            jaxbMarshaller.marshal(customer, file);

            // ✅ Print the file path to console for debugging
            System.out.println("XML file created at: " + file.getAbsolutePath());

            return file.getAbsolutePath(); // ✅ Return the XML file path
        } catch(JAXBException e) {
            System.out.println("Error during XML transformation: " + e.getMessage());
            return null;  // ✅ Return null in case of failure (could also throw an exception)
        }
    }
}
