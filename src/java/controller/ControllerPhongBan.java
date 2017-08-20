/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.PhongBan;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.ModelPhongBan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControllerPhongBan {
    @RequestMapping("editPB")
    public String edit(HttpServletRequest request, ModelMap model) {
        String mapb = request.getParameter("txtMapb");
        String tenpb = request.getParameter("txtTenpb");
        PhongBan pb = new PhongBan(mapb,tenpb);
        model.addAttribute("phongban", pb);

        List<PhongBan> list = new ArrayList<PhongBan>();
        list = ModelPhongBan.showPhongBan("");
        model.addAttribute("listPhongBan", list);
        return "qlphongban";
    }
    
    @RequestMapping("deletePB")
    public String delete(HttpServletRequest request, ModelMap model,
            @ModelAttribute("phongban") PhongBan pb) {
        String mapb = request.getParameter("txtMapb");
        ModelPhongBan.delete(mapb);
        List<PhongBan> list = new ArrayList<PhongBan>();
        list = ModelPhongBan.showPhongBan("");
        model.addAttribute("listPhongBan", list);
        pb = list.get(0);
        model.addAttribute("phongban", pb);
        return "qlphongban";
    }
    
    @RequestMapping(params = "btnUpdatePB")
    public String update(@ModelAttribute("phongban") PhongBan pb, ModelMap model) {
        ModelPhongBan.update(pb);
        List<PhongBan> list = new ArrayList<PhongBan>();
        list = ModelPhongBan.showPhongBan("");
        model.addAttribute("listPhongBan", list);
        return "qlphongban";
    }

    @RequestMapping(params = "btnInsertPB")
    public String insert(@ModelAttribute("phongban") PhongBan pb, ModelMap model) {
        ModelPhongBan.insert(pb);
        List<PhongBan> list = new ArrayList<PhongBan>();
        list = ModelPhongBan.showPhongBan("");
        model.addAttribute("listPhongBan", list);
        return "qlphongban";
    }
}
