class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix.length == 0 )
            return 0;
        
       char[][] copy = new char[matrix.length][matrix[0].length];
        
        for(int i=0; i<matrix[0].length; i++)
            copy[0][i] = matrix[0][i];
        
        for(int i=0; i<matrix.length; i++)
            copy[i][0] = matrix[i][0];
        
        // for(int i=0; i <copy.length; i++)
        //     for(int j=0; j<copy[0].length; j++)
        //         System.out.println("copy["+i+"][" +j+ "] = " +copy[i][j]);
        
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    //System.out.println("i" +i+ "j" +j);
                    // System.out.println("m" +matrix[i][j]);
                    // System.out.println("copy["+i+"][" +j+ "] = " +copy[i][j]);
                    // System.out.println("1st" +copy[i-1][j]);
                    // System.out.println("2nd" +copy[i][j-1]);
                    // System.out.println("3rd" +(copy[i-1][j-1]));
                    int a = (copy[i][j-1]) - '0';
                    int b = (copy[i-1][j]) - '0';
                    int c = (copy[i-1][j-1]) - '0';
                    //System.out.println("left: " +a+ " top: " +b+ " diag: " +c);
                    
                    int min = Math.min(a, Math.min(b, c));
                    //System.out.println("Math Min:" +min);
                    min = min + 1;    
                    //System.out.println("Char Min:" +min);
                    copy[i][j] = (char)(min + '0');
                    //System.out.println("copy["+i+"][" +j+ "] = " +copy[i][j]);
                    
                    }       
                    else{
                        //System.out.println("i" +i+ "j" +j);
                        // System.out.println("copy["+i+"][" +j+ "] = " +copy[i][j]);
                        copy[i][j] = '0';
                        //System.out.println("copy["+i+"][" +j+ "] = " +copy[i][j]);
                    }
                                                    
            }
        }
                                           
        
        // for(int i=0; i<copy.length;i++)
        //     for(int j=0;j<copy[0].length;j++){
        //         System.out.println("c["+i+"]["+j+"] " +copy[i][j]);
        //     }
            
        int max_of_s = copy[0][0] - '0'; 
        int max_i = 0; 
        int max_j = 0; 
        for(int i = 0; i < matrix.length; i++) 
        { 
            for(int j = 0; j < matrix[0].length; j++) 
            { 
                if(max_of_s < (copy[i][j] - '0') )
                { 
                    max_of_s = copy[i][j] - '0'; 
                    max_i = i;  
                    max_j = j; 
                }      
            }                  
        }
        
        // System.out.println("max of s: " +copy[max_i][max_j]+ " max_i: "+ max_i +" max_j: " +max_j+ " maxofs: " +max_of_s);
        return (copy[max_i][max_j]- '0') * (copy[max_i][max_j] - '0');
            
//         int cnt = 0;
//         //System.out.println("Maximum size sub-matrix is: "); 
//         for(int i = max_i; i > max_i - max_of_s; i--) 
//         { 
// //             if(max_j == copy.length){
// //                 for(int j = max_j; j >= max_j - max_of_s; j--) 
// //             {
                
// //                 cnt++;
// //                 System.out.print(matrix[i][j] + " "); 
// //             }  
// //             System.out.println();
// //             }
// //             else{
//                 for(int j = max_j; j > max_j - max_of_s; j--) 
//             {
                
//                 cnt++;
//                 //System.out.print(matrix[i][j] + " "); 
//             }  
//             //System.out.println();
            
             
//         }
//         //System.out.println(cnt);
//         return cnt;
        
    }
}