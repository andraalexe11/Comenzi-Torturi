import java.io.Serializable;

public class tort extends entity implements Serializable {
    private String tip;
    tort(){}
    tort(int id, String tip){
        setId(id);
        this.tip = tip;
    }
    public String getTip(){
        return this.tip;
    }
    public void setTip(String tip){
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "tort{" +
                "tip='" + tip + '\'' +
                '}';
    }
}
