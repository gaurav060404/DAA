public class naive {
    public static boolean algo(String text,String pattern){
        for (int i = 0; i <= text.length()-pattern.length(); i++) {
            int j;
            for ( j = 0; j < pattern.length(); j++) {
                if (text.charAt(i+j)!=pattern.charAt(j)) {
                    break;
                }
            }
            if(j==pattern.length()){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String text = "abcdabcabcdf";
        String pattern = "abc";
        System.out.println(algo(text,pattern));
    }
}
