/*
 * This file is part of Bytecast.
 *
 * Bytecast is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bytecast is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Bytecast.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package edu.syr.bytecast.interp.amd64;

import java.util.Map;
import java.util.TreeMap;


public class RegisterBank {
    
    private Map<String, Register> m_naturalRegs;
    private Map<String, RegisterOverlay> m_regOverlays;
    
    public RegisterBank()
    {    
        m_regOverlays = new TreeMap<String,RegisterOverlay>();
        m_regOverlays.put("RAX",    new RegisterOverlay("RAX", 63, 0));
        m_regOverlays.put("EAX",    new RegisterOverlay("RAX", 31, 0));
        m_regOverlays.put("AX",     new RegisterOverlay("RAX", 15, 0));
        m_regOverlays.put("AH",     new RegisterOverlay("RAX", 15, 8));
        m_regOverlays.put("AL",     new RegisterOverlay("RAX",  7, 0));
        m_regOverlays.put("RBX",    new RegisterOverlay("RBX", 63, 0));
        m_regOverlays.put("EBX",    new RegisterOverlay("RBX", 31, 0));
        m_regOverlays.put("BX",     new RegisterOverlay("RBX", 15, 0));
        m_regOverlays.put("BH",     new RegisterOverlay("RBX", 15, 8));
        m_regOverlays.put("BL",     new RegisterOverlay("RBX",  7, 0));
        m_regOverlays.put("RCX",    new RegisterOverlay("RCX", 63, 0));
        m_regOverlays.put("ECX",    new RegisterOverlay("RCX", 31, 0));
        m_regOverlays.put("CX",     new RegisterOverlay("RCX", 15, 0));
        m_regOverlays.put("CH",     new RegisterOverlay("RCX", 15, 8));
        m_regOverlays.put("CL",     new RegisterOverlay("RCX",  7, 0));
        m_regOverlays.put("RDX",    new RegisterOverlay("RDX", 63, 0));
        m_regOverlays.put("EDX",    new RegisterOverlay("RDX", 31, 0));
        m_regOverlays.put("DX",     new RegisterOverlay("RDX", 15, 0));
        m_regOverlays.put("DH",     new RegisterOverlay("RDX", 15, 8));
        m_regOverlays.put("DL",     new RegisterOverlay("RDX",  7, 0));
        
        m_naturalRegs = new TreeMap<String, Register>();
        m_naturalRegs.put("RAX", new Register());
        m_naturalRegs.put("RBX", new Register());
        m_naturalRegs.put("RCX", new Register());
        m_naturalRegs.put("RDX", new Register());
    }

    //Sets a register in the register bank
    public void setValue(String name, long value){
        RegisterOverlay overlay = m_regOverlays.get(name); 
        m_naturalRegs.get(overlay.ParentRegisterName).setValue(value, overlay.MSB, overlay.LSB);
    }
    
    public void getValue(String name){
        RegisterOverlay overlay = m_regOverlays.get(name);
        m_naturalRegs.get(overlay.ParentRegisterName).getValue(overlay.MSB, overlay.LSB);
    }
    
}
