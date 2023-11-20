package dto;

public class TestOrderDto {

    private String status;
    private int courierId;

    private String customerName;

    private String customerPhone;

    private String comment;
    private int id;

    public TestOrderDto(String s) {
        this.status = "OPEN";
        this.courierId = 0;
        this.id = 0;
    }


    public void setId(int id) {
        this.id = id;
    }

    public TestOrderDto(String customerName, String customerPhone, String comment) {
        this.status = "OPEN";
        this.courierId = 0;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.comment = comment;
        this.id = 0;
    }


    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}









