/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.NhanVien;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import model.ModelNhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ControllerNhanVien {
    
    @RequestMapping("qlnhanvien")
    public String qlnhanvien(ModelMap model) {
        ModelNhanVien mnv = new ModelNhanVien();
        List<NhanVien> list = new ArrayList<NhanVien>();
        list = mnv.showNhanVien("");
        model.addAttribute("listNhanVien", list);

        NhanVien nv = new NhanVien();
        nv = list.get(0);
        model.addAttribute("nhanvien", nv);
        return "qlnhanvien";
    }

    @RequestMapping("editNV")
    public String edit(HttpServletRequest request, ModelMap model) {
        String id = request.getParameter("txtId");
        String name = request.getParameter("txtName");
        String gen = request.getParameter("txtGender");
        boolean gender;
        if (gen.equals("true")) {
            gender = true;
        } else {
            gender = false;
        }
        java.sql.Date bd = java.sql.Date.valueOf(request.getParameter("txtBirthday"));
        Date birthday = bd;
        String photo = request.getParameter("txtPhoto");
        String email = request.getParameter("txtEmail");
        String phone = request.getParameter("txtPhone");
        double salary = Double.parseDouble(request.getParameter("txtSalary"));
        String notes = request.getParameter("txtNotes");
        String departid = request.getParameter("txtDepartId");

        NhanVien nv = new NhanVien(id, name, gender, birthday, photo, email, phone, salary, notes, departid);
        model.addAttribute("nhanvien", nv);

        List<NhanVien> list = new ArrayList<NhanVien>();
        list = ModelNhanVien.showNhanVien("");
        model.addAttribute("listNhanVien", list);
        return "qlnhanvien";
    }

    @RequestMapping("deleteNV")
    public String delete(HttpServletRequest request, ModelMap model,
            @ModelAttribute("nhanvien") NhanVien nv) {
        String id = request.getParameter("txtId");
        ModelNhanVien.delete(id);
        List<NhanVien> list = new ArrayList<NhanVien>();
        list = ModelNhanVien.showNhanVien("");
        model.addAttribute("listNhanVien", list);
        nv = list.get(0);
        model.addAttribute("nhanvien", nv);
        return "qlnhanvien";
    }

    @Autowired
    ServletContext context;

    @RequestMapping(value = "xuli", params = "btnUpdateNV", method = RequestMethod.POST)
    public String update(@ModelAttribute("nhanvien") NhanVien nv, ModelMap model,
            @RequestParam("photo") MultipartFile photo) {
        ModelNhanVien.update(nv);
        List<NhanVien> list = new ArrayList<NhanVien>();
        list = ModelNhanVien.showNhanVien("");
        model.addAttribute("listNhanVien", list);
        model.addAttribute("link", photo);
        return "qlnhanvien";
    }

    @RequestMapping(value = "xuli", params = "btnInsertNV", method = RequestMethod.POST)
    public String insert(@ModelAttribute("nhanvien") NhanVien nv, ModelMap model,
            @RequestParam("photo") MultipartFile photo) {
        ModelNhanVien.insert(nv);
        List<NhanVien> list = new ArrayList<NhanVien>();
        list = ModelNhanVien.showNhanVien("");
        model.addAttribute("listNhanVien", list);
        try {
            String photoPath = context.getRealPath("/image/" + photo.getOriginalFilename());
            photo.transferTo(new File(photoPath));
            model.addAttribute("photo", photo.getOriginalFilename());
        } catch (Exception e) {
            model.addAttribute("message", "Lỗi lưu file !");
        }
        return "qlnhanvien";
    }
//    @RequestMapping(value = "xuli")
//    public String insert(ModelMap model) {
//        ModelNhanVien.insert(nv);
//        List<NhanVien> list = new ArrayList<NhanVien>();
//        list = ModelNhanVien.showNhanVien("");
//        model.addAttribute("listNhanVien", list);
//        System.out.println(nv.getPhoto());
//        System.out.println(nv.getName());
//        return "redirect: qlnhanvien.htm";
//    }
//    @ModelAttribute("majors")
//    public List<String> getMajors() {
//        List<String> majors = new ArrayList<>();
//        majors.add("S001");
//        majors.add("S002");
//        majors.add("S003");
//        majors.add("S004");
//        majors.add("S005");
//        return majors;
//    }
}
