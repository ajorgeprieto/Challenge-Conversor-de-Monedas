import java.io.IOException;

public class ConversorDeMoneda {
    private TipoDeCambioAPI api = new TipoDeCambioAPI();

    public double convertir(String from, String to, double monto) throws IOException, InterruptedException {
        double tasaDeCambio = api.getRate(from, to);
        return monto * tasaDeCambio;
    }
}
