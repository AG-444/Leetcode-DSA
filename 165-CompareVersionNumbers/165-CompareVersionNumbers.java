// Last updated: 9/23/2025, 11:51:00 AM
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        List<Integer> verList1 = new ArrayList<>();
        List<Integer> verList2 = new ArrayList<>();
        int maxIdx = Math.max(ver1.length , ver2.length);
        for(int i=0;i<maxIdx;i++){
            try{
                verList1.add(Integer.parseInt(ver1[i]));
            }
            catch(ArrayIndexOutOfBoundsException  e){
                verList1.add(0);
            }
            try{
                verList2.add(Integer.parseInt(ver2[i]));
            }
            catch(ArrayIndexOutOfBoundsException  e){
                verList2.add(0);
            }
        }
        // System.out.println(verList1);
        // System.out.println(verList2);
        for(int i=0;i<maxIdx;i++){
            if(verList1.get(i) > verList2.get(i)){
                return 1;
            }
            if(verList1.get(i) < verList2.get(i)){
                return -1;
            }
        }
        return 0;
    }
}