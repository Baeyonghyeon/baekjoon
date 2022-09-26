package coplet;

public class BarcodeGenerate {
    public static void main(String[] args) {
        String output = barcode(3);
        System.out.println(output); // "121"

        output = barcode(7);
        System.out.println(output); // "1213121"

        output = barcode(20);
        System.out.println(output); // "1213123132123 1213123"
    }

    public static String barcode(int len) {
        return aux("", len);
    }

    public static boolean isValid(String str) {
        StringBuffer sb = new StringBuffer(str);
        String reverse = sb.reverse().toString();
        int halfLen = (int)Math.floor((double) str.length() / 2);

        for(int i = 1; i <= halfLen; i++) {
            if(reverse.substring(0, i).equals(reverse.substring(i, i + i))) {
                return false;
            }
        }
        return true;
    }

    public static String aux(String str, int len) {
        String chr = "123";
        if(str.length() == len) return str;

        for(int i = 0; i < chr.length(); i++) {
            String currentStr = str + chr.charAt(i);
            if(isValid(currentStr)) {
                String founded = aux(currentStr, len);
                if(founded != null) return founded;
            }
        }
        
        return null;
    }
}
