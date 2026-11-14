//Input: Integer array piles, piles[i] is the number of bananas in the ith pile. 
// Also given an integer h, which represents the number of hours you have to eat all the bananas
// In h number of hours we need to eat all the bananas
// Additionally, Koko will only eat from one pile for a given hour. Even if the pile has less than k bananas, it will eat those less bananas in the current pile but wont switch to the next pile to cover up the remaining bananas. So, for each hour, only one pile is considered to be eaten by koko
// this means that, the totat number of hours h required to eat all the bananas will always be greater than or equal to the length of the array.
// bananas per hour eating rate of k
// each hour, you may choose a pile of bananas and eats k bananas from that pile. 
// if the pile has less than k bananas, you may finish eating the pile but you cannot eat from another pile in the same hour. (aka in each hour, you may only choose one pile to eat)
// Return the minimum integer k such that you can eat all the bananas within h hours. 
// Basically choose a minimum k (i.e. no. of bananas eaten per hour) such that all bananas are eaten from the piles within h hours.
// How to determine the upper bound for the answer? How much time does it take koko to eat a pile with x bananas? x/k? for example, if we have decided, that we're gonna eat 2 bananas per hour and we have 4 bananas in a max pile, so time taken to finish that pile would be 4/2 = 2. 
// therefore, it takes ceil(x/k) time to finish the x pile when koko eats at a rate of k bananas per hour. 
// We must determine the minimum possible value of k (i.e. number of bananas eaten per hour) such that koko can finish eating all the piles within the given h hours. 
// So upper bound will be The maximum pile or the maximum element in our array would be the upper bound of k (i.e. no of bananas per hour eating rate). Because if koko can select a pile with the max number of bananas and eat them in an hour, it can also eat each of the remaining piles in which bananas are less than the maximum pile in an hour. 
// Considering m to be the largest pile, and n to be the number of piles. A brute force solution would be to linearly check all values from 1 to m and find the minimum possible value at which koko can complete the task. this approach would take O(n * m) time. 
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //Brute force solution for this
        // linear search, where we are searching for k, i.e. number of bananas per hour eating rate. 
        // the max k, would be the maximum number bananans in a particular pile, this would ensure that all bananas are eaten within the h number of hours
        // So basically eating speed of the maximum element in the piles array, which represents the maximum number of bananas for a given pile.
        // but we need to find the min k
        // Try every possible eating speed for the given piles, at any point, the first speed that finishes within h hours would be our answer. 
        // start with speed = 1, i.e. 1 banana eaten per hour for a given pile, if the total number of hours for finishing all then bananas from all the piles with this rate is less than k, then this would be our answer
        // if not, then increase the speed and repeat. 
        // for each speed, we wanna make sure that we compute the total hours taking for completing bananas in each pile so that would be summing up ceil(pile/speed) for every pile
        //int speed = 1;
        // as long as we haven't found a satisfying speed, we will run a loop and keep increasing our speed
        //while(true){
        //    long totalTime = 0;
        //    for(int pile: piles){
                // we wanna compute the time taken to eat all bananas for this current selected pile and then keep adding up the time for each pile into our total time. 
        //        totalTime += (int)Math.ceil((double) pile / speed);
                // why are we taking the ceiling of our time taken to complete a pile?
                // because consider this example, if we have 5 bananas in a particular pile, and our speed is 2 bananas eaten per hour, then as per the question of only choosing one pile for each hour to eat bananas it would take us 3 hours to complete this pile of 5 banans, i.e. 2 + 2 + 1, this is the order of how koko would eat bananas in 3 hours for this pile. mathematically, it would be 5/2 = 2.5 ~ 3 hours. 
        //    }
            // Once we have computed the total time taken to complete all the piles, we will check if total time is less than the h number of hours limit provided by the question, if it does then we return the current speed, if it doesnt the we increase our speed. 

        //    if(totalTime <= h){
        //        return speed;
        //    }
        //    speed++;
        //}
        // Time complexity of the brute force approach is O(n * m), where n is length of the input array piles, and m is the maximum number of bananas in a pile. By incrementing speed as long as answer is not found, we will eventually reach till m times that is the maximum number of bananas in a pile, across different piles.
        // In the above brute force approach, we are taking into account all the speeds starting from 1 to eat bananas from each pile. Even if the total time taken for slow speeds exceeds h. basically from 1 till m, we are considering all speeds by incrementing by 1 in each iteration. But we know that searching for the right speed is happening in a sorted search space, because speed is getting incrementing by 1 in each iteration till m, so all these individual speeds would be sorted.
        // so why not do binary search from 1 till m, to search for the correct speed, instead of linearly searching the correct speed by incrementing our speed by 1 in every iteration and visiting all speeds. 
        //We could do a binary search, where upper bound of our speed would be m the maximum number of bananas in a pile across different piles in our array, m guarantees that koko would be able to complete eating all bananas from each pile within h number of hours. 
        // What would be the lower bound? it would be 1
        // start reference would point to 1, end reference would point to m i.e. the max element of our array
        // and then we search for the correct speed while doing binary search
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt(); // Java Stream API expression, to get the max integer from the piles array
        // initially we know that at worst, the max element of our array would be our right answer
        int result = end;
        while(start<=end){
            int mid = start + (end - start)/2;
            // So now, what to compute and compare with h? 
            long totalTime = 0;
            for(int p: piles){
                totalTime += Math.ceil((double)p/mid);
            }
            if(totalTime <= h){
                result = mid; // this might be our min rate k (i.e. number of bananas eaten per hour to complete all bananas from the piles within h), but there might also be an even lesser rate k, on the left search space so continue looking for that on the left
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}
