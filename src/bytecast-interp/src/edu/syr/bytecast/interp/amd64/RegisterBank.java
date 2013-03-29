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
        m_regOverlays.put("RAX",    new RegisterOverlay("RAX",     63, 0));
        m_regOverlays.put("EAX",    new RegisterOverlay("RAX",     31, 0));
        m_regOverlays.put("AX",     new RegisterOverlay("RAX",     15, 0));
        m_regOverlays.put("AH",     new RegisterOverlay("RAX",     15, 8));
        m_regOverlays.put("AL",     new RegisterOverlay("RAX",      7, 0));
        m_regOverlays.put("RBX",    new RegisterOverlay("RBX",     63, 0));
        m_regOverlays.put("EBX",    new RegisterOverlay("RBX",     31, 0));
        m_regOverlays.put("BX",     new RegisterOverlay("RBX",     15, 0));
        m_regOverlays.put("BH",     new RegisterOverlay("RBX",     15, 8));
        m_regOverlays.put("BL",     new RegisterOverlay("RBX",      7, 0));
        m_regOverlays.put("RCX",    new RegisterOverlay("RCX",     63, 0));
        m_regOverlays.put("ECX",    new RegisterOverlay("RCX",     31, 0));
        m_regOverlays.put("CX",     new RegisterOverlay("RCX",     15, 0));
        m_regOverlays.put("CH",     new RegisterOverlay("RCX",     15, 8));
        m_regOverlays.put("CL",     new RegisterOverlay("RCX",      7, 0));
        m_regOverlays.put("RDX",    new RegisterOverlay("RDX",     63, 0));
        m_regOverlays.put("EDX",    new RegisterOverlay("RDX",     31, 0));
        m_regOverlays.put("DX",     new RegisterOverlay("RDX",     15, 0));
        m_regOverlays.put("DH",     new RegisterOverlay("RDX",     15, 8));
        m_regOverlays.put("DL",     new RegisterOverlay("RDX",      7, 0));
        m_regOverlays.put("RSP",    new RegisterOverlay("RSP",     63, 0));
        m_regOverlays.put("ESP",    new RegisterOverlay("RSP",     31, 0));
        m_regOverlays.put("SP",     new RegisterOverlay("RSP",     15, 0));
        m_regOverlays.put("RBP",    new RegisterOverlay("RBP",     63, 0));
        m_regOverlays.put("EBP",    new RegisterOverlay("RBP",     31, 0));
        m_regOverlays.put("BP",     new RegisterOverlay("RBP",     15, 0));
        m_regOverlays.put("RSI",    new RegisterOverlay("RSI",     63, 0));
        m_regOverlays.put("ESI",    new RegisterOverlay("RSI",     31, 0));
        m_regOverlays.put("SI" ,    new RegisterOverlay("RSI",     15, 0));
        m_regOverlays.put("RDI",    new RegisterOverlay("RDI",     63, 0));
        m_regOverlays.put("EDI",    new RegisterOverlay("RDI",     31, 0));
        m_regOverlays.put("DI",     new RegisterOverlay("RDI",     15, 0));
        m_regOverlays.put("R8",     new RegisterOverlay("R8",      63, 0));
        m_regOverlays.put("R9",     new RegisterOverlay("R9",      63, 0));
        m_regOverlays.put("R10",    new RegisterOverlay("R10",     63, 0));
        m_regOverlays.put("R11",    new RegisterOverlay("R11",     63, 0));
        m_regOverlays.put("R12",    new RegisterOverlay("R12",     63, 0));
        m_regOverlays.put("R13",    new RegisterOverlay("R13",     63, 0));
        m_regOverlays.put("R14",    new RegisterOverlay("R14",     63, 0));
        m_regOverlays.put("R15",    new RegisterOverlay("R15",     63, 0));
        m_regOverlays.put("R16",    new RegisterOverlay("R16",     63, 0));
        m_regOverlays.put("SS",     new RegisterOverlay("SS",      15, 0));
        m_regOverlays.put("CS",     new RegisterOverlay("CS",      15, 0));
        m_regOverlays.put("DS",     new RegisterOverlay("DS",      15, 0));
        m_regOverlays.put("ES",     new RegisterOverlay("ES",      15, 0));
        m_regOverlays.put("FS",     new RegisterOverlay("FS",      15, 0));
        m_regOverlays.put("GS",     new RegisterOverlay("GS",      15, 0));
        m_regOverlays.put("EFLAGS", new RegisterOverlay("EFLAGS",  31, 0));
        m_regOverlays.put("CF",     new RegisterOverlay("EFLAGS",   0, 0));
        m_regOverlays.put("PF",     new RegisterOverlay("EFLAGS",   2, 2));
        m_regOverlays.put("AF",     new RegisterOverlay("EFLAGS",   4, 4));
        m_regOverlays.put("ZF",     new RegisterOverlay("EFLAGS",   6, 6));
        m_regOverlays.put("SF",     new RegisterOverlay("EFLAGS",   7, 7));
        m_regOverlays.put("TF",     new RegisterOverlay("EFLAGS",   8, 8));
        m_regOverlays.put("IF",     new RegisterOverlay("EFLAGS",   9, 9));
        m_regOverlays.put("DF",     new RegisterOverlay("EFLAGS",  10,10));
        m_regOverlays.put("OF",     new RegisterOverlay("EFLAGS",  11,11));
        m_regOverlays.put("IOPL",   new RegisterOverlay("EFLAGS",  13,12));
        m_regOverlays.put("NT",     new RegisterOverlay("EFLAGS",  14,14));
        m_regOverlays.put("RF",     new RegisterOverlay("EFLAGS",  16,16));
        m_regOverlays.put("VM",     new RegisterOverlay("EFLAGS",  17,17));
        m_regOverlays.put("AC",     new RegisterOverlay("EFLAGS",  18,18));
        m_regOverlays.put("VIF",    new RegisterOverlay("EFLAGS",  19,19));
        m_regOverlays.put("VIP",    new RegisterOverlay("EFLAGS",  20,20));
        m_regOverlays.put("ID",     new RegisterOverlay("EFLAGS",  21,21));
        
        m_naturalRegs = new TreeMap<String, Register>();
        m_naturalRegs.put("RAX",     new Register());
        m_naturalRegs.put("RBX",     new Register());
        m_naturalRegs.put("RCX",     new Register());
        m_naturalRegs.put("RDX",     new Register());
        m_naturalRegs.put("RSP",     new Register());
        m_naturalRegs.put("RBP",     new Register());
        m_naturalRegs.put("RSI",     new Register());
        m_naturalRegs.put("RDI",     new Register());
        m_naturalRegs.put("RIP",     new Register());
        m_naturalRegs.put("R8",      new Register());
        m_naturalRegs.put("R9",      new Register());
        m_naturalRegs.put("R10",     new Register());
        m_naturalRegs.put("R11",     new Register());
        m_naturalRegs.put("R12",     new Register());
        m_naturalRegs.put("R13",     new Register());
        m_naturalRegs.put("R14",     new Register());
        m_naturalRegs.put("R15",     new Register());
        m_naturalRegs.put("R16",     new Register());
        m_naturalRegs.put("SS",      new Register());
        m_naturalRegs.put("CS",      new Register());
        m_naturalRegs.put("DS",      new Register());
        m_naturalRegs.put("ES",      new Register());
        m_naturalRegs.put("FS",      new Register());
        m_naturalRegs.put("GS",      new Register());
        m_naturalRegs.put("EFLAGS",  new Register());
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
