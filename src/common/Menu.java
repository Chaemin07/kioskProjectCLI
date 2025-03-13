package common;

import java.util.List;

public class Menu {

    private MenuCategory category;
    private List<MenuItem> menuItem;

    public Menu(MenuCategory category, List<MenuItem> menuItem) {
        this.category = category;
        this.menuItem = menuItem;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public List<MenuItem> getMenuItem() {
        return menuItem;
    }
}
