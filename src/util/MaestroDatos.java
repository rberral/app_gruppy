package util;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

 

public class MaestroDatos {

	
	public static Map<Integer, String> getRolesUsuario(){
		Map<Integer, String> listado = null;
		Document documento = null;
		documento = loadDocument(Constantes.URLMaestroRolXML);
		if(documento == null){
			return null;
		}
		listado = new HashMap<Integer, String>();
		//System.out.println("Root element :" + documento.getDocumentElement().getNodeName());
		NodeList nList = documento.getElementsByTagName("rol");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;

				//System.out.println("Valor : " + eElement.getElementsByTagName("valor").item(0).getTextContent());
				//System.out.println("Nombre : " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
				int valor = Integer.parseInt(eElement.getElementsByTagName("valor").item(0).getTextContent());
				String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
				listado.put(valor, nombre);
			}
		}	
		return listado;
	}
	
	
	private static Document loadDocument(String nombreFicheroXML){
		Document doc = null;
		try
		{
			File fXmlFile = new File(nombreFicheroXML);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);

			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
		}
		catch (Exception spe)
		{
	        System.out.println( spe.getMessage() );
		}
		return doc;
	}
}
