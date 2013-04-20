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
package edu.syr.bytecast.interp.amd64.instructions;

import edu.syr.bytecast.amd64.api.constants.InstructionType;
import edu.syr.bytecast.amd64.api.instruction.IInstruction;
import edu.syr.bytecast.amd64.api.instruction.IOperand;
import edu.syr.bytecast.interp.amd64.AMD64Environment;
import edu.syr.bytecast.interp.amd64.IISAInstruction;
import java.util.List;

/**
 * 
 * @author sheng
 */
public class ISAInstructionMOVSBL implements IISAInstruction {

    @Override
    public InstructionType getInstructionType() {
        return InstructionType.MOVSBL;
    }

    @Override
    public long execute(AMD64Environment env, IInstruction instruction) {
        List<IOperand> operands = instruction.getOperands();
        if (operands == null || operands.size() != 2) {
            return 0;
        }

        // Move the value from the second operand to the first one.
        IOperand second = operands.get(1);
        IOperand first = operands.get(0);
        
        //get one byte from the second operand
        long value = env.getValue(second, env.getOperandWidth(second)) & 0x0ff;
        
        //get the value of the 8th_bit
        
        int sign_bit = (int)value >> 7;
        
        if(sign_bit == 1){
            value = value | 0xffffffffffffff00l;
        }
        
        env.setValue(first, value, env.getOperandWidth(first));
        return 0;
    }
}
