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

public class Register {

    long m_value;

    //Returns a signed value of the binary contents between
    //the msb and lsb.
    public long getValue(int msb, int lsb) {
        
        // the upper mask is used to zero out all bits
        // above the msb while retaining the value of
        // all bits at positions less than or equal to the msb
        long upper_mask;
        if (msb != 63) {
            upper_mask = (1 << (msb + 1)) - 1;
        } else {
            upper_mask = -1;
        }
        
        // apply the upper mask and shift by the lsb
        long ret = (m_value & upper_mask) >> lsb;

        //find the value of the sign bit if the requested width is not
        //64 bits.
        if ((msb - lsb) != 63) {

            long sign_bit = ret >> (msb - lsb);
            
            //if the sign bit is one, subtract 2^(num_bits);
            if (sign_bit == 1) {
                int num_bits = msb - lsb + 1;
                ret -= (1 << num_bits);
            }
        }

        return ret;
    }

    //Returns the full 64-bit value
    public long getValue() {
        return m_value;
    }

    //sets a bit range to a specific value
    public void setValue(long value, int msb, int lsb) {
        
        long high_mask = ~((1 << (msb-lsb+1))-1);
        high_mask = (high_mask | value) << lsb;
        long low_mask = 0;
        if(lsb > 0){
            low_mask = (1 << lsb)-1;
        }
        
        long mask = high_mask|low_mask;
        
        m_value |= mask;
    }

    //sets the entire bit range to a value
    public void setValue(long value) {
        m_value = value;
    }

    //test stub
    public static void main(String[] args) {
        Register test = new Register();
        test.setValue(0x0ff00);
        System.out.println(test.getValue(15, 8));
        test.setValue(-1);
        test.setValue(0, 7, 4);
        System.out.println(test.getValue());
    }
}
