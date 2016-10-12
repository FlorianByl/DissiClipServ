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

/**
 * Fournit des methode static permettant d'effectuer
 * des verifications pouvant êtres redondante.
 * @author Florian BAYLE
 */
public class Utils
{
    /**
     * Verifie si un port est correct. Elle prend en compte
     * les port reservés, ainsi que le nombre de port possible
     * soit 65536. Un port est valide s'il se trouve entre les valeurs
     * 1024 <= port <= 65535
     * @param port numéro de port à vérifier
     * @return True si le port est correcte
     */
    static boolean CheckPort(int port)
    {
        return !((port < 1024) || (port > 65335));
    }
}
