public class App {
    public static void main(String[] args) {

        int a = 30;
        int b = 11;
        int c = 14;

        int terkecilCaraPertama = nilaiTerkecilCaraPertama(a,b,c);
        int terkecilCaraKedua = nilaiTerkecilCaraKedua(a,b,c);
        
        System.out.println("nilai terkecil menggunakan cara pertama : " + terkecilCaraPertama);
        System.out.println("nilai terkecil menggunakan cara kedua   : " + terkecilCaraKedua);
    }

   public static int nilaiTerkecilCaraPertama(int a, int b, int c) {
        int terkecilTemp = a;
        if (b < terkecilTemp) terkecilTemp = b;
        if (c < terkecilTemp) return c;
        return terkecilTemp;
   }


   public static int nilaiTerkecilCaraKedua(int a, int b, int c) {
        int terkecilTemp = Math.min(a,b);
        terkecilTemp = Math.min(terkecilTemp, c);
        return terkecilTemp;
   }
}
