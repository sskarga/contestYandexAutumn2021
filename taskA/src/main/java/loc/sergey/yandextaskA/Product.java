package loc.sergey.yandextaskA;

import java.util.Objects;

public class Product {
    private long id;
    private long count;
    private long evenId;
    private boolean shipment;

    public Product(long id, long count, long evenId, boolean shipment) {
        this.id = id;
        this.count = count;
        this.evenId = evenId;
        this.shipment = shipment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getEvenId() {
        return evenId;
    }

    public void setEvenId(long evenId) {
        this.evenId = evenId;
    }

    public boolean isShipment() {
        return shipment;
    }

    public void setShipment(boolean shipment) {
        this.shipment = shipment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && count == product.count && evenId == product.evenId && shipment == product.shipment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, count, evenId, shipment);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", count=" + count +
                ", evenId=" + evenId +
                ", shipment=" + shipment +
                '}';
    }
}
