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

/**
 * Represente un client qui est connecté avec le serveur.
 * @author Florian BAYLE
 */
public class Client extends Thread
{
    private Socket _sckSocket;
    
    /**
     * Constructeur
     * @param socket Socket du client
     */
    public Client(Socket socket)
    {
        _sckSocket = socket;
    }
}
