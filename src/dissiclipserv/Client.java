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

import java.net.Socket;
import java.util.ArrayList;

/**
 * Represente un client qui est connecté avec le serveur.
 * @author Florian BAYLE
 */
public class Client
{
    private Socket              _sckSocket;     //Le socket du client
    
    private String              _sPseudo;       //Le pseudo du client
    private int                 _iId;           //Identifiant du client
    private boolean             _bIsConnected;  //Si le client est connecté
    private ArrayList<Client>   _aAmis;         //Amis du client
    
    
    /**
     * Constructeur avec parametre socket
     * @param socket Socket du client
     */
    public Client(Socket socket)
    {
        _sckSocket = socket;
    }
    
    /**
     * Constructeur avec parametre pseudo
     * @param pseudo Pseudo du client
     */
    public Client(String pseudo)
    {
        _sPseudo = pseudo;
    }
    
    /**
     * Constructeur avec parametre socket et pseudo
     * @param socket
     * @param pseudo 
     */
    public Client(Socket socket, String pseudo)
    {
        _sckSocket = socket;
        _sPseudo = pseudo;
    }

    /**
     * Permet de recuperer toutes les informations relative au client
     * excepté le socket (voir, GetSocket())
     * @return Structure contenant les dernieres informations du client.
     */
    public ClientInformations Information()
    {
        return new ClientInformations(_sPseudo, _iId, _bIsConnected, _aAmis);
    }
}
