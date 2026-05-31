class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long ast=mass;
        for(int asteroid:asteroids){
            if(asteroid>ast){
                return false;
            }
            ast+=asteroid;
        }
        return true;
    }
}