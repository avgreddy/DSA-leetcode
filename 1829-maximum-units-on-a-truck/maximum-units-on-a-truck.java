class Solution {
    public int maximumUnits(int[][] b, int truckSize) {
        List<Box> box = new ArrayList<>();
        int n = b.length;
        for(int i = 0;i<n;i++){
            box.add(new Box(b[i][0],b[i][1]));
        }
        Collections.sort(box,(b1,b2) ->{
            return b2.up - b1.up;
        });
        int totalunits = 0;
        int i = 0;
        while(truckSize > 0 && i<n){
            Box bt = box.get(i);
            if(bt.nb <= truckSize){
                totalunits += bt.nb*bt.up;
                truckSize -= bt.nb;
            }
            else{
                totalunits += truckSize*bt.up;
                truckSize = 0;
            }
            i++;
        }
        return totalunits;
    }
}
class Box{
    int nb,up;
    public Box(int n,int u){
        nb = n;
        up = u;
    }
}