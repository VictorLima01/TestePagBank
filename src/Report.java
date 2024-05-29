import java.time.LocalDate;
import java.util.List;

public class Report {

    private String mostSalesDate;

    private String biggestSalesDates;
    
    private String mostSalesClients;

    public Report(LocalDate mostSalesDate, List<LocalDate> biggestSalesDates, List<Integer> mostSalesClients) {
    }

    public String getMostSalesDate() {
        return mostSalesDate;
    }

    public void setMostSalesDate(String mostSalesDate) {
        this.mostSalesDate = mostSalesDate;
    }

    public String getBiggestSalesDates() {
        return biggestSalesDates;
    }

    public void setBiggestSalesDates(String biggestSalesDates) {
        this.biggestSalesDates = biggestSalesDates;
    }

    public String getMostSalesClients() {
        return mostSalesClients;
    }

    public void setMostSalesClients(String mostSalesClients) {
        this.mostSalesClients = mostSalesClients;
    }
}
