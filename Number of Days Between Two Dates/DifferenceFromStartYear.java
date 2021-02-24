class Solution {
    public int daysBetweenDates(String date1, String date2) {
		return Math.abs(getDaysFrom19710101(date1) - getDaysFrom19710101(date2));
	}
	
	int getDaysFrom19710101(String date) {
		String[] str = date.split("-");
		int year = Integer.valueOf(str[0]);
		int month = Integer.valueOf(str[1]);
		int day = Integer.valueOf(str[2]);
        
        int count = year * 365 + day;
		
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
