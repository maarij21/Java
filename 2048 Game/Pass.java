public class Pass {

    private int passID;
    private int protectionRating;
    private int workHours;
    private int movesMade;

    public Pass( int ID, int pRating ){
        passID = ID;
        protectionRating = pRating;
        workHours = 0;
        movesMade = 0;
    }

    public int getPassID(){
        return passID;
    }

    public int getProtectionRating(){
        return protectionRating;
    }

    public int hoursLeft(){
        return workHours;
    }

    public void deductHours(){
        /**\
         *  create method to deduct hours one
         */
        workHours -= 1;
    }

}
