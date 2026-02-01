package dto;
import java.util.List;
public class OrderDTO {
    private List<Item> items;
    public OrderDTO(List<Item> items) { this.items = items; }
    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = items; }
    public static class Item {
        private String itemType;
        private int itemId;
        public Item(String itemType, int itemId) {
            this.itemType = itemType;
            this.itemId = itemId;
        }
        public String getItemType() { return itemType; }
        public void setItemType(String itemType) { this.itemType = itemType; }

        public int getItemId() { return itemId; }
        public void setItemId(int itemId) { this.itemId = itemId; }
    }
}
