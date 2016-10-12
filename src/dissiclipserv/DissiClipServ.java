/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dissiclipserv;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

/**
 *
 * @author tchoa
 */
public class DissiClipServ 
{
    public static void main(String[] args) 
    {
        ClientParser cp = null;
        
        try {
            cp = new ClientParser();
        } catch (IOException ex) {
            ClientParser.CreateFileClient();
            try {
                cp = new ClientParser();
            } catch (IOException ex1) {
                Logger.getLogger(DissiClipServ.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
}
