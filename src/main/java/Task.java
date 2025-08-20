public class Task {
    protected String descript;
    protected Boolean progressStatus;

    public Task(String d, Boolean p) {
        descript = d;
        progressStatus = p;
    }
    
    public Task(String d) {
        descript = d;
        progressStatus = false;
    }

    public String getProgressStatus() {
        if (progressStatus.equals(false)) {
            return " ";
        }
        return "X";
    }

    public void mark() {
        this.progressStatus = true;
    }

    public void unMark() {
        this.progressStatus = false;
    }

    public String toString() {
        return "[" + this.getProgressStatus() + "] " + this.descript;
    }


}