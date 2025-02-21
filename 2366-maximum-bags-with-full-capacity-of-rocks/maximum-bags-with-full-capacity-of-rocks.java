class Solution {
    public int maximumBags(int[] cap, int[] rocks, int additionalRocks) {
        List<Bag> bags = new ArrayList<>();
        int n = cap.length;
        for(int i = 0;i<n;i++){
            bags.add(new Bag(cap[i],rocks[i],cap[i]-rocks[i]));
        }
        Collections.sort(bags,(b1,b2) ->{
            return b1.rem-b2.rem;
        });
        int i = 0;
        int totalbags = 0;
        while(additionalRocks > 0 && i<n){
            Bag b = bags.get(i);
            if(b.rem  == 0 || b.rem <= additionalRocks){
                totalbags++;
                additionalRocks -= b.rem;
            }
            else{
                break;
            }
            i++;
        }
        return totalbags;
    }
}
class Bag{
    int cap,rock,rem;
    public Bag(int c,int r,int re){
        cap = c;
        rock = r;
        rem = re;
    }
}