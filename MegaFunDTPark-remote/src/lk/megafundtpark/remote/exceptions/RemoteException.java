/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.remote.exceptions;

import javax.servlet.ServletException;

/**
 *
 * @author Janakshi
 */
public class RemoteException extends ServletException {

    public RemoteException(String server) {
        super("Exception in initializing the " + server);
    }
}
