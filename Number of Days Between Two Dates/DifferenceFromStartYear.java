// Refer - https://www.geeksforgeeks.org/find-number-of-days-between-two-given-dates/

class Solution {
    public int daysBetweenDates(String date1, String date2) {
		return Math.abs(getDaysFrom19710101(date1) - getDaysFrom19710101(date2));
	}
	
	int getDaysFrom19710101(String date) {
		String[] str = date.split("-");
		int year = Integer.valueOf(str[0]);
		int month = Integer.valueOf(str[1]);
		int day = Integer.valueOf(str[2]);
        
        int count = year * 365 + day;     //Either consider it starting from 0000/00/00/ or as given in the constraints 1971/00/00 -> so it could be year - 1971 and so on calculate 
		
		int monthDays[] = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        for(int i=0; i<month-1; i++){
            count += monthDays[i];
        }
        
        count += countLeapYears(year, month);

		return count;
	}
    
    public int countLeapYears(int year, int month){
        
        if(month <= 2)
            year--;
        
        return year/4 - year/100 + year/400;
        
    }
}
