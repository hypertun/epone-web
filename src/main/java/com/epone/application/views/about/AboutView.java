package com.epone.application.views.about;

import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("About")
@Route(value = "about", layout = MainLayout.class)
public class AboutView extends VerticalLayout {

    String visionStatement = "To source, train and match most suitable fdw to our invaluable clients with professional services.";
    String visionHeadingHTML = "<span>Our</span> <span style=\"color:green\">Vision</span>";

    String historyHeadingHTML = "<span>Our</span> <span style=\"color:green\">History</span>";
    String history1 = "EP One Manpower Pte Ltd was established in 2012, after the owner of the agency has several issues with his own Foreign Domestic Worker (FDW) and several business trips (food businesses) to countries such as Indonesia, Philippines and Myanmar. Being a person good in processes improvement and character enhancement, he started off the Employment Agency's business by recruiting personally a few Indonesian candidates with good potential. He trained them personally, brief them and inculcate in them value of hard working, ability to take hardship, meticulous in doing chores and hygiene.";
    String history2 = "Today EP One Manpower Pte Ltd has 3 branches located in Bukit Timah, Hougang and Sin Ming areas, with several Training Centres overseas in Myanmar, Philippine, Indonesia and India. EP One Manpower Pte Ltd is committed to match you with the most competence workers through constant screening in the worker's home-country, training and inculcating the correct value in the workers, prior to come into Singapore, and with best services.";

    String myanmarHeading = "<span>Face to Face</span> <span style=\"color:green\">Interview</span><span> in Myanmar, May 2017</span>";

    public AboutView() {
        VerticalLayout explainVertical = new VerticalLayout();
        explainVertical.add(getCardFormat(getHeading(visionHeadingHTML), new Paragraph(visionStatement)));
        explainVertical
                .add(getCardFormat(getHeading(historyHeadingHTML), new Paragraph(history1), new Paragraph(history2)));

        Image aboutChen = new Image("images/about-chen.jpg", "chen photo");

        HorizontalLayout aboutHorizontal = new HorizontalLayout(explainVertical,
                getCardFormat(aboutChen, new Paragraph("Celebrity couple has a helper through our agency")));
        aboutHorizontal.setWidth("100%");

        VerticalLayout myanmarLayout = getMyanmarLayout();
        myanmarLayout.setWidth("100%");
        myanmarLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        myanmarLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        VerticalLayout aboutVertical = new VerticalLayout(aboutHorizontal, myanmarLayout);

        add(aboutVertical);
        getStyle().set("padding-left", "300px").set("padding-right", "300px");
    }

    private VerticalLayout getCardFormat(Component header, Component... content) {
        VerticalLayout ret = new VerticalLayout();
        ret.add(header);
        ret.add(content);
        ret.setWidth("100");
        return ret;
    }

    private H2 getHeading(String html) {
        H2 heading = new H2();
        heading.getElement().setProperty("innerHTML", html);
        heading.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        return heading;
    }

    private VerticalLayout getMyanmarLayout() {
        VerticalLayout ret = new VerticalLayout();
        ret.add(getHeading(myanmarHeading));

        Image m1 = new Image("images/ep-one-m1.jpg", "ep one m1");
        Image m2 = new Image("images/ep-one-m2.jpg", "ep one m2");
        HorizontalLayout imageLayout = new HorizontalLayout(m1, m2);
        imageLayout.setWidth("100%");
        imageLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        imageLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        ret.add(imageLayout);
        ret.add(new Paragraph(
                "These are some of the candidates interviewed. Many speak fluent English, some even were able to communicate in Mandarin. Some even were Ex Singapore with good employment history."));
        return ret;
    }
}
