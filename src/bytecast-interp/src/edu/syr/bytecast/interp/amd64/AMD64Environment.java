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

import edu.syr.bytecast.amd64.api.constants.OperandType;
import edu.syr.bytecast.amd64.api.constants.OperandTypeMemoryEffectiveAddress;
import edu.syr.bytecast.amd64.api.constants.RegisterType;
import edu.syr.bytecast.amd64.api.instruction.IOperand;
import edu.syr.bytecast.amd64.impl.instruction.operand.OperandMemoryEffectiveAddress;
import java.util.Stack;


public class AMD64Environment {
    
    public AMD64Environment(){
        m_memory    = new Memory();
        m_regbank   = new RegisterBank();
        m_stack     = new Stack<Long>();
    }
    
    public long getValue(RegisterType register) {
        long ret;
        ret = m_regbank.getValue(register);    
        return ret;
    }

        
    public long getValue(OperandTypeMemoryEffectiveAddress addr) {
        RegisterType baseReg  = addr.getBase();
        RegisterType indexReg = addr.getIndex();
        long scale = addr.getScale();
        long offset = addr.getOffset();
        long base = 0;
        long index = 0;
        if(baseReg != null) {
            base = getValue(baseReg);
        }
        if(indexReg != null) {
            index = getValue(indexReg);
        }
        
        return base+index*scale+offset;
    }
    
    public long getValue(IOperand op) {
        long ret = 0;
        switch(op.getOperandType())
        {
            case REGISTER:
                RegisterType register = (RegisterType)op.getOperandValue();
                ret = getValue(register);   
                break;
            
            case CONSTANT:
                ret = (Long)op.getOperandValue();
                break;
                
            case NUMBER: 
                ret = (Long)op.getOperandValue();
                break;
            
            case MEMORY_EFFECITVE_ADDRESS:
                ret = getValue((OperandTypeMemoryEffectiveAddress)op.getOperandValue());
                break; 
                
            default: break;
        }

        return ret;
    }

    
    public void setValue(IOperand op, long value) {
        switch(op.getOperandType())
        {
            case REGISTER:
                RegisterType register = (RegisterType)op.getOperandValue();
                setValue(register, value);
                break;
                       
            default: break;
        }
    }
    
    public void setValue(RegisterType reg, long value)
    {
        m_regbank.setValue(reg, value);        
    }
    
    public int getOperandWidth(IOperand op){
        int width = 64;
        switch(op.getOperandType())
        {
            case REGISTER:
                RegisterType register = (RegisterType)op.getOperandValue();
                width = m_regbank.getWidth(register);
                break;
                       
            default: break;
        }
        
        return width;
    }
    
    public Memory        m_memory;
    public RegisterBank  m_regbank;
    public Stack<Long>   m_stack;
}