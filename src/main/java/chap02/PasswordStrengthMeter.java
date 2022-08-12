package chap02;

public class PasswordStrengthMeter {

    public Stage meter(String password) {
        if(password==null||password.isEmpty()){
            return Stage.INVALID;
        }
        int count = getStage(password);
       if(count==3) return Stage.HARD;
       if(count==2) return Stage.NORMAL;
       return Stage.EASY;
    }

    private int getStage(String password) {
        int metCounts = 0;
        if(password.length()>=8){
             metCounts++;
        }
        if(password.matches(".*\\d.*")){
            metCounts++;
        }
        if(password.matches(".*[A-Z].*")){
            metCounts++;
        }
        return metCounts;
    }
}
