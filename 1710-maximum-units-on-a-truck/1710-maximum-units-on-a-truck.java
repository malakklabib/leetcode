class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a1,a2)->Integer.compare(a2[1], a1[1]));
        int numberOfBoxes = 0;
        int total = 0;
        for(int i = 0; i < boxTypes.length; i++){
            if(numberOfBoxes + boxTypes[i][0] < truckSize){
                numberOfBoxes+= boxTypes[i][0];
                total+= boxTypes[i][0] * boxTypes[i][1];
            }
            else if(truckSize - numberOfBoxes > 0){
                int takenBoxes = truckSize - numberOfBoxes;
                numberOfBoxes+= takenBoxes;
                total+= takenBoxes * boxTypes[i][1];
            }
            else
                break;
        }
        return total;
    }
}