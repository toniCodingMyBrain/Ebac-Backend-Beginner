public class App {

    public static Byte getBoxingValue(byte c) {
        Byte boxedNumByte = c;
        return boxedNumByte;
    }

    public static Boolean wasBoxed(Byte c) {
        return c instanceof Byte;
    }

    public static void main(String[] args) throws Exception {
        // tipos primitivos
        byte numByte = 127;
        System.out.println("Fazendo Boxing para classe Wrapper do valor: " + numByte);
        getBoxingValue(numByte);
        String response = wasBoxed(numByte) == true ? "É instância do Wrapper Byte."
                : "Não é instância do Wrapper Byte";
        System.out.println("Verificando se a instância do Wrapper Byte: " + response);
        System.out.println("End program...");
    }
}
