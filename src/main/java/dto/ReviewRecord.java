package dto;

public class ReviewRecord extends EntityRecord {

    private long clientId;

    private long productId;

    private String content;

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Review{" +
                super.toString() +
                "clientId=" + clientId +
                ", productId=" + productId +
                ", content='" + content + '\'' +
                '}';
    }
}
