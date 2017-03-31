package kata;

import java.util.List;

/**
 * PaginationHelper - kata/515bb423de843ea99400000a/
 */
class PaginationHelper<I> {
    private List<I> collection;
    private int itemsPerPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        if (itemsPerPage == 0) return 0;
        return (int) Math.ceil(1.0 * itemCount() / itemsPerPage);
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex < 0 || pageIndex > pageCount() - 1) return -1;
        if (pageIndex < pageCount() - 1) {
            return itemsPerPage;
        } else {
            return itemCount() - pageIndex * itemsPerPage;
        }
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemsPerPage == 0 || itemIndex < 0 || itemIndex > itemCount() - 1) return -1;

        return itemIndex / itemsPerPage;
    }
}