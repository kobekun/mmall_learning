import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Scanner;

/**
 * Created by dell on 2017/7/27.
 */
public class Joda_time {
    public static void main(String[] args) {

        new Joda_time().calDayNumber();
    }

    public void calDayNumber(){

        Scanner scanner = new Scanner(System.in);
        try{
            while(true){
                System.out.println("*********请输入生日(yyyy-MM-dd Or yyyy-MM-dd HH:mm:ss)*********");
                String line = scanner.nextLine();
                if("exit".equalsIgnoreCase(line)){
                    break;
                }
                DateTimeFormatter format = null;
                if(line.length()==10){
                    format = DateTimeFormat.forPattern("yyyy-MM-dd");
                }else{
                    format = DateTimeFormat .forPattern("yyyy-MM-dd HH:mm:ss");
                }
                DateTime startDateTime = null;;
                try {
                    startDateTime = DateTime.parse(line, format);
                } catch (Exception e) {
                    System.err.println("输入格式错误,请重新输入生日!");
                    continue;
                }
                calDays(startDateTime, new DateTime());
            }
        }finally{
            scanner.close();
        }

    }

    private void calDays(DateTime startDateTime,DateTime endDateTime){

        Days days = Days.daysBetween(startDateTime, endDateTime);
        System.out.println("今天是你人生的第"+days.getDays()+"天");

        Hours hours = Hours.hoursBetween(startDateTime, endDateTime);
        System.out.println("今天是你人生的第"+hours.getHours()+"小时");

        Minutes minutes = Minutes.minutesBetween(startDateTime, endDateTime);
        System.out.println("今天是你人生的第"+minutes.getMinutes()+"分钟");

        Seconds seconds = Seconds.secondsBetween(startDateTime, endDateTime);
        System.out.println("今天是你人生的第"+seconds.getSeconds()+"秒");
    }
}
