package com.epone.application.views.faq;

import java.util.LinkedHashMap;

import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("FAQ")
@Route(value = "faq", layout = MainLayout.class)
public class Questions extends Accordion {
    LinkedHashMap<String, String> qna = new LinkedHashMap<>();

    public Questions() {

        qna.put("Why you should hire a helper through EP One Manpower?", """
                We not only do our utmost to match you with a candidate that best suits your needs but we \
                endeavour to do it with the least disruption to your busy schedule.
                <br>
                <br>
                Every part of the hiring process from initial shortlist, interview to subsequent signatory, payment \
                will be conducted online. The only time you need to visit is when you are ready to bring your \
                helper home.
                """);

        qna.put("How long does it take to hire a maid from overseas?",
                """
                                    It typically takes between three to eight weeks for the shortlisted candidate to arrive in Singapore \
                        if she has a valid passport, complete set of documents and the application is for a straightforward \
                        case (as opposed to for example, a sponsor case).  Upon her arrival in Singapore, it takes about \
                        another one week for her to pass her medical checkup and attend the mandatory Settling-In \
                        Programme before she can start work in your home.
                                        """);

        qna.put("What is the average basic salary of an Indonesian maid?",
                "S$550.  Basic salary commensurate with experience.");

        qna.put("What is the average basic salary of a Myanmar maid?",
                "S$480 to S$550. Basic salary commensurate with experience.");

        qna.put("What is the average basic salary of a Filipino maid?",
                "S$650.  Basic salary commensurate with experience.");

        qna.put("What is the maid levy?",
                """
                            All employers who hire MDWs in Singapore are required to pay a monthly maid levy to The \
                        Central Provident Fund (collecting on behalf of MOM). The Singapore government regulates the \
                        number of MDWs in Singapore through this levy.
                                """);

        qna.put("How much is the maid levy?",
                """
                                                The monthly levy is S$300 for the first maid and S$450 for the subsequent maid, each payable \
                                                for the period that the respective work permit is valid. An employer who is a Singapore citizen \
                                                qualifies for the S$60 concessionary levy if he/she lives with either:
                                                <ol>
                        <li>Young child below 16 years old</li>
                        <li>Elderly person who is at least 67 years old</li>
                        <li>Person with disabilities (to be certified by a Singapore-registered doctor)</li>
                                                </ol>
                                                    """);

        qna.put("What is the minimum insurance coverage required?",
                """
                        MOM stipulates that employers need to purchase medical and personal accident insurance for the \
                        helpers with an annual claim limit of at least S$60,000.
                                    """);

        qna.put("What is a security bond and how much is it?",
                """
                        All employers of MDWs are required to post a S$5,000 security bond. The purpose of this bond \
                        is to ensure that the employer makes timely salary payments and facilitates the MDW’s timely \
                        repatriation when her work permit has expired/is revoked or cancelled. \
                        <br>
                        <br>
                        The security bond may also be forfeited in full/partially if the employer/the MDW violates any \
                        of the work permit or security bond conditions or if the MDW goes missing.
                                        """);

        qna.put("What is an alternative to the S$5,000 security deposit?",
                """
                        Employers can purchase an insurance policy from BOLTTECH INSURANCE AGENCY PTE. \
                        LTD., which is a much cheaper alternative compared to placing a S$5,000 deposit.
                                        """);
        qna.put("Does the maid need to undergo regular medical check up?",
                """
                        Within 2 weeks from the maid’s arrival in Singapore, she must be examined by a Singapore- \
                        registered doctor.  She can only get her work permit issued and start work at the employer’s \
                        home after she has passed the pre-employment medical examination and deemed Fit To Work.  \
                        Otherwise, she will have to be repatriated.
                        <br>
                        <br>
                        Such medical examination, including checks for pregnancy, VDRL, Body Mass Index (BMI) and \
                        visible signs of abuse are required every six months, whereas HIV and TB tests are added on \
                        upon each maid’s 2-year stay in Singapore.
                                        """);
        qna.put("Who is responsible for the maid's medical expenses?",
                """
                        The employer is fully liable for all the medical expenses of the maid, including hospitalization, \
                        outpatient and medical repatriation costs if necessary.  As such, it is imperative to have adequate \
                        insurance coverage in place.
                                        """);
        qna.put("What to do when maid gets pregnant?",
                """
                                            You might have heard of cases of MDWs getting pregnant. If you notice signs like \
                                            fatigue, nausea, vomiting, missed periods, or sudden weight gain in your helper, it is \
                                            best to have an open conversation with your helper. If she confirms that she is \
                                            pregnant or if you strongly suspect it based on the signs, suggest that she goes for a \
                                            proper pregnancy test at a clinic. This will give you both clarity on the situation. If the \
                                            test is positive, you should know that she would have to return home since she will no \
                                            longer be allowed to work.
                                            <br>
                                            <br>
                                            Take note that her medical insurance does not cover costs related to her pregnancy, \
                                            which will have to be borne by her employer. 
                                            <br>
                                            <br>
                                            In such cases, open and empathetic communication with your MDW is the key. Speak \
                                            with her compassionately to avoid unnecessary stress and emotional strain for both \
                                            parties.
                        <br>
                        <br>
                                                The employer should inform MOM of the pregnancy and upload a copy of the doctor’s memo. \
                                                MOM will contact the employer within seven working days.  Subsequently, the employer should \
                                                cancel her work permit and purchase an air ticket to repatriate the maid. \
                                                It is important for the employer to notify MOM when he/she first becomes aware of the \
                                                pregnancy as failure to do so may result in the forfeiture of the security deposit.
                                                                """);
        qna.put("Can I hire a maid on part-time basis?",
                """
                        No.  Under MOM regulations, maids are not permitted to engage in part-time employment.
                                        """);
        qna.put("What are the obligations of the employer to the maid?",
                """
                        According to MOM’s regulations, the employer must ensure the maid:
                        <ol>
                        <li>has at least one rest day each month that cannot be compensated away</li>
                        <lihas one rest day per week for the other weeks in the month for which she may be paid
                        salary in-lieu</li>
                        <li>has adequate rest and is provided with adequate food and acceptable accommodation
                        (consists adequate shelter, basic amenities, sufficient ventilation, safety, modesty, space
                        and privacy)</li>
                        <li>receives any medical care needed, including hospitalization and six-monthly medical
                        examinations</li>
                        <li>is able to integrate into the employer’s family and her new role</li>
                        <li>is paid her salary every month, no later than 7 days after the last day of the salary period
                        (not to exceed 1 month)</li>
                        <li>is provided with a safe working environment</li>
                        <li>is repatriated home with a passage paid by the employer, after giving her reasonable
                        notice and paying her any outstanding salary</li>
                        <li>is brought before the Controller of Work Passes when required by MOM</li>
                                                </ol>

                                        """);
        qna.put("From which countries can I hire a maid from if I engage Epone Manpower?",
                """
                        We recruit maids from Indonesia, Myanmar, the Philippines and India( Mizoram).
                                        """);
        qna.put("Can EP One Manpower assist with passport and work permit renewals?",
                """
                        Our Passport Renewal Assistance, where we handle the entire process, ensuring the \
                        maid's travel documents are always up-to-date.
                        <br>
                        During the times your helper is here with you, make sure your helper&#39;s passport \
                        remains valid (with at least 6 months'; validity). Here, we prioritize the details, \
                        allowing you to focus on an uninterrupted partnership with your trusted household \
                        helper.
                                        """);
        qna.put("How do I apply for GIRO bank account for levy payment?",
                """
                        You can use this link to apply.
                        <br>
                        https://www.mom.gov.sg/faq/work-pass-general/how-do-i-apply-for-giro-bank-account-for-my-
                        levy-payment
                                            """);
        qna.put("Do I need to attend any course if I am a 1st time employing a maid?",
                """
                        Yes. You need to attend an online EOP course if you have not employed a maid before. The \
                        course is available in English, Chinese, Malay and Tamil.
                        <br>
                        Use this link to enroll using employer Singpass. \
                        <br>
                        www.eop.com.sg
                                        """);
        qna.put("Which nationality of helper is better?",
                """
                        Each nationality has its own merits and weaknesses. However it depends more on an \
                        individual&#39;s experience level, family background, educational level, stress level, \
                        ability to learn, whether is a fast learner or takes a longer time to comprehend  certain \
                        instructions. Case-to-case depending on the need. For instance, MDW for children in \
                        younger age, we recommend a more active, more energetic, more cheerful nature \
                        MDW to care, to mingle and play with the kids. For elderly care, we recommend one \
                        with a better height and weight to support elderly&#39;s movement. Occasionally we do \
                        have employers that request a &quot;good cook&quot; as they are more particular about their \
                        meal. In such cases, we have to source for one that is good at cooking, and willing to \
                        learn more from recipe books. For newborn baby care, especially when the mother is \
                        not able to spend more time to coach the MDW, no compromise, we have to \
                        recommend an experienced maid, with related baby care experiences to start off.
                        <br>
                        <br>
                        Contact us and our friendly staff can better understand your needs and help you match \
                        with a suitable helper.
                                        """);
        qna.put("Who is eligible to work as Migrant domestic worker(MDW) in Singapore?",
                """
                        To be granted a work permit, domestic workers must fulfill the followings:
                        <ol>
                        <li>female</li>
                        <li>between 23 and 50 years old</li>
                        <li>from approved nations (the Philippines, Indonesia, Bangladesh, Cambodia, \
                        Hong Kong, Indonesia, Macau, Malaysia, Myanmar, South Korea, Sri Lanka, \
                        Taiwan, Thailand)</li>
                        <li>have at least eight years of formal education.</li>
                        <ol><br>Note that to be an employer, there are a number of requirements you must meet, such \
                        as earning a minimum salary (in most cases). These requirements are in place partly to \
                        ensure that you are adequately able to care for your worker and pay her salary on \
                        time. 
                        In addition, helpers must:
                        <ol>
                        <li>Work at employers'; NRIC-registered addresses.</li>
                        <li>Attend the Settling-in Programme (SIP) if they are first-time helpers. MOM \
                        will inform employers if their helpers need to attend the SIP in the Work Permit \
                        in-principle approval (IPA) letter.</li>
                        <li>Not be related to their employers.</li>
                        <li>Not be in Singapore during the Work Permit application. Employers can only \
                        bring helpers into Singapore after they have received an IPA letter and bought a \
                        $5,000 security bond.</li>
                        </ol>
                        Criteria for first-time helpers:
                        A first-time helper is one who has never worked in Singapore as a helper before. This
                        includes a helper who:
                        <ol>
                        <li>Doesn’t have an employment record as a helper with MOM’s Work Pass
                        Division.</li>
                        <li>Has an employment record as a helper with MOM but eventually did not work
                        in Singapore.</li>
                        </ol>
                                        """);
        qna.put("Can I hire a second MDW?",
                """
                        You may be able to hire a second migrant domestic worker (MDW) if you \
                        meet any of the following criteria:
                        <ol>
                        <li>You or your spouse is at least 60 years old.</li>
                        <li>You have at least 2 children below 18 years old and living with you.</li>
                        <li>You have a parent or parent-in-law who is at least 60 years old and living with</li>
                        you.
                        </ol>
                        MOM will also consider your financial ability to hire, maintain and upkeep the \
                        helpers in an acceptable accommodation.You also need to provide sufficient privacy \
                        and sleeping space in the house for the 2 MDWs.
                        To apply for the second MDW, submit a Work Permit application and provide the \
                        relevant information:
                        <ol>
                        <li>A copy of the children's birth certificates.</li>
                        <li>A copy of the parent's or parent-in-law's identity cards and the employer's or \
                        spouse's birth certificate.</li>
                        </ol> 
                        Each household can hire up to 2 MDWs. \
                                        """);
        qna.put("What is the maximum number of years an MDW can work for the same employer?",
                """
                        There is no maximum number of years a migrant domestic worker (MDW) can work \
                        for the same employer. However, the maximum age that the MDW can work in \
                        Singapore is generally 60 years old.
                                        """);

        for (String i : qna.keySet()) {
            Paragraph getPara = new Paragraph();
            getPara.getElement().setProperty("innerHTML", qna.get(i));
            add(i, getPara);
        }

        getStyle().set("padding-left", "100px");
        getStyle().set("padding-right", "100px"); 
    }
}
