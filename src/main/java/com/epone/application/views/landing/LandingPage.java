package com.epone.application.views.landing;

import com.epone.application.views.MainLayout;

import com.epone.application.utilities.*;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.NativeLabel;
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

@JavaScript("https://cdnjs.cloudflare.com/ajax/libs/iframe-resizer/4.2.10/iframeResizer.min.js")
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

        String serviceTransParencyStatement = "<span style=\"color:green\">Service Transparency</span>";
        String serviceTransParencyString = "We have a policy of transparent services as we value our customer. In this respect, we:";
        String serviceTransParaOption1 = "Indicate the payment methods available to you i.e. cash, cheque or online bank payment etc.";
        String serviceTransParaOption2 = "Seek and value your feedback anytime. If your feedback is less than positive, we "
                        +
                        "endeavour to resolve the problem either IMMEDIATELY or within a few working days, " +
                        "depending on the complexity of each case.";

        String replacementStatement = "<span style=\"color:green\">Replacement Service Guarentee</span>";
        String replacementString = "If you are not happy, we are not happy as well. We understand your needs may change over time "
                        +
                        "and it is not always a one-size-fits-all.  Therefore, we provide you with a replacement helper "
                        +
                        "within a period of 6 months, starting from the commencement of your hire of the very first " +
                        "helper. If you are not happy, we are not happy as well. We understand your needs may change over time "
                        +
                        "and it is not always a one-size-fits-all.  Therefore, we provide you with a replacement helper "
                        +
                        "within a period of 6 months, starting from the commencement of your hire of the very first " +
                        "helper.";

        String transfersStatement = "<span style=\"color:green\">Transfers</span>";
        String transfersString = "If you need to transfer your helper to another employer, we can also assist you as well. The terms "
                        +
                        "and conditions of such transfers shall be clearly explained to you.";

        String serviceAgreementStatement = "<span style=\"color:green\">Service Agreement</span>";
        String serviceAgreementString = "We provide a fair and comprehensive Service Agreement to you which amongst other things "
                        +
                        "state the terms and conditions of service transactions including any deposits paid and also the "
                        +
                        "date of commencement of the helper’s employment.";

        String confidentialityStatement = "<span style=\"color:green\">Confidentiality</span>";
        String confidentialityString1 = "​We will collect personal information provided by our users, including their names, "
                        +
                        "mobile telephone numbers, email addresses, resumes etc. to provide our services to " + //
                        "the users. ​The information collected is used solely to provide our agency services.";
        String confidentialityString2 = "EP One Manpower is committed to protect the privacy of your personal data. We do "
                        +
                        "not sell, rent, loan, trade or lease personal information obtained. The parties in which " + //
                        "we may disclose your information include:";

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

                IFrame googleReviews = new IFrame("https://cb8234035643410dbfe274a473e5bff9.elf.site");
                googleReviews.getElement().executeJs("iFrameResize(this)");
                googleReviews.setWidth("100%");
                googleReviews.getStyle().set("border","none");

                add(footerBanner, matchHeading, adsHori, googleReviews, ourServices, getServices());
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

        private H4 getH4Heading(String html) {
                H4 heading = new H4();
                heading.getElement().setProperty("innerHTML", html);
                heading.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
                return heading;
        }

        private Image getServiceImage(String imageLoc, String imageName) {
                Image im = new Image(imageLoc, imageName);
                im.setHeight("300px");
                im.setWidth("300px");
                return im;
        }

        private VerticalLayout getServices() {
                VerticalLayout sLayout = new VerticalLayout();

                Image tIm = getServiceImage("icons/support.png", "service transparency image");
                Image rIm = getServiceImage("icons/replace.png", "replacement image");
                Image transferIm = getServiceImage("icons/transfer.png", "transfer image");
                Image saIm = getServiceImage("icons/case.png", "service agreement image");
                Image cIm = getServiceImage("icons/confidentiality.png", "confidentiality image");

                HTMLUnorderedList serviceTransOptionsList = new HTMLUnorderedList();
                serviceTransOptionsList.addListItem(serviceTransParaOption1, serviceTransParaOption2);
                NativeLabel serviceTransOptions = new NativeLabel();
                serviceTransOptions.getElement().setProperty("innerHTML", serviceTransOptionsList.getHtml("uol"));

                VerticalLayout tVerticalLayout = new VerticalLayout(getH4Heading(serviceTransParencyStatement),
                                new Paragraph(serviceTransParencyString), serviceTransOptions);
                HorizontalLayout tHorizontalLayout = new HorizontalLayout(tIm, tVerticalLayout);

                VerticalLayout rVerticalLayout = new VerticalLayout(getH4Heading(replacementStatement),
                                new Paragraph(replacementString));
                HorizontalLayout rHorizontalLayout = new HorizontalLayout(rVerticalLayout, rIm);

                VerticalLayout transferVerticalLayout = new VerticalLayout(getH4Heading(transfersStatement),
                                new Paragraph(transfersString));
                HorizontalLayout transferHorizontalLayout = new HorizontalLayout(transferIm, transferVerticalLayout);

                VerticalLayout saVerticalLayout = new VerticalLayout(getH4Heading(serviceAgreementStatement),
                                new Paragraph(serviceAgreementString));
                HorizontalLayout saHorizontalLayout = new HorizontalLayout(saVerticalLayout, saIm);

                HTMLUnorderedList cHtmlUnorderedList = new HTMLUnorderedList();
                cHtmlUnorderedList.addListItem("Government Agencies",
                                "3rd Party Service Providers that act as our agents, contractors and service providers",
                                "Companies that support or facilitate your needs",
                                "Other parties in which you have given consent");
                NativeLabel cOptions = new NativeLabel();
                cOptions.getElement().setProperty("innerHTML", cHtmlUnorderedList.getHtml("uol"));

                VerticalLayout cVerticalLayout = new VerticalLayout(getH4Heading(confidentialityStatement),
                                new Paragraph(confidentialityString1),
                                new Paragraph(confidentialityString2),
                                cOptions);
                HorizontalLayout cHorizontalLayout = new HorizontalLayout(cIm, cVerticalLayout);

                sLayout.add(tHorizontalLayout, rHorizontalLayout, transferHorizontalLayout, saHorizontalLayout,
                                cHorizontalLayout);
                sLayout.setAlignItems(FlexComponent.Alignment.CENTER);
                sLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
                sLayout.setWidth("100%");
                sLayout.setSpacing(false);
                sLayout.setPadding(false);
                sLayout.getStyle().set("border", "1px solid black");

                return sLayout;
        }

}
