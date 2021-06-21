/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory_game;

import java.util.logging.Level;
import java.util.logging.Logger;

public class pause {
    

    public  void mainn() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(pause.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}