package kr.co.inhatcspring.beans;
import java.time.LocalDateTime;

public class BoardDataBean {

    private Long boardId;
    private LocalDateTime createdDate;
    private String content;
    private String category; 
    private String userId;

    // 기본 생성자
    public BoardDataBean() {
    }

    // 매개변수가 있는 생성자
    public BoardDataBean(Long boardId, LocalDateTime createdDate, String content, String category, String userId) {
        this.boardId = boardId;
        this.createdDate = createdDate;
        this.content = content;
        this.category = category;
        this.userId = userId;
    }

    // Getter 및 Setter 메소드
    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BoardDataBean{" +
                "boardId=" + boardId +
                ", createdDate=" + createdDate +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
