package sample;

import java.util.Date;

public class Translation  {
    private int id;
    private int id_transfer;
    private Date date_transfer;
    private String transfer_type;
    private int sum_transfer;
    private int id_recipient;

    public Translation(int id, int id_transfer, Date date_transfer, String transfer_type, int sum_transfer, int id_recipient) {
        this.id = id;
        this.id_transfer = id_transfer;
        this.date_transfer = date_transfer;
        this.transfer_type = transfer_type;
        this.sum_transfer = sum_transfer;
        this.id_recipient = id_recipient;
    }

    public Translation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_transfer() {
        return id_transfer;
    }

    public void setId_transfer(int id_transfer) {
        this.id_transfer = id_transfer;
    }

    public Date getDate_transfer() {
        return date_transfer;
    }

    public void setDate_transfer(Date date_transfer) {
        this.date_transfer = date_transfer;
    }

    public String getTransfer_type() {
        return transfer_type;
    }

    public void setTransfer_type(String transfer_type) {
        this.transfer_type = transfer_type;
    }

    public int getSum_transfer() {
        return sum_transfer;
    }

    public void setSum_transfer(int sum_transfer) {
        this.sum_transfer = sum_transfer;
    }

    public int getId_recipient() {
        return id_recipient;
    }

    public void setId_recipient(int id_recipient) {
        this.id_recipient = id_recipient;
    }

}
