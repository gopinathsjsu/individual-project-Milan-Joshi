package response;

import java.util.HashMap;

public class CategoryLimit {
    public static CategoryLimit categoryLimit = null;
    public static HashMap<String,Integer> categoryLimitMap = new HashMap<String,Integer>();

    private CategoryLimit() {
        categoryLimitMap.put("Essentials",3);
        categoryLimitMap.put("Luxury",4);
        categoryLimitMap.put("Misc",6);

    }

    public static CategoryLimit getInstance() {
        if (categoryLimit != null)
            return categoryLimit;
        else {
            categoryLimit = new CategoryLimit();
            return categoryLimit;
        }
    }
}
