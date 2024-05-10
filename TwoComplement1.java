public class TwoComplement1 {
    public static void main(String[] args) {
        int x=10;
        String str=Integer.toBinaryString(x);
        int n=str.length();
        String twos=" ";
        
            for (int i = n - 1; i >= 0; i--) 
        {
            if (str.charAt(i) == '1') 
            { 
                twos = twos.substring(0, i) + '0' + twos.substring(i + 1); 
            }  
            else
            { 
                twos = twos.substring(0, i) + '1' + twos.substring(i + 1); 
                break; 
            } 
            System.out.println(twos);
        } 
        
        }
    }
    

