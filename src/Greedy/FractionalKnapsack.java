package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {

    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    class Pair {
        double weightRatio;
        int itemIndex;

        Pair(double weightRatio, int itemIndex) {
            this.weightRatio = weightRatio;
            this.itemIndex = itemIndex;
        }
    }

    //DESC
    class WeightRatioComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            if(p2.weightRatio > p1.weightRatio)
                return 1;
            else if(p2.weightRatio < p1.weightRatio)
                return -1;
            return 0;
        }
    }


    double fractionalKnapsack(int W, Item[] arr, int n) {
        List<Pair> weightRatioList = new ArrayList<>();

        //O(n)
        for(int i=0;i<arr.length;i++) {
            double weightRatio = (arr[i].value*1.0/arr[i].weight);
            weightRatioList.add(new Pair(weightRatio, i));
        }

        //O(NlogN)
        weightRatioList.sort(new WeightRatioComparator());

        int i=0;
        double totalValue=0.0;
        //O(n)
        while(W>0 && i<n) {
            Pair pair = weightRatioList.get(i);
            int itemIndex = pair.itemIndex;
            int weight = arr[itemIndex].weight;
            int value = arr[itemIndex].value;

            //complete item
            if(weight <= W) {
                totalValue+= value;
            } else {
                totalValue+= (W*1.0) * pair.weightRatio;
            }

            W = W  - weight;
            i++;
        }
        return totalValue;
    }
}
