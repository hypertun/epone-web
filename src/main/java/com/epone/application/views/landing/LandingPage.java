package com.epone.application.views.landing;

import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Welcome")
@Route(value = "", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class LandingPage extends HorizontalLayout {

    // private TextField name;
    // private Button sayHello;

    private Image footerBanner;
    private Paragraph companyOverviewHeader;
    private Paragraph companyOverview; 

    public LandingPage() {
        footerBanner = new Image("images/banner.png", "banner");

        companyOverviewHeader = new Paragraph("Company Overview");
        companyOverview = new Paragraph("EP One Manpower Pte Ltd was established in 2012, after the owner of the agency has several issues with his own Foreign Domestic Worker (FDW) and several business trips (food businesses) to countries such as Indonesia, Philippines and Myanmar. Being a person good in processes improvement and character enhancement, he started off the Employment Agency's business by recruiting personally a few Indonesian candidates with good potential. He trained them personally, brief them and inculcate in them value of hard working, ability to take hardship, meticulous in doing chores and hygiene etc..and \r\n" + //
                        "\r\n" + //
                        "Today EP One Manpower Pte Ltd has 3 branches located in Bukit Timah, Hougang and Sin Ming, with several Training Centres overseas in Myanmar, Philippine, Indonesia and India. EP One Manpower Pte Ltd is committed to match you with the most competence workers through constant screening in the worker's home-country, training and inculcating the correct value in the workers, prior to come into Singapore, and with best services.");
        // name = new TextField("Your name");
        // sayHello = new Button("Say hello");
        // sayHello.addClickListener(e -> {
        //     Notification.show("Hello " + name.getValue());
        // });
        // sayHello.addClickShortcut(Key.ENTER);

        // setMargin(true);
        // setVerticalComponentAlignment(Alignment.END, name, sayHello);

        // add(name, sayHello);
        add(companyOverviewHeader,companyOverview,footerBanner);
    }

}
