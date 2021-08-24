package pojo;

public class Products {

    private String product;
    private String imageURL;
    private double dolarsPrice;
    private double  poundsPrice;
    private double euroPrice;

    public Products(String product, String imageURL, double dolarprice, double poundsprice,
                    double europrice) {
        this.product = product;
        this.imageURL = imageURL;
        this.dolarsPrice = dolarprice;
        this.poundsPrice = poundsprice;
        this.euroPrice = europrice;
    }


    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public double getDolarsPrice() {
        return dolarsPrice;
    }

    public void setDolarsPrice(double dolarprice) {
        this.dolarsPrice = dolarprice;
    }

    public double getPoundsPrice() {
        return poundsPrice;
    }

    public void setPoundsPrice(double poundsprice) {
        this.poundsPrice = poundsprice;
    }

    public double getEuroPrice() {
        return euroPrice;
    }

    public void setEuroPrice(double europrice) {
        this.euroPrice = europrice;
    }
}
