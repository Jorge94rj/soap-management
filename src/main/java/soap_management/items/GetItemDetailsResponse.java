//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.06.17 a las 01:25:54 PM CDT 
//


package soap_management.items;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ItemDetails" type="{http://soap-management/items}ItemDetails"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "itemDetails"
})
@XmlRootElement(name = "GetItemDetailsResponse")
public class GetItemDetailsResponse {

    @XmlElement(name = "ItemDetails", required = true)
    protected ItemDetails itemDetails;

    /**
     * Obtiene el valor de la propiedad itemDetails.
     * 
     * @return
     *     possible object is
     *     {@link ItemDetails }
     *     
     */
    public ItemDetails getItemDetails() {
        return itemDetails;
    }

    /**
     * Define el valor de la propiedad itemDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemDetails }
     *     
     */
    public void setItemDetails(ItemDetails value) {
        this.itemDetails = value;
    }

}
