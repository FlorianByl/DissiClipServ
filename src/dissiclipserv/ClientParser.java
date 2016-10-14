/*
 * Copyright (C) 2016 Florian BAYLE
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package dissiclipserv;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.DataConversionException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * S'occupe du parsing du XML client
 * @author Florian BAYLE
 */
public class ClientParser 
{
    private static String   _sFileName = "Clients.xml";
    
    private Document        _xmlDocument;
    private Element         _xmlRacine;
    
    private ArrayList       _alClients = new ArrayList();
    
    /**
     * Parse le fichier xml et recupere toutes les informations
     * relative aux clients
     * @throws IOException 
     */
    public ClientParser() throws IOException
    {
        SAXBuilder sxb = new SAXBuilder();
        
        try {
            _xmlDocument = sxb.build(new File(_sFileName));
        } catch (JDOMException ex) {
            Logger.getLogger("Fichier non conforme");
        }
        
        _xmlRacine = _xmlDocument.getRootElement();
        
        //Parse la liste des clients
        List clients = _xmlRacine.getChildren("client");
        
        Iterator i = clients.iterator();
        
        while(i.hasNext())
        {            
            Element client = (Element)i.next();
            ClientInformations tmp_info = new ClientInformations();
            
            try {
                
                tmp_info._iId = client.getAttribute("id").getIntValue();
                tmp_info._sPseudo = client.getChild("pseudo").getText();
                
                tmp_info._bIsConnected = false;
                
                Element friends = client.getChild("friends");
                
                List ids = friends.getChildren("id");
                
                Iterator j = ids.iterator();
                
                while(j.hasNext())
                {
                    Element id = (Element)j.next();
                    tmp_info._aAmis.add(parseInt(id.getText()));
                }
            
            } catch (DataConversionException ex) {}
            
            _alClients.add(tmp_info);
            
        }
    }
    
    /**
     * Génére un fichier xml destine a la gestion des clients
     */
    public static void CreateFileClient()
    {
        File file;
        file = new File(_sFileName);
        
        if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException ex) {}
        }
        
        Element racine = new Element("clients");
        Document document = new Document(racine);
        
        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        try {
            sortie.output(document, new FileOutputStream(_sFileName));
        } catch (IOException ex) {}
    }
}
