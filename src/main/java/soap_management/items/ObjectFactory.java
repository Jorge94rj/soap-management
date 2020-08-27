//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.06.17 a las 01:25:54 PM CDT 
//


package soap_management.items;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap_management.items package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap_management.items
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetItemDetailsRequest }
     * 
     */
    public GetItemDetailsRequest createGetItemDetailsRequest() {
        return new GetItemDetailsRequest();
    }

    /**
     * Create an instance of {@link GetAllItemsResponse }
     * 
     */
    public GetAllItemsResponse createGetAllItemsResponse() {
        return new GetAllItemsResponse();
    }

    /**
     * Create an instance of {@link ItemDetails }
     * 
     */
    public ItemDetails createItemDetails() {
        return new ItemDetails();
    }

    /**
     * Create an instance of {@link GetItemDetailsResponse }
     * 
     */
    public GetItemDetailsResponse createGetItemDetailsResponse() {
        return new GetItemDetailsResponse();
    }

    /**
     * Create an instance of {@link GetAllItemsRequest }
     * 
     */
    public GetAllItemsRequest createGetAllItemsRequest() {
        return new GetAllItemsRequest();
    }

}
