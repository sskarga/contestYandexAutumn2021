package loc.sergey.yandextaskD.entity;

public class Market {
    private Long shopId;
    private String shopName;

    public Market(Long shopId, String shopName) {
        this.shopId = shopId;
        this.shopName = shopName;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String toString() {
        return "Market{" +
                "shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                '}';
    }
}
