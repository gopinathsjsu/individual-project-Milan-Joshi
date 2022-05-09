package factory;

public class Misc implements Category{
    private static int categoryCount = 0;

    @Override
    public int getCategoryCount() {
        categoryCount += 1;
        return categoryCount;
    }

    @Override
    public void setCategoryCount(double quantity) {
        categoryCount += quantity;
    }
}
