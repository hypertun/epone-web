package com.epone.application.views.services;

import com.epone.application.theme.ThemeConfig;
import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Helper Nationality Comparison")
@Route(value = "compare-nationalities", layout = MainLayout.class)
public class NationalityComparison extends VerticalLayout {

    public NationalityComparison() {
        setSizeFull();
        setPadding(true);
        setSpacing(false);
        setAlignItems(FlexComponent.Alignment.CENTER);
        
        add(createHeader());
        add(createComparisonTable());
        add(createNationalityCards());
        add(createCtaSection());
    }
    
    private Component createHeader() {
        VerticalLayout header = new VerticalLayout();
        header.setPadding(false);
        header.setSpacing(false);
        header.setAlignItems(FlexComponent.Alignment.CENTER);
        header.setWidthFull();
        header.setMaxWidth("1200px");
        
        H1 title = new H1("Compare Helper Nationalities");
        title.getStyle()
            .set("color", ThemeConfig.PRIMARY_COLOR)
            .set("font-size", "2.5rem")
            .set("margin-bottom", "0.5rem");
        
        Paragraph description = new Paragraph(
            "Each nationality has unique strengths and cultural aspects. " +
            "Compare the different nationalities to find the best match for your family's needs."
        );
        description.getStyle()
            .set("color", ThemeConfig.TEXT_SECONDARY)
            .set("text-align", "center")
            .set("max-width", "800px")
            .set("margin-bottom", "2rem");
        
        header.add(title, description);
        return header;
    }
    
    private Component createComparisonTable() {
        Div tableContainer = new Div();
        tableContainer.setWidthFull();
        tableContainer.setMaxWidth("1200px");
        tableContainer.getStyle()
            .set("margin-bottom", "3rem");
        
        // Create a list of comparison items
        List<ComparisonItem> comparisonItems = createComparisonData();
        
        // Create grid
        Grid<ComparisonItem> grid = new Grid<>();
        grid.setItems(comparisonItems);
        grid.setAllRowsVisible(true);  // Auto-adjust height
        
        // Style the grid
        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES, GridVariant.LUMO_COLUMN_BORDERS);
        grid.getStyle()
            .set("border-radius", "8px")
            .set("overflow", "hidden")
            .set("box-shadow", "0 2px 8px rgba(0, 0, 0, 0.1)");
        
        // Add feature column
        grid.addColumn(ComparisonItem::getFeature)
            .setHeader("Features")
            .setWidth("200px")
            .setFlexGrow(0);
        
        // Add nationality columns with custom renderers for flag and content
        grid.addColumn(new ComponentRenderer<>(item -> {
            return createNationalityContentCell(item.getIndonesian());
        }))
        .setHeader(createNationalityHeaderComponent("Indonesian", "images/indo-flag.png"))
        .setFlexGrow(1);
        
        grid.addColumn(new ComponentRenderer<>(item -> {
            return createNationalityContentCell(item.getFilipino());
        }))
        .setHeader(createNationalityHeaderComponent("Filipino", "images/phil-flag.png"))
        .setFlexGrow(1);
        
        grid.addColumn(new ComponentRenderer<>(item -> {
            return createNationalityContentCell(item.getMyanmar());
        }))
        .setHeader(createNationalityHeaderComponent("Myanmar", "images/myam-flag.png"))
        .setFlexGrow(1);
        
        tableContainer.add(grid);
        return tableContainer;
    }
    
    private Component createNationalityHeaderComponent(String nationality, String flagImagePath) {
        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(false);
        layout.setSpacing(false);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        
        Image flag = new Image(flagImagePath, nationality);
        flag.setHeight("40px");
        flag.setWidth("60px");
        flag.getStyle().set("border-radius", "4px");
        
        H4 text = new H4(nationality);
        text.getStyle()
            .set("margin", "8px 0 0 0")
            .set("font-weight", "600")
            .set("color", ThemeConfig.PRIMARY_COLOR);
        
        layout.add(flag, text);
        return layout;
    }
    
    private Component createNationalityContentCell(String content) {
        Paragraph text = new Paragraph(content);
        text.getStyle()
            .set("margin", "0")
            .set("color", ThemeConfig.TEXT_SECONDARY)
            .set("line-height", "1.6");
        
        return text;
    }
    
    private List<ComparisonItem> createComparisonData() {
        List<ComparisonItem> items = new ArrayList<>();
        
        // Languages
        items.add(new ComparisonItem(
            "Languages",
            "Bahasa Indonesia (similar to Malay). Younger helpers often speak English.",
            "English is widely spoken as it's an official language in the Philippines.",
            "Burmese. Some may speak basic English or Chinese."
        ));
        
        // Experience
        items.add(new ComparisonItem(
            "Experience Level",
            "Many have experience in Malaysia, Hong Kong, and Taiwan.",
            "Often experienced with international employers in Hong Kong, Middle East, and Taiwan.",
            "Growing presence in Singapore. Some are ex-Singapore with good track records."
        ));
        
        // Cuisine
        items.add(new ComparisonItem(
            "Cooking Skills",
            "Familiar with local cuisine (nasi goreng, satay) which resonates with Singaporean palates.",
            "Known for diverse cooking abilities with Western and Asian influences.",
            "Cuisine influenced by neighboring countries like China, India, and Thailand."
        ));
        
        // Childcare
        items.add(new ComparisonItem(
            "Childcare",
            "Good with children and responsive to instructions.",
            "Known for being nurturing and compassionate with children.",
            "Patient and attentive with careful supervision skills."
        ));
        
        // Eldercare
        items.add(new ComparisonItem(
            "Eldercare",
            "Cultural respect for elders translates well to caregiving.",
            "Known for medical training and empathetic eldercare.",
            "Families often choose Myanmar helpers for elderly care due to patience and physical capabilities."
        ));
        
        // Adaptation
        items.add(new ComparisonItem(
            "Cultural Adaptation",
            "Similar cultural background to Singapore making integration easier.",
            "Adaptable and quick to learn new environments.",
            "Strong family values and respect for authority."
        ));
        
        // Salary Range
        items.add(new ComparisonItem(
            "Typical Salary Range",
            "S$550-S$650",
            "S$650-S$750",
            "S$480-S$550"
        ));
        
        return items;
    }
    
    // Data class for comparison items
    public static class ComparisonItem {
        private final String feature;
        private final String indonesian;
        private final String filipino;
        private final String myanmar;
        
        public ComparisonItem(String feature, String indonesian, String filipino, String myanmar) {
            this.feature = feature;
            this.indonesian = indonesian;
            this.filipino = filipino;
            this.myanmar = myanmar;
        }
        
        public String getFeature() { return feature; }
        public String getIndonesian() { return indonesian; }
        public String getFilipino() { return filipino; }
        public String getMyanmar() { return myanmar; }
    }
    
    private Component createNationalityCards() {
        H2 sectionTitle = new H2("Learn More About Each Nationality");
        sectionTitle.getStyle()
            .set("color", ThemeConfig.PRIMARY_COLOR)
            .set("text-align", "center")
            .set("margin-bottom", "2rem");
        
        // Cards container
        HorizontalLayout cardsLayout = new HorizontalLayout();
        cardsLayout.setWidthFull();
        cardsLayout.setMaxWidth("1200px");
        cardsLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        cardsLayout.getStyle().set("flex-wrap", "wrap");
        
        // Add nationality cards
        cardsLayout.add(
            createNationalityCard(
                "Indonesian Helpers",
                "Cultural similarities with Singapore make integration seamless. Many speak Bahasa which is similar to Malay.",
                "images/indo.png",
                "indo maids"
            ),
            createNationalityCard(
                "Filipino Helpers",
                "Known for English proficiency and nurturing personalities. Many have experience with international employers.",
                "images/Phil.jpg",
                "phil maids"
            ),
            createNationalityCard(
                "Myanmar Helpers",
                "Strong family values and attentive care. Particularly good with elderly care due to patience and physical capabilities.",
                "images/myam.jpg",
                "myam maids"
            )
        );
        
        VerticalLayout section = new VerticalLayout(sectionTitle, cardsLayout);
        section.setPadding(false);
        section.setSpacing(false);
        section.setWidthFull();
        section.setAlignItems(FlexComponent.Alignment.CENTER);
        
        return section;
    }
    
    private Component createNationalityCard(String nationality, String description, String imagePath, String route) {
        VerticalLayout card = new VerticalLayout();
        card.setPadding(false);
        card.setSpacing(false);
        card.setWidth("350px");
        card.setHeight("400px");
        card.getStyle().set("margin", "1rem");
        
        // Apply card styling
        ThemeConfig.applyCardStyle(card);
        card.getStyle().set("cursor", "pointer");
        
        // Image
        Image image = new Image(imagePath, nationality);
        image.setWidth("100%");
        image.setHeight("200px");
        image.getStyle()
            .set("object-fit", "cover")
            .set("border-top-left-radius", ThemeConfig.BORDER_RADIUS)
            .set("border-top-right-radius", ThemeConfig.BORDER_RADIUS);
        
        // Content
        VerticalLayout content = new VerticalLayout();
        content.setPadding(true);
        content.setSpacing(false);
        content.setHeightFull();
        
        H3 title = new H3(nationality);
        title.getStyle()
            .set("margin", "0 0 1rem 0")
            .set("color", ThemeConfig.PRIMARY_COLOR)
            .set("font-weight", "600");
        
        Paragraph desc = new Paragraph(description);
        desc.getStyle()
            .set("margin", "0 0 auto 0")
            .set("color", ThemeConfig.TEXT_SECONDARY)
            .set("line-height", "1.6");
        
        // Call to action
        HorizontalLayout cta = new HorizontalLayout();
        cta.setAlignItems(FlexComponent.Alignment.CENTER);
        cta.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        cta.setWidthFull();
        cta.setPadding(false);
        cta.setSpacing(false);
        cta.getStyle().set("margin-top", "1rem");
        
        Button learnMoreBtn = new Button("Learn More", new Icon(VaadinIcon.ARROW_RIGHT));
        learnMoreBtn.getStyle()
            .set("background-color", ThemeConfig.PRIMARY_COLOR)
            .set("color", "white")
            .set("border-radius", "4px")
            .set("padding", "8px 16px")
            .set("font-weight", "600");
        
        cta.add(learnMoreBtn);
        
        content.add(title, desc, cta);
        card.add(image, content);
        
        // Add navigation
        card.addClickListener(e -> UI.getCurrent().navigate(route));
        
        // Add hover effect
        card.getElement().executeJs(
            "this.addEventListener('mouseenter', function() {" +
                "this.style.transform = 'translateY(-5px)';" +
                "this.style.boxShadow = '0 8px 24px rgba(0, 0, 0, 0.15)';" +
            "});" +
            "this.addEventListener('mouseleave', function() {" +
                "this.style.transform = 'translateY(0)';" +
                "this.style.boxShadow = '0 2px 8px rgba(0, 0, 0, 0.12)';" +
            "});"
        );
        
        return card;
    }
    
    private Component createCtaSection() {
        VerticalLayout ctaLayout = new VerticalLayout();
        ctaLayout.setWidthFull();
        ctaLayout.setMaxWidth("800px");
        ctaLayout.setPadding(true);
        ctaLayout.setSpacing(true);
        ctaLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        ctaLayout.getStyle()
            .set("margin-top", "3rem")
            .set("padding", "2rem")
            .set("border-radius", ThemeConfig.BORDER_RADIUS)
            .set("background-color", "#f8f9fa")
            .set("text-align", "center");
        
        H2 ctaTitle = new H2("Need Help Deciding?");
        ctaTitle.getStyle()
            .set("color", ThemeConfig.PRIMARY_COLOR)
            .set("margin", "0 0 1rem 0");
        
        Paragraph ctaText = new Paragraph(
            "Our experienced consultants can help you find the perfect helper based on your specific needs. " +
            "Contact us today for a personalized recommendation."
        );
        ctaText.getStyle()
            .set("margin", "0 0 1.5rem 0")
            .set("color", ThemeConfig.TEXT_SECONDARY);
        
        // Buttons
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        
        Button contactBtn = new Button("Contact Us", new Icon(VaadinIcon.ENVELOPE));
        contactBtn.addClickListener(e -> UI.getCurrent().navigate("contact"));
        contactBtn.getStyle()
            .set("background-color", ThemeConfig.PRIMARY_COLOR)
            .set("color", "white")
            .set("padding", "10px 20px")
            .set("border-radius", "4px")
            .set("font-weight", "600");
        
        Button browseBtn = new Button("Browse Helpers", new Icon(VaadinIcon.SEARCH));
        browseBtn.addClickListener(e -> UI.getCurrent().getPage().setLocation("https://epone.netmaid.com.sg/searchmaid"));
        browseBtn.getStyle()
            .set("background-color", "#f0f0f0")
            .set("color", ThemeConfig.TEXT_PRIMARY)
            .set("padding", "10px 20px")
            .set("border-radius", "4px")
            .set("font-weight", "600");
        
        buttons.add(contactBtn, browseBtn);
        
        ctaLayout.add(ctaTitle, ctaText, buttons);
        return ctaLayout;
    }
}