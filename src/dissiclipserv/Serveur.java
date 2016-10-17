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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian BAYLE
 */
public class Serveur 
{
    private ServerSocket    _ssSocket;
    private int             _iPort;
    private ClientParser    _cpClientSave;
    
    /**
     * 
     * @param port Port d'écoute du serveur
     */
    public Serveur (int port)
    {
        _iPort = port;
        
        //Recuperation des clients sauvegardés en XML
        try {            
            _cpClientSave = new ClientParser();
        } catch (IOException ex) {
            Logger.getLogger("Load client file failed");
        }
        
        //Creation du socket d'écoute
        try {
            _ssSocket = new ServerSocket(_iPort);
        } catch(IOException ex) {
            Logger.getLogger("Error in serversocket creating");
        }
    }
    
    /**
     * Boucle principale du serveur
     */
    public void Listen()
    {
        while(true){
        Socket socket = null;
        try {
            socket = _ssSocket.accept();
            
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            
            byte[] c = new byte[100];
            is.read(c);
            
            System.out.println(new String(c));
            
        } catch (IOException ex) {
            Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    
}
