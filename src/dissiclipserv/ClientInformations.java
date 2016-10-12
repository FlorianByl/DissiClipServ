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

import java.util.ArrayList;

/**
 * Permet de rescenser toutes les informations d'un client
 * @author Florian BAYLE
 */
public class ClientInformations
{
    public String              _sPseudo;       //Le pseudo du client
    public int                 _iId;           //Identifiant du client
    public boolean             _bIsConnected;  //Si le client est connecté
    public ArrayList<Client>   _aAmis;         //Amis du client

    public ClientInformations(String _sPseudo, int _iId, boolean _bIsConnected, ArrayList<Client> _aAmis)
    {
        this._sPseudo = _sPseudo;
        this._iId = _iId;
        this._bIsConnected = _bIsConnected;
        this._aAmis = _aAmis;
    }
    
    
}
