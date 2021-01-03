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
    private int tmpCnt;
    private int tmpPnt;
    private char[] tmp = new char[4];
    
    public int read(char[] buf, int n) {
        
        int charCopied = 0;
        
        while (charCopied < n) {
            if (tmpPnt == 0) {
                tmpCnt = read4(tmp);
            }

            while (charCopied < n && tmpPnt < tmpCnt) {
                buf[charCopied++] = tmp[tmpPnt++];
            }

            if (tmpCnt < 4) //Return the charCopied uptil now because the buffer count is less than 4
                break;
            if (tmpPnt == tmpCnt) //Reset tmpPnt because we finished reading 4 chars
                tmpPnt = 0;
        }

        return charCopied;
    }
}
