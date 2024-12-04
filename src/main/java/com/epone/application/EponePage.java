package com.epone.application;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

public class EponePage extends VerticalLayout {
    public EponePage() {}

    public H1 GetH1Heading(String html) {
        H1 heading = new H1();
        heading.getElement().setProperty("innerHTML", html);
        heading.addClassNames(Margin.Top.XLARGE, Margin.Bottom.XLARGE);
        return heading;
    }

    public H2 GetH2Heading(String html) {
        H2 heading = new H2();
        heading.getElement().setProperty("innerHTML", html);
        heading.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        return heading;
    }

    public H3 GetH3Heading(String html) {
        H3 heading = new H3();
        heading.getElement().setProperty("innerHTML", html);
        heading.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        return heading;
    }

    public H4 GetH4Heading(String html) {
        H4 heading = new H4();
        heading.getElement().setProperty("innerHTML", html);
        heading.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        return heading;
    }

    public H5 GetH5Heading(String html) {
        H5 heading = new H5();
        heading.getElement().setProperty("innerHTML", html);
        heading.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        return heading;
    }

    public Paragraph GetParagraph(String html) {
        Paragraph para = new Paragraph(html);
        para.getElement().setProperty("innerHTML", html);
        return para;
    }

    public VerticalLayout GetHeaderBodyCardWithSpacing(Component header,Component body) {
        VerticalLayout vl = new VerticalLayout(header, body);
        vl.setPadding(true);
        vl.getThemeList().add("spacing-l");
        vl.getStyle().set("padding-left", "5%").set("padding-right", "5%");
        return vl;
    }

    public Image GetImage(String imageLoc, String imageName) {
        Image im = new Image(imageLoc, imageName);
        im.setHeight("300px");
        im.setWidth("300px");
        return im;
    }
}
