package com.epone.application.views.services;

import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Hiring A Maid")
@Route(value = "hiring maids", layout = MainLayout.class)
public class Hiringamaid extends VerticalLayout {

    String heading = "Our 4-Step Hiring Process";

    String step1Heading = "Selection";
    String step1Body = "You select a candidate from our extensive catalogue of available helpers.";

    String step2Heading = "Paperwork";
    String step2Body = "Our professional team will handle all necessary paperwork for you.";

    String step3Heading = "Training";
    String step3Body = "Before flying into Singapore, our overseas training centres will train your helper up to meet your needs.";

    String step4Heading = "Deployment";
    String step4Body = "After completing the necessary paperwork, your helper starts work in your home.";

    public Hiringamaid() {
        addAndExpand(getHeading(heading),getSteps());
        setPadding(true);
        getThemeList().add("spacing-l");
        getStyle().set("padding-left", "5%").set("padding-right", "5%");
        setAlignItems(FlexComponent.Alignment.CENTER);
        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        setWidth("100%");
    }

    private H1 getHeading(String headingString) {
        H1 heading = new H1(headingString);
        heading.getStyle().set("color", "green");
        heading.addClassNames(Margin.Top.XLARGE, Margin.Top.XLARGE);
        return heading;
    }

    private HorizontalLayout getSteps() {
        return new HorizontalLayout(
                getCard("images/number-1.png", step1Heading, step1Body),
                getCard("images/two.png", step2Heading, step2Body),
                getCard("images/number-3.png", step3Heading, step3Body),
                getCard("images/number-4.png", step4Heading, step4Body)
        );
    }

    private Details getCard(String imageLoc,
            String title,
            String description) {
        Image im = new Image(imageLoc, imageLoc + "image");
        im.setHeight("50px");
        im.setWidth("50px");

        H5 titleH5 = new H5(title);
        titleH5.getStyle().set("color", "green");
        titleH5.addClassNames(Margin.Top.XLARGE, Margin.Top.MEDIUM);


        Details ret = new Details(im, titleH5, new Paragraph(description));
        ret.setOpened(true);
        return ret;
    }
}
