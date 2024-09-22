package com.epone.application.views.landing;

import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Welcome")
@Route(value = "home", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class LandingPage extends VerticalLayout {

    // private TextField name;
    // private Button sayHello;
    String leadStatement = "<span>One Of The </span><span style=\"color:green\">Top Maid Agencies</span><span> In Singapore</span>";
    Paragraph leadPara = new Paragraph("At EPOne, our mission is to be the preferred and trusted employment agency"
            +
            " for the provision of Foreign Domestic Workers to both our clients and candidates. We are committed" +
            " to provide professional services, and to source and train the best helpers to exceed our customer's expectation, at low cost.");

    String ourServicesStatement = "<span>Our</span> <span style=\"color:green\">Services</span>";
    Paragraph ourServicesPara = new Paragraph(
            "We recruit, train, and place Foreign Domestic Workers (FDWs) from countries such as Indonesia, the Philippines, Myanmar, and India. "
                    +
                    "We offers comprehensive services, including pre-departure training and orientation for workers, skills matching, and full support throughout the employment process. "
                    +
                    "We are committed to providing professional, reliable, and efficient service to meet the needs of employers seeking domestic help. "
                    +
                    "We ensure both employers and workers have a positive and successful experience.");

    public LandingPage() {
        VerticalLayout lead = new VerticalLayout(getHeading(leadStatement), leadPara);
        Image footerBanner = new Image("images/banner.png", "banner");
        HorizontalLayout missionHori = new HorizontalLayout(lead, footerBanner);
        missionHori.setHeight("100%");

        HorizontalLayout adsHori = new HorizontalLayout(getReviewFormat("Over", "10+", "years of experience"),
                getReviewFormat("Suppliers from", "many", "countries"),
                getReviewFormat("Average Score Of", "4.0+", "On Google Reviews"));
        adsHori.getStyle().set("border", "2px solid grey").set("border-radius", "5px");
        adsHori.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        adsHori.setWidth("80%");
        adsHori.setHeight("100%");

        VerticalLayout ourServices = new VerticalLayout(getHeading(ourServicesStatement), ourServicesPara);
        ourServices.setAlignItems(FlexComponent.Alignment.CENTER);

        // name = new TextField("Your name");
        // sayHello = new Button("Say hello");
        // sayHello.addClickListener(e -> {
        // Notification.show("Hello " + name.getValue());
        // });
        // sayHello.addClickShortcut(Key.ENTER);

        // setMargin(true);
        // setVerticalComponentAlignment(Alignment.END, name, sayHello);

        // add(name, sayHello);

        add(missionHori, adsHori, ourServices);
        setPadding(true);
        getThemeList().add("spacing-l");
        getStyle().set("padding-left", "300px").set("padding-right", "300px");
        setAlignItems(FlexComponent.Alignment.CENTER);
        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
    }

    private VerticalLayout getReviewFormat(String start, String mid, String end) {
        Paragraph midFormatted = new Paragraph(mid);
        midFormatted.getStyle()
        .set("color", "green")
        .set("font-weight", "bold")
        .set("font-size","30px");

        Paragraph startFormatted = new Paragraph(start);
        Paragraph endFormatted = new Paragraph(end);
        startFormatted.getStyle()
        .set("font-weight", "bold");
        endFormatted.getStyle()
        .set("font-weight", "bold");

        VerticalLayout returnedLayout = new VerticalLayout(startFormatted, midFormatted, endFormatted);
        returnedLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        returnedLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        returnedLayout.getStyle().set("border","1px solid black");

        return returnedLayout;
    }

    private H2 getHeading(String html) {
        H2 heading = new H2();
        heading.getElement().setProperty("innerHTML", html);
        heading.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        return heading;
    }

}
