enum Month {
    January,
    February,
    May;
}
enum Week {
    MONDAY("понедельник"),
    TUESDAY("вторник"),
    WEDNESDAY("среда"),
    THURSDAY("четверг"),
    FRIDAY("пятница"),
    SATURDAY("суббота"),
    SUNDAY("воскресенье");

    private String mood;

    private Week(String mood){
        this.mood = mood;
    }

    public String getMood(){
        return mood;
    }
}

public class CustomEnum {
    public static void main(String[] args) {
        System.out.println(Week.MONDAY.getMood());
        System.out.println(Month.January);
        System.out.println(Month.January.equals(Month.January));
    }
}
