/**
 * Practical 8
 *
 * @author Jigar Vakil
 */
package BANK;


public class Bankops implements java.io.Serializable{
    private static String ac_no;
    private static String ac_type;
    private static String ac_holder_name;
    private static float ac_bal;

    public float getAc_bal() {
        return ac_bal;
    }

    public void setAc_bal(float ac_bal) {
        this.ac_bal = ac_bal;
    }

    public String getAc_no() {
        return ac_no;
    }

    public void setAc_no(String ac_no) {
        this.ac_no = ac_no;
    }

    public String getAc_type() {
        return ac_type;
    }

    public void setAc_type(String ac_type) {
        this.ac_type = ac_type;
    }

    public String getAc_holder_name() {
        return ac_holder_name;
    }

    public void setAc_holder_name(String ac_holder_name) {
        this.ac_holder_name = ac_holder_name;
    }
    
    public String withdrawAmt(float amt)
    {
        float tot = this.ac_bal - amt;
        if(tot>=1000)
        {
            this.ac_bal = tot;
            return "Take your cash "+amt;
        }
        else
            return "Insufficient balance "+this.ac_bal;
    }
    public String deposit(float amt)
    {
        this.ac_bal+=amt;
        return amt + " Cash added to your account";
    }
}
