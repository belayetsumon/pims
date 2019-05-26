/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.selfservice;

import itgarden.model.ProfileImage;
import itgarden.model.Users;
import itgarden.repository.ProfileImageRepository;
import itgarden.repository.UsersRepository;
import itgarden.service.LoggedUserService;
import itgarden.service.StorageProperties;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/selfservice_profileimage")
public class ProfileImageSelfserviceController {

    @Autowired
    StorageProperties properties;

    @Autowired
    ProfileImageRepository profileImageRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, ProfileImage profileImage) {
        Users users = new Users();
        users.setId(e_id);
        model.addAttribute("list", profileImageRepository.findByGovernmentIdOrderByIdDesc(users));
        profileImage.setGovernmentId(users);
        return "pims/selfservice/profileimage";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, ProfileImage profileImage) {

        model.addAttribute("profileImage", profileImageRepository.getOne(id));
        model.addAttribute("list", profileImageRepository.findAll());
        Users users = new Users();
        users.setId(id);
        profileImage.setGovernmentId(users);
        return "pims/selfservice/profileimage";
    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model,
            @PathVariable Long e_id, @Valid ProfileImage profileImage, BindingResult bindingResult,
            @RequestParam("pic") MultipartFile pic, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("list", profileImageRepository.findAll());
            model.addAttribute("employee", usersRepository.findById(e_id));
            Users users = new Users();
            users.setId(e_id);
            profileImage.setGovernmentId(users);
             return "pims/selfservice/profileimage";
        }

        if (pic.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload");
             return "pims/selfservice/profileimage";
        }

        if (pic.getSize() > 150000) {
            model.addAttribute("message", "File size is learge. Please upload 150X150 px.file");
             return "pims/selfservice/profileimage";
        }

        if (!pic.isEmpty()) {
            try {
                byte[] bytes = pic.getBytes();

                // Creating the directory to store file
                File dir = new File(properties.getRootPath());
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + pic.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                model.addAttribute("message", "You successfully uploaded");

                profileImage.setImageName(pic.getOriginalFilename());

                profileImage.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
                
                profileImage.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());
                
                
                
                profileImageRepository.save(profileImage);

                redirectAttributes.addFlashAttribute("message", " Image successfully uploaded");

                return "redirect:/selfservice_profileimage/index/{e_id}";
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("message", pic.getOriginalFilename() + " => " + e.getMessage());
                return "redirect:/selfservice_profileimage/index/{e_id}";

            }
        } else {
            redirectAttributes.addFlashAttribute("message", "File empty");
            return "redirect:/selfservice_profileimage/index/{e_id}";
        }

    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, ProfileImage profileImage, RedirectAttributes redirectAttrs) {

       profileImage = profileImageRepository.getOne(id);

        File file = new File(properties.getRootPath() + File.separator + profileImage.getImageName());

        file.delete();

        redirectAttrs.addAttribute("e_id", profileImage.getGovernmentId());

        profileImageRepository.deleteById(id);

        return "redirect:/selfservice_profileimage/index/{e_id}";
    }

}
