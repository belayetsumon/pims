/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.model.AdditionalQualification;
import itgarden.model.AddressInformation;
import itgarden.model.ChildrenInformation;
import itgarden.model.DisciplinaryActionDetails;
import itgarden.model.EducationalInformation;
import itgarden.model.FirstJoiningInformation;
import itgarden.model.ForeignTrainingInformation;
import itgarden.model.GeneralInformation;
import itgarden.model.HonorsAndAwardInformation;
import itgarden.model.InServiceTrainingInformation;
import itgarden.model.JobEntryProcess;
import itgarden.model.LanguageInformation;
import itgarden.model.Leaveinfo;
import itgarden.model.MagisterialPower;
import itgarden.model.Membership;
import itgarden.model.OtherServiceInformation;
import itgarden.model.PostingAbroadInformation;
import itgarden.model.PostingRecordInformation;
import itgarden.model.PresentJob;
import itgarden.model.ProfileImage;
import itgarden.model.PromotionsInformation;
import itgarden.model.PublicationInformation;
import itgarden.model.RetirementPension;
import itgarden.model.SelectionGrade;
import itgarden.model.ServiceHistories;
import itgarden.model.SpousName;
import itgarden.model.Users;
import itgarden.model.enumvalue.Status;
import itgarden.repository.AcrRepository;
import itgarden.repository.AdditionalQualificationRepository;
import itgarden.repository.AddressInformationRepository;
import itgarden.repository.ChildrenInformationRepository;
import itgarden.repository.DisciplinaryActionDetailsRepository;
import itgarden.repository.EducationalInformationRepository;
import itgarden.repository.FirstJoiningInformationRepository;
import itgarden.repository.ForeignTrainingInformationRepository;
import itgarden.repository.GeneralInformationRepository;
import itgarden.repository.HonorsAndAwardInformationRepository;
import itgarden.repository.InServiceTrainingInformationRepository;
import itgarden.repository.JobEntryProcessRepository;
import itgarden.repository.LanguageInformationRepository;
import itgarden.repository.LeaveinfoRepository;
import itgarden.repository.MagisterialPowerRepository;
import itgarden.repository.MembershipRepository;
import itgarden.repository.OtherServiceInformationRepository;
import itgarden.repository.PostingAbroadInformationRepository;
import itgarden.repository.PostingRecordInformationRepository;
import itgarden.repository.PresentJobRepository;
import itgarden.repository.ProfileImageRepository;
import itgarden.repository.PromotionsInformationRepository;
import itgarden.repository.PublicationInformationRepository;
import itgarden.repository.RetirementPensionRepository;
import itgarden.repository.SelectionGradeRepository;
import itgarden.repository.ServiceHistoriesRepository;
import itgarden.repository.SpousNameRepository;
import itgarden.repository.UsersRepository;
import itgarden.service.StorageProperties;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/profile")
@PreAuthorize("hasAuthority('profile')")
public class ProfileController {

    @Autowired
    StorageProperties properties;

    @Autowired
    ProfileImageRepository profileImageRepository;

    @Autowired
    AdditionalQualificationRepository additionalQualificationRepository;

    @Autowired
    AddressInformationRepository addressInformationRepository;

    @Autowired
    ChildrenInformationRepository childrenInformationRepository;

    @Autowired
    DisciplinaryActionDetailsRepository disciplinaryActionDetailsRepository;

    @Autowired
    EducationalInformationRepository educationalInformationRepository;

    @Autowired
    GeneralInformationRepository generalInformationRepository;

    @Autowired
    HonorsAndAwardInformationRepository honorsAndAwardInformationRepository;

    @Autowired
    ForeignTrainingInformationRepository foreignTrainingInformationRepository;

    @Autowired
    InServiceTrainingInformationRepository inServiceTrainingInformationRepository;

    @Autowired
    LanguageInformationRepository languageInformationRepository;

    @Autowired
    MagisterialPowerRepository magisterialPowerRepository;

    @Autowired
    OtherServiceInformationRepository otherServiceInformationRepository;
    @Autowired
    PostingAbroadInformationRepository postingAbroadInformationRepository;

    @Autowired
    PostingRecordInformationRepository postingRecordInformationRepository;

    @Autowired
    PromotionsInformationRepository promotionsInformationRepository;

    @Autowired
    PublicationInformationRepository publicationInformationRepository;

    @Autowired
    SelectionGradeRepository selectionGradeRepository;

    @Autowired
    ServiceHistoriesRepository serviceHistoriesRepository;

    @Autowired
    SpousNameRepository spousNameRepository;

    @Autowired
    JobEntryProcessRepository jobEntryProcessRepository;

    @Autowired
    FirstJoiningInformationRepository firstJoiningInformationRepository;

    @Autowired
    PresentJobRepository presentJobRepository;

    @Autowired
    LeaveinfoRepository leaveinfoRepository;

    @Autowired
    AcrRepository acrRepository;

    @Autowired
    RetirementPensionRepository retirementPensionRepository;

    @Autowired
    MembershipRepository membershipRepository;

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping("/shortprofile")
    public String shortprofile(Model model) {
        model.addAttribute("attribute", "value");
        return "view.name";
    }

    @RequestMapping("/newprofile")
    public String newprofile(Model model) {
        model.addAttribute("alluser", usersRepository.findByStatusAndGeneralInformationIsNullOrderByIdDesc(Status.Active));
        return "pims/profile/newprofile";
    }

    @RequestMapping("/profilelist")
    public String profilelist(Model model) {
        model.addAttribute("alluser", usersRepository.findByGeneralInformationIsNotNullOrderByIdDesc());
        return "pims/profile/profilelist";
    }

    @RequestMapping("/fullprofile/{e_id}")
    public String fullprofile(Model model, @PathVariable Long e_id) {
        Users users = new Users();
        users.setId(e_id);
        model.addAttribute("employee", usersRepository.getOne(e_id));
        model.addAttribute("additionalQualification", additionalQualificationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("addressInformation", addressInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("childrenInformation", childrenInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("disciplinaryAction", disciplinaryActionDetailsRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("educationalInformation", educationalInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("foreignTrainingInformation", foreignTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("generalInformation", generalInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("honorsAndAwardInformation", honorsAndAwardInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("inServiceTrainingInformation", inServiceTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("languageInformation", languageInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("magisterialPower", magisterialPowerRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("otherServiceInformation", otherServiceInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("postingAbroadInformation", postingAbroadInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("postingRecordInformation", postingRecordInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("promotionsInformation", promotionsInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("publicationInformation", publicationInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("selectionGrade", selectionGradeRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("serviceHistories", serviceHistoriesRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("jobentryprocess", jobEntryProcessRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("firstjoininginformation", firstJoiningInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("presentjob", presentJobRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("leaveinfo", leaveinfoRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("membership", membershipRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("acr", acrRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("retirementpension", retirementPensionRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("spousName", spousNameRepository.findByGovernmentIdOrderByIdDesc(users));
        return "pims/profile/fullprofile";
    }

    @RequestMapping("/shortprofile/{e_id}")
    public String shortprofile(Model model, @PathVariable Long e_id) {
        Users users = new Users();
        users.setId(e_id);
        model.addAttribute("employee", usersRepository.getOne(e_id));
        model.addAttribute("additionalQualification", additionalQualificationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("addressInformation", addressInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("childrenInformation", childrenInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("disciplinaryAction", disciplinaryActionDetailsRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("educationalInformation", educationalInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("foreignTrainingInformation", foreignTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("generalInformation", generalInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("honorsAndAwardInformation", honorsAndAwardInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("inServiceTrainingInformation", inServiceTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("languageInformation", languageInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("magisterialPower", magisterialPowerRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("otherServiceInformation", otherServiceInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("postingAbroadInformation", postingAbroadInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("postingRecordInformation", postingRecordInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("promotionsInformation", promotionsInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("publicationInformation", publicationInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("selectionGrade", selectionGradeRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("serviceHistories", serviceHistoriesRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("jobentryprocess", jobEntryProcessRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("firstjoininginformation", firstJoiningInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("presentjob", presentJobRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("leaveinfo", leaveinfoRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("membership", membershipRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("acr", acrRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("retirementpension", retirementPensionRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("spousName", spousNameRepository.findByGovernmentIdOrderByIdDesc(users));
        return "pims/profile/short_profile";
    }

    @RequestMapping("/longprofile/{e_id}")
    public String longprofile(Model model, @PathVariable Long e_id) {
        Users users = new Users();
        users.setId(e_id);
        model.addAttribute("employee", usersRepository.getOne(e_id));
        model.addAttribute("additionalQualification", additionalQualificationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("addressInformation", addressInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("childrenInformation", childrenInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("disciplinaryAction", disciplinaryActionDetailsRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("educationalInformation", educationalInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("foreignTrainingInformation", foreignTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("generalInformation", generalInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("honorsAndAwardInformation", honorsAndAwardInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("inServiceTrainingInformation", inServiceTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("languageInformation", languageInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("magisterialPower", magisterialPowerRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("otherServiceInformation", otherServiceInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("postingAbroadInformation", postingAbroadInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("postingRecordInformation", postingRecordInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("promotionsInformation", promotionsInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("publicationInformation", publicationInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("selectionGrade", selectionGradeRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("serviceHistories", serviceHistoriesRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("jobentryprocess", jobEntryProcessRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("firstjoininginformation", firstJoiningInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("presentjob", presentJobRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("leaveinfo", leaveinfoRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("membership", membershipRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("acr", acrRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("retirementpension", retirementPensionRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("spousName", spousNameRepository.findByGovernmentIdOrderByIdDesc(users));
        return "pims/profile/longprofile";
    }

    @RequestMapping("/createprofilepdf/{e_id}")
    public String createprofilepdf(Model model, @PathVariable Long e_id) {
        Users users = new Users();
        users.setId(e_id);
        model.addAttribute("employee", usersRepository.getOne(e_id));
        model.addAttribute("additionalQualification", additionalQualificationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("addressInformation", addressInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("childrenInformation", childrenInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("disciplinaryAction", disciplinaryActionDetailsRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("educationalInformation", educationalInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("foreignTrainingInformation", foreignTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("generalInformation", generalInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("honorsAndAwardInformation", honorsAndAwardInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("inServiceTrainingInformation", inServiceTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("languageInformation", languageInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("magisterialPower", magisterialPowerRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("otherServiceInformation", otherServiceInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("postingAbroadInformation", postingAbroadInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("postingRecordInformation", postingRecordInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("promotionsInformation", promotionsInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("publicationInformation", publicationInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("selectionGrade", selectionGradeRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("serviceHistories", serviceHistoriesRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("jobentryprocess", jobEntryProcessRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("firstjoininginformation", firstJoiningInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("presentjob", presentJobRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("leaveinfo", leaveinfoRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("membership", membershipRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("acr", acrRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("retirementpension", retirementPensionRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("spousName", spousNameRepository.findByGovernmentIdOrderByIdDesc(users));
        return "pims/profile/fullprofilePrint";
    }

    @RequestMapping(value = "/downloadpdf/{e_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public void downloadpdf(Model model, @PathVariable Long e_id, HttpServletRequest request, HttpServletResponse response) throws com.itextpdf.text.DocumentException, IOException {

        Users users = new Users();

        users.setId(e_id);

        Users employee = usersRepository.getOne(e_id);

        ProfileImage pimage = profileImageRepository.findByGovernmentId(users);;

        List<AdditionalQualification> additionalQualification = additionalQualificationRepository.findByGovernmentIdOrderByIdDesc(users);

        List<AddressInformation> addressInformation = addressInformationRepository.findByGovernmentIdOrderByIdDesc(users);

        List<ChildrenInformation> childrenInformation = childrenInformationRepository.findByGovernmentIdOrderByIdDesc(users);

        List<DisciplinaryActionDetails> disciplinaryAction = disciplinaryActionDetailsRepository.findByGovernmentIdOrderByIdDesc(users);

        List<EducationalInformation> educationalInformation = educationalInformationRepository.findByGovernmentIdOrderByIdDesc(users);

        List<ForeignTrainingInformation> foreignTrainingInformation = foreignTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users);

        GeneralInformation generalInformation = generalInformationRepository.findByGovernmentIdOrderByIdDesc(users);

        List<HonorsAndAwardInformation> honorsAndAwardInformation = honorsAndAwardInformationRepository.findByGovernmentIdOrderByIdDesc(users);

        List<InServiceTrainingInformation> inServiceTrainingInformation = inServiceTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users);

        List<LanguageInformation> languageInformation = languageInformationRepository.findByGovernmentIdOrderByIdDesc(users);

        List<MagisterialPower> magisterialPower = magisterialPowerRepository.findByGovernmentIdOrderByIdDesc(users);

        List<OtherServiceInformation> otherServiceInformation = otherServiceInformationRepository.findByGovernmentIdOrderByIdDesc(users);

        List<PostingAbroadInformation> postingAbroadInformation = postingAbroadInformationRepository.findByGovernmentIdOrderByIdDesc(users);

        List<PostingRecordInformation> postingRecordInformation = postingRecordInformationRepository.findByGovernmentIdOrderByIdDesc(users);

        List<PromotionsInformation> promotionsInformation = promotionsInformationRepository.findByGovernmentIdOrderByIdDesc(users);

        List<PublicationInformation> publicationInformation = publicationInformationRepository.findByGovernmentIdOrderByIdDesc(users);

        List<SelectionGrade> selectionGrade = selectionGradeRepository.findByGovernmentIdOrderByIdDesc(users);

        List<ServiceHistories> serviceHistories = serviceHistoriesRepository.findByGovernmentIdOrderByIdDesc(users);
//
        JobEntryProcess jobentryprocess = jobEntryProcessRepository.findByGovernmentId(users);

        FirstJoiningInformation firstjoininginformation = firstJoiningInformationRepository.findByGovernmentId(users);

        PresentJob presentjob = presentJobRepository.findByGovernmentId(users);

        List< Leaveinfo> leaveinfo = leaveinfoRepository.findByGovernmentIdOrderByIdDesc(users);

        List<Membership> membership = membershipRepository.findByGovernmentIdOrderByIdDesc(users);

        RetirementPension retirementpension = retirementPensionRepository.findByGovernmentId(users);

        List<SpousName> spousName = spousNameRepository.findByGovernmentIdOrderByIdDesc(users);

        String pdfFileName = "city_pdf.pdf";

//        try {
        // Get the text that will be added to the PDF
//            String text = request.getParameter("text");
//            if (text == null || text.trim().length() == 0) {
//                text = "You didn't enter any text.";
//            }
//            // step 1
//            Document document = new Document();
//
//            // step 2
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            PdfWriter.getInstance(document, baos);
//            // step 3
//            document.open();
//
//            Font fontSize_8_bold = FontFactory.getFont(FontFactory.TIMES, 8f, Font.BOLD, BaseColor.DARK_GRAY);
//
//            Font fontSize_8_normal = FontFactory.getFont(FontFactory.TIMES, 8f, Font.NORMAL, BaseColor.DARK_GRAY);
//
//            Font fontSize_10_normal = FontFactory.getFont(FontFactory.TIMES, 10f);
//
//            Font fontSize_14_normal = FontFactory.getFont(FontFactory.TIMES, 14f);
//
//            Font fontSize_14_bold = FontFactory.getFont(FontFactory.TIMES, 14f, Font.BOLD, BaseColor.DARK_GRAY);
//
//            Font fontSize_16_normal = FontFactory.getFont(FontFactory.TIMES, 16f);
//
//            Paragraph profiletitle = new Paragraph("Full Profile", fontSize_14_bold);
//            profiletitle.setSpacingAfter(10);
//            profiletitle.setSpacingBefore(10);
//            profiletitle.setAlignment(Element.ALIGN_CENTER);
//
//            document.add(profiletitle);
//
//            PdfPTable stable = new PdfPTable(3); // 3 columns.
//            stable.setWidthPercentage(100);
//            stable.setSpacingBefore(10);
//            stable.setSpacingAfter(10);
//
//            PdfPCell scell;
//            scell = new PdfPCell(new Paragraph("Government ID ", fontSize_8_bold));
//            stable.addCell(scell);
//            scell = new PdfPCell(new Paragraph(employee.getGovernmentId(), fontSize_8_normal));
//            stable.addCell(scell);
//
//            if (employee.getProfileImage() != null) {
//
//                File dir = new File(properties.getRootPath());
//
//                String imageFile = dir.getAbsolutePath() + File.separator + employee.getProfileImage().getImageName();
//                Image img = Image.getInstance(imageFile);
//                img.scaleAbsolute(150f, 150f);
//
//                scell = new PdfPCell(img);
//
//            } else {
//                scell = new PdfPCell(new Paragraph("Image not available", fontSize_8_normal));
//            }
//            scell.setRowspan(7);
//            stable.addCell(scell);
//
//            scell = new PdfPCell(new Paragraph("Name ", fontSize_8_bold));
//            stable.addCell(scell);
//            scell = new PdfPCell(new Paragraph(employee.getName(), fontSize_8_normal));
//            stable.addCell(scell);
//
//            scell = new PdfPCell(new Paragraph("Designation ", fontSize_8_bold));
//            stable.addCell(scell);
//
//            if (employee.getPresentJob() != null) {
//                scell = new PdfPCell(new Paragraph(employee.getPresentJob().getPostingDesignation().getName(), fontSize_8_normal));
//            } else {
//                scell = new PdfPCell(new Paragraph("", fontSize_8_normal));
//            }
//
//            stable.addCell(scell);
//
//            scell = new PdfPCell(new Paragraph("Department ", fontSize_8_bold));
//            stable.addCell(scell);
//
//            scell = new PdfPCell(new Paragraph(employee.getDepartment().getName(), fontSize_8_normal));
//            stable.addCell(scell);
//
//            scell = new PdfPCell(new Paragraph("Sub-Department ", fontSize_8_bold));
//            stable.addCell(scell);
//
//            scell = new PdfPCell(new Paragraph(employee.getSubDepartment().getName(), fontSize_8_normal));
//            stable.addCell(scell);
//
//            scell = new PdfPCell(new Paragraph("Posting Location ", fontSize_8_bold));
//            stable.addCell(scell);
//
//            if (employee.getPresentJob() != null) {
//                scell = new PdfPCell(new Paragraph(employee.getPresentJob().getPresentPostingLocation().getName(), fontSize_8_normal));
//            } else {
//                scell = new PdfPCell(new Paragraph("", fontSize_8_normal));
//            }
//
//            stable.addCell(scell);
//
//            scell = new PdfPCell(new Paragraph("Employee Status ", fontSize_8_bold));
//            stable.addCell(scell);
//
//            if (employee.getGeneralInformation() != null) {
//                scell = new PdfPCell(new Paragraph(employee.getGeneralInformation().getEmployeeStatus().toString(), fontSize_8_normal));
//            } else {
//                scell = new PdfPCell(new Paragraph("", fontSize_8_normal));
//            }
//
//            stable.addCell(scell);
//
//            document.add(stable);
//
//            PdfPTable sstable = new PdfPTable(8); // 3 columns.
//            sstable.setWidthPercentage(100);
//            sstable.setSpacingBefore(10);
//            sstable.setSpacingAfter(10);
//
//            PdfPCell sscell;
//
//            scell = new PdfPCell(new Paragraph("Date of Birth", fontSize_8_bold));
//            sstable.addCell(scell);
//
//            if (employee.getGeneralInformation() != null) {
//                scell = new PdfPCell(new Paragraph(employee.getGeneralInformation().getDateofBirth(), fontSize_8_normal));
//            } else {
//                scell = new PdfPCell(new Paragraph("", fontSize_8_normal));
//            }
//
//            sstable.addCell(scell);
//
//            scell = new PdfPCell(new Paragraph("Joining Date", fontSize_8_bold));
//            sstable.addCell(scell);
//
//            if (employee.getFirstJoiningInformation() != null) {
//                scell = new PdfPCell(new Paragraph(employee.getFirstJoiningInformation().getDateFirstJoining(), fontSize_8_normal));
//            } else {
//                scell = new PdfPCell(new Paragraph("", fontSize_8_normal));
//            }
//            sstable.addCell(scell);
//
//            scell = new PdfPCell(new Paragraph("P.R.L Date ", fontSize_8_bold));
//            sstable.addCell(scell);
//
//            if (employee.getGeneralInformation() != null) {
//                scell = new PdfPCell(new Paragraph(employee.getGeneralInformation().getlPRDate(), fontSize_8_normal));
//            } else {
//                scell = new PdfPCell(new Paragraph("", fontSize_8_normal));
//            }
//
//            sstable.addCell(scell);
//
//            scell = new PdfPCell(new Paragraph("Retirement Date ", fontSize_8_bold));
//            sstable.addCell(scell);
//
//            if (employee.getRetirementPension() != null) {
//                scell = new PdfPCell(new Paragraph(employee.getRetirementPension().getStartDate(), fontSize_8_normal));
//            } else {
//                scell = new PdfPCell(new Paragraph("", fontSize_8_normal));
//            }
//            sstable.addCell(scell);
//
//            document.add(sstable);
//
//            Paragraph gtitle = new Paragraph("1.General Information", fontSize_10_normal);
//            document.add(gtitle);
//
//            PdfPTable table = new PdfPTable(6); // 3 columns.
//            table.setWidthPercentage(100);
//            table.setSpacingBefore(10);
//            table.setSpacingAfter(10);
//
//            PdfPCell cell1 = new PdfPCell(new Paragraph("Government ID ", fontSize_8_bold));
//
//            PdfPCell governmentID = new PdfPCell(new Paragraph(generalInformation.getGovernmentId().getGovernmentId(), fontSize_8_normal));
//
//            PdfPCell cell2 = new PdfPCell(new Paragraph("Name", fontSize_8_bold));
//
//            PdfPCell name = new PdfPCell(new Paragraph(generalInformation.getName(), fontSize_8_normal));
//
//            PdfPCell cell3 = new PdfPCell(new Paragraph("Father's Name", fontSize_8_bold));
//
//            PdfPCell fathersname = new PdfPCell(new Paragraph(generalInformation.getFathersName(), fontSize_8_normal));
//
//            PdfPCell cell4 = new PdfPCell(new Paragraph("Mother's Name", fontSize_8_bold));
//
//            PdfPCell motherName = new PdfPCell(new Paragraph(generalInformation.getMothersName(), fontSize_8_normal));
//
//            PdfPCell cell5 = new PdfPCell(new Paragraph("Home District", fontSize_8_bold));
//
//            PdfPCell homeDistricts = new PdfPCell(new Paragraph(generalInformation.getHomeDistrict().toString(), fontSize_8_normal));
//
//            PdfPCell cell6 = new PdfPCell(new Paragraph("Date Of Birth", fontSize_8_bold));
//
//            PdfPCell dob = new PdfPCell(new Paragraph(generalInformation.getDateofBirth(), fontSize_8_normal));
//
//            PdfPCell cell7 = new PdfPCell(new Paragraph("Country Of Birth", fontSize_8_bold));
//
//            PdfPCell cob = new PdfPCell(new Paragraph(generalInformation.getBirthCountry().toString(), fontSize_8_normal));
//
//            PdfPCell cell8 = new PdfPCell(new Paragraph("Birth Certificate Number", fontSize_8_bold));
//
//            PdfPCell bcn = new PdfPCell(new Paragraph(generalInformation.getBirthCertificateNumber(), fontSize_8_normal));
//
//            PdfPCell cell9 = new PdfPCell(new Paragraph("Gender", fontSize_8_bold));
//
//            PdfPCell gender = new PdfPCell(new Paragraph(generalInformation.getGender().toString(), fontSize_8_normal));
//
//            PdfPCell cell10 = new PdfPCell(new Paragraph("Marital Status", fontSize_8_bold));
//
//            PdfPCell maritalstatus = new PdfPCell(new Paragraph(generalInformation.getMaritalStatus().toString(), fontSize_8_normal));
//
//            PdfPCell cell11 = new PdfPCell(new Paragraph("Religion", fontSize_8_bold));
//
//            PdfPCell religion = new PdfPCell(new Paragraph(generalInformation.getReligion().toString(), fontSize_8_normal));
//
//            PdfPCell cell12 = new PdfPCell(new Paragraph("Ethnic Identity", fontSize_8_bold));
//
//            PdfPCell ethnicidentity = new PdfPCell(new Paragraph(generalInformation.getEthnicIdentity().toString(), fontSize_8_normal));
//
//            PdfPCell cell13 = new PdfPCell(new Paragraph("Nationality", fontSize_8_bold));
//
//            PdfPCell nationality = new PdfPCell(new Paragraph(generalInformation.getNationality(), fontSize_8_normal));
//
//            PdfPCell cell14 = new PdfPCell(new Paragraph("Blood Group", fontSize_8_bold));
//
//            PdfPCell bloodgroup = new PdfPCell(new Paragraph(generalInformation.getBloodGroup().toString(), fontSize_8_normal));
//
//            PdfPCell cell15 = new PdfPCell(new Paragraph("Driving Licence", fontSize_8_bold));
//
//            PdfPCell drivingLicence = new PdfPCell(new Paragraph(generalInformation.getDrivingLicence(), fontSize_8_normal));
//
//            PdfPCell cell16 = new PdfPCell(new Paragraph("Passport No", fontSize_8_bold));
//
//            PdfPCell passportno = new PdfPCell(new Paragraph(generalInformation.getPassportNo(), fontSize_8_normal));
//
//            PdfPCell cell17 = new PdfPCell(new Paragraph("National Id No", fontSize_8_bold));
//
//            PdfPCell nid = new PdfPCell(new Paragraph(generalInformation.getNid(), fontSize_8_normal));
//
//            PdfPCell cell18 = new PdfPCell(new Paragraph("TIN No", fontSize_8_bold));
//
//            PdfPCell tin = new PdfPCell(new Paragraph(generalInformation.getTin(), fontSize_8_normal));
//
//            PdfPCell cell19 = new PdfPCell(new Paragraph("P.R.L.Date", fontSize_8_bold));
//
//            PdfPCell prldate = new PdfPCell(new Paragraph(generalInformation.getlPRDate().toString(), fontSize_8_normal));
//
//            PdfPCell cell20 = new PdfPCell(new Paragraph("Employee Status", fontSize_8_bold));
//
//            PdfPCell employeeStatus = new PdfPCell(new Paragraph(generalInformation.getEmployeeStatus().toString(), fontSize_8_normal));
//
//            table.addCell(cell1);
//            table.addCell(governmentID);
//            table.addCell(cell2);
//            table.addCell(name);
//            table.addCell(cell3);
//            table.addCell(fathersname);
//            table.addCell(cell4);
//
//            table.addCell(motherName);
//            table.addCell(cell5);
//
//            table.addCell(homeDistricts);
//
//            table.addCell(cell6);
//
//            table.addCell(dob);
//
//            table.addCell(cell7);
//
//            table.addCell(cob);
//
//            table.addCell(cell8);
//
//            table.addCell(bcn);
//
//            table.addCell(cell9);
//
//            table.addCell(gender);
//
//            table.addCell(cell10);
//
//            table.addCell(maritalstatus);
//
//            table.addCell(cell11);
//
//            table.addCell(religion);
//
//            table.addCell(cell12);
//
//            table.addCell(ethnicidentity);
//
//            table.addCell(cell13);
//
//            table.addCell(nationality);
//
//            table.addCell(cell14);
//
//            table.addCell(bloodgroup);
//
//            table.addCell(cell15);
//
//            table.addCell(drivingLicence);
//
//            table.addCell(cell16);
//
//            table.addCell(passportno);
//
//            table.addCell(cell17);
//
//            table.addCell(nid);
//
//            table.addCell(cell18);
//
//            table.addCell(tin);
//
//            table.addCell(cell19);
//
//            table.addCell(prldate);
//
//            table.addCell(cell20);
//
//            table.addCell(employeeStatus);
//
//            document.add(table);
//
//            Paragraph addresstitle = new Paragraph("2. Address", fontSize_10_normal);
//            document.add(addresstitle);
//
//            if (!addressInformation.isEmpty()) {
//
//                PdfPTable addresstable = new PdfPTable(9); // 3 columns.
//
//                addresstable.setWidthPercentage(100);
//
//                addresstable.setSpacingBefore(10);
//
//                addresstable.setSpacingAfter(10);
//
//                PdfPCell addressType = new PdfPCell(new Paragraph("Address Type", fontSize_8_bold));
//                addresstable.addCell(addressType);
//
//                PdfPCell vill = new PdfPCell(new Paragraph("Vill/ Road", fontSize_8_bold));
//                addresstable.addCell(vill);
//
//                PdfPCell post = new PdfPCell(new Paragraph("Post Office", fontSize_8_bold));
//                addresstable.addCell(post);
//
//                PdfPCell district = new PdfPCell(new Paragraph("District", fontSize_8_bold));
//                addresstable.addCell(district);
//
//                PdfPCell upzilla = new PdfPCell(new Paragraph("upzilla", fontSize_8_bold));
//                addresstable.addCell(upzilla);
//
//                PdfPCell email = new PdfPCell(new Paragraph("Email", fontSize_8_bold));
//                addresstable.addCell(email);
//
//                PdfPCell mobile = new PdfPCell(new Paragraph("mobile", fontSize_8_bold));
//                addresstable.addCell(mobile);
//
//                PdfPCell telephone = new PdfPCell(new Paragraph("Telephone", fontSize_8_bold));
//                addresstable.addCell(telephone);
//
//                PdfPCell fax = new PdfPCell(new Paragraph("Fax", fontSize_8_bold));
//                addresstable.addCell(fax);
//
//                for (AddressInformation addresslist : addressInformation) {
//
//                    PdfPCell cell;
//                    cell = new PdfPCell(new Paragraph(addresslist.getAddressType().toString(), fontSize_8_normal));
//                    addresstable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(addresslist.getVillage(), fontSize_8_normal));
//                    addresstable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(addresslist.getPostOffice(), fontSize_8_normal));
//                    addresstable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(addresslist.getDistrict().toString(), fontSize_8_normal));
//                    addresstable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(addresslist.getUpazila().getName(), fontSize_8_normal));
//                    addresstable.addCell(cell);
//                    cell = new PdfPCell(new Paragraph(addresslist.getEmail(), fontSize_8_normal));
//                    addresstable.addCell(cell);
//                    cell = new PdfPCell(new Paragraph(addresslist.getMobile(), fontSize_8_normal));
//                    addresstable.addCell(cell);
//                    cell = new PdfPCell(new Paragraph(addresslist.getTelphone(), fontSize_8_normal));
//                    addresstable.addCell(cell);
//                    cell = new PdfPCell(new Paragraph(addresslist.getFax(), fontSize_8_normal));
//                    addresstable.addCell(cell);
//                }
//
////                PdfPCell cell;
////                cell = new PdfPCell(new Paragraph("sumon", fontSize_8_normal));
////                addresstable.addCell(cell);
//                document.add(addresstable);
//
//            } else {
//
//                Paragraph emptyAddress = new Paragraph("Sorry!The address's information is not found.", fontSize_10_normal);
//                document.add(emptyAddress);
//
//            }
//
//            Paragraph spoustitle = new Paragraph("3.Spouse Information", fontSize_10_normal);
//            document.add(spoustitle);
//
//            if (!spousName.isEmpty()) {
//
//                PdfPTable spouseTable = new PdfPTable(9); // 3 columns.
//
//                spouseTable.setWidthPercentage(100);
//
//                spouseTable.setSpacingBefore(10);
//
//                spouseTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Name", fontSize_8_bold));
//                spouseTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("National Id No", fontSize_8_bold));
//                spouseTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Date of Marriage", fontSize_8_bold));
//                spouseTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Marriage Registration No", fontSize_8_bold));
//                spouseTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Passport No", fontSize_8_bold));
//                spouseTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Occupation", fontSize_8_bold));
//                spouseTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Organization", fontSize_8_bold));
//                spouseTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Designation", fontSize_8_bold));
//                spouseTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Location", fontSize_8_bold));
//                spouseTable.addCell(cell);
//
//                for (SpousName spouslist : spousName) {
//
//                    cell = new PdfPCell(new Paragraph(spouslist.getSpouseName(), fontSize_8_bold));
//                    spouseTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(spouslist.getNid(), fontSize_8_bold));
//                    spouseTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(spouslist.getDateofMarriage(), fontSize_8_bold));
//                    spouseTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(spouslist.getMarriageRegistrationNo(), fontSize_8_bold));
//                    spouseTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(spouslist.getPassportNo(), fontSize_8_bold));
//                    spouseTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(spouslist.getOccupation(), fontSize_8_bold));
//                    spouseTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(spouslist.getOrganization(), fontSize_8_bold));
//                    spouseTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(spouslist.getDesignation(), fontSize_8_bold));
//                    spouseTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(spouslist.getLocation(), fontSize_8_bold));
//                    spouseTable.addCell(cell);
//
//                }
//
//                document.add(spouseTable);
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry!The Spouse's information is not found.", fontSize_10_normal);
//                document.add(emptyvalue);
//            }
//
//            Paragraph childrentitle = new Paragraph("4.Children  Information", fontSize_10_normal);
//            document.add(childrentitle);
//
//            if (!childrenInformation.isEmpty()) {
//
//                PdfPTable childTable = new PdfPTable(10); // 3 columns.
//
//                childTable.setWidthPercentage(100);
//
//                childTable.setSpacingBefore(10);
//
//                childTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Name", fontSize_8_bold));
//                childTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Gender", fontSize_8_bold));
//                childTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Date of Birth", fontSize_8_bold));
//                childTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Birth Certificate No ", fontSize_8_bold));
//                childTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Psychical Status", fontSize_8_bold));
//                childTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Schooling", fontSize_8_bold));
//                childTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Education Level", fontSize_8_bold));
//                childTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Marital Status", fontSize_8_bold));
//                childTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Employment", fontSize_8_bold));
//                childTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Remarks", fontSize_8_bold));
//                childTable.addCell(cell);
//
//                for (ChildrenInformation childrenList : childrenInformation) {
//
//                    cell = new PdfPCell(new Paragraph(childrenList.getChildName(), fontSize_8_bold));
//                    childTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(childrenList.getGender().toString(), fontSize_8_bold));
//                    childTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(childrenList.getDateofBirth(), fontSize_8_bold));
//                    childTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(childrenList.getBirthCertificateNumber(), fontSize_8_bold));
//                    childTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(childrenList.getPsychicalStatus().toString(), fontSize_8_bold));
//                    childTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(childrenList.getSchooling().toString(), fontSize_8_bold));
//                    childTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(childrenList.getEducationLevel(), fontSize_8_bold));
//                    childTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(childrenList.getMaritalStatus().toString(), fontSize_8_bold));
//                    childTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(childrenList.getEmplyment().toString(), fontSize_8_bold));
//                    childTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(childrenList.getRemarks(), fontSize_8_bold));
//                    childTable.addCell(cell);
//
//                }
//
//                document.add(childTable);
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! The childrean's information is not found.", fontSize_10_normal);
//                document.add(emptyvalue);
//            }
//
//            Paragraph educationtitle = new Paragraph("5.Education Information", fontSize_10_normal);
//            document.add(educationtitle);
//
//            if (!childrenInformation.isEmpty()) {
//
//                PdfPTable eduTable = new PdfPTable(9); // 3 columns.
//
//                eduTable.setWidthPercentage(100);
//
//                eduTable.setSpacingBefore(10);
//
//                eduTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Name of Institution ", fontSize_8_bold));
//                eduTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Principal Subject", fontSize_8_bold));
//                eduTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Certificate / Degree", fontSize_8_bold));
//                eduTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Year ", fontSize_8_bold));
//                eduTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Board or University", fontSize_8_bold));
//                eduTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Division / Class", fontSize_8_bold));
//                eduTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("GPA", fontSize_8_bold));
//                eduTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("GPA Point", fontSize_8_bold));
//                eduTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Distinction", fontSize_8_bold));
//                eduTable.addCell(cell);
//
//                for (EducationalInformation educationList : educationalInformation) {
//
//                    cell = new PdfPCell(new Paragraph(educationList.getNameOfInstitution(), fontSize_8_bold));
//                    eduTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(educationList.getPrincipalSubject(), fontSize_8_bold));
//                    eduTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(educationList.getCertificateDegree(), fontSize_8_bold));
//                    eduTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(educationList.getYear(), fontSize_8_bold));
//                    eduTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(educationList.getBoardoruniversity().toString(), fontSize_8_bold));
//                    eduTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(educationList.getDivisionClass(), fontSize_8_bold));
//                    eduTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(educationList.getgPA(), fontSize_8_bold));
//                    eduTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(educationList.getgPAPoint(), fontSize_8_bold));
//                    eduTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(educationList.getDistinction(), fontSize_8_bold));
//                    eduTable.addCell(cell);
//                }
//
//                document.add(eduTable);
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! The education's information is not found.", fontSize_10_normal);
//                document.add(emptyvalue);
//            }
//
//            Paragraph additionaltitle = new Paragraph("6.Additional Qualifications", fontSize_10_normal);
//            document.add(additionaltitle);
//
//            if (!additionalQualification.isEmpty()) {
//
//                PdfPTable addiTable = new PdfPTable(1); // 3 columns.
//
//                addiTable.setWidthPercentage(100);
//
//                addiTable.setSpacingBefore(10);
//
//                addiTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Qualifications", fontSize_8_bold));
//                addiTable.addCell(cell);
//
//                for (AdditionalQualification additionalQualificationlist : additionalQualification) {
//                    cell = new PdfPCell(new Paragraph(additionalQualificationlist.getQualification(), fontSize_8_normal));
//                    addiTable.addCell(cell);
//                }
//
//                document.add(addiTable);
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! The  Additional Qualification is not found.", fontSize_10_normal);
//                document.add(emptyvalue);
//            }
//
//            Paragraph languagetitle = new Paragraph("7.Language Information ", fontSize_10_normal);
//            document.add(languagetitle);
//
//            if (!languageInformation.isEmpty()) {
//
//                PdfPTable langTable = new PdfPTable(3); // 3 columns.
//
//                langTable.setWidthPercentage(100);
//
//                langTable.setSpacingBefore(10);
//
//                langTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Language", fontSize_8_bold));
//                langTable.addCell(cell);
//                cell = new PdfPCell(new Paragraph("Skill", fontSize_8_bold));
//                langTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Proficiency", fontSize_8_bold));
//                langTable.addCell(cell);
//
//                for (LanguageInformation languageList : languageInformation) {
//                    cell = new PdfPCell(new Paragraph(languageList.getLanguage().toString(), fontSize_8_normal));
//                    langTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(languageList.getSkill().toString(), fontSize_8_normal));
//                    langTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(languageList.getProficiency().toString(), fontSize_8_normal));
//                    langTable.addCell(cell);
//                }
//
//                document.add(langTable);
//
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! The  language information   is not found.", fontSize_10_normal);
//
//                emptyvalue.setSpacingAfter(10);
//
//                emptyvalue.setSpacingBefore(10);
//
//                document.add(emptyvalue);
//
//            }
//
//            Paragraph jobentrytitle = new Paragraph("8.Job Entry Process", fontSize_10_normal);
//            document.add(jobentrytitle);
//
//            if (jobentryprocess != null) {
//
//                PdfPTable firstJobTable = new PdfPTable(6); // 3 columns.
//
//                firstJobTable.setWidthPercentage(100);
//
//                firstJobTable.setSpacingBefore(10);
//
//                firstJobTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Authority", fontSize_8_bold));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(jobentryprocess.getAuthority().toString(), fontSize_8_normal));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Designation", fontSize_8_bold));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(jobentryprocess.getDesignation().getName(), fontSize_8_normal));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Exam Type", fontSize_8_bold));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(jobentryprocess.getExamType().toString(), fontSize_8_normal));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Grade ", fontSize_8_bold));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(jobentryprocess.getGrade().toString(), fontSize_8_normal));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Batch ", fontSize_8_bold));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(jobentryprocess.getBatch(), fontSize_8_normal));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Exam Title ", fontSize_8_bold));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(jobentryprocess.getExamTitle(), fontSize_8_normal));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Exam Government Order No", fontSize_8_bold));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(jobentryprocess.getExamGovernmentOrderNo(), fontSize_8_normal));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Exam Date ", fontSize_8_bold));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(jobentryprocess.getExamDate(), fontSize_8_normal));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Result Date  ", fontSize_8_bold));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(jobentryprocess.getResultDate(), fontSize_8_normal));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Merit No ", fontSize_8_bold));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(jobentryprocess.getMeritNo(), fontSize_8_normal));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Selection Type", fontSize_8_bold));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(jobentryprocess.getSelectionType().toString(), fontSize_8_normal));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Quota", fontSize_8_bold));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(jobentryprocess.getQuota().toString(), fontSize_8_normal));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Job Confirmation Date", fontSize_8_bold));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(jobentryprocess.getJobConfirmationDate(), fontSize_8_normal));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Job Confirmation Order No", fontSize_8_bold));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(jobentryprocess.getJobConfirmationOrderNo(), fontSize_8_normal));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Job Confirmation Serial No", fontSize_8_bold));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(jobentryprocess.getJobConfirmationSerialNo(), fontSize_8_normal));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Freedom Fighter Certificate No ", fontSize_8_bold));
//                firstJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(jobentryprocess.getFreedomFighterCertificateNo(), fontSize_8_normal));
//                firstJobTable.addCell(cell);
//
//                document.add(firstJobTable);
//
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! The first Job  is not found.", fontSize_10_normal);
//
//                emptyvalue.setSpacingAfter(10);
//
//                emptyvalue.setSpacingBefore(10);
//
//                document.add(emptyvalue);
//            }
//
//            Paragraph presentJobtitle = new Paragraph("10.Present Job", fontSize_10_normal);
//            document.add(presentJobtitle);
//
//            if (presentjob != null) {
//
//                PdfPTable presentJobTable = new PdfPTable(8); // 3 columns.
//
//                presentJobTable.setWidthPercentage(100);
//
//                presentJobTable.setSpacingBefore(10);
//
//                presentJobTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Posting Reason", fontSize_8_bold));
//                presentJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Posting Type", fontSize_8_bold));
//                presentJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Designation", fontSize_8_bold));
//                presentJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Office Location", fontSize_8_bold));
//                presentJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Joining Date", fontSize_8_bold));
//                presentJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Date of Gazetted   ", fontSize_8_bold));
//                presentJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Grade  ", fontSize_8_bold));
//                presentJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Remarks ", fontSize_8_bold));
//                presentJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(presentjob.getPostingReason().name(), fontSize_8_normal));
//                presentJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(presentjob.getPostingType().name().toString(), fontSize_8_normal));
//                presentJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(presentjob.getPostingDesignation().getName(), fontSize_8_normal));
//                presentJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(presentjob.getPresentPostingLocation().getName(), fontSize_8_normal));
//                presentJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(presentjob.getDateJoining(), fontSize_8_normal));
//                presentJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(presentjob.getDateofGazetted(), fontSize_8_normal));
//                presentJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(presentjob.getGrade(), fontSize_8_normal));
//                presentJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(presentjob.getRemarks(), fontSize_8_normal));
//                presentJobTable.addCell(cell);
//
//                document.add(presentJobTable);
//
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! The first Job  is not found.", fontSize_10_normal);
//
//                emptyvalue.setSpacingAfter(10);
//
//                emptyvalue.setSpacingBefore(10);
//
//                document.add(emptyvalue);
//            }
//
//            Paragraph postingRecordtitle = new Paragraph("11.Posting Record Information", fontSize_10_normal);
//            document.add(postingRecordtitle);
//
//            if (!postingRecordInformation.isEmpty()) {
//
//                PdfPTable pReordJobTable = new PdfPTable(8); // 3 columns.
//
//                pReordJobTable.setWidthPercentage(100);
//
//                pReordJobTable.setSpacingBefore(10);
//
//                pReordJobTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Posting Reason", fontSize_8_bold));
//                pReordJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Posting Type", fontSize_8_bold));
//                pReordJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Designation", fontSize_8_bold));
//                pReordJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Office Location", fontSize_8_bold));
//                pReordJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Country", fontSize_8_bold));
//                pReordJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Period From", fontSize_8_bold));
//                pReordJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Period To   ", fontSize_8_bold));
//                pReordJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Grade  ", fontSize_8_bold));
//                pReordJobTable.addCell(cell);
//
//                for (PostingRecordInformation postingRecordList : postingRecordInformation) {
//
//                    cell = new PdfPCell(new Paragraph(postingRecordList.getPostingReason().name(), fontSize_8_normal));
//                    pReordJobTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(postingRecordList.getPostingType().name().toString(), fontSize_8_normal));
//                    pReordJobTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(postingRecordList.getPostingDesignation().getName(), fontSize_8_normal));
//                    pReordJobTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(postingRecordList.getPostingLocation().getName(), fontSize_8_normal));
//                    pReordJobTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(postingRecordList.getCountry().name(), fontSize_8_normal));
//                    pReordJobTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(postingRecordList.getPeriodFrom(), fontSize_8_normal));
//                    pReordJobTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(postingRecordList.getPeriodTo(), fontSize_8_normal));
//                    pReordJobTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(postingRecordList.getScale(), fontSize_8_normal));
//                    pReordJobTable.addCell(cell);
//
//                }
//
//                document.add(pReordJobTable);
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! The first Job  is not found.", fontSize_10_normal);
//
//                emptyvalue.setSpacingAfter(10);
//
//                emptyvalue.setSpacingBefore(10);
//
//                document.add(emptyvalue);
//            }
//
//            Paragraph promotionstitle = new Paragraph("12.Promotions Information", fontSize_10_normal);
//            document.add(promotionstitle);
//
//            if (!promotionsInformation.isEmpty()) {
//
//                PdfPTable pReordJobTable = new PdfPTable(8); // 3 columns.
//
//                pReordJobTable.setWidthPercentage(100);
//
//                pReordJobTable.setSpacingBefore(10);
//
//                pReordJobTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Date of Promotion", fontSize_8_bold));
//                pReordJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Govt Order Date", fontSize_8_bold));
//                pReordJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Nature Of Promotions", fontSize_8_bold));
//                pReordJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Posting Type", fontSize_8_bold));
//                pReordJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Designation", fontSize_8_bold));
//                pReordJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Office Location", fontSize_8_bold));
//                pReordJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Country   ", fontSize_8_bold));
//                pReordJobTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Grade  ", fontSize_8_bold));
//                pReordJobTable.addCell(cell);
//
//                for (PromotionsInformation promotionsList : promotionsInformation) {
//
//                    cell = new PdfPCell(new Paragraph(promotionsList.getDateofPromotion(), fontSize_8_normal));
//                    pReordJobTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(promotionsList.getGovtOrderDate().toString(), fontSize_8_normal));
//                    pReordJobTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(promotionsList.getNatureOfPromotions().toString(), fontSize_8_normal));
//                    pReordJobTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(promotionsList.getPostingType().toString(), fontSize_8_normal));
//                    pReordJobTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(promotionsList.getPostingDesignation().getName(), fontSize_8_normal));
//                    pReordJobTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(promotionsList.getPostingLocation().getName(), fontSize_8_normal));
//                    pReordJobTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(promotionsList.getCountry().toString(), fontSize_8_normal));
//                    pReordJobTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(promotionsList.getScale(), fontSize_8_normal));
//                    pReordJobTable.addCell(cell);
//
//                }
//                document.add(pReordJobTable);
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! The first Job  is not found.", fontSize_10_normal);
//
//                emptyvalue.setSpacingAfter(10);
//
//                emptyvalue.setSpacingBefore(10);
//
//                document.add(emptyvalue);
//            }
//
//            Paragraph magisterialtitle = new Paragraph("13.Magisterial Power", fontSize_10_normal);
//            document.add(magisterialtitle);
//
//            if (!magisterialPower.isEmpty()) {
//
//                PdfPTable mgTable = new PdfPTable(2); // 3 columns.
//
//                mgTable.setWidthPercentage(100);
//
//                mgTable.setSpacingBefore(10);
//
//                mgTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("From", fontSize_8_bold));
//                mgTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("To", fontSize_8_bold));
//                mgTable.addCell(cell);
//
//                for (MagisterialPower magisterialPowerList : magisterialPower) {
//                    cell = new PdfPCell(new Paragraph(magisterialPowerList.getFromDate(), fontSize_8_normal));
//                    mgTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(magisterialPowerList.getEndDate(), fontSize_8_normal));
//                    mgTable.addCell(cell);
//                }
//                document.add(mgTable);
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! no information   is found.", fontSize_10_normal);
//
//                emptyvalue.setSpacingAfter(10);
//
//                emptyvalue.setSpacingBefore(10);
//
//                document.add(emptyvalue);
//
//            }
//
//            Paragraph selectiontitle = new Paragraph("14.Selection Grade Information ", fontSize_10_normal);
//            document.add(selectiontitle);
//
//            if (!magisterialPower.isEmpty()) {
//
//                PdfPTable mgTable = new PdfPTable(8); // 3 columns.
//
//                mgTable.setWidthPercentage(100);
//
//                mgTable.setSpacingBefore(10);
//
//                mgTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Date of Promotion", fontSize_8_bold));
//                mgTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Gov't Order Date", fontSize_8_bold));
//                mgTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Nature Of Promotions", fontSize_8_bold));
//                mgTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Posting Type", fontSize_8_bold));
//                mgTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Designation", fontSize_8_bold));
//                mgTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Office Location", fontSize_8_bold));
//                mgTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Country", fontSize_8_bold));
//                mgTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Grade", fontSize_8_bold));
//                mgTable.addCell(cell);
//
//                for (SelectionGrade selectionGradeList : selectionGrade) {
//
//                    cell = new PdfPCell(new Paragraph(selectionGradeList.getDateofPromotion(), fontSize_8_bold));
//                    mgTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(selectionGradeList.getGovtOrderDate(), fontSize_8_bold));
//                    mgTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(selectionGradeList.getNatureOfPromotions().toString(), fontSize_8_bold));
//                    mgTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(selectionGradeList.getPostingType().toString(), fontSize_8_bold));
//                    mgTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(selectionGradeList.getPostingDesignation().getName(), fontSize_8_bold));
//                    mgTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(selectionGradeList.getPostingLocation().getName(), fontSize_8_bold));
//                    mgTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(selectionGradeList.getCountry().toString(), fontSize_8_bold));
//                    mgTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(selectionGradeList.getScale(), fontSize_8_bold));
//                    mgTable.addCell(cell);
//                }
//                document.add(mgTable);
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! no information   is found.", fontSize_10_normal);
//
//                emptyvalue.setSpacingAfter(10);
//
//                emptyvalue.setSpacingBefore(10);
//
//                document.add(emptyvalue);
//
//            }
//
//            Paragraph postingAbroadtitle = new Paragraph("15.Posting Abroad Information", fontSize_10_normal);
//            document.add(postingAbroadtitle);
//
//            if (!postingAbroadInformation.isEmpty()) {
//
//                PdfPTable paTable = new PdfPTable(7); // 3 columns.
//
//                paTable.setWidthPercentage(100);
//
//                paTable.setSpacingBefore(10);
//
//                paTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Posting Type", fontSize_8_bold));
//                paTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Designation", fontSize_8_bold));
//                paTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Office Location", fontSize_8_bold));
//                paTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Country", fontSize_8_bold));
//                paTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Period From", fontSize_8_bold));
//                paTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Period To", fontSize_8_bold));
//                paTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Scale/Grade", fontSize_8_bold));
//                paTable.addCell(cell);
//
//                for (PostingAbroadInformation postingAbroadList : postingAbroadInformation) {
//
//                    cell = new PdfPCell(new Paragraph(postingAbroadList.getPostingType().toString(), fontSize_8_normal));
//                    paTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(postingAbroadList.getPostingDesignation().getName(), fontSize_8_normal));
//                    paTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(postingAbroadList.getPostingLocation().getName(), fontSize_8_normal));
//                    paTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(postingAbroadList.getCountry().toString(), fontSize_8_normal));
//                    paTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(postingAbroadList.getPeriodFrom(), fontSize_8_normal));
//                    paTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(postingAbroadList.getPeriodTo(), fontSize_8_normal));
//                    paTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(postingAbroadList.getScale(), fontSize_8_normal));
//                    paTable.addCell(cell);
//                }
//                document.add(paTable);
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! no information   is found.", fontSize_10_normal);
//
//                emptyvalue.setSpacingAfter(10);
//
//                emptyvalue.setSpacingBefore(10);
//
//                document.add(emptyvalue);
//
//            }
//
//            Paragraph foreigntitle = new Paragraph("16.Foreign Training", fontSize_10_normal);
//            document.add(foreigntitle);
//
//            if (!foreignTrainingInformation.isEmpty()) {
//
//                PdfPTable ftTable = new PdfPTable(6); // 3 columns.
//
//                ftTable.setWidthPercentage(100);
//
//                ftTable.setSpacingBefore(10);
//
//                ftTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Training Title", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Country", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Training Institute", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Position", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Period From", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Period To", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                for (ForeignTrainingInformation foreignTrainingList : foreignTrainingInformation) {
//
//                    cell = new PdfPCell(new Paragraph(foreignTrainingList.getTypeofTraining(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(foreignTrainingList.getCountry(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(foreignTrainingList.getTrainingInstitute(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(foreignTrainingList.getPosition(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(foreignTrainingList.getPeriodFrom(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(foreignTrainingList.getPeriodTo(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                }
//                document.add(ftTable);
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! no information   is found.", fontSize_10_normal);
//
//                emptyvalue.setSpacingAfter(10);
//
//                emptyvalue.setSpacingBefore(10);
//
//                document.add(emptyvalue);
//
//            }
//
//            Paragraph inServicetitle = new Paragraph("17.In Service Training", fontSize_10_normal);
//            document.add(inServicetitle);
//
//            if (!inServiceTrainingInformation.isEmpty()) {
//
//                PdfPTable ftTable = new PdfPTable(6); // 3 columns.
//
//                ftTable.setWidthPercentage(100);
//
//                ftTable.setSpacingBefore(10);
//
//                ftTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Training Title", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Training Type", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Training Institute", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Position", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Period From", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Period To", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                for (InServiceTrainingInformation inServiceTrainingList : inServiceTrainingInformation) {
//
//                    cell = new PdfPCell(new Paragraph(inServiceTrainingList.getTrainingTitle(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(inServiceTrainingList.getTrainingType(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(inServiceTrainingList.getTrainingInstitute(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(inServiceTrainingList.getPosition(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(inServiceTrainingList.getPeriodFrom(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(inServiceTrainingList.getPeriodTo(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                }
//                document.add(ftTable);
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! no information   is found.", fontSize_10_normal);
//
//                emptyvalue.setSpacingAfter(10);
//
//                emptyvalue.setSpacingBefore(10);
//
//                document.add(emptyvalue);
//
//            }
//
//            Paragraph othertitle = new Paragraph("18.Other Service", fontSize_10_normal);
//            document.add(othertitle);
//
//            if (!otherServiceInformation.isEmpty()) {
//
//                PdfPTable ftTable = new PdfPTable(6); // 3 columns.
//
//                ftTable.setWidthPercentage(100);
//
//                ftTable.setSpacingBefore(10);
//
//                ftTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Name of the Employer", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Address", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Type of Service", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Position", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Period From", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Period From", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                for (OtherServiceInformation otherServiceList : otherServiceInformation) {
//
//                    cell = new PdfPCell(new Paragraph(otherServiceList.getNameoftheEmployer(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(otherServiceList.getAddress(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(otherServiceList.getTypeofService(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(otherServiceList.getPosition(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(otherServiceList.getPeriodFrom(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(otherServiceList.getPeriodTo(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                }
//                document.add(ftTable);
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! no information   is found.", fontSize_10_normal);
//
//                emptyvalue.setSpacingAfter(10);
//
//                emptyvalue.setSpacingBefore(10);
//
//                document.add(emptyvalue);
//
//            }
//
//            Paragraph honorstitle = new Paragraph("19.Honors and Award", fontSize_10_normal);
//            document.add(honorstitle);
//
//            if (!honorsAndAwardInformation.isEmpty()) {
//
//                PdfPTable ftTable = new PdfPTable(2); // 3 columns.
//
//                ftTable.setWidthPercentage(100);
//
//                ftTable.setSpacingBefore(10);
//
//                ftTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Title of Award ", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Ground", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                for (HonorsAndAwardInformation honorsAndAwardList : honorsAndAwardInformation) {
//
//                    cell = new PdfPCell(new Paragraph(honorsAndAwardList.getTitleOfAward(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(honorsAndAwardList.getGround(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                }
//                document.add(ftTable);
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! no information   is found.", fontSize_10_normal);
//
//                emptyvalue.setSpacingAfter(10);
//
//                emptyvalue.setSpacingBefore(10);
//
//                document.add(emptyvalue);
//
//            }
//
//            Paragraph disciplinarytitle = new Paragraph("20.Disciplinary Action", fontSize_10_normal);
//            document.add(disciplinarytitle);
//
//            if (!disciplinaryAction.isEmpty()) {
//
//                PdfPTable ftTable = new PdfPTable(4); // 3 columns.
//
//                ftTable.setWidthPercentage(100);
//
//                ftTable.setSpacingBefore(10);
//
//                ftTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Nature of Offence  ", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Punishment Nature", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Punishment ", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Order Date:", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                for (DisciplinaryActionDetails disciplinaryActionlist : disciplinaryAction) {
//
//                    cell = new PdfPCell(new Paragraph(disciplinaryActionlist.getNatureofOffence(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(disciplinaryActionlist.getPunishmentNature(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(disciplinaryActionlist.getPunishment(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    //cell = new PdfPCell(new Paragraph(disciplinaryActionlist.getOderDate(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                }
//                document.add(ftTable);
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! no information   is found.", fontSize_10_normal);
//
//                emptyvalue.setSpacingAfter(10);
//
//                emptyvalue.setSpacingBefore(10);
//
//                document.add(emptyvalue);
//
//            }
//
//            Paragraph leavetitle = new Paragraph("21.Leave Information ", fontSize_10_normal);
//            document.add(leavetitle);
//
//            if (!leaveinfo.isEmpty()) {
//
//                PdfPTable ftTable = new PdfPTable(8); // 3 columns.
//
//                ftTable.setWidthPercentage(100);
//
//                ftTable.setSpacingBefore(10);
//
//                ftTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Government Order No  ", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Leave Type", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Leave Approved Length ", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Leave Start Date", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Join Date", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Total Enjoy Day", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Status", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Remark", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                for (Leaveinfo leavelist : leaveinfo) {
//
//                    cell = new PdfPCell(new Paragraph(leavelist.getGovernmentOrderNo(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(leavelist.getLeaveType().toString(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(leavelist.getLeaveApprovedLength(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(leavelist.getLeaveStartDate(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(leavelist.getJoinDate(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(leavelist.getTotalEnjoyDay(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(leavelist.getStatus().toString(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(leavelist.getRemark(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                }
//                document.add(ftTable);
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! no information   is found.", fontSize_10_normal);
//
//                emptyvalue.setSpacingAfter(10);
//
//                emptyvalue.setSpacingBefore(10);
//
//                document.add(emptyvalue);
//
//            }
//
//            Paragraph publicationstitle = new Paragraph("22.Publications Information  ", fontSize_10_normal);
//            document.add(publicationstitle);
//
//            if (!publicationInformation.isEmpty()) {
//
//                PdfPTable ftTable = new PdfPTable(3); // 3 columns.
//
//                ftTable.setWidthPercentage(100);
//
//                ftTable.setSpacingBefore(10);
//
//                ftTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Publication Type ", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Title", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Publication Year ", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                for (PublicationInformation publicationList : publicationInformation) {
//
//                    cell = new PdfPCell(new Paragraph(publicationList.getPublicationType(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(publicationList.getTitle(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(publicationList.getPublicationYear(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                }
//                document.add(ftTable);
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! no information   is found.", fontSize_10_normal);
//
//                emptyvalue.setSpacingAfter(10);
//
//                emptyvalue.setSpacingBefore(10);
//
//                document.add(emptyvalue);
//
//            }
//
//            Paragraph professionaltitle = new Paragraph("23.Professional Organization Membership  ", fontSize_10_normal);
//            document.add(professionaltitle);
//
//            if (!membership.isEmpty()) {
//
//                PdfPTable ftTable = new PdfPTable(5); // 3 columns.
//
//                ftTable.setWidthPercentage(100);
//
//                ftTable.setSpacingBefore(10);
//
//                ftTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("Regulatory Body ", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Registration No", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Registration Date", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Last Renewal Date", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Remarks", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                for (Membership membershiplist : membership) {
//
//                    cell = new PdfPCell(new Paragraph(membershiplist.getRegulatoryBody(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(membershiplist.getRegistrationNo(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(membershiplist.getRegistrationDate(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(membershiplist.getLastRenewaalDate(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//
//                    cell = new PdfPCell(new Paragraph(membershiplist.getRemarks(), fontSize_8_normal));
//                    ftTable.addCell(cell);
//                }
//                document.add(ftTable);
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! no information   is found.", fontSize_10_normal);
//
//                emptyvalue.setSpacingAfter(10);
//
//                emptyvalue.setSpacingBefore(10);
//
//                document.add(emptyvalue);
//
//            }
//
//            Paragraph retirementtitle = new Paragraph("24.Retirement and Pension  ", fontSize_10_normal);
//            document.add(retirementtitle);
//
//            if (retirementpension != null) {
//
//                PdfPTable ftTable = new PdfPTable(5); // 3 columns.
//
//                ftTable.setWidthPercentage(100);
//
//                ftTable.setSpacingBefore(10);
//
//                ftTable.setSpacingAfter(10);
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Paragraph("P.R.L Date ", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Retirement Type", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Start Date", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Nominee", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph("Remarks", fontSize_8_bold));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(retirementpension.getLprDate(), fontSize_8_normal));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(retirementpension.getRetirementType().toString(), fontSize_8_normal));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(retirementpension.getStartDate(), fontSize_8_normal));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(retirementpension.getNominee(), fontSize_8_normal));
//                ftTable.addCell(cell);
//
//                cell = new PdfPCell(new Paragraph(retirementpension.getRemarks(), fontSize_8_normal));
//                ftTable.addCell(cell);
//
//                document.add(ftTable);
//            } else {
//
//                Paragraph emptyvalue = new Paragraph("Sorry! no information   is found.", fontSize_10_normal);
//
//                emptyvalue.setSpacingAfter(10);
//
//                emptyvalue.setSpacingBefore(10);
//
//                document.add(emptyvalue);
//
//            }
//
//            // step 4
////            document.add(new Paragraph(String.format(
////                    "You have submitted the following text using the %s method:",
////                    request.getMethod())));
////            document.add(new Paragraph(text));
//            // step 5
//            document.close();
//
//            // setting some response headers
//            response.setHeader("Expires", "0");
//            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
//            response.setHeader("Pragma", "public");
//            // setting the content type
//            response.setContentType("application/pdf");
//            // the contentlength
//            response.setContentLength(baos.size());
//            response.setHeader("Content-disposition", "inline; " + "filename=" + pdfFileName);
//            // write ByteArrayOutputStream to the ServletOutputStream
//            OutputStream os = response.getOutputStream();
//            baos.writeTo(os);
//            os.flush();
//            os.close();
//        } catch (DocumentException e) {
//            throw new IOException(e.getMessage());
//        }
    }

    //@RequestMapping(value = "/downloadpdf/{e_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
//    @ResponseBody
//    public void demo(Model model, @PathVariable Long e_id, HttpServletRequest request, HttpServletResponse response) throws com.itextpdf.text.DocumentException, IOException {
//
//        String pdfFileName = "city_pdf.pdf";
//
//        try {
//            // Get the text that will be added to the PDF
//            String text = request.getParameter("text");
//            if (text == null || text.trim().length() == 0) {
//                text = "You didn't enter any text.";
//            }
//            // step 1
//            Document document = new Document();
//            // step 2
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            PdfWriter.getInstance(document, baos);
//            // step 3
//            document.open();
//
//            // step 4
//            document.add(new Paragraph(String.format(
//                    "You have submitted the following text using the %s method:",
//                    request.getMethod())));
//            document.add(new Paragraph(text));
//            // step 5
//            document.close();
//
//            // setting some response headers
//            response.setHeader("Expires", "0");
//            response.setHeader("Cache-Control",
//                    "must-revalidate, post-check=0, pre-check=0");
//            response.setHeader("Pragma", "public");
//            // setting the content type
//            response.setContentType("application/pdf");
//            // the contentlength
//            response.setContentLength(baos.size());
//            response.setHeader("Content-disposition", "inline; " + "filename=" + pdfFileName);
//            // write ByteArrayOutputStream to the ServletOutputStream
//            OutputStream os = response.getOutputStream();
//            baos.writeTo(os);
//            os.flush();
//            os.close();
//        } catch (DocumentException e) {
//            throw new IOException(e.getMessage());
//        }
//
//    }
}
