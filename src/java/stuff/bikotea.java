/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stuff;

/**
 *
 * @author Bingen
 */
public class bikotea {
    
    private String pasahitza;
    private boolean admin;

    public String getPasahitza() {
        return pasahitza;
    }

    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public bikotea(String pasahitza, boolean admin) {
        this.pasahitza = pasahitza;
        this.admin = admin;
    }
    
}
