import java.time.LocalDate;

public class Client {

    private LocalDate saleDate;
    private Integer clientId;
    
    private Integer saleCount;
    
    private Integer saleValue;

    public Client(LocalDate saleDate, Integer clientId, Integer saleCount, Integer saleValue) {
        this.saleDate = saleDate;
        this.clientId = clientId;
        this.saleCount = saleCount;
        this.saleValue = saleValue;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(Integer saleValue) {
        this.saleValue = saleValue;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
}
