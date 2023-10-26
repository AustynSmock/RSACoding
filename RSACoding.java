public class RSACoding{
    public static void main(String args[])
    {

        int p = 9967;
        int q = 9973;
        int privateKey = 179;

        int n = p*q;
        int phi = (p-1)*(q-1);
        assert (gcd(privateKey,phi) == 1);
        int g = public_key_finder(privateKey, phi); 

        String message = "HELLO! HOW ARE YOU? LISTEN, PAY ATTENTION.";

        System.out.println("Sample output (p = " + p + ", q = " + q + ", private key = " + privateKey + ", public key = " + g + "):");
        System.out.println();

        System.out.print("\tGiven text:\n" + "\t" + message + "\n");
        System.out.println();
        System.out.print("\tDigital message grouping two characters together:\n"); 
        String digitized = ""; 

        for (int count = 0; count < message.length(); count++)
        {
            if (count%2==0 && count != 0)
                digitized += " ";
            digitized += find(Character.toString(message.charAt(count))); 
        }
        System.out.println("\t" + digitized);
        System.out.println();

        String encrypted_code = "";
        String split[] = digitized.split(" ");
        for (String part : split)
        {
            encrypted_code += Integer.toString(modular_power(Integer.parseInt(part), g, n));
            encrypted_code += " ";
        }
        System.out.print("\tEncryption for the grouped digits:\n");
        System.out.println("\t" + encrypted_code);
        System.out.println();

        String decrypted_code = "";
        String d_code_parts[] = encrypted_code.split(" ");
        for (String part : d_code_parts)
        {
            decrypted_code += Integer.toString(modular_power(Integer.parseInt(part), privateKey, n));
            decrypted_code += " ";
        }
        System.out.print("\tDecryption for the above number groups:\n");
        System.out.println("\t" + decrypted_code);
        System.out.println();

        String decrypted_message = "";
        String d_message_parts[] = decrypted_code.split(" ");
        for (String part : d_message_parts)
        {
            int mid = part.length() / 2;
            String[] halves = {part.substring(0, mid),part.substring(mid)};
            decrypted_message += find(halves[0]);
            decrypted_message += find(halves[1]);
        }
        System.out.print("\tDecrypted message:\n");
        System.out.println("\t" + decrypted_message);
    }

    static int public_key_finder(int a, int m)
    {
        int m0 = m;
        int i = 0, j = 1;
        if (m == 1)
            return 0;
        while (a > 1) 
        {
            int q = a / m;
            int t = m;
            m = a % m;
            a = t;
            t = i;
            i = j - q * i;
            j = t;
        }

        if (j < 0)
            j += m0;
        return j;
    }

    public static int modular_power(int n, int m, int k)
    {
        if (n == 0) return 0;
        if (m == 0) return 1;
        long y;
        if (m % 2 == 0)
        {
            y = modular_power(n, m / 2, k);
            y = (y * y) % k;
        }

        else
        {
            y = n % k;
            y = (y * modular_power(n, m - 1, k) % k) % k;
        } return (int)((y + k) % k);
    }

    static int gcd(int n, int m)
    {
        if (m == 0)
            return n;
        else
            return gcd(m, n%m);
    }

    private static String find(String a)
    {
        switch (a){
            case "A":
                return "10";
            case "B":
                return "11";
            case "C":
                return "12";
            case "D":
                return "13";
            case "E":
                return "14";
            case "F":
                return "15";
            case "G":
                return "16";
            case "H":
                return "17";
            case "I":
                return "18";
            case "J":
                return "19";
            case "K":
                return "20";
            case "L":
                return "21";
            case "M":
                return "22";
            case "N":
                return "23";
            case "O":
                return "24";
            case "P":
                return "25";
            case "Q":
                return "26";
            case "R":
                return "27";
            case "S":
                return "28";
            case "T":
                return "29";
            case "U":
                return "30";
            case "V":
                return "31";
            case "W":
                return "32";
            case "X":
                return "33";
            case "Y":
                return "34";
            case "Z":
                return "35";
            case " ":
                return "36";
            case ",":
                return "37";
            case ".":
                return "38";
            case "?":
                return "39";
            case "!":
                return "40";
            case "10":
                return "A";
            case "11":
                return "B";
            case "12":
                return "C";
            case "13":
                return "D";
            case "14":
                return "E";
            case "15":
                return "F";
            case "16":
                return "G";
            case "17":
                return "H";
            case "18":
                return "I";
            case "19":
                return "J";
            case "20":
                return "K";
            case "21":
                return "L";
            case "22":
                return "M";
            case "23":
                return "N";
            case "24":
                return "O";
            case "25":
                return "P";
            case "26":
                return "Q";
            case "27":
                return "R";
            case "28":
                return "S";
            case "29":
                return "T";
            case "30":
                return "U";
            case "31":
                return "V";
            case "32":
                return "W";
            case "33":
                return "X";
            case "34":
                return "Y";
            case "35":
                return "Z";
            case "36":
                return " ";
            case "37":
                return ",";
            case "38":
                return ".";
            case "39":
                return "?";
            case "40":
                return "!";
            default:
                return "-1";
        }
    }
}