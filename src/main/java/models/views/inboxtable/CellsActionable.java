package models.views.inboxtable;

/**
 * This is an interface to make sure to set the button function on cell component {@link ActionButton}.
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * */

public interface CellsActionable {
    int onView(int row);
}
