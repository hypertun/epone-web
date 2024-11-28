package com.epone.application.views.landing;

import org.checkerframework.checker.units.qual.s;

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

        String matchStatement = "<span>At EP One Manpower, we are doing our very best to match </span><span style=\"color:green\">YOU</span>"
                        +
                        " a <span style=\"color:green\">HELPER</span><span> who meets your family’s needs.</span>";

        String leadStatement = "<span>One Of The </span><span style=\"color:green\">Top Maid Agencies</span><span> In Singapore</span>";
        Paragraph leadPara = new Paragraph("At EPOne, our mission is to be the preferred and trusted employment agency"
                        +
                        " for the provision of Foreign Domestic Workers to both our clients and candidates. We are committed"
                        +
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
                lead.setWidth("250%");
                Image footerBanner = new Image("images/banner.png", "banner");

                HorizontalLayout adsHori = new HorizontalLayout(lead,
                                getReviewFormat("With over", "10+", "years of experience"),
                                getReviewFormat("Helpers from", "DIVERSE", "countries"),
                                getReviewFormat("Average Score Of", "4.0+", "On Google Reviews"));
                adsHori.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
                adsHori.setAlignItems(FlexComponent.Alignment.CENTER);

                VerticalLayout ourServices = new VerticalLayout(getHeading(ourServicesStatement), ourServicesPara);
                ourServices.setAlignItems(FlexComponent.Alignment.CENTER);

                H1 matchHeading = new H1();
                matchHeading.getElement().setProperty("innerHTML", matchStatement);
                matchHeading.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
                matchHeading.getStyle().set("text-align", "center");

                add(footerBanner, matchHeading, adsHori, ourServices);
                setPadding(true);
                getThemeList().add("spacing-l");
                getStyle().set("padding-left", "5%").set("padding-right", "5%");
                setAlignItems(FlexComponent.Alignment.CENTER);
                setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        }

        private VerticalLayout getReviewFormat(String start, String mid, String end) {
                Paragraph midFormatted = new Paragraph(mid);
                midFormatted.getStyle()
                                .set("color", "green")
                                .set("font-weight", "bold")
                                .set("font-size", "30px");

                Paragraph startFormatted = new Paragraph(start);
                Paragraph endFormatted = new Paragraph(end);
                startFormatted.getStyle()
                                .set("font-weight", "bold");
                endFormatted.getStyle()
                                .set("font-weight", "bold");

                VerticalLayout returnedLayout = new VerticalLayout(startFormatted, midFormatted, endFormatted);
                returnedLayout.setAlignItems(FlexComponent.Alignment.CENTER);
                returnedLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
                returnedLayout.getStyle().set("border", "1px solid black");
                returnedLayout.setSpacing(false);
                returnedLayout.setPadding(false);
                returnedLayout.setSizeFull();

                return returnedLayout;
        }

        private H2 getHeading(String html) {
                H2 heading = new H2();
                heading.getElement().setProperty("innerHTML", html);
                heading.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
                return heading;
        }

}
