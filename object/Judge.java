package mainentry.object;

/**
 * @author Seeker
 * @date 2018/1/30
 */
public class Judge extends User {
    private String speciality;
    private int attempts;
    private int solved;

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getSolved() {
        return solved;
    }

    public void setSolved(int solved) {
        this.solved = solved;
    }
}
