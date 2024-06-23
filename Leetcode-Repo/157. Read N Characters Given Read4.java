/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] buf4=new char[4];
        int cr=-1;
        int i=0;
        int j=0;
        while(cr!=0 && i<n){
            cr=read4(buf4);
            j=i;
            while((i<j+cr) && i<n){
                buf[i]=buf4[i-j];
                i++;
            }
        }
        return i;
    }
}