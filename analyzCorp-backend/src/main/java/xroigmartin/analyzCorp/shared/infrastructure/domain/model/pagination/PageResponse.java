package xroigmartin.analyzCorp.shared.infrastructure.domain.model.pagination;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@Builder
public class PageResponse<T> implements Serializable {

  private final long totalItems;
  private final long totalPages;
  private final int currentPage;
  private final int currentSize;
  private final boolean firstPage;
  private final boolean lastPage;
  private final T data;

  public PageResponse(){
    this(0L,0L,0,0,true, true,null);
  };

  public PageResponse(long totalItems, long totalPages, int currentPage, int currentSize,T data) {
        this(totalItems, totalPages, currentPage, currentSize, currentPage == 0, currentPage == totalPages, data);
  }

  public boolean isFirstPage() {
    return this.currentPage == 0;
  }

  public boolean isLastPage() {
    return this.totalPages == this.currentPage;
  }

}
