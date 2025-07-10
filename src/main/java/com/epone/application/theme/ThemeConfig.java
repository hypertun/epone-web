package com.epone.application.theme;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ThemeConfig {
    
    // Brand Colors
    public static final String PRIMARY_COLOR = "#2E7D32"; // Green
    public static final String SECONDARY_COLOR = "#4CAF50"; // Light Green
    public static final String ACCENT_COLOR = "#FF9800"; // Orange for CTAs
    public static final String LIGHT_BG = "#F5F7FA"; // Light background
    public static final String TEXT_PRIMARY = "#212121"; // Dark text
    public static final String TEXT_SECONDARY = "#757575"; // Medium gray text
    
    // Font Sizes
    public static final String FONT_SIZE_XL = "2.5rem";
    public static final String FONT_SIZE_LG = "1.75rem";
    public static final String FONT_SIZE_MD = "1.25rem";
    public static final String FONT_SIZE_SM = "0.875rem";
    
    // Spacing
    public static final String SPACE_XS = "0.25rem";
    public static final String SPACE_SM = "0.5rem";
    public static final String SPACE_MD = "1rem";
    public static final String SPACE_LG = "1.5rem";
    public static final String SPACE_XL = "2.5rem";
    
    // Border Radius
    public static final String BORDER_RADIUS = "8px";
    
    // Card Styles
    public static void applyCardStyle(Component component) {
        component.getElement().getStyle()
            .set("border-radius", BORDER_RADIUS)
            .set("box-shadow", "0 2px 8px rgba(0, 0, 0, 0.12)")
            .set("padding", SPACE_MD)
            .set("background-color", "white")
            .set("transition", "transform 0.2s, box-shadow 0.2s")
            .set("overflow", "hidden");
    }
    
    // Primary Button
    public static Button createPrimaryButton(String text) {
        Button button = new Button(text);
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.getElement().getStyle()
            .set("background-color", PRIMARY_COLOR)
            .set("border-radius", "6px")
            .set("font-weight", "600")
            .set("padding", "10px 20px");
        return button;
    }
    
    // Helper to create a feature item
    public static HorizontalLayout createFeatureItem(Image icon, String heading, String text) {
        HorizontalLayout layout = new HorizontalLayout();
        
        icon.setWidth("48px");
        icon.setHeight("48px");
        
        H2 headingComponent = new H2(heading);
        headingComponent.getStyle()
            .set("color", PRIMARY_COLOR)
            .set("margin", "0")
            .set("font-size", FONT_SIZE_MD);
        
        VerticalLayout content = new VerticalLayout(headingComponent, new Paragraph(text));
        content.setPadding(false);
        content.setSpacing(false);
        
        layout.add(icon, content);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        
        return layout;
    }
}