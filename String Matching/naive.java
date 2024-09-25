public class naive {
    public static boolean algo(String text,String pattern){
        String temp = "";
        int len = 0;
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i)!=pattern.charAt(j)) {
                    len = 0;
                    i = i-1;
                    break;
                }else{
                    len++;
                }
            }
            if(len==pattern.length()){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String text = "abcdabcabcdf";
        String pattern = "abcdrr";
        System.out.println(algo(text,pattern));
    }
}
