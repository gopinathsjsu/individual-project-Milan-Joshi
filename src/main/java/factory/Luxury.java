package factory;

public class Luxury implements Category {
    private static int categoryCount = 0;

    @Override
    public int getCategoryCount() {
        return  categoryCount;
    }

    @Override
    public void setCategoryCount(double quantity) {
        categoryCount += quantity;
    }
}
