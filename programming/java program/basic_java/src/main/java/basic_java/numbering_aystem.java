package basic_java;

public class numbering_aystem {
    public static void main(String[] args) {


        // bainary,octal,hexadecimal to decimal

        String bainary = "100010110";
        Integer decimal = Integer.parseInt(bainary, 2);
        System.out.println(decimal);

        String octal = "012345671234";
        Integer decimals = Integer.parseInt(octal, 8);
        System.out.println(decimals);

        String hexadecimal ="A907";
        Integer decimalh = Integer.parseInt(hexadecimal, 16);
        System.out.println(decimalh);
    
        // decimal to bainary,hexadecimal,octal

        int decimalt = 23425;
        String binaryt = Integer.toBinaryString(decimalt);
        System.out.println(binaryt); 

        String octalt = Integer.toOctalString(decimalt);
        System.out.println(octalt);

        String hexadecimalt = Integer.toHexString(decimalt);
        System.out.println(hexadecimalt); 
    
    
    }

}
