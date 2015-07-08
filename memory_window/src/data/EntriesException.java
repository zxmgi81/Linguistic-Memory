package data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class EntriesException extends Exception {
    
    /**
     * default constructor
     */
    public EntriesException() {
        super("Could not find value for every card! \n"
                + "Returning partially filled HashMap");
    }
    public EntriesException(String message) {
        super(message);
    }
}
