import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        File file = new File("C:/Users/Letícia Viana/TestePagBank/src/teste.txt");
        try {
            Report report = createReport(file);
            System.out.println(report);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Report createReport(File input) throws IOException, IOException {
      LocalDate mostSalesDate = null;
      List<LocalDate> biggestSalesDates = new ArrayList<>();
      List<Integer> mostSalesClients = new ArrayList<>();
      List<Client> clients = new ArrayList<>();

      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
      String line;

      while ((line = br.readLine()) != null) {
       String[] splitStr = line.split(",");

        LocalDate saleDate = LocalDate.parse(splitStr[0], DateTimeFormatter.BASIC_ISO_DATE);
        Integer clientId = Integer.parseInt(splitStr[1]);
        Integer saleCount = Integer.parseInt(splitStr[2]);
        Integer saleValue = Integer.parseInt(splitStr[3]);
        Client client = new Client(saleDate, clientId, saleCount, saleValue);
        clients.add(client);
        }

        Optional<Client> maiorQtdVendas1 = clients.stream().max(
                Comparator.comparingInt(Client::getSaleCount));

        Optional<Client> maiorValorVendas1 = clients.stream().max(
                Comparator.comparingInt(Client::getSaleValue));

        Optional<Client> maiorValorVendas2 = clients.stream().filter(sale -> !
                sale.equals(maiorValorVendas1.orElse(null))).max(
                Comparator.comparingInt(Client::getSaleValue));

        Optional<Client> maiorValorVendas3 = clients.stream().filter(sale -> !
                sale.equals(maiorValorVendas1.orElse(null))).filter(
                        sale -> !sale.equals(maiorValorVendas2.orElse(null)))
                .max(Comparator.comparingInt(Client::getSaleValue));

        mostSalesDate = maiorQtdVendas1.get().getSaleDate();

        biggestSalesDates.add(maiorValorVendas1.get().getSaleDate());
        biggestSalesDates.add(maiorValorVendas2.get().getSaleDate());
        biggestSalesDates.add(maiorValorVendas3.get().getSaleDate());

        System.out.println(mostSalesDate);
        System.out.println(biggestSalesDates.get(0) + ", " + biggestSalesDates.get(1) + ", " + biggestSalesDates.get(2));

        br.close();
        return new Report(mostSalesDate, biggestSalesDates, mostSalesClients);
    }



}