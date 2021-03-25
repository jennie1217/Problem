public class binaryReversal {

    public static String binaryReversal(String str) {
        StringBuilder inputBinaryStr = new StringBuilder(Integer.toBinaryString(Integer.parseInt(str)));
        int inputBinaryLength = inputBinaryStr.length();
        int byteLen = 8 - (inputBinaryLength % 8);

        if (inputBinaryLength % 8 != 0) {
            while (byteLen > 0) {
                inputBinaryStr.insert(0, "0");
                byteLen--;
            }
        }

        int res = Integer.parseInt(inputBinaryStr.reverse().toString(), 2);
        return Integer.toString(res);
    }

    public static void main(String[] args) {
        System.out.println(binaryReversal("47"));
    }
}
