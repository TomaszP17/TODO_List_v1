public class Record {
    private int idRecord;
    private String content;
    private boolean isDone;


    public Record(int idRecord, String content, boolean isDone) {
        this.idRecord = idRecord;
        this.content = content;
        this.isDone = isDone;
    }

    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
