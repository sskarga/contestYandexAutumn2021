package loc.sergey.yandextaskD.entity;

public class Billing {
    private Long orderId;
    private Long shopId ;
    private Long cost;

    public Billing(Long orderId, Long shopId, Long cost) {
        this.orderId = orderId;
        this.shopId = shopId;
        this.cost = cost;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "orderId=" + orderId +
                ", shopId=" + shopId +
                ", cost=" + cost +
                '}';
    }
}
