class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        Car[] cars = new Car[n];
        
        for(int i=0; i<n; i++){
            cars[i] = new Car(position[i], ((target-position[i])*1.0)/speed[i]);
        }
        
        Arrays.sort(cars, (car1, car2)->car1.position - car2.position);
        
        int ans = 0;
        for(int i=n-1;i>=1; i--){
            
            if(cars[i].timeToTarget >= cars[i-1].timeToTarget){
                cars[i-1].timeToTarget = cars[i].timeToTarget;
            }
            else
                ans++;
        }
        return ans+1;
        
    }
}
class Car{
    int position;
    double timeToTarget;
    Car(int position, double timeToTarget){
        this.position = position;
        this.timeToTarget = timeToTarget;
    }
}

/*
We need double as the timeToTarget so that we calculate car fleets appropriately.
Consider eg below:
10
[6,8]
[3,2]
*/
