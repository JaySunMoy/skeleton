package com.vaadin.test.views;

import com.vaadin.event.ShortcutAction;
import com.vaadin.navigator.View;
import com.vaadin.test.beans.JobItem;
import com.vaadin.test.components.DashboardCard;
import com.vaadin.test.components.SearchBar;
import com.vaadin.test.layouts.TemplateLayout;
import com.vaadin.test.utils.LabelUtils;
import com.vaadin.test.utils.LayoutUtils;
import com.vaadin.test.utils.TestDataUtils;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class that represents the Dashboard View.
 *
 * @author JMoy
 */
public class DashboardView extends TemplateLayout implements View {

    /**
     * Generated Serial Version UID.
     */
    private static final long serialVersionUID = -2181608046017915332L;

    /**
     * Constant value that represents the path to the template file used for this {@link CustomLayout}.
     */
    private static final String TEMPLATE_PATH = "dashboard";

    /**
     * Constant value that represents the data location for the header.
     */
    private static final String HEADER_LOCATION = "header";

    /**
     * Constant value that represents the data location for the menu.
     */
    private static final String CONTENT_LOCATION = "content";

    /**
     *
     */
    private final List<DashboardCard> cardList;

    /**
     * Constructor.
     */
    public DashboardView() {
        super(TEMPLATE_PATH);

        final Label header = LabelUtils.wordWrap("Welcome to your Dashboard");
        header.addStyleName(ValoTheme.LABEL_H1);

        final VerticalLayout content = LayoutUtils.verticalBlock();
        content.setMargin(false);

        final Layout cards = LayoutUtils.cssBlock("dashboard-cards");

        final List<JobItem> items = TestDataUtils.dashboardData();
        cardList = items.stream().map(DashboardCard::new).collect(Collectors.toList());
        cardList.forEach(cards::addComponent);

        final SearchBar searchBar = new SearchBar("Search by job name..");

        final Button searchButton = searchBar.getSearchButton();
        searchButton.addClickListener(e -> search(searchBar.getSearchField().getValue(), cards));
        searchButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        content.addComponents(searchBar, cards);

        addComponent(header, HEADER_LOCATION);
        addComponent(content, CONTENT_LOCATION);
    }

    /**
     *
     *
     * @param searchText
     * @param cards
     */
    private void search(final String searchText, final Layout cards) {
        final List<DashboardCard> filteredList =
                cardList.stream().filter(card -> card.getHeader().getValue().contains(searchText)).collect(Collectors.toList());
        cards.removeAllComponents();
        filteredList.forEach(cards::addComponent);
    }
}
