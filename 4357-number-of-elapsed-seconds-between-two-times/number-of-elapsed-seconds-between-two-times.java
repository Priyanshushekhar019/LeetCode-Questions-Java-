class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        String[] str1=startTime.split(":");
        String[] str2=endTime.split(":");
        int a=Integer.parseInt(str1[0])*3600+Integer.parseInt(str1[1])*60+Integer.parseInt(str1[2]);
        int b=Integer.parseInt(str2[0])*3600+Integer.parseInt(str2[1])*60+Integer.parseInt(str2[2]);
        return Math.abs(b-a);
    }
}