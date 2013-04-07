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
import edu.syr.bytecast.amd64.api.constants.InstructionType;
import edu.syr.bytecast.interp.amd64.instructions.*;
import java.util.Map;
import java.util.TreeMap;


public class ISA {
    private static final Map<InstructionType, IISAInstruction> m_instructions = new TreeMap();
    static {
        m_instructions.put(InstructionType.ADD, new ISAInstructionADD());
        m_instructions.put(InstructionType.CALLQ, new ISAInstructionCALLQ()); 
        m_instructions.put(InstructionType.CMP, new ISAInstructionCMP()); 
        m_instructions.put(InstructionType.CMPL, new ISAInstructionCMPL()); 
        m_instructions.put(InstructionType.JGE, new ISAInstructionJGE()); 
        m_instructions.put(InstructionType.JMP, new ISAInstructionJMP()); 
        m_instructions.put(InstructionType.JNE, new ISAInstructionJNE()); 
        m_instructions.put(InstructionType.LEA, new ISAInstructionLEA()); 
        m_instructions.put(InstructionType.LEAVEQ, new ISAInstructionLEAVEQ()); 
        m_instructions.put(InstructionType.MOV, new ISAInstructionMOV()); 
        m_instructions.put(InstructionType.MOVSBL, new ISAInstructionMOVSBL()); 
        m_instructions.put(InstructionType.MOVZBL, new ISAInstructionMOVZBL()); 
        m_instructions.put(InstructionType.NOP, new ISAInstructionNOP()); 
        m_instructions.put(InstructionType.POP, new ISAInstructionPOP()); 
        m_instructions.put(InstructionType.PUSH, new ISAInstructionPUSH()); 
        m_instructions.put(InstructionType.RETQ, new ISAInstructionRETQ()); 
        m_instructions.put(InstructionType.SAR, new ISAInstructionSAR()); 
        m_instructions.put(InstructionType.SHR, new ISAInstructionSHR()); 
        m_instructions.put(InstructionType.SUB, new ISAInstructionSUB());         
    }
}
