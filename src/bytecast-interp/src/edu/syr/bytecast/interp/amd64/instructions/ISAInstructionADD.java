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

import edu.syr.bytecast.interp.amd64.*;
import edu.syr.bytecast.amd64.api.constants.*;
import edu.syr.bytecast.amd64.api.instruction.IInstruction;
import edu.syr.bytecast.amd64.api.instruction.IOperand;
import edu.syr.bytecast.amd64.impl.instruction.AMD64Instruction;
import edu.syr.bytecast.amd64.impl.instruction.operand.*;

import java.util.ArrayList;
import java.util.List;

public class ISAInstructionADD implements IISAInstruction {
    
    @Override
    public InstructionType getInstructionType(InstructionType instruction) {
        return InstructionType.ADD;
    }

    @Override
    public void execute(AMD64Environment env, IInstruction instruction) {
       List<IOperand> operands = instruction.getOperands();
       if(operands.size() == 2)
       {
           IOperand op1 = operands.get(0);
           IOperand op2 = operands.get(1);
           
           long val1= env.getValue(op1);
           long val2= env.getValue(op2);
           
           long sum = val1 + val2;

           env.setValue(op1, sum);
           int result_width = env.getOperandWidth(op1);
           if(checkOverflow(val1,val2,result_width)){
               env.setValue(RegisterType.OF, 1);
               env.setValue(RegisterType.CF, 1);
           }
           else {
               env.setValue(RegisterType.OF, 0);
               env.setValue(RegisterType.CF, 0);              
           }
       }

    }
    
    private static boolean checkOverflow(long a, long b, int width)
    {
        boolean ret = false;
        
        //This will guarantee a <= b
        if(a > b){
            ret = checkOverflow(b,a,width);
        } else {
            long max_value = 1 << (width-1)-1;
            long min_value = -max_value - 1;
            
            //check max negative case
            if(a < 0 && b < 0 && (min_value - b) > a) {
                ret = true;
            } else if( a > (max_value - b)) { // check max positive case
                ret = true;
            }
        }
        return ret;
    }

}
